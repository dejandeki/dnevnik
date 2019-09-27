package com.example.dnevnikjartest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dnevnikjartest.entity.Predmet;
import com.example.dnevnikjartest.repo.PredmetRepository;
import org.springframework.transaction.annotation.Transactional;

@Service("predmetService")
@Transactional
public class PredmetService {

	private PredmetRepository predmetRepository;

	@Autowired
	public PredmetService(PredmetRepository predmetRepository) {
		this.predmetRepository = predmetRepository;
	}

	public List<Predmet> findAll() {

		return predmetRepository.findAll();
	}

	public void savePredmeti(Predmet predmet) {
		predmetRepository.save(predmet);
	}

	public Predmet get(int id_predmet) {
		return predmetRepository.findById(id_predmet).get();
	}

	public void delete(int id_predmet) {
		predmetRepository.deleteById(id_predmet);
	}

}
