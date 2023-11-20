package com.advanciastage.gestionalehr.entity;

import java.util.ArrayList;
import java.util.List;

public class Percentuali {
 private List<Percentuale> lista;
 
 public Percentuali() {
	 this.lista=new ArrayList<>();
	 lista.add(new Percentuale(1,0.99));
	 lista.add(new Percentuale(2,0.98));
	 lista.add(new Percentuale(3,0.97));
	 lista.add(new Percentuale(4,0.96));
	 lista.add(new Percentuale(5,0.95));
	 lista.add(new Percentuale(6,0.94));
	 lista.add(new Percentuale(7,0.93));
	 lista.add(new Percentuale(8,0.92));
	 lista.add(new Percentuale(9,0.91));
	 lista.add(new Percentuale(10,0.90));
	 
 }

public List<Percentuale> getLista() {
	return lista;
}

public void setLista(List<Percentuale> lista) {
	this.lista = lista;
}
}
