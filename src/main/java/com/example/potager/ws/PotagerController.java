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
import com.example.potager.bll.PotagerManager;
import com.example.potager.bo.Potager;


@RestController
public class PotagerController {
	
	@Autowired
	PotagerManager potagerManager;
	
	@GetMapping("/api/potager")
	public List<Potager> getPotager() {
		return potagerManager.getAllPotager();
	}
	
	@GetMapping("/api/potager/{id}")
	public Potager one(@PathVariable Integer id) {
		return potagerManager.getById(id);
	}
	
	@PostMapping("/api/potager")
	public Potager create(@RequestBody Potager potager) {
		
		potagerManager.addPotager(potager);
		return potager;
	}
	
	@PutMapping("/api/potager/{id}")
	public Potager update(@PathVariable Integer id, @RequestBody Potager potager) {
		
		potagerManager.updatePotager(potager, id);
		
		return potager;
		
	}
	
	@DeleteMapping("/api/potager/{id}")
	public String delete(@PathVariable Integer id){
		
		Potager p = potagerManager.getById(id);
		potagerManager.deletePotager(p);
		
		return "Le Potager répondant au nom de " + p.getNom() + " a bien été supprimé";
		
	}
	
}
