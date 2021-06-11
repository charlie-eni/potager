package com.example.potager.bo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idCarre")
public class Carre {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idCarre;

	@OneToMany(mappedBy = "carre", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	List<PlanteIntoCarre> plans = new ArrayList<PlanteIntoCarre>();

	private Integer surface;
	private TypeSol typeSol;
	private Exposition typeExposition;

	@ManyToOne
	private Potager potager;

	public Carre(Integer surface, TypeSol typeSol, Exposition typeExposition, Potager potager) {
		super();
		this.surface = surface;
		this.typeSol = typeSol;
		this.typeExposition = typeExposition;
		this.potager = potager;
	}
	public void miseEnPlan(PlanteIntoCarre plan) {
		this.plans.add(plan);
		plan.setCarre(this);
	}
}
