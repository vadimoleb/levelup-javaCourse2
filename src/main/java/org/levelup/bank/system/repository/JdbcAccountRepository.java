package org.levelup.bank.system.repository;

import org.levelup.bank.system.domain.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class JdbcAccountRepository implements AccountRepository {

    private final JdbcConnectionService jdbcConnectionService;

    public JdbcAccountRepository() {
        this.jdbcConnectionService = new JdbcConnectionService();
    }


    @Override
    public Collection<Account> findUserAccounts(long userId) {

        try (Connection conn = jdbcConnectionService.openConnection()) {
            // Statement <- PreparedStatement <- CallableStatement
            PreparedStatement statement = conn.prepareStatement("select * from accounts where client_id = ?");
            statement.setLong(1, userId);


            //ResultSet
            //executeUpdate - insert, delete, update

            ResultSet resultSet = statement.executeQuery();
            return mapResultSet(resultSet);

        } catch (SQLException exc) {
            System.out.println("Ошибка взаимодействия с базой данных");
            System.err.println("Ошибка " + exc.getMessage());
            exc.printStackTrace();
        }

        return null;
    }

    @Override
    public Account createAccount(String number, String currency, long clientId) {
        try (Connection conn = jdbcConnectionService.openConnection()) {
            PreparedStatement findMaxAccountIdStatement =
                    conn.prepareStatement("select max(account_id) from accounts");
            ResultSet maxAccountIdResultSet = findMaxAccountIdStatement.executeQuery();
            maxAccountIdResultSet.next();
            long maxAccountId = maxAccountIdResultSet.getLong(1);

            PreparedStatement insertStatement = conn.prepareStatement("insert into accounts values (?, ?, ?, ?)");
            long account_id = maxAccountId + 1;
            insertStatement.setLong(1,account_id);
            insertStatement.setString(2, number);
            insertStatement.setString(3,currency);
            insertStatement.setLong(4,clientId);

            insertStatement.executeUpdate();
            //возвращаем полученную строку, т.к инсерт не возвращает это
            PreparedStatement selectStatement =
                    conn.prepareStatement("select * from accounts where account_id = ?");
            selectStatement.setLong(1,account_id);
            ResultSet resultSet = selectStatement.executeQuery();
            resultSet.next();
            return mapAccount(resultSet);

        } catch (SQLException exc) {
            System.out.println("Ошибка взаимодействия с базой данных");
            System.err.println("Ошибка " + exc.getMessage());
            exc.printStackTrace();
        }


        return null;
    }

    private Collection<Account> mapResultSet(ResultSet resultSet) throws SQLException {
        Collection<Account> accounts = new ArrayList<>();
        while (resultSet.next()) {   //возвращает boolean
            accounts.add(mapAccount(resultSet));
        }
        return accounts;
    }

    private Account mapAccount(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong("account_id");
        String number = resultSet.getString("number");
        String currency = resultSet.getString("currency");

        return new Account(
                id,
                number,
                currency
        );
    }

}
