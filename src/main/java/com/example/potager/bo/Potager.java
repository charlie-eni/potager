package com.example.potager.bo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Potager {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idPotager;
	private String localisation;
	private String nom;
	private Integer surface;
	private String ville;

	@OneToMany(mappedBy = "potager", cascade = CascadeType.ALL)
	private List<Carre> lstCarre = new ArrayList<Carre>();


	public Potager(String localisation, String nom, Integer surface, String ville) {
		super();
		this.localisation = localisation;
		this.nom = nom;
		this.surface = surface;
		this.ville = ville;
	}
	
	public void addCarre(Carre carre) {
		lstCarre.add(carre);
		carre.setPotager(this);
	}

}
