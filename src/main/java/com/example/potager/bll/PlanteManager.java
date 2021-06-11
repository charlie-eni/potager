package com.example.potager.bll;

import java.util.List;

import com.example.potager.bo.Plante;

public interface PlanteManager {

	public void addPlante(Plante plante) throws PlanteException;

	public void updatePlante(Plante plante, Integer id);

	public void deletePlante(Integer id);

	public List<Plante> getAllPlante();

	public Plante getById(Integer id);

}
