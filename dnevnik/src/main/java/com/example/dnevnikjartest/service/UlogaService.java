package com.example.dnevnikjartest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dnevnikjartest.entity.Uloga;
import com.example.dnevnikjartest.repo.UlogaRepository;

@Service
@Transactional
public class UlogaService {

	@Autowired
	private UlogaRepository ulogaRepository;

	public List<Uloga> findAll() {
		return ulogaRepository.findAll();
	}

}
