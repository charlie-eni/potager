package com.example.potager.bo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class PlanteIntoCarre {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	@ManyToOne
	Plante plante;

	@ManyToOne
	Carre carre;

	private Integer quantite;
	private LocalDate dateMiseEnPlace;
	private LocalDate dateRecolte;

	public PlanteIntoCarre(Integer quantite, LocalDate dateMiseEnPlace, LocalDate dateRecolte) {
		super();
		this.quantite = quantite;
		this.dateMiseEnPlace = dateMiseEnPlace;
		this.dateRecolte = dateRecolte;
	}

}
