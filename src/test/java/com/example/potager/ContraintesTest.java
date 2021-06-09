package com.example.potager;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import javax.transaction.TransactionScoped;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.potager.bll.CarreException;
import com.example.potager.bll.CarreManager;
import com.example.potager.bll.GestionPotagerManager;
import com.example.potager.bll.PlanteException;
import com.example.potager.bll.PlanteIntoCarreException;
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

@SpringBootTest
class ContraintesTest {

	@Autowired
	PotagerManager potaManager;

	@Autowired
	CarreManager carrManager;

	@Autowired
	PlanteManager planteManager;
	
	@Autowired
	GestionPotagerManager gestionManager;
	
	/*
	@Test
	@Transactional
	void surfaceCarreInferieurSurfacePotager() throws CarreException {
		System.out.println("========= Contrainte carre potager ========");
		Potager potager4 = new Potager("serre", "Second potager", 1500, "Quimper");
		potaManager.addPotager(potager4);
		Carre carre = new Carre(500, TypeSol.CALCAIRE, Exposition.MI_OMBRE, potager4);
		carrManager.addCarre(carre);
		
		Carre carre2 = new Carre(500, TypeSol.CALCAIRE, Exposition.MI_OMBRE, potager4);
		carrManager.addCarre(carre2);

		Carre carre3 = new Carre(500, TypeSol.CALCAIRE, Exposition.MI_OMBRE, potager4);
		carrManager.addCarre(carre3);	
		
		//Carre carre4 = new Carre(500, TypeSol.CALCAIRE, Exposition.MI_OMBRE, potager4);
		//carrManager.addCarre(carre4);
		
		System.out.println(carre);
	}
	
	@Test
	@Transactional
	void surfacePlanteInferieureSurfaceCarre() throws PlanteIntoCarreException{
		System.out.println("======== Contrainte plante carre ========");
		Potager potager = new Potager("ici", "Potager de test", 10000, "Quimper");
		Plante plante = new Plante("Pommier", Type.fruit, "Golden", 200, 1, LocalDate.now());
		Plante plante2 = new Plante("Tomate", Type.fruit, "Citron", 200, 1, LocalDate.now());
		Plante plante3 = new Plante("Pêche", Type.fruit, "Melba", 200, 3, LocalDate.now());
		PlanteIntoCarre plan = new PlanteIntoCarre(1, LocalDate.now(), LocalDate.now().plusMonths(1));
		Carre carre = new Carre(900, TypeSol.CALCAIRE, Exposition.MI_OMBRE, potager);
		gestionManager.addPlanteToPotager(potager, plante, carre, plan);
		gestionManager.addPlanteToPotager(potager, plante2, carre, plan);
		gestionManager.addPlanteToPotager(potager, plante3, carre, plan);
	}

	@Test
	@Transactional
	void dateActionSuperieurOuEgaleADateJour() throws PlanteIntoCarreException{
		System.out.println("======== Contrainte date ========");
		
		Action action = new Action(LocalDate.now(), "Arrosage", "carré 1");
		gestionManager.addAction(action);
		
		Action action2 = new Action(LocalDate.now().minusDays(1), "Arrosage", "carré 1");
		gestionManager.addAction(action2);
	}
	
	@Test
	@Transactional
	void pasDeDoublonPlante() throws PlanteException {
		System.out.println("======== Contrainte doublon plante ========");
		
		Plante planteA = new Plante("Pommier", Type.fruit, "Golden", 200, 1, LocalDate.now());
		
		Plante planteB = new Plante("Pommier", Type.fruit, "Golden", 250, 1, LocalDate.now());
		
		planteManager.addPlante(planteA);
		planteManager.addPlante(planteB);
	}*/
	
	@Test
	@Transactional

	void pasPlusDeTroisPlantesDuMemeNom() throws PlanteIntoCarreException {
		System.out.println("======== Contrainte plante Nom ========");
		Potager potager = new Potager("ici", "Potager de test", 10000, "Quimper");
		Plante plante = new Plante("Cerise", Type.fruit, "Golden", 200, 1, LocalDate.now());
		Plante plante2 = new Plante("Cerise", Type.fruit, "Citron", 200, 1, LocalDate.now());
		Plante plante3 = new Plante("Cerise", Type.fruit, "Melba", 200, 1, LocalDate.now());
		Plante plante4 = new Plante("Cerise", Type.fruit, "rouge", 200, 1, LocalDate.now());
		PlanteIntoCarre plan = new PlanteIntoCarre(1, LocalDate.now(), LocalDate.now().plusMonths(1));
		Carre carre = new Carre(900, TypeSol.CALCAIRE, Exposition.MI_OMBRE, potager);
		gestionManager.addPlanteToPotager(potager, plante, carre, plan);
		gestionManager.addPlanteToPotager(potager, plante2, carre, plan);
		gestionManager.addPlanteToPotager(potager, plante3, carre, plan);
		gestionManager.addPlanteToPotager(potager, plante4, carre, plan);


	}
	
	
}
