package com.example.potager;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.potager.bll.ActionManager;
import com.example.potager.bll.CarreException;
import com.example.potager.bll.CarreManager;
import com.example.potager.bll.PlanteManager;
import com.example.potager.bll.PotagerManager;
import com.example.potager.bo.Action;
import com.example.potager.bo.Carre;
import com.example.potager.bo.Exposition;
import com.example.potager.bo.Plante;
import com.example.potager.bo.Potager;
import com.example.potager.bo.TypeSol;
import com.example.potager.bo.Type;

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

	
	/*
	@Test
	@Transactional
	void addPotagerTest() {
		System.out.println("Ajout de Potager");
		Potager potager = new Potager("serre", "Premier potager", 50, "Quimper");
		potaManager.addPotager(potager);
		System.out.println();
	}

	*/
	@Test
	//@Transactional
	void addCarreToPotager() throws CarreException {
		System.out.println("========= Ajout carré au potager ========");
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
/*
	@Test
	void addPlanteToCarreToPotager() {
		System.out.println("============== Ajout d'une plante ================");
		Potager potager = new Potager("serre", "Premier potager", 5000, "Quimper");
		potaManager.addPotager(potager);
		Carre carre = new Carre(1000, TypeSol.CALCAIRE, Exposition.MI_OMBRE, potager);
		carrManager.addCarre(carre);
		Plante plante = new Plante("Tomate", Type.fruit, "cerise", 100, carre, 10, LocalDate.now());
		planteManager.addPlante(plante);
		System.out.println(plante);
	}

	@Test
	@Transactional
	void updatePlanteToCarreToPotager() {
		System.out.println("============== Update d'une plante ================");
		Potager potager = new Potager("serre", "Premier potager", 5000, "Quimper");
		potaManager.addPotager(potager);
		Carre carre = new Carre(1000, TypeSol.CALCAIRE, Exposition.MI_OMBRE, potager);
		carrManager.addCarre(carre);
		Plante plante = new Plante("Tomate", Type.fruit, "cerise", 100, carre, 10, LocalDate.now());
		planteManager.addPlante(plante);
		System.out.println(plante);
		potager.setNom("Premier potager updater");
		potaManager.updatePotager(potager);
		plante.setVariete("coeur de boeuf");
		planteManager.updatePlante(plante);
		carre.setTypeSol(TypeSol.ARGILEUX);
		carrManager.updateCarre(carre);
		System.out.println("======== SYSO Update ========");
		System.out.println(plante);
	}

	@Test
	@Transactional
	void deletePlanteToCarreToPotager() {
		System.out.println("============== Delete d'une plante ================");
		Potager potager = new Potager("serre", "Premier potager", 5000, "Quimper");
		potaManager.addPotager(potager);
		Carre carre = new Carre(1000, TypeSol.CALCAIRE, Exposition.MI_OMBRE, potager);
		carrManager.addCarre(carre);
		Plante plante = new Plante("Tomate", Type.fruit, "cerise", 100, carre, 10, LocalDate.now());
		planteManager.addPlante(plante);
		System.out.println(plante);
		potaManager.deletePotager(potager);
		carrManager.deleteCarre(carre);
		planteManager.deletePlante(plante.getIdPlante());
		System.out.println("======== Delete Plante ========");
		System.out.println(planteManager.getAllPlante() + "Coucou les plantes");
	} 

	@Test
	@Transactional
	void listActionTwoWeeks() {
		List<Action> actions = actionManager.listActionForTwoWeeks();
		assertEquals(actions.size(),1);
	}
	
<<<<<<< HEAD
//	Visualiser la localisation d�une plante (nom ou nom et vari�t�) dans les potagers
//	(potager, carr�, quantit� etc.)
	@Test
	@Transactional
	void getPotagerByPlant() {
		List<Potager> potagers = potaManager.getPotagerByPlant("Toomate");
		assertEquals(potagers.size(),1);
	}*/
	
}
