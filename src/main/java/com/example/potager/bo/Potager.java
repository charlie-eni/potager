package com.example.potager.bo;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class Potager {
	private String localisation;
	private String nom;
	private String surface;
	private String ville;

}
