package com.company.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter

@Entity
public class ClientContact {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id_clientContact;

    @Column (length = 255)
    private String name;
    @Column (length = 255)
    private String email;

    @JoinColumn(name = "id_client")
    @ManyToOne (optional = true)
    private Client client;

}
