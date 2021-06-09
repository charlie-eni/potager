package com.example.potager.ihm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.potager.bll.PlanteManager;

@Controller
public class PlanteEcran {

	@Autowired
	PlanteManager planteManager;
	
	@GetMapping("/plante/index")
	public String listePotagers(Model model) {
		model.addAttribute("potagers", planteManager.getAllPlante());
		return "indexPlante";
	}
}
