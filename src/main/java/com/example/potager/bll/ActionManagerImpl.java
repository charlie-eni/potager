package com.example.potager.bll;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.potager.bo.Action;
import com.example.potager.dal.ActionDAO;

public class ActionManagerImpl implements ActionManager {

	@Autowired
	ActionDAO dao;
	
	@Override
	public void addAction(Action action) {
		dao.save(action);
	}

}
