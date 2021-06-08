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
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Carre {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idCarre;
	
	@OneToMany(mappedBy = "carre", fetch = FetchType.EAGER)
    List<PlanteIntoCarre> plans;
	
	private Integer surface;
	private TypeSol typeSol;
	private Exposition typeExposition;

	@ManyToOne
	private Potager potager;

	public Carre(Integer surface, TypeSol typeSol, Exposition typeExposition, Potager potager) {
		super();
		this.plans = new ArrayList<PlanteIntoCarre>();
		this.surface = surface;
		this.typeSol = typeSol;
		this.typeExposition = typeExposition;
		this.potager = potager;
	}

}
