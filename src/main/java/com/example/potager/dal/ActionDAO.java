package com.example.potager.dal;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.potager.bo.Action;

public interface ActionDAO extends CrudRepository<Action, Integer> {

	@Query("SELECT a FROM Action a WHERE a.date<:date")
	List<Action> listAction(@Param("date") LocalDate date);

}
