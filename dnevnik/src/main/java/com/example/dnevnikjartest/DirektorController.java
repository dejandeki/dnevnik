package com.example.dnevnikjartest;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.dnevnikjartest.entity.Ocena;
import com.example.dnevnikjartest.service.OcenaService;
import com.example.dnevnikjartest.service.PredmetService;

@Controller
public class DirektorController {

	@Autowired
	private OcenaService ocenaService;
	@Autowired
	private PredmetService predmetService;
	
    @RequestMapping("/direktor/statistika")
    public String barGraph(Model model) {
        Map<String, Double> surveyMap = new LinkedHashMap<>();
        surveyMap.put("Matematika", 4.0);
        surveyMap.put("Srpski", 2.7);
        surveyMap.put("Engleski", 2.0);
        surveyMap.put("Muzicko", 1.9);
        surveyMap.put("Gradjansko", 5.);
        surveyMap.put("Veronauka", 3.2);
        surveyMap.put("Likovno", 2.);
        surveyMap.put("Fizicko", 1.3);
        model.addAttribute("surveyMap", surveyMap);
        return "direktor_statistika";
    }

    @RequestMapping("/direktor/statistika2")
    public String prosekNaNivouSkole(Model model) {
    
    	
    	List<Ocena> lista = ocenaService.izlistajSve();
    	
    		int	prosek = ocenaService.prosecnaNaNivouSkole(1);
    		int prosek2 = ocenaService.prosecnaNaNivouSkole(3);
    			model.addAttribute("listaPredmeta", lista);
    			model.addAttribute("prosek", prosek);
    			model.addAttribute("prosek2", prosek2);

    	return "direktor_statistikaproba";
    			
    }
}
