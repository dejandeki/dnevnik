package com.example.dnevnikjartest.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.dnevnikjartest.entity.Cetvrtak;
@Repository
public interface CetvrtakRepository extends JpaRepository<Cetvrtak, Integer> {

	@Query(value="select * from cetvrtak where id_odeljenje = ?1", nativeQuery = true)
	List<Cetvrtak> findAll(int id);
	
		@Query(value="select * from cetvrtak c inner join odeljenje o on(c.id_odeljenje=o.id_odeljenje) inner join korisnik k on(k.id_korisnik=o.id_ucitelj) where k.id_korisnik = ?1", nativeQuery = true)
		List<Cetvrtak> findById(int id);
	
}
