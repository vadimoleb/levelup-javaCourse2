package org.levelup.bank.system.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @Column(name = "account_id")
    private Long id;
    @Column(name = "number")
    private String number;
    @Column(name = "currency")
    private String currency;

    @Column(name = "client_id")
    private Long clientId;

}
