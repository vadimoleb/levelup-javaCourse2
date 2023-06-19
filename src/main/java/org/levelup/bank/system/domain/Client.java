package org.levelup.bank.system.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "clients")
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   //отмечаем то что генерируется постгресом
    @Column(name = "client_id")
    private Integer id;

    @Column(name  = "fio")
    private String fio;

    @Column(name  = "phone")
    private String phone;
}
