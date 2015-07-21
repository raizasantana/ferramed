package test;

import static org.junit.Assert.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Metrica;

import org.junit.Test;

import servlet.MetricaServlet;

public class MetricaFuncionalTest {
	
	HttpServletRequest request;
	HttpServletResponse response;
	
	
	MetricaServlet mServlet = new MetricaServlet();
			
	@Test
	public void testGetMetrica() {
		request.setAttribute("id", 1);	
		Metrica m = new Metrica();
		m.setId(1);		
		
		mServlet.getMetrica(request, response);
		
		assertEquals(1,request.getParameter("metrica_id"));
		
	}

	@Test
	public void testEditarMetrica() {
		fail("Not yet implemented");
	}

}
