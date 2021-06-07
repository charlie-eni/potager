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
		// TODO Auto-generated method stub

	}

	@Override
	public List<Potager> getAllPotager() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Potager getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
