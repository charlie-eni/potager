package com.example.potager.bll;

import java.util.ArrayList;
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
	public void addCarre(Carre carre) throws CarreException {

		List<Integer> lstSurface = new ArrayList<Integer>();
		List<Carre> lstCarre = getAllCarre();

		for (Carre carre2 : lstCarre) {
			if (carre.getPotager().getIdPotager() == carre2.getPotager().getIdPotager()) {
				lstSurface.add(carre2.getSurface());
			}
		}
		int sum = 0;
		for (int i = 0; i < lstSurface.size(); i++) {
			sum += lstSurface.get(i);
		}

		if ((sum + carre.getSurface()) > carre.getPotager().getSurface()) {
			throw new CarreException("La surface des carrés est plus importante que le Potager");
		}

		dao.save(carre);
	}

	@Override
	public void deleteCarre(Carre carre) {
		dao.delete(carre);
	}

	@Override
	public void removeCarreById(Integer id) {
		dao.deleteById(id);
	}

	@Override
	public void updateCarre(Carre carre, Integer id) {
		carre.setIdCarre(id);
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
