package model;

import java.sql.Date;

import dao.MetricaDAO;

public class Coleta {
	private int id;
	private Metrica metrica;
	private Date data;
	private String observacao;
	private float valor;
	
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float f) {
		this.valor = f;
	}
	public Metrica getMetrica() {
		return metrica;
	}
	public void setMetrica(int id_metrica) {
		MetricaDAO mDAO = new MetricaDAO();
		metrica = mDAO.getMetrica(id_metrica);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
}