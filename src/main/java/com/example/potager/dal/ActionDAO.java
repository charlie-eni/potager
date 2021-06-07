package com.example.potager.dal;

import org.springframework.data.repository.CrudRepository;

import com.example.potager.bo.Action;

public interface ActionDAO extends CrudRepository<Action, Integer> {

}
