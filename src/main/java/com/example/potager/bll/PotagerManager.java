package com.example.potager.bll;

import java.util.List;

import com.example.potager.bo.Potager;

public interface PotagerManager {

	public void addPotager(Potager potager);
	public void updatePotager(Potager potager);
	public void deletePlante(Potager potager);
	public List<Potager> getAllPotager();
	public Potager getById(Integer id);
}
