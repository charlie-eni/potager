package com.example.potager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.potager.bll.ActionManager;
import com.example.potager.bll.CarreException;
import com.example.potager.bll.CarreManager;
import com.example.potager.bll.PlanteManager;
import com.example.potager.bll.PotagerManager;
import com.example.potager.bo.Carre;
import com.example.potager.bo.Exposition;
import com.example.potager.bo.Potager;
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
	ActionManager actionManager;
	
	@Test
	void surfaceCarreInferieurSurfacePotager() throws CarreException {
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

}
