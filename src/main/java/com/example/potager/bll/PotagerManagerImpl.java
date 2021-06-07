package com.example.potager.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.potager.bo.Potager;
import com.example.potager.dal.PotagerDAO;

@Service
public class PotagerManagerImpl implements PotagerManager {

	@Autowired
	PotagerDAO dao;

	@Override
	public void addPotager(Potager potager) {
		dao.save(potager);
	}

	@Override
	public void updatePotager(Potager potager) {
		dao.save(potager);
	}

	@Override
	public void deletePotager(Potager potager) {
		dao.delete(potager);
	}

	@Override
	public List<Potager> getAllPotager() {
		return (List<Potager>) dao.findAll();
	}

	@Override
	public Potager getById(Integer id) {
		return dao.findById(id).orElse(null);
	}
	
	public List<Potager> getPotagerByPlant(String plantName){
		return dao.getPotagerFromPlante(plantName);
	}

}
