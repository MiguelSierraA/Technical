package com.company.repository;

import com.company.entity.Tuser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TuserRepository extends JpaRepository <Tuser, Integer> {
}
