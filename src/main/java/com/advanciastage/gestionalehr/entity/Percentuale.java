package com.advanciastage.gestionalehr.entity;

public class Percentuale {

	private Integer percentuale;
	private Double valore;
	public Integer getPercentuale() {
		return percentuale;
	}
	public void setPercentuale(Integer percentuale) {
		this.percentuale = percentuale;
	}
	public Double getValore() {
		return valore;
	}
	public void setValore(Double valore) {
		this.valore = valore;
	}
	public Percentuale(Integer percentuale, Double valore) {
		super();
		this.percentuale = percentuale;
		this.valore = valore;
	}
}
