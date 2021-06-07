package com.example.potager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.potager.bll.PotagerManager;
import com.example.potager.bo.Potager;

@SpringBootTest
class FonctionnalitesTests {

	@Autowired
	PotagerManager potaManager;

	@Test
	void addPotagerTest() {
		System.out.println("Ajout de Potager");
		Potager potager = new Potager("serre", "Premier potager", "50", "Quimper");
		potaManager.addPotager(potager);
		System.out.println();
	}

}
