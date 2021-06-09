package com.example.potager.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.potager.bll.GestionPotagerManager;
import com.example.potager.bo.Action;
import com.example.potager.bo.Carre;

@RestController
public class GestionController {

	@Autowired
	GestionPotagerManager gestionManager;
	
	@GetMapping("/api/getAction")
	public List<Action> getAction(){
		return gestionManager.listActionForTwoWeeks();
	}
	
}
