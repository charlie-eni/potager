package com.example.potager.dal;

import org.springframework.data.repository.CrudRepository;

import com.example.potager.bo.Plante;
import com.example.potager.bo.PlanteIntoCarre;

public interface PlanteIntoCarreDAO extends CrudRepository<PlanteIntoCarre, Integer> {

//	@Query("DELETE FROM PlanteIntoCarre pic WHERE pic.plante = :id")
//	Integer deleteByPlanteIdPlante(@Param("id") Integer id);
	
	void deleteByPlante(Plante plante);
}
