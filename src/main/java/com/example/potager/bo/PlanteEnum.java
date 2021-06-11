package com.example.potager.bo;

public enum PlanteEnum {

	TOMATE(Type.fruit, "Cerise", 20), POMME(Type.fruit, "Golden", 50);

	private final Type typeFruit;
	private String variete;
	private final Integer surface;

	private PlanteEnum(Type typeFruit, String variete, Integer surface) {
		this.typeFruit = typeFruit;
		this.variete = variete;
		this.surface = surface;
	}

	public Type getTypeFruit() {
		return typeFruit;
	}

	public String getVariete() {
		return variete;
	}

	public Integer getSurface() {
		return surface;
	}

	public void setVariete(String variete) {
		this.variete = variete;
	}
}
