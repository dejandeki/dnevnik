package com.example.dnevnikjartest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dnevnikjartest.entity.Poruka;
import com.example.dnevnikjartest.repo.PorukaRepository;

@Service
@Transactional
public class PorukaService {

	private PorukaRepository porukaRepository;

	@Autowired
	public PorukaService(PorukaRepository porukaRepository) {
		this.porukaRepository = porukaRepository;
	}
	
	public List<Poruka> svePorukeZaRoditelja(int id){
		return porukaRepository.findByRoditelj(id);
	}
	
	public List<Poruka> svePorukeZaUcitelja (int id){
		return porukaRepository.findByUcitelj(id);
	}
	
	public void savePoruka (Poruka poruka) {
		porukaRepository.save(poruka);
	}
	
	public Poruka editPoruka(int id_poruka) {
		return porukaRepository.getOne(id_poruka);
	}
	
	public void deletePoruka(int id_poruka) {
		porukaRepository.deleteById(id_poruka);
	}
}
