package org.levelup.bank.system.domain;

public class Account {
    private Long id;
    private String number;
    private String currency;

    public Account(Long id, String number, String currency) {
        this.id = id;
        this.number = number;
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", currency='" + currency + '\'' +
                '}';
    }
}
