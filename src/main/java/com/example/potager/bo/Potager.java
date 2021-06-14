package com.example.potager.bo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idPotager")
public class Potager {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idPotager;
	private String localisation;
	private String nom;
	
	@NotNull(message="Ne peut pas être nul")
	@Min(value = 1, message = "Surface trop petite, 1 minimum") 
	@Max(value = 10000, message = "Surface trop grande, 10000 maximum")
	private Integer surface;
	private String ville;

	@OneToMany(mappedBy = "potager")
	private List<Carre> carre;

	public Potager(String localisation, String nom, Integer surface, String ville) {
		super();
		this.carre = new ArrayList<Carre>();
		this.localisation = localisation;
		this.nom = nom;
		this.surface = surface;
		this.ville = ville;
	}

	public void addCarre(Carre carre) {
		this.carre.add(carre);
		carre.setPotager(this);
	}

}
