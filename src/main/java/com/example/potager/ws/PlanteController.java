package com.example.potager.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.potager.bll.PlanteManager;
import com.example.potager.bo.Carre;
import com.example.potager.bo.Plante;

@RestController
public class PlanteController {

	@Autowired
	PlanteManager planteManager;
	
	@GetMapping("/api/getPlante")
	public List<Plante> getPlante(){
		return planteManager.getAllPlante();	
		}
	
	@GetMapping("/WS/getPlante/{id}")
	public Plante one(@PathVariable Integer id) {
		return planteManager.getById(id);
	}
}
