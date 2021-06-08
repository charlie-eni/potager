package com.example.potager.bll;

import java.util.List;

import com.example.potager.bo.Carre;
import com.example.potager.bo.Potager;
import com.example.potager.bo.TypeSol;

public interface PotagerManager {

	public void addPotager(Potager potager);
	
	public void updatePotager(Potager potager);
	
	public void deletePotager(Potager potager);
	
	public List<Potager> getAllPotager();
	
	public Potager getById(Integer id);
	
	public Integer getPotagerByPlant(String plantName);
}
