package com.example.potager.bll;

import java.util.List;

import com.example.potager.bo.Potager;

public interface PotagerManager {

	public void addPotager(Potager potager);

	public void updatePotager(Potager potager, Integer id);

	public void deletePotager(Potager potager);
	
	public void deletePotagerById(Integer id);

	public List<Potager> getAllPotager();

	public Potager getById(Integer id);
}
