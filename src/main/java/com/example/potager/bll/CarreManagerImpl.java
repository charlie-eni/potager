package com.example.potager.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.potager.bo.Carre;
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
	public void deleteCarre(Carre carre) {
		dao.delete(carre);
	}

	/*
	 * @Override public void removeCarreById(Integer id) { dao.deleteById(id); }
	 */

	@Override
	public void updateCarre(Carre carre) {
		dao.save(carre);
	}

	@Override
	public Carre getById(Integer id) {
		return dao.findById(id).orElse(null);
	}

	@Override
	public List<Carre> getAllCarre() {
		return (List<Carre>) dao.findAll();
	}

}
