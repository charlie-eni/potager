package com.example.potager.bo;

import java.util.List;

import javax.persistence.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Carre {

	private Integer idCarre;
	private Integer surface;
	private TypeSol typeSol;
	private Exposition typeExposition;
	private Potager potager;
	private List<Plante> plante;

	public Carre(Integer surface, TypeSol typeSol, Exposition typeExposition, Potager potager, List<Plante> plante) {
		super();
		this.surface = surface;
		this.typeSol = typeSol;
		this.typeExposition = typeExposition;
		this.potager = potager;
		this.plante = plante;
	}

}
