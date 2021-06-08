package com.example.potager;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.potager.bll.GestionPotagerManager;
import com.example.potager.bll.PlanteException;
import com.example.potager.bll.PlanteManager;
import com.example.potager.bll.PotagerManager;
import com.example.potager.bo.Plante;
import com.example.potager.bo.Type;

@SpringBootTest
class DeuxiemeContraintesTest {

	@Autowired
	PotagerManager potaManager;

	@Autowired
	PlanteManager planteManager;
	
	@Autowired
	GestionPotagerManager gestionManager;
	
//	@Test
//	@Transactional
//	void surfacePlanteInferieureSurfaceCarre() throws PlanteIntoCarreException{
//		System.out.println("======== Contrainte plante carre ========");
//		Potager potager = new Potager("ici", "Potager de test", 10000, "Quimper");
//		Plante plante = new Plante("Pommier", Type.fruit, "Golden", 200, 1, LocalDate.now());
//		Plante plante2 = new Plante("Tomate", Type.fruit, "Citron", 200, 1, LocalDate.now());
//		Plante plante3 = new Plante("Pêche", Type.fruit, "Melba", 200, 3, LocalDate.now());
//		PlanteIntoCarre plan = new PlanteIntoCarre(1, LocalDate.now(), LocalDate.now().plusMonths(1));
//		Carre carre = new Carre(900, TypeSol.CALCAIRE, Exposition.MI_OMBRE, potager);
//		gestionManager.addPlanteToPotager(potager, plante, carre, plan);
//		gestionManager.addPlanteToPotager(potager, plante2, carre, plan);
//		gestionManager.addPlanteToPotager(potager, plante3, carre, plan);
//	}

	@Test
	@Transactional
	void pasDeDoublonPlante() throws PlanteException {
		Plante planteA = new Plante("Pommier", Type.fruit, "Golden", 200, 1, LocalDate.now());
		
		Plante planteB = new Plante("Pommier", Type.fruit, "Golden", 250, 1, LocalDate.now());
		
		planteManager.addPlante(planteA);
		planteManager.addPlante(planteB);
	}
	
}
