package com.example.potager.bll;

import java.util.List;

import com.example.potager.bo.Carre;

public interface CarreManager {

	public void addCarre(Carre carre) throws CarreException;

	public void deleteCarre(Carre carre);

	public void removeCarreById(Integer id);

	public void updateCarre(Carre carre, Integer id);

	public Carre getById(Integer id);

	public List<Carre> getAllCarre();

}
