package com.example.potager;

import java.time.LocalDate;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.potager.bll.ActionManager;
import com.example.potager.bo.Action;

@Component
public class DBinit {

	@Autowired
	ActionManager actionMger;
	
	@PostConstruct
	private void postConstruct() {
		actionMger.addAction(new Action(LocalDate.now(), "NOW!", "fdsfds"));
		actionMger.addAction(new Action(LocalDate.now().plusMonths(1), "Dans un mois", "fdsfds"));
	}

}
