package com.example.potager.bo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Plante {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idPlante;
	
	@OneToMany(mappedBy = "plante", fetch = FetchType.EAGER)
    List<PlanteIntoCarre> plans;

	private String nom;
	private Type type;
	private String variete;
	private Integer surface;
	private Integer nbPlante;
	private LocalDate miseEnPlace;

	public Plante(String nom, Type type, String variete, Integer surface, Integer nbPlante,
			LocalDate miseEnPlace) {
		super();
		this.plans = new ArrayList<PlanteIntoCarre>();
		this.nom = nom;
		this.type = type;
		this.variete = variete;
		this.surface = surface;
		this.nbPlante = nbPlante;
		this.miseEnPlace = miseEnPlace;
	}

}
