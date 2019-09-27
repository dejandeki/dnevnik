package com.example.dnevnikjartest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dnevnikjartest.entity.Predmet;

@Repository("predmetRepository")
public interface PredmetRepository extends JpaRepository<Predmet, Integer> {

   
}
