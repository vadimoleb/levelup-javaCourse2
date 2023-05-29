package org.levelup.bank.system.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnectionService {

    public Connection openConnection() throws SQLException {
       return DriverManager.getConnection(
                //jdbc url
                //protocol:sub-protocol
                //jdbc:<vendor_name>://<host>:<port>
                "jdbc:postgresql://localhost:5432/bank-system",
                "postgres",
                "postgres"
        );
    }


}
