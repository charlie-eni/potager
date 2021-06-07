package com.example.potager.dal;

import org.springframework.data.repository.CrudRepository;

import com.example.potager.bo.Potager;

public interface PotagerDAO extends CrudRepository<Potager, Integer> {

}
