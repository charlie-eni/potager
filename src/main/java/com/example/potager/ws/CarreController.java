package com.example.potager.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.potager.bll.CarreException;
import com.example.potager.bll.CarreManager;
import com.example.potager.bo.Carre;


@RestController
public class CarreController {

	@Autowired
	CarreManager carreManager;
	
	@GetMapping("/api/carre")
	public List<Carre> getCarre(){
		return carreManager.getAllCarre();	
		}
	
	@GetMapping("/api/carre/{id}")
	public Carre one(@PathVariable Integer id) {
		return carreManager.getById(id);
	}
	
	@PostMapping("/api/carre")
	public Carre create(@RequestBody Carre carre) throws CarreException {
		
		carreManager.addCarre(carre);
		return carre;
		
	}
}
