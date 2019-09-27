package com.example.dnevnikjartest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dnevnikjartest.entity.Uloga;

@Repository("ulogaRepository")
public interface UlogaRepository extends JpaRepository<Uloga, Integer> {

	
}
