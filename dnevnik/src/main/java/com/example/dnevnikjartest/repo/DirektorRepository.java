package com.example.dnevnikjartest.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.dnevnikjartest.entity.Korisnik;

@Repository("direktorRepository")
public interface DirektorRepository extends JpaRepository<Korisnik, Integer> {

    @Query(value = "select * from korisnik k where k.id_uloga=4",
            nativeQuery = true)
    List<Korisnik> findAll();

}
