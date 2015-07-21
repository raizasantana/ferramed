package test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import model.Formula;

import org.junit.Before;
import org.junit.Test;

import dao.FormulaDAO;

public class FormulaTest {
	
	@Test
	public void testGetId() {
		Formula formula = new Formula();
		FormulaDAO fDAO = new FormulaDAO();
		try {
			formula = fDAO.getFormula(2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(2, formula.getId());
		
	}

	@Test
	public void testGetNome() {
		Formula formula = new Formula();
		FormulaDAO fDAO = new FormulaDAO();
		try {
			formula = fDAO.getFormula(2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("Formula 1", formula.getNome());
	}

	@Test
	public void testGetMetrica1() {
		Formula formula = new Formula();
		FormulaDAO fDAO = new FormulaDAO();
		try {
			formula = fDAO.getFormula(2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("Metrica Composta 1", formula.getMetrica1().getNome());
	}

	@Test
	public void testGetMetrica2() {
		Formula formula = new Formula();
		FormulaDAO fDAO = new FormulaDAO();
		try {
			formula = fDAO.getFormula(2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("Metrica Composta 2", formula.getMetrica2().getNome());
	}

	@Test
	public void testGetOperador() {
		Formula formula = new Formula();
		FormulaDAO fDAO = new FormulaDAO();
		try {
			formula = fDAO.getFormula(2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("+", formula.getOperador());
	}

}
