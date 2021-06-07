package com.example.potager.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	private String surface;
	private String ville;

}
