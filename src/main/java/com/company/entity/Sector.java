package com.company.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter

@Entity
public class Sector {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id_sector;

    @Column (length = 255)
    private String sector_name;
}
