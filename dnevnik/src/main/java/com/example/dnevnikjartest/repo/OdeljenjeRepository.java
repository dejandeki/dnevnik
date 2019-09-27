package com.example.dnevnikjartest.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dnevnikjartest.entity.Odeljenje;

@Repository("odeljenjeRepository")
public interface OdeljenjeRepository extends JpaRepository<Odeljenje, Integer>{
    
}
