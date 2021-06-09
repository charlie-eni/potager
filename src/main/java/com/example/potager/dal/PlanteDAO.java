package com.example.potager.dal;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.potager.bo.Plante;

public interface PlanteDAO extends CrudRepository<Plante, Integer> {

	Optional<Plante> findByNomAndVariete(String nom, String variete);

	Optional<Plante> findByNom(String nom);
}
