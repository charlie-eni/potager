package com.example.potager.bll;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.potager.bo.Action;
import com.example.potager.bo.Carre;
import com.example.potager.bo.Plante;
import com.example.potager.bo.PlanteIntoCarre;
import com.example.potager.bo.Potager;
import com.example.potager.dal.ActionDAO;
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
	PlanteManager planteManager;

	@Autowired
	PlanteIntoCarreDAO planDAO;

	@Autowired
	ActionDAO actionDAO;

	@Override
	@Transactional
	public void addPlanteToPotager(Potager potager, Plante plante, Carre carre, PlanteIntoCarre plan)
			throws PlanteIntoCarreException {

		List<Plante> lstPlante = planteManager.getAllPlante();
		List<Integer> lstSurface = new ArrayList<Integer>();

		for (Plante p : lstPlante) {

			for (PlanteIntoCarre pic : p.getPlans()) {
				if (pic.getCarre().getIdCarre() == carre.getIdCarre()) {

					lstSurface.add((p.getSurface() * p.getNbPlante()));
				}
			}

		}
		int sum = 0;
		for (int i = 0; i < lstSurface.size(); i++) {
			sum += lstSurface.get(i);
		}

		if ((sum + (plante.getSurface() * plante.getNbPlante())) > carre.getSurface()) {
			throw new PlanteIntoCarreException("La limite de plante est atteinte pour le carré!");
		}

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
		return (List<Potager>) potaDAO.findAll();
	}

	@Override
	public void addAction(Action action) throws PlanteIntoCarreException {
		if (action.getDate().isBefore(LocalDate.now())) {
			throw new PlanteIntoCarreException("La date n'est pas valide");
		}
		actionDAO.save(action);
	}

	@Override
	public List<Action> listActionForTwoWeeks() {
		LocalDate date = LocalDate.now().plusDays(14);
		return actionDAO.listAction(date);
	}

	@Override
	public Integer getPotagerByPlant(String plantName) {
		return potaDAO.getPotagerFromPlante(plantName);
	}

	@Override
	public void deletePlan(Integer id) {
		planDAO.deleteById(id);
	}

}
