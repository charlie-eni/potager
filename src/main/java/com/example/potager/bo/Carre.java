package com.example.potager.bo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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

	@OneToMany(mappedBy = "carre", fetch = FetchType.EAGER)
	List<PlanteIntoCarre> plans = new ArrayList<PlanteIntoCarre>();

	@NotNull(message="Ne peut pas être nul")
	@Min(value = 1, message = "Surface trop petite, 1 minimum") 
	@Max(value = 10000, message = "Surface trop grande, 10000 maximum")
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
