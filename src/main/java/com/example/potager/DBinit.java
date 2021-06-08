package com.example.potager;

import java.time.LocalDate;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.potager.bll.ActionManager;
import com.example.potager.bll.CarreException;
import com.example.potager.bll.CarreManager;
import com.example.potager.bll.PlanteManager;
import com.example.potager.bll.PotagerManager;
import com.example.potager.bo.Action;
import com.example.potager.bo.Carre;
import com.example.potager.bo.Exposition;
import com.example.potager.bo.Plante;
import com.example.potager.bo.PlanteIntoCarre;
import com.example.potager.bo.Potager;
import com.example.potager.bo.Type;
import com.example.potager.bo.TypeSol;
import com.example.potager.dal.PlanteIntoCarreDAO;

@Component
public class DBinit {

	@Autowired
	ActionManager actionMger;

	@Autowired
	PlanteManager planteMger;

	@Autowired
	PotagerManager potagerMger;

	@Autowired
	CarreManager carreMger;
	
	@Autowired
	PlanteIntoCarreDAO planDAO;

	@PostConstruct
	@Transactional
	private void postConstruct() throws CarreException {
		actionMger.addAction(new Action(LocalDate.now(), "NOW!", "fdsfds"));
		actionMger.addAction(new Action(LocalDate.now().plusMonths(1), "Dans un mois", "fdsfds"));

		Potager potager = new Potager("serre", "Premier potager", 1500, "Quimper");
		potagerMger.addPotager(potager);

		Carre carre = new Carre(1000, TypeSol.CALCAIRE, Exposition.MI_OMBRE, potager);

		Plante plante = new Plante("Tomate", Type.fruit, "cerise", 100, 10, LocalDate.now());
	
		PlanteIntoCarre plan = new PlanteIntoCarre(12, LocalDate.now(), LocalDate.now());
		plan.addCarre(carre);
		plan.addPlante(plante);
		
		
		planteMger.addPlante(plante);
		carreMger.addCarre(carre);
		planDAO.save(plan);
	}

}
