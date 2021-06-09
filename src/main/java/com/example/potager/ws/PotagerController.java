package com.example.potager.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.potager.bll.PotagerManager;
import com.example.potager.bo.Potager;


@RestController
public class PotagerController {
	
	@Autowired
	PotagerManager potagerManager;
	
	@GetMapping("/api/Potager")
	public List<Potager> getPotager() {
		return potagerManager.getAllPotager();
	}
	
	@GetMapping("/api/potager/{id}")
	public Potager one(@PathVariable Integer id) {
		return potagerManager.getById(id);
	}
	
}
