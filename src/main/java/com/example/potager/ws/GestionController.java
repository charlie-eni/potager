package com.example.potager.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.potager.bll.GestionPotagerManager;
import com.example.potager.bll.PlanteIntoCarreException;
import com.example.potager.bo.Action;


@RestController
public class GestionController {

	@Autowired
	GestionPotagerManager gestionManager;
	
	@GetMapping("/api/action")
	public List<Action> getAction(){
		return gestionManager.listActionForTwoWeeks();
	}
	
	//TODO recherche d'une action par id
	
	@PostMapping("/api/action")
	public Action create(@RequestBody Action action) throws PlanteIntoCarreException {
		
		gestionManager.addAction(action);
		return action;
		
	}
	
}
