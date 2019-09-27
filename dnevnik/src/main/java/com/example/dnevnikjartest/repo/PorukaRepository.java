package com.example.dnevnikjartest.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.dnevnikjartest.entity.Poruka;

@Repository
public interface PorukaRepository extends JpaRepository<Poruka, Integer> {

	@Query(value= "select * from poruka p inner join korisnik k on (p.id_roditelj=k.id_korisnik) where k.id_korisnik=?1", nativeQuery = true)
	List<Poruka> findByRoditelj(int id);
	
	@Query(value= "select * from poruka p inner join korisnik k on (p.id_ucitelj=k.id_korisnik) where k.id_korisnik=?1", nativeQuery = true)
	List<Poruka> findByUcitelj(int id);
	
}
