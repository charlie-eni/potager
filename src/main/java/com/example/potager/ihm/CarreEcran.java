package com.example.potager.ihm;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.potager.bll.CarreException;
import com.example.potager.bll.CarreManager;
import com.example.potager.bll.PotagerManager;
import com.example.potager.bo.Carre;
import com.example.potager.bo.Potager;

@Controller
public class CarreEcran {

	@Autowired
	private CarreManager manager;

	@Autowired
	private PotagerManager potagerManager;

	@GetMapping("/carre/ajout/{idPotager}")
	public String saisieCarre(Carre carre) {
		return "les_carres/ajoutCarre";
	}

	@PostMapping("/carre/ajout/{idPotager}")
	public String ajoutCarre(@PathVariable("idPotager") Integer idPotager, @Valid Carre carre, BindingResult result,
			Model model) throws CarreException {
		
		try {
			System.out.println(idPotager);
			Potager currentPotager = potagerManager.getById(idPotager);

			currentPotager.addCarre(carre);

			manager.addCarre(carre);
			return "redirect:/carre/index";
			
		} catch (CarreException e) {
			
			model.addAttribute("error", e.getMessage());
			return "les_carres/ajoutCarre";
			
		}

		
	}

	@GetMapping("/carre/index")
	public String listeCarres(Model model) {
		model.addAttribute("carres", manager.getAllCarre());
		return "les_carres/indexCarre";
	}

	@GetMapping("carre/edit/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		Carre carre = manager.getById(id);
		model.addAttribute("carre", carre);
		return "les_carres/updateCarre";
	}

	@PostMapping("carre/update/{id}")
	public String updateCarre(@PathVariable("id") Integer id, @Valid Carre carre, BindingResult result, Model model) throws CarreException {
		carre.setIdCarre(id);
		if (result.hasErrors()) {
			return "les_carres/updateCarre";
		}
		manager.updateCarre(carre, id);
		return "redirect:/carre/index";
	}

	@GetMapping("/carre/delete/{id}")
	public String deleteCarre(@PathVariable("id") Integer id, Model model) {
		manager.deleteCarreById(id);
		return "redirect:/carre/index";
	}

}
