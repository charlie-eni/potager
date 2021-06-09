package com.example.potager.bll;

import java.util.List;
import java.util.Optional;

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
	public void addPlante(Plante plante) throws PlanteException {

		Optional<Plante> doublon = dao.findByNomAndVariete(plante.getNom(), plante.getVariete());
		if (doublon.isPresent()) {
			throw new PlanteException("Pas de doublons de plantes");
		}
		dao.save(plante);
	}

	@Override
	public void addPlanteToCarre(Plante plante, Carre carre) throws PlanteException {
		addPlante(plante);
	}

	@Override
	public void updatePlante(Plante plante) {
		dao.save(plante);
	}

	@Override
	public void deletePlante(Integer id) {
		dao.deleteById(id);
	}

	@Override
	public List<Plante> getAllPlante() {
		return (List<Plante>) dao.findAll();
	}

	@Override
	public Plante getById(Integer id) {
		return dao.findById(id).orElse(null);
	}

}
