/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.dnevnikjartest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dnevnikjartest.entity.Ocena;
import com.example.dnevnikjartest.repo.OcenaRepository;

/**
 *
 * @author Grupa2
 */
@Service
@Transactional
public class OcenaService {

	private OcenaRepository  ocenaRepository;

	@Autowired
	public OcenaService(OcenaRepository ocenaRepository) {
	
		this.ocenaRepository =ocenaRepository;
	}
	 public List<Ocena>izlistajSve(){
		 return ocenaRepository.findAll();
	 }
	public List<Ocena> izlistaj(int id) {
		return ocenaRepository.findByIdUcenika(id);
	}
	public void saveOcene(Ocena ocene) {
		ocenaRepository.save(ocene);
	}
	public List<Ocena> nadjiPoId(int id){
		return ocenaRepository.findByIdRoditelj(id);
	}
    public int prosecnaNaNivouSkole(int id){
    	return ocenaRepository.findAvgOceneByPredmet(id);
    }
}