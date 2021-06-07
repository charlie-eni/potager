package com.example.potager;

import java.time.LocalDate;

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

}
