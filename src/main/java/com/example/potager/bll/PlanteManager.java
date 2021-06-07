package com.example.potager.bll;

import java.util.List;

import com.example.potager.bo.Carre;
import com.example.potager.bo.Plante;

public interface PlanteManager {

	public void addPlante(Plante plante);

	public void addPlanteToCarre(Plante plante, Carre carre);

	public void updatePlante(Plante plante);

	public void deletePlante(Integer id);

	public List<Plante> getAllPlante();

	public Plante getById(Integer id);

}
