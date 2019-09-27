package com.example.dnevnikjartest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dnevnikjartest.entity.Korisnik;
import com.example.dnevnikjartest.repo.UciteljRepository;

@Service
@Transactional
public class UciteljService {

	private UciteljRepository uciteljRepository;

	@Autowired
	public UciteljService(UciteljRepository uciteljRepository) {
		
		this.uciteljRepository = uciteljRepository;
	}
	
	public List<Korisnik> listUcitelji(){
		return uciteljRepository.findAll();
	}
	
}
