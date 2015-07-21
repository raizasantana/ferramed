package model;

import java.util.List;

public class Formula {
	
	
	private int id;
	private String nome;
	private Metrica metrica1;
	private Metrica metrica2;
	private String operador;
	
	public Formula(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Metrica getMetrica1() {
		return metrica1;
	}

	public void setMetrica1(Metrica metrica1) {
		this.metrica1 = metrica1;
	}

	public Metrica getMetrica2() {
		return metrica2;
	}

	public void setMetrica2(Metrica metrica2) {
		this.metrica2 = metrica2;
	}

	public String getOperador() {
		return operador;
	}

	public void setOperador(String operador) {
		this.operador = operador;
	}

	
	
	
	
}
