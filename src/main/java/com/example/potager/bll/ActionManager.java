package com.example.potager.bll;

import java.util.List;

import com.example.potager.bo.Action;

public interface ActionManager {

	public void addAction(Action action);
	
	public List<Action> listActionForTwoWeeks();
	
}
