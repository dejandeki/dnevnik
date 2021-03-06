package com.example.dnevnikjartest.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.dnevnikjartest.entity.Subota;
@Repository
public interface SubotaRepository extends JpaRepository<Subota, Integer> {

	@Query(value="select * from subota where id_odeljenje = ?1", nativeQuery = true)
	List<Subota> findAll(int id);
	
		@Query(value="select * from subota p inner join odeljenje o on(p.id_odeljenje=o.id_odeljenje) inner join korisnik k on(k.id_korisnik=o.id_ucitelj) where k.id_korisnik = ?1", nativeQuery = true)
		List<Subota> findById(int id);
}
