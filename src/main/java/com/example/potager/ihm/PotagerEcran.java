package com.example.potager.ihm;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.potager.bll.PotagerManager;
import com.example.potager.bo.Potager;

@Controller
public class PotagerEcran {

	@Autowired
	private PotagerManager manager;

	@GetMapping("/potager/saisie")
	public String saisiePotager(Potager potager) {
		return "ajoutPotager";
	}

	@PostMapping("/potager/ajout")
	public String ajoutPotager(@Valid Potager potager, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "ajoutPotager";
		}
		manager.addPotager(potager);
		return "redirect:/potager/index";
	}

	@GetMapping("/potager/index")
	public String listePotagers(Model model) {
		model.addAttribute("potagers", manager.getAllPotager());
		return "indexPotager";
	}

	@GetMapping("potager/edit/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		Potager potager = manager.getById(id);
		model.addAttribute("potager", potager);
		return "updatePotager";
	}

	@PostMapping("potager/update/{id}")
	public String updatePotager(@PathVariable("id") Integer id, @Valid Potager potager, BindingResult result,
			Model model) {
		potager.setIdPotager(id);
		if (result.hasErrors()) {
			return "updatePotager";
		}
		manager.updatePotager(potager, id);
		return "redirect:/potager/index";
	}

	@GetMapping("/potager/delete/{id}")
	public String deletePotager(@PathVariable("id") Integer id, Model model) {
		manager.deletePotagerById(id);
		return "redirect:/potager/index";
	}
}
