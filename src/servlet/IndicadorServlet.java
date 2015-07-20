package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IndicadorDAO;
import dao.MetricaDAO;
import model.Indicador;
import model.Metrica;

@WebServlet("/indicador/indicador")
public class IndicadorServlet extends HttpServlet{
	
private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	{
		String acao = (String) request.getParameter("acao");
		
		
		if (acao != null)
		{
			switch (acao)
			{
				case "Criar":
					criarIndicador(request, response);
					break;
				case "listar":
					listarIndicadores(request, response);
					break;
				case "atualizarIndicador":
					editarIndicador(request, response);
					break;
				/*case "editarMetrica":
					getMetrica(request, response);
					break;
				case "atualizarMetrica":
					editarMetrica(request, response);
					break;*/
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
				criarIndicador(request, response);
				break;
				case "listar":
					listarIndicadores(request, response);
				break;
				case "editarIndicador":
					getIndicador(request, response);
					break;
				case "atualizarIndicador":
					editarIndicador(request, response);
					break;	
				default:
					break;
			}
		}

	}
	
	public void criarIndicador(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		
		Indicador indicador = new Indicador();
		indicador.setDescricao(request.getParameter("descricao"));
		indicador.setMeta(Float.valueOf(request.getParameter("meta")));
		
		IndicadorDAO iDAO = new IndicadorDAO();
		try {
			iDAO.criarIndicador(indicador);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		listarIndicadores(request, response);
		
		
	}
	
	public void listarIndicadores(HttpServletRequest request,
			HttpServletResponse response)
	{
		IndicadorDAO iDAO = new IndicadorDAO();
		
		ArrayList<Indicador> ids = new ArrayList<Indicador>();
		
		try {
			ids = iDAO.listarIndicadores();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		request.setAttribute("indicadores", ids);
		try {
			request.getRequestDispatcher("listarIndicadores.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public void getIndicador(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		int id = Integer.valueOf(request.getParameter("id"));
		
		IndicadorDAO iDAO = new IndicadorDAO();
		Indicador i;
		try {
			i = iDAO.getIndicador(id);
			request.setAttribute("indicador_id", i.getId());
			request.setAttribute("indicador_desc",i.getDescricao());
			request.setAttribute("indicador_meta",i.getMeta());
			
			
			request.getRequestDispatcher("editarIndicador.jsp").forward(request, response);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	public void editarIndicador(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		int id = Integer.valueOf(request.getParameter("id"));

		
		Indicador i = new Indicador();
		i.setId(id);
		i.setDescricao(request.getParameter("descricao"));
		i.setMeta(Float.valueOf(request.getParameter("meta")));
		
		IndicadorDAO iDAO = new IndicadorDAO();
		try {
			iDAO.editarIndicador(i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		
		listarIndicadores(request, response);

		
	}
		
	
	

}
