package com.example.potager.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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

	private Integer surface;
	private TypeSol typeSol;
	private Exposition typeExposition;

	@ManyToOne
	private Potager potager;

	@OneToOne
	private Plante plante;

	public Carre(Integer surface, TypeSol typeSol, Exposition typeExposition, Potager potager, Plante plante) {
		super();
		this.surface = surface;
		this.typeSol = typeSol;
		this.typeExposition = typeExposition;
		this.potager = potager;
		this.plante = plante;
	}

}
