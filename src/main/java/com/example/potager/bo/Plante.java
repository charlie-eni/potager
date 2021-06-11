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

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idPlante")
public class Plante {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idPlante;

	@OneToMany(mappedBy = "plante", fetch = FetchType.EAGER)
	List<PlanteIntoCarre> plans = new ArrayList<PlanteIntoCarre>();

	private String nom;
	private Type type;
	private String variete;
	private Integer surface;
	private Integer nbPlante;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate miseEnPlace;

	public Plante(String nom, Type type, String variete, Integer surface, Integer nbPlante, LocalDate miseEnPlace) {
		super();
		this.nom = nom;
		this.type = type;
		this.variete = variete;
		this.surface = surface;
		this.nbPlante = nbPlante;
		this.miseEnPlace = miseEnPlace;
	}

	public void miseEnPlan(PlanteIntoCarre plan) {
		this.plans.add(plan);
		plan.setPlante(this);
	}

}
