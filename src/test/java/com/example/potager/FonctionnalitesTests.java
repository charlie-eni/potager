package com.example.potager;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.hibernate.internal.build.AllowSysOut;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.potager.bll.CarreManager;
import com.example.potager.bll.PlanteManager;
import com.example.potager.bll.PotagerManager;
import com.example.potager.bo.Carre;
import com.example.potager.bo.Exposition;
import com.example.potager.bo.Plante;
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

	@Test
	void addPotagerTest() {
		System.out.println("Ajout de Potager");
		Potager potager = new Potager("serre", "Premier potager", 50, "Quimper");
		potaManager.addPotager(potager);
		System.out.println();
	}

	@Test
	void addCarreToPotager() {
		System.out.println("========= Ajout carré au potager ========");
		Potager potager = new Potager("serre", "Premier potager", 50, "Quimper");
		potaManager.addPotager(potager);
		Carre carre = new Carre(1000, TypeSol.CALCAIRE, Exposition.MI_OMBRE, potager);
		carrManager.addCarre(carre);
		System.out.println(carre);
	}

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
		planteManager.deletePlante(plante);
		System.out.println("======== Delete Plante ========");
		System.out.println(plante);
	}

}
