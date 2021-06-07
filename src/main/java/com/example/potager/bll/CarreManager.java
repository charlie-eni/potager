package com.example.potager.bll;

import com.example.potager.bo.Carre;
import com.example.potager.bo.Plante;

public interface CarreManager {

	public void addCarre(Carre carre);
	
	public void removeCarre(Carre carre);
	
	public void removeCarreById(Integer id);
	
	public void updateCarre(Carre carre);
	
	public Plante getNomPlante();
	
}
