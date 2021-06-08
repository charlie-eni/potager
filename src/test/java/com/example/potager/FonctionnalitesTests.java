package com.example.potager;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.potager.bll.ActionManager;
import com.example.potager.bll.CarreManager;
import com.example.potager.bll.GestionPotagerManager;
import com.example.potager.bll.PlanteManager;
import com.example.potager.bll.PotagerManager;
import com.example.potager.bo.Carre;
import com.example.potager.bo.Exposition;
import com.example.potager.bo.Plante;
import com.example.potager.bo.PlanteIntoCarre;
import com.example.potager.bo.Potager;
import com.example.potager.bo.Type;
import com.example.potager.bo.TypeSol;

@SpringBootTest
class FonctionnalitesTests {

	@Autowired
	PotagerManager potaManager;

	@Autowired
	CarreManager carrManager;

	@Autowired
	PlanteManager planteManager;
	
	@Autowired
	ActionManager actionManager;
	
	@Autowired
	GestionPotagerManager gestionManager;

	@Test
	@Transactional
	void addPlantesToPotager() {
		Potager potager = new Potager("ici", "Potager de test", 1000, "Quimper");
		Plante plante = new Plante("Pommier", Type.fruit, "Golden", 200, 1, LocalDate.now());
		PlanteIntoCarre plan = new PlanteIntoCarre(1, LocalDate.now(), LocalDate.now().plusMonths(1));
		Carre carre = new Carre(500, TypeSol.CALCAIRE, Exposition.MI_OMBRE, potager);
		gestionManager.addPlanteToPotager(potager, plante, carre, plan);
	}
	
}
