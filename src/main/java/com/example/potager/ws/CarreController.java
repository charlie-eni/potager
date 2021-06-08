package com.example.potager.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.potager.bll.CarreManager;
import com.example.potager.bo.Carre;

@RestController
public class CarreController {

	@Autowired
	CarreManager carreManager;
	
	@GetMapping("/api/getCarre")
	public List<Carre> getCarre(){
		return carreManager.getAllCarre();	}
}
