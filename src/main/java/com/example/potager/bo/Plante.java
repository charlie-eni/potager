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
public class Plante {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idPlante;
	private String nom;
	private Type type;
	private String variete;	
	private Integer surface;
	private Carre carre;
	private Integer nbPlante;
	private LocalDate miseEnPlace;
	
	public Plante(String nom, Type type, String variete, Integer surface, Carre carre, Integer nbPlante,
			LocalDate miseEnPlace) {
		super();
		this.nom = nom;
		this.type = type;
		this.variete = variete;
		this.surface = surface;
		this.carre = carre;
		this.nbPlante = nbPlante;
		this.miseEnPlace = miseEnPlace;
	}
	
	
	

	
}
