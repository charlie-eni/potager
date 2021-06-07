package com.example.potager.dal;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.potager.bo.Potager;

public interface PotagerDAO extends CrudRepository<Potager, Integer> {

	@Query("SELECT p FROM Potager p, Plante a WHERE a.nom =:plantName")
	List<Potager> getPotagerFromPlante(@Param("plantName") String plantName);
}
