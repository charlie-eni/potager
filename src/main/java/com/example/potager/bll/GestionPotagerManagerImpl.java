package com.example.potager.bll;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.potager.bo.Action;
import com.example.potager.bo.Carre;
import com.example.potager.bo.Plante;
import com.example.potager.bo.PlanteIntoCarre;
import com.example.potager.bo.Potager;
import com.example.potager.dal.CarreDAO;
import com.example.potager.dal.PlanteDAO;
import com.example.potager.dal.PlanteIntoCarreDAO;
import com.example.potager.dal.PotagerDAO;

@Service
public class GestionPotagerManagerImpl implements GestionPotagerManager {

	@Autowired
	CarreDAO carDAO;

	@Autowired
	PotagerDAO potaDAO;

	@Autowired
	PlanteDAO planteDAO;
	
	@Autowired
	PlanteIntoCarreDAO planDAO;

	@Override
	@Transactional
	public void addPlanteToPotager(Potager potager, Plante plante, Carre carre, PlanteIntoCarre plan) {
		plan.addCarre(carre);
		plan.addPlante(plante);
		potager.addCarre(carre);
		planDAO.save(plan);
		planteDAO.save(plante);
		carDAO.save(carre);
		potaDAO.save(potager);
	}

	@Override
	public List<Potager> showPotager() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addAction(Action action) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Action> showAction() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getPotagerByPlanteName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePlan(Integer id) {
		// TODO Auto-generated method stub

	}

}
