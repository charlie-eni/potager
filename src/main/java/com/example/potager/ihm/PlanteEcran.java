package com.example.potager.ihm;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.potager.bll.PlanteException;
import com.example.potager.bll.PlanteManager;
import com.example.potager.bo.Plante;

@Controller
public class PlanteEcran {

	@Autowired
	PlanteManager planteManager;

	@GetMapping("/plante/index")
	public String listePlantes(Model model) {
		model.addAttribute("plantes", planteManager.getAllPlante());
		return "les_plantes/indexPlante";
	}

	@GetMapping("/plante/saisie")
	public String saisiePlante(Plante plante) {
		return "les_plantes/ajoutPlante";
	}

	@PostMapping("/plante/ajout")
	public String ajoutPlante(@Valid Plante plante, BindingResult result, Model model) throws PlanteException {
		if (result.hasErrors()) {
			return "les_plantes/ajoutPlante";
		}
		planteManager.addPlante(plante);
		return "redirect:/plante/index";
	}

	@GetMapping("plante/edit/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		Plante plante = planteManager.getById(id);
		model.addAttribute("plante", plante);
		return "les_plantes/updatePlante";
	}

	@PostMapping("plante/update/{id}")
	public String updatePlante(@PathVariable("id") Integer id, @Valid Plante plante, BindingResult result,
			Model model) {
		plante.setIdPlante(id);
		if (result.hasErrors()) {
			return "les_plantes/updatePlante";
		}
		planteManager.updatePlante(plante, id);
		return "redirect:/plante/index";
	}

	@GetMapping("/plante/delete/{id}")
	public String deletePlante(@PathVariable("id") Integer id, Model model) {
		planteManager.deletePlante(id);
		return "redirect:/plante/index";
	}
}
