package com.example.potager.bll;

import java.util.List;

import com.example.potager.bo.Action;
import com.example.potager.bo.Carre;
import com.example.potager.bo.Plante;
import com.example.potager.bo.PlanteIntoCarre;
import com.example.potager.bo.Potager;

public interface GestionPotagerManager {

	public void addPlanteToPotager(Potager potager, Plante plante, Carre carre, PlanteIntoCarre plan) throws PlanteIntoCarreException;

	public List<Potager> showPotager();

	public void addAction(Action action) throws PlanteIntoCarreException;

	public List<Action> listActionForTwoWeeks();

	public Integer getPotagerByPlant(String plantName);

	public void deletePlan(Integer id);
}
