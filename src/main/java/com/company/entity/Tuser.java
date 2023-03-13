package com.company.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter

@Entity
public class Tuser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_user;

    @Column (length = 255)
    private String name;
    @Column (length = 255)
    private String last_name;
    @Column (length = 255)
    private String email;
    @Column (length = 255)
    private String pass;
    private Timestamp last_login;


}
