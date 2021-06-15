package com.example.potager.dal;

import org.springframework.data.repository.CrudRepository;

import com.example.potager.bo.Plante;
import com.example.potager.bo.PlanteIntoCarre;

public interface PlanteIntoCarreDAO extends CrudRepository<PlanteIntoCarre, Integer> {

	void deleteByPlante(Plante plante);
}
