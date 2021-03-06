package com.example.potager.bll;

import java.util.List;

import com.example.potager.bo.Action;
import com.example.potager.bo.Carre;
import com.example.potager.bo.Plante;
import com.example.potager.bo.PlanteIntoCarre;
import com.example.potager.bo.Potager;

public interface GestionPotagerManager {

	public void addPlanteToPotager(Plante plante, Carre carre, PlanteIntoCarre plan)
			throws PlanteIntoCarreException, CarreException;

	public List<Potager> showPotager();

	public void addAction(Action action) throws PlanteIntoCarreException;

	public List<Action> listActionForTwoWeeks();

	public List<PlanteIntoCarre> listPlan();

	public Integer getPotagerByPlant(String plantName);

	public void deletePlan(Integer id);

	public void deletePlanByPlante(Plante plante);
}
