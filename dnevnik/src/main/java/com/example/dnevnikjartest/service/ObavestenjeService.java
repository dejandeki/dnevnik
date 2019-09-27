/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.dnevnikjartest.service;

import com.example.dnevnikjartest.entity.Obavestenje;
import com.example.dnevnikjartest.repo.ObavestenjeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Grupa2
 */
@Service("obavestenjeService")
@Transactional
public class ObavestenjeService {

	private ObavestenjeRepository obavestenjeRepository;

	@Autowired
	public ObavestenjeService(ObavestenjeRepository obavestenjeRepository) {

		this.obavestenjeRepository = obavestenjeRepository;
	}

	public List<Obavestenje> listObavestenja() {
		return obavestenjeRepository.findAll();
	}

	public void save(Obavestenje obavestenja) {
		obavestenjeRepository.save(obavestenja);
	}

	public void delete(int id_obavestenja) {
		obavestenjeRepository.deleteById(id_obavestenja);
	}
}