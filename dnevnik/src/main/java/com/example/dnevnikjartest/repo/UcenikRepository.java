package com.example.dnevnikjartest.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.dnevnikjartest.entity.Ucenik;

@Repository("ucenikRepository")
public interface UcenikRepository extends JpaRepository<Ucenik, Integer> {
        
	@Query(value="select * from ucenik u inner join odeljenje o on(u.id_odeljenje=o.id_odeljenje) inner join korisnik k on(k.id_korisnik=o.id_ucitelj) where k.id_korisnik = ?1", nativeQuery = true)
	List<Ucenik> findByIdRoditelja(int id);
	
    @Query(value="select * from ucenik u inner join odeljenje o on(u.id_odeljenje = o.id_odeljenje) where o.id_ucitelj=?1", nativeQuery = true)
    List<Ucenik> findUcenikePoOdeljenju(int id);
}


      