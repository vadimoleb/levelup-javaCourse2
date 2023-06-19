package org.levelup.bank.system.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

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

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

}
