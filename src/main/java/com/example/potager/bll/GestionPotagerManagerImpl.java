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

	@Autowired
	GestionPotagerManager gestionManager;

	@Override
	@Transactional
	public void addPlanteToPotager(Plante plante, Carre carre, PlanteIntoCarre plan)
			throws PlanteIntoCarreException, CarreException {

		List<Plante> lstPlante = planteManager.getAllPlante();
		List<Integer> lstSurface = new ArrayList<Integer>();

		List<Plante> lstNomPlante = new ArrayList<Plante>();

		for (Plante p : lstPlante) {

			for (PlanteIntoCarre pic : p.getPlans()) {
				if (pic.getCarre().getIdCarre() == carre.getIdCarre()) {

					lstSurface.add((p.getSurface() * p.getNbPlante()));
				}

				if (pic.getCarre().getIdCarre().equals(carre.getIdCarre())) {
					lstNomPlante.add(pic.getPlante());
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

		if (3 < (lstNomPlante.size() + 1)) {
			throw new PlanteIntoCarreException("Vous avez atteint le maximum de plantes pour ce carré");
		}

		plante.miseEnPlan(plan);
		carre.miseEnPlan(plan);
		planDAO.save(plan);
		planteDAO.save(plante);
		carDAO.save(carre);
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
	@Transactional
	public void deletePlan(Integer id) {

		PlanteIntoCarre plan = planDAO.findById(id).orElse(null);

		planteDAO.delete(plan.getPlante());

		planDAO.deleteById(id);
	}

	@Override
	public List<PlanteIntoCarre> listPlan() {
		return (List<PlanteIntoCarre>) planDAO.findAll();
	}

	@Override
	public void deletePlanByPlante(Plante plante) {
		planDAO.deleteByPlante(plante);
	}

}
