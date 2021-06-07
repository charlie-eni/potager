package com.example.potager.bll;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.potager.bo.Action;
import com.example.potager.dal.ActionDAO;

@Service
public class ActionManagerImpl implements ActionManager {

	@Autowired
	ActionDAO dao;

	@Override
	public void addAction(Action action) {
		dao.save(action);
	}

	@Override
	public List<Action> listActionForTwoWeeks() {
		LocalDate date = LocalDate.now().plusDays(14);
		return dao.listAction(date);
		
	}

}
