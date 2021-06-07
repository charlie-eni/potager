package com.example.potager.bo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Action {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idAction;
	private LocalDate date;						
	private String evenement;						
	private String lieu; //(quel potager ou quel carré ou “serre” ou “autre”)	
	
	public Action(LocalDate date, String evenement, String lieu) {
		super();
		this.date = date;
		this.evenement = evenement;
		this.lieu = lieu;
	}
	
	
}
