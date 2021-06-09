package com.example.potager.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.potager.bll.PlanteException;
import com.example.potager.bll.PlanteManager;
import com.example.potager.bo.Plante;

@RestController
public class PlanteController {

	@Autowired
	PlanteManager planteManager;
	
	@GetMapping("/api/plante")
	public List<Plante> getPlante(){
		return planteManager.getAllPlante();	
		}
	
	@GetMapping("/api/plante/{id}")
	public Plante one(@PathVariable Integer id) {
		return planteManager.getById(id);
	}
	
	@PostMapping("/api/plante")
	public Plante create(@RequestBody Plante plante) throws PlanteException {
		
		planteManager.addPlante(plante);
		return plante;
		
	}
	
	@PutMapping("/api/plante/{id}")
	public Plante update(@RequestBody Plante plante, @PathVariable Integer id) {
		
		planteManager.updatePlante(plante, id);
		return plante;
		
	}
	
	@DeleteMapping("/api/plante/{id}")
	public String delete(@PathVariable Integer id) {
		
		Plante p = planteManager.getById(id);
		planteManager.deletePlante(id);
		return "La Plante répondant au nom de " + p.getNom() + " et variété " + p.getVariete() + " a bien été supprimé";
		
	}
}
