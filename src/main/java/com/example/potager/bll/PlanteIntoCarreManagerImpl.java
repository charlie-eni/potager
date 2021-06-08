package com.example.potager.bll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.potager.bo.PlanteIntoCarre;
import com.example.potager.dal.PlanteIntoCarreDAO;

@Service
public class PlanteIntoCarreManagerImpl implements PlanteIntoCarreManager {

	@Autowired
	PlanteIntoCarreDAO dao;

	@Override
	public void deletePlanIntoCarre(PlanteIntoCarre plan) {
		dao.delete(plan);
	}

	@Override
	public void deletePlanIntoCarreById(Integer id) {
		dao.deleteById(id);
	}

}
