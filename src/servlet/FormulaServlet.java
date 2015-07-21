package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Formula;
import model.Metrica;
import dao.FormulaDAO;
import dao.MetricaDAO;

@WebServlet("/formula/formula")
public class FormulaServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	{
		String acao = (String) request.getParameter("acao");
		
		
		if (acao != null)
		{
			switch (acao)
			{
				case "Criar":
					criarFormula(request, response);
					break;
				case "listarMetrica":
					listarMetrica(request, response);
					break;
				case "listar":
					listarFormulas(request, response);
					break;
				case "editarFormula":
					getFormula(request, response);
					break;
				case "atualizarFormula":
					editarFormula(request, response);
					break;
				default:
					break;
			}
		}
	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	{
		String acao = (String) request.getParameter("acao");
		
		
		if (acao != null)
		{
			switch (acao)
			{
				case "Criar":
					criarFormula(request, response);
					break;
				case "listarMetrica":
					listarMetrica(request, response);
					break;
				case "listar":
					listarFormulas(request, response);
					break;
				case "editarFormula":
					getFormula(request, response);
					break;
				case "atualizarFormula":
					editarFormula(request, response);
					break;	
				default:
					break;
			}
		}

	}
	
	private void criarFormula(HttpServletRequest request, HttpServletResponse response) {
		String message = "Fórmula inserida com sucesso.";
			
		Formula f = new Formula();
		f.setNome(request.getParameter("nome"));
		MetricaDAO mDAO = new MetricaDAO();
		int metrica1_id = Integer.valueOf(request.getParameter("metrica1_id"));
		int metrica2_id = Integer.valueOf(request.getParameter("metrica2_id"));
		Metrica m1 = mDAO.getMetrica(metrica1_id);
		Metrica m2 = mDAO.getMetrica(metrica2_id);
		
		f.setMetrica1(m1);
		f.setMetrica2(m2);
		f.setOperador(request.getParameter("operador"));

		
		FormulaDAO fDAO = new FormulaDAO();
		try {
			fDAO.adicionarFormula(f);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			message = "Erro ao inserir formula. Tente novamente mais tarde";
		}
		
		request.setAttribute("message", message);
		
		try {
			request.getRequestDispatcher("formula?acao=listarMetrica").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private void listarMetrica(HttpServletRequest request, HttpServletResponse response){
		MetricaDAO mDao = new MetricaDAO();
		List<Metrica> metricas = mDao.listarMetricasCompostas();
		request.setAttribute("metricas", metricas);
		
		List<String> operadores = new ArrayList<String>();
		operadores.add("+");
		operadores.add("-");
		operadores.add("*");
		operadores.add("/");
		request.setAttribute("operadores", operadores);
		
		try {
			request.getRequestDispatcher("criarFormula.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void listarFormulas(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
				
		FormulaDAO fDAO = new FormulaDAO();
		ArrayList<Formula> formulas = new ArrayList<Formula>();
		try {
			formulas = fDAO.listarFormulas();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		request.setAttribute("formulas",formulas);
		
		try {
			request.getRequestDispatcher("listarFormulas.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void getFormula(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id = Integer.valueOf(request.getParameter("id"));
		MetricaDAO mDao = new MetricaDAO();
		List<Metrica> metricas = mDao.listarMetricasCompostas();
		request.setAttribute("metricas", metricas);
		
		List<String> operadores = new ArrayList<String>();
		operadores.add("+");
		operadores.add("-");
		operadores.add("*");
		operadores.add("/");
		request.setAttribute("operadores", operadores);
		
		FormulaDAO fDAO = new FormulaDAO();
		Formula f;
		try {
			f = fDAO.getFormula(id);
			request.setAttribute("formula_id", f.getId());
			request.setAttribute("formula_nome",f.getNome());
			request.setAttribute("metrica1_id",f.getMetrica1().getId());
			request.setAttribute("metrica2_id",f.getMetrica2().getId());
			request.setAttribute("operador_f",f.getOperador());
			
			request.getRequestDispatcher("editarFormula.jsp").forward(request, response);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	public void editarFormula(HttpServletRequest request,
			HttpServletResponse response) {
		
		
		int id = Integer.valueOf(request.getParameter("id"));

		
		Formula f = new Formula();
		f.setId(id);
		f.setNome(request.getParameter("nome"));
		f.setNome(request.getParameter("nome"));
		MetricaDAO mDAO = new MetricaDAO();
		int metrica1_id = Integer.valueOf(request.getParameter("metrica1_id"));
		int metrica2_id = Integer.valueOf(request.getParameter("metrica2_id"));
		Metrica m1 = mDAO.getMetrica(metrica1_id);
		Metrica m2 = mDAO.getMetrica(metrica2_id);
		
		f.setMetrica1(m1);
		f.setMetrica2(m2);
		f.setOperador(request.getParameter("operador_f"));
		FormulaDAO fDAO = new FormulaDAO();
		try {
			fDAO.editarFormula(f);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		
		listarFormulas(request, response);
		
	}
}
