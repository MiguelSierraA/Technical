package com.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer>{


}
