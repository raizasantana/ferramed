package model;

public class Metrica {
	
	private String processoColeta, processoAnalise, nome, tipo;
	Indicador indicador;
	private float valor;
	private int id;
	
	public Indicador getIndicador(){
		return indicador;
	}
	
	public void setIndicador(Indicador t)
	{
		this.indicador = t;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getProcessoColeta() {
		return processoColeta;
	}
	public void setProcessoColeta(String processoColeta) {
		this.processoColeta = processoColeta;
	}
	public String getProcessoAnalise() {
		return processoAnalise;
	}
	public void setProcessoAnalise(String processoAnalise) {
		this.processoAnalise = processoAnalise;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	
	

}
