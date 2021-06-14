package com.example.potager.ihm;

import java.time.LocalDate;

import javax.transaction.Transactional;
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
import com.example.potager.bll.GestionPotagerManager;
import com.example.potager.bll.PlanteException;
import com.example.potager.bll.PlanteIntoCarreException;
import com.example.potager.bll.PlanteManager;
import com.example.potager.bo.Carre;
import com.example.potager.bo.Plante;
import com.example.potager.bo.PlanteIntoCarre;
import com.example.potager.dal.PlanteIntoCarreDAO;

@Controller
public class PlanteEcran {

	@Autowired
	PlanteManager planteManager;

	@Autowired
	private CarreManager carreManager;

	@Autowired
	private GestionPotagerManager gestionManager;
	
	@Autowired
	PlanteIntoCarreDAO dao;

	@GetMapping("/plante/index")
	public String listePlantes(Model model) {
		model.addAttribute("plantes", planteManager.getAllPlante());
		return "les_plantes/indexPlante";
	}

	@GetMapping("/plante/ajout/{idCarre}")
	public String saisiePlante(Plante plante) {
		return "les_plantes/ajoutPlante";
	}

	@PostMapping("/plante/ajout/{idCarre}")
	@Transactional
	public String ajoutPlante(@PathVariable("idCarre") Integer idCarre, @Valid Plante plante, PlanteIntoCarre plan,
			BindingResult result, Model model) throws PlanteException, PlanteIntoCarreException, CarreException {

		try {
			Carre carre = carreManager.getById(idCarre);

			plan = new PlanteIntoCarre(1, LocalDate.now(), LocalDate.now().plusMonths(1));
			System.out.println(plante);
			gestionManager.addPlanteToPotager(plante, carre, plan);

			return "redirect:/plante/index";

		} catch (PlanteIntoCarreException planteIntoE) {
			model.addAttribute("error", planteIntoE.getMessage());
			return "les_plantes/ajoutPlante";
		} catch (CarreException carreE) {
			model.addAttribute("error", carreE.getMessage());
			return "les_plantes/ajoutPlante";
		}

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
	@Transactional
	public String deletePlante(@PathVariable("id") Integer id, Model model) {
		 
		Plante plante = planteManager.getById(id);
		gestionManager.deletePlanByPlante(plante);
		planteManager.deletePlante(id);
		return "redirect:/plante/index";
	}

}
