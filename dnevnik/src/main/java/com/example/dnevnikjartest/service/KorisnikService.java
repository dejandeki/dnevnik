package com.example.dnevnikjartest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dnevnikjartest.entity.Korisnik;
import com.example.dnevnikjartest.repo.KorisnikRepository;

@Service("korisnikService")
@Transactional
public class KorisnikService {

	private KorisnikRepository korisnikRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	public KorisnikService(KorisnikRepository korisnikRepository,
			BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.korisnikRepository = korisnikRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	
	public List<Korisnik> listAll() {
		return korisnikRepository.findAll();
	}

	public void save(Korisnik korisnik) {
		korisnik.setPassword(bCryptPasswordEncoder.encode(korisnik.getPassword()));
		korisnikRepository.save(korisnik);
	}

	public Korisnik get(int id_korisnik) {
		return korisnikRepository.findById(id_korisnik).get();
	}

	public void delete(int id_korisnik) {
		korisnikRepository.deleteById(id_korisnik);
	}


	public Korisnik findByUsername(String username) {
		return korisnikRepository.findByUsername(username);
	}

	public List<Korisnik> nadjiRoditelje(){
		return korisnikRepository.findByRoditelj();
	}

	public int nadjiUcitelja (int id) {
		return korisnikRepository.findUcitelj(id);
	}
}
