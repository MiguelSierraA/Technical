package com.company.repository;

import com.company.entity.ClientContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientContactRepository extends JpaRepository <ClientContact, Integer> {

}
