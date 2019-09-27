package com.example.dnevnikjartest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dnevnikjartest.entity.Ucenik;
import com.example.dnevnikjartest.repo.UcenikRepository;

@Service("ucenikService")
@Transactional
public class UcenikService {

	private UcenikRepository ucenikRepository;

	@Autowired
	public UcenikService(UcenikRepository ucenikRepository) {
		this.ucenikRepository = ucenikRepository;
	}

	public List<Ucenik> listAll() {
		return ucenikRepository.findAll();

	}

	public void saveUcenici(Ucenik ucenici) {
		ucenikRepository.save(ucenici);
	}

	public Ucenik get(int id_ucenik) {
		return ucenikRepository.getOne(id_ucenik);
	}

	public void delete(int id_ucenik) {
		ucenikRepository.deleteById(id_ucenik);
	}

	public List<Ucenik> nadjiPoId(int id) {
		return ucenikRepository.findByIdRoditelja(id);
	}
	public List<Ucenik> uceniciPoOdeljenjima(int id){
		return ucenikRepository.findUcenikePoOdeljenju(id);
	}
}
