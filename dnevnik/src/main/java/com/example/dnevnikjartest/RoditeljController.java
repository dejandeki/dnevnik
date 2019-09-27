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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.dnevnikjartest.entity.Korisnik;
import com.example.dnevnikjartest.entity.Obavestenje;
import com.example.dnevnikjartest.entity.Ocena;
import com.example.dnevnikjartest.entity.Ponedeljak;
import com.example.dnevnikjartest.entity.Poruka;
import com.example.dnevnikjartest.service.KorisnikService;
import com.example.dnevnikjartest.service.ObavestenjeService;
import com.example.dnevnikjartest.service.OcenaService;
import com.example.dnevnikjartest.service.PorukaService;

/**
 *
 * @author Grupa2
 */
@Controller
public class RoditeljController {

	@Autowired
	private PorukaService porukaService;
	@Autowired
	private KorisnikService korisnikService;
	@Autowired
	private OcenaService ocenaService;
    @Autowired
    private ObavestenjeService obavestenjeService;

    @RequestMapping("/roditelj/listaPoruka")
    public String viewSvePoruke(Model model) {
    	
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        Korisnik kor = korisnikService.findByUsername(userDetails.getUsername());
        int id = kor.getId_korisnik();
        
    	List<Poruka> lista = porukaService.svePorukeZaRoditelja(id);
    	model.addAttribute("poruka", lista);
    	
    	return "roditelj_listaporuka";
    }
    
    @RequestMapping("/roditelj/novaPoruka")
    public String novaPoruka(Model model) {
    	
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        Korisnik kor = korisnikService.findByUsername(userDetails.getUsername());
        int id = kor.getId_korisnik();
        
        Poruka poruka = new Poruka();
        int uid = korisnikService.nadjiUcitelja(id);
        poruka.setKorisnik_roditelj(kor);
        Korisnik korucitelj = korisnikService.get(uid);
        poruka.setKorisnik_ucitelj(korucitelj);
        
        model.addAttribute("poruka", poruka);
        return "roditelj_noveporuke";
    }
    
    @RequestMapping(value = "savePoruka", method = RequestMethod.POST)
	public String savePoruka(@ModelAttribute("poruka") Poruka poruka) {
		porukaService.savePoruka(poruka);

		return "redirect:/roditelj/listaPoruka";
	}
    
    @RequestMapping("/roditelj/listaObavestenja")
    public String viewSvaObavestenja(Model model) {
        List<Obavestenje> listaObavestenja = obavestenjeService.listObavestenja();
        model.addAttribute("obavestenja", listaObavestenja);
        return "roditelj_listaobavestenja";
    }

    @RequestMapping("/roditelj/djackaKnjizica")
    public String viewOcene(Model model) {
    	
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        Korisnik kor = korisnikService.findByUsername(userDetails.getUsername());
        int id = kor.getId_korisnik();
        
        List<Ocena> listaOcena = ocenaService.nadjiPoId(id);
        model.addAttribute("ocene", listaOcena);
           
        
        return "roditelj_djackaknjizica";
    }
}
