package com.example.potager.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.potager.bo.Carre;
import com.example.potager.bo.Plante;
import com.example.potager.dal.PlanteDAO;

@Service
public class PlanteManagerImpl implements PlanteManager {

	@Autowired
	private PlanteDAO dao;
	
	@Override
	public void addPlante(Plante plante) {
		dao.save(plante);
		
	}

	@Override
	public void addPlanteToCarre(Plante plante, Carre carre) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePlante(Plante plante) {
		dao.save(plante);
		
	}

	@Override
	public void deletePlante(Plante plante) {
		dao.delete(plante);
		
	}

	@Override
	public List<Plante> getAllPlante() {

		return (List<Plante>)dao.findAll();
	}

	@Override
	public Plante getById(Integer id) {
		
		return null;
	}

}