package com.example.potager.dal;

import org.springframework.data.repository.CrudRepository;

import com.example.potager.bo.Plante;

public interface PlanteDAO extends CrudRepository<Plante, Integer> {

}
