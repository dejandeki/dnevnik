package com.example.dnevnikjartest.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.dnevnikjartest.entity.Korisnik;
@Repository
public interface UciteljRepository extends JpaRepository<Korisnik, Integer> {

	@Query(value="select * from korisnik k where k.id_uloga=3",
			nativeQuery=true)
	List<Korisnik> findAll();
}
