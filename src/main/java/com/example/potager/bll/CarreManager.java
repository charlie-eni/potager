package com.example.potager.bll;

import java.util.List;

import com.example.potager.bo.Carre;

public interface CarreManager {

	public void addCarre(Carre carre) throws CarreException;

	public void deleteCarre(Carre carre);

	public void deleteCarreById(Integer id);

	public void updateCarre(Carre carre, Integer id)throws CarreException;

	public Carre getById(Integer id);

	public List<Carre> getAllCarre();

}
