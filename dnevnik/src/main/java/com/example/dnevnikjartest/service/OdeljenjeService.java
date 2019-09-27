package com.example.dnevnikjartest.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dnevnikjartest.entity.Odeljenje;
import com.example.dnevnikjartest.repo.OdeljenjeRepository;

@Service("odeljenjeService")
@Transactional
public class OdeljenjeService {

	private OdeljenjeRepository odeljenjeRepository;

	@Autowired
	public OdeljenjeService(OdeljenjeRepository odeljenjeRepository) {
		this.odeljenjeRepository = odeljenjeRepository;
	}

	public List<Odeljenje> listAll() {
		return odeljenjeRepository.findAll();
	}

	public void saveOdeljenje(Odeljenje odeljenje) {
		odeljenjeRepository.save(odeljenje);
	}

	public Odeljenje get(int id_odeljenje) {
		return odeljenjeRepository.findById(id_odeljenje).get();
	}

	public void delete(int id_odeljenje) {
		odeljenjeRepository.deleteById(id_odeljenje);
	}
}
