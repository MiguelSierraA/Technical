package com.company.entity;

import java.sql.Timestamp;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_client;
	@Column(length = 255)
	private String name;
	@Column(length = 255)
	private String email;
	@Column(length = 255)
	private String nit;
	@Column(length = 255)
	private String address;
	@Column(length = 255)
	private String city;
	
	private Timestamp created_date;

	@JoinColumn (name = "id_sector")
	@ManyToOne (optional = true)
	private Sector sector;

	@JoinColumn (name = "id_user")
	@ManyToOne (optional = true)
	private Tuser tuser;
}
