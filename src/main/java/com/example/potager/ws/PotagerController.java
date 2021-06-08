package com.example.potager.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.potager.bll.PotagerManager;
import com.example.potager.bo.Potager;


@RestController
public class PotagerController {
	
	@Autowired
	PotagerManager potagerMger;
	
	@GetMapping("/api/getPotager")
	public List<Potager> getPotager() {
		return potagerMger.getAllPotager();
	}
	
}
