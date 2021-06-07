package com.example.potager.bll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.potager.bo.Carre;
import com.example.potager.bo.Plante;
import com.example.potager.dal.CarreDAO;

@Service
public class CarreManagerImpl implements CarreManager {

	@Autowired
	CarreDAO dao;

	@Override
	public void addCarre(Carre carre) {
		dao.save(carre);
	}

	@Override
	public void removeCarre(Carre carre) {
		dao.delete(carre);
	}

	@Override
	public void removeCarreById(Integer id) {
		dao.deleteById(id);
	}

	@Override
	public void updateCarre(Carre carre) {
		dao.save(carre);
	}

	@Override
	public Plante getNomPlante() {
		return null;
	}

}
