/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.dnevnikjartest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dnevnikjartest.entity.Obavestenje;

/**
 *
 * @author Grupa2
 */
@Repository("obavestenjeRepository")
public interface ObavestenjeRepository extends JpaRepository<Obavestenje, Integer> {

	
}