package com.example.dnevnikjartest.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.dnevnikjartest.entity.Korisnik;

@Repository("korisnikRepository")
public interface KorisnikRepository extends JpaRepository<Korisnik, Integer> {

	public Korisnik findByUsername(String username);

	@Query(value = "select * from korisnik where id_uloga = 2", nativeQuery = true)
	List<Korisnik> findByRoditelj();
	
	@Query(value = "select o.id_ucitelj from odeljenje o inner join ucenik u on(o.id_odeljenje=u.id_odeljenje) where u.id_roditelj=?1", nativeQuery = true)
	int findUcitelj(int id) ;
	
}
