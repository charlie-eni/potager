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

	//TODO Une plante dans un carré
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idPlante;
	private String nom;
	private Type type;
	private String variete;	
	private Integer surface;
	private Integer nbPlante;
	private LocalDate miseEnPlace;
	private LocalDate dateRecolte;
	
	public Plante(String nom, Type type, String variete, Integer surface, Integer nbPlante, LocalDate miseEnPlace,
			LocalDate dateRecolte) {
		super();
		this.nom = nom;
		this.type = type;
		this.variete = variete;
		this.surface = surface;
		this.nbPlante = nbPlante;
		this.miseEnPlace = miseEnPlace;
		this.dateRecolte = dateRecolte;
	}
	
	

	
}
