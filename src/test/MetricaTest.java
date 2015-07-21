package test;

import static org.junit.Assert.*;
import model.Indicador;
import model.Metrica;

import org.junit.Test;

public class MetricaTest {

	Metrica m = new Metrica();

	
	@Test
	public void testGetIndicador() {
		
		Indicador i = new Indicador();
		i.setDescricao("Ind 1");
		m.setIndicador(i);
		assertEquals(i, m.getIndicador());
		
	}

	@Test
	public void testGetId() {
		m.setId(10);
		assertEquals("Tetstes", 10, m.getId());
	}

	@Test
	public void testGetTipo() {
		m.setTipo("SIMPLES");
		assertEquals("SIMPLES", m.getTipo());
	}


	@Test
	public void testGetProcessoColeta() {
		m.setProcessoColeta("Processo de coleta");
		assertEquals("Processo de coleta", m.getProcessoColeta());
	}

	

	@Test
	public void testGetProcessoAnalise() {
		m.setProcessoColeta("Processo de Analise");
		assertEquals("Processo de Analise", m.getProcessoColeta());
	}

		@Test
	public void testGetNome() {
		m.setNome("Metrica 1");
		assertEquals("Metrica 1", m.getNome());
	}


	/*@Test
	public void testGetValor() {
		m.setValor(5.1);
		assertEquals(5.1, m.getValor());
	}*/



}
