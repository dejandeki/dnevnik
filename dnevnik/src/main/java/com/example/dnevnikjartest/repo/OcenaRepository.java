/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.dnevnikjartest.repo;

import com.example.dnevnikjartest.entity.Ocena;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Grupa2
 */
@Repository("ocenaRepository")
public interface OcenaRepository extends JpaRepository<Ocena, Integer>{
    
    @Query(value="select avg(ocena) from ocena where id_predmet = ?1", nativeQuery = true)
    int findAvgOceneByPredmet(int id);
	
	@Query(value="select * from ocena where id_ucenik = ?1", nativeQuery = true)
	List<Ocena> findByIdUcenika(int id);
	
	@Query(value="select * from ocena o inner join ucenik u on(o.id_ucenik=u.id_ucenik) inner join korisnik k on(k.id_korisnik=u.id_roditelj) where k.id_korisnik = ?1 order by id_predmet", nativeQuery = true)
    List<Ocena> findByIdRoditelj(int id);
}
