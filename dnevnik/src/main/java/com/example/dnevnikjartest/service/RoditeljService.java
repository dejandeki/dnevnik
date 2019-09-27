package com.example.dnevnikjartest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dnevnikjartest.entity.Korisnik;
import com.example.dnevnikjartest.repo.RoditeljRepository;

@Service("roditeljService")
@Transactional
public class RoditeljService {

    private RoditeljRepository roditeljRepository;

    @Autowired
    public RoditeljService(RoditeljRepository roditeljRepository) {

        this.roditeljRepository = roditeljRepository;
    }

    public List<Korisnik> listRoditelji() {
        return roditeljRepository.findAll();
    }

    public void save(Korisnik korisnik) {
        roditeljRepository.save(korisnik);
    }
}
