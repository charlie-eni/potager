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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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

	@NotBlank(message = "Ne peut pas être nul")
	private String nom;

	private Type type;

	@NotBlank(message = "Ne peut pas être nul")
	private String variete;

	@NotNull(message = "Ne peut pas être nul")
	@Min(value = 1, message = "Surface trop petite, 1 minimum")
	@Max(value = 10000, message = "Surface trop grande, 10000 maximum")
	private Integer surface;

	@NotNull(message = "Ne peut pas être nul")
	@Min(value = 1, message = "Vous devez au minimum mettre une plante")
	private Integer nbPlante;

	//@NotNull(message = "Ne peut pas être nul")
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
