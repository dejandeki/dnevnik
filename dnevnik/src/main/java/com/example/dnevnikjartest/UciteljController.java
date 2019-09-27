/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.dnevnikjartest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.dnevnikjartest.entity.Cetvrtak;
import com.example.dnevnikjartest.entity.Korisnik;
import com.example.dnevnikjartest.entity.Ocena;
import com.example.dnevnikjartest.entity.Petak;
import com.example.dnevnikjartest.entity.Ponedeljak;
import com.example.dnevnikjartest.entity.Predmet;
import com.example.dnevnikjartest.entity.Sreda;
import com.example.dnevnikjartest.entity.Subota;
import com.example.dnevnikjartest.entity.Ucenik;
import com.example.dnevnikjartest.entity.Utorak;
import com.example.dnevnikjartest.service.CetvrtakService;
import com.example.dnevnikjartest.service.KorisnikService;
import com.example.dnevnikjartest.service.OcenaService;
import com.example.dnevnikjartest.service.PetakService;
import com.example.dnevnikjartest.service.PonedeljakService;
import com.example.dnevnikjartest.service.PredmetService;
import com.example.dnevnikjartest.service.SredaService;
import com.example.dnevnikjartest.service.SubotaService;
import com.example.dnevnikjartest.service.UcenikService;
import com.example.dnevnikjartest.service.UtorakService;

/**
 *
 * @author Grupa2
 */
@Controller
public class UciteljController {

	@Autowired
	private KorisnikService korisnikService;
	@Autowired
	private OcenaService ocenaService;
	@Autowired
	private PredmetService predmetService;
	@Autowired
	private UcenikService ucenikService;
	@Autowired
	private PonedeljakService ponedeljakService;
	@Autowired
	private UtorakService utorakService;
	@Autowired
	private SredaService sredaService;
	@Autowired
	private CetvrtakService cetvrtakService;
	@Autowired
	private PetakService petakService;
	@Autowired
	private SubotaService subotaService;

	@RequestMapping("/ucitelj/rasporedZaOdeljenje")
	public String getRasporedZaOdeljenje(Model model) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) auth.getPrincipal();
		Korisnik kor = korisnikService.findByUsername(userDetails.getUsername());
		int id = kor.getId_korisnik();

		List<Ponedeljak> getPonedeljak = ponedeljakService.nadjiPoId(id);
		List<Utorak> getUtorak = utorakService.nadjiPoId(id);
		List<Sreda> getSreda = sredaService.nadjiPoId(id);
		List<Cetvrtak> getCetvrtak = cetvrtakService.nadjiPoId(id);
		List<Petak> getPetak = petakService.nadjiPoId(id);
		List<Subota> getSubota = subotaService.nadjiPoId(id);

		model.addAttribute("ponedeljak", getPonedeljak);
		model.addAttribute("utorak", getUtorak);
		model.addAttribute("sreda", getSreda);
		model.addAttribute("cetvrtak", getCetvrtak);
		model.addAttribute("petak", getPetak);
		model.addAttribute("subota", getSubota);

		return "ucitelj_raspored2";
	}

	@RequestMapping("/ucitelj/listaUcenikaZaOdabirOcena")
	public String viewSvaOdeljenjaZaRaspored(Model model) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) auth.getPrincipal();
		Korisnik kor = korisnikService.findByUsername(userDetails.getUsername());
		int id = kor.getId_korisnik();

		List<Ucenik> listaUcenika = ucenikService.uceniciPoOdeljenjima(id);

		model.addAttribute("ucenici", listaUcenika);
		return "ucitelj_dnevnikUcenika";
	}

	@RequestMapping("/ucitelj/oceneZaUcenika/{id}")
	public String viewOcene(@PathVariable(name = "id") int id, Model model) {

		List<Ocena> listaOcena = ocenaService.izlistaj(id);
		model.addAttribute("ocene", listaOcena);

		return "ucitelj_dnevnikOcena";
	}

	@RequestMapping("/ucitelj/ocene")
	public String ocene(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) auth.getPrincipal();
		Korisnik kor = korisnikService.findByUsername(userDetails.getUsername());
		int id = kor.getId_korisnik();

		List<Predmet> getPredmeti = predmetService.findAll();
		List<Ucenik> getUcenici = ucenikService.nadjiPoId(id);
		Ocena theOcene = new Ocena();
		model.addAttribute("predmeti", getPredmeti);
		model.addAttribute("ucenici", getUcenici);
		model.addAttribute("ocene", theOcene);
		return "ucitelj_ocene";

	}

	@RequestMapping(value = "saveOcene", method = RequestMethod.POST)
	public String saveOcene(@ModelAttribute("ocene") Ocena theOcene) {

		ocenaService.saveOcene(theOcene);

		return "redirect:/ucitelj/ocene";
	}

}
