package com.example.potager.dal;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.potager.bo.Carre;
import com.example.potager.bo.Potager;
import com.example.potager.bo.TypeSol;

public interface PotagerDAO extends CrudRepository<Potager, Integer> {

	@Query("SELECT c.idCarre FROM PlanteIntoCarre pic JOIN pic.carre c JOIN pic.plante pl WHERE pl.nom = :plantName")
	Integer getPotagerFromPlante(@Param("plantName") String plantName);
}
