package com.example.potager;

import java.time.LocalDate;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.potager.bll.CarreException;
import com.example.potager.bll.CarreManager;
import com.example.potager.bll.GestionPotagerManager;
<<<<<<< Updated upstream
import com.example.potager.bll.PlanteIntoCarreException;
=======
import com.example.potager.bll.PlanteException;
>>>>>>> Stashed changes
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
	PlanteManager planteMger;

	@Autowired
	PotagerManager potagerMger;

	@Autowired
	CarreManager carreMger;

	@Autowired
	PlanteIntoCarreDAO planDAO;

	@Autowired
	GestionPotagerManager gestionMger;

	@PostConstruct
	@Transactional
	private void postConstruct() throws CarreException, PlanteIntoCarreException, PlanteException {

		gestionMger.addAction(new Action(LocalDate.now(), "NOW!", "fdsfds"));
		gestionMger.addAction(new Action(LocalDate.now().plusMonths(1), "Dans un mois", "fdsfds"));

		Potager potager = new Potager("serre", "Premier potager", 1500, "Quimper");
		potagerMger.addPotager(potager);
		Potager potager2 = new Potager("serre", "second potager", 500, "brest");
		potagerMger.addPotager(potager2);

		Carre carre = new Carre(1000, TypeSol.CALCAIRE, Exposition.MI_OMBRE, potager);
		Carre carre2 = new Carre(500, TypeSol.ARGILEUX, Exposition.MI_OMBRE, potager2);

		Plante plante = new Plante("Tomate", Type.fruit, "cerise", 100, 10, LocalDate.now());
		Plante plante2 = new Plante("carotte", Type.fruit, "cerise", 100, 10, LocalDate.now());

		PlanteIntoCarre plan = new PlanteIntoCarre(12, LocalDate.now(), LocalDate.now());
		plan.addCarre(carre);
		plan.addPlante(plante);

		PlanteIntoCarre plan2 = new PlanteIntoCarre(12, LocalDate.now(), LocalDate.now());
		plan2.addCarre(carre2);
		plan2.addPlante(plante2);

		planteMger.addPlante(plante);
		carreMger.addCarre(carre);
		planDAO.save(plan);

		planteMger.addPlante(plante2);
		carreMger.addCarre(carre2);
		planDAO.save(plan2);

		Integer idCarre = gestionMger.getPotagerByPlant("Tomate");
		System.out.println(idCarre);

	}

}
