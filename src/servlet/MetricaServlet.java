package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IndicadorDAO;
import dao.MetricaDAO;
import model.Indicador;
import model.Metrica;

@WebServlet("/metrica/metrica")
public class MetricaServlet extends HttpServlet{
	
private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	{
		String acao = (String) request.getParameter("acao");
		
		
		if (acao != null)
		{
			switch (acao)
			{
				case "Criar":
					criarMetrica(request, response);
					break;
				case "listarMetricas":
					listarMetricas(request, response);
					break;
				case "editarMetrica":
					getMetrica(request, response);
					break;
				case "atualizarMetrica":
					editarMetrica(request, response);
					break;
				case "listarIndicadores":
					IndicadorDAO iDAO = new IndicadorDAO();
				try {
					request.setAttribute("indicadores", iDAO.listarIndicadores());
					try {
						request.getRequestDispatcher("criarMetrica.jsp").forward(request, response);
					} catch (ServletException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
					
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
					criarMetrica(request, response);
					break;
				case "listarMetricas":
					listarMetricas(request, response);
					break;
				case "editarMetrica":
					getMetrica(request, response);
					break;
				case "atualizarMetrica":
					editarMetrica(request, response);
					break;
				case "listarIndicadores":
					IndicadorDAO iDAO = new IndicadorDAO();
				try {
					request.setAttribute("indicadores", iDAO.listarIndicadores());
					try {
						request.getRequestDispatcher("criarMetrica.jsp").forward(request, response);
					} catch (ServletException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
					break;
				default:
					break;
			}
		}

	}
	
	
//TODO Adicionar relação com o indicador 
	private void criarMetrica(HttpServletRequest request,
			HttpServletResponse response) {
		
		
		
		Metrica m = new Metrica();
		m.setNome(request.getParameter("nome"));
		m.setProcessoColeta(request.getParameter("processoColeta"));
		m.setProcessoAnalise(request.getParameter("processoAnalise"));
		m.setTipo(request.getParameter("tipoMetrica"));
		Indicador i = new Indicador();
		i.setId(Integer.valueOf(request.getParameter("indicador")));
		m.setIndicador(i);
		
		MetricaDAO mDAO = new MetricaDAO();
		try {
			mDAO.adicionarMetrica(m);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		listarMetricas(request, response);

	}
	
	
	private void listarMetricas(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
				
		MetricaDAO mDAO = new MetricaDAO();
		ArrayList<Metrica> ms =  mDAO.listarMetricas();
		
		request.setAttribute("metricas",ms);
		
		try {
			request.getRequestDispatcher("/metrica/listarMetricas.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void getMetrica(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id = Integer.valueOf(request.getParameter("id"));
		
		MetricaDAO mDAO = new MetricaDAO();
		IndicadorDAO iDAO = new IndicadorDAO();
		Metrica m;
		try {
			m = mDAO.getMetrica(id);
			
			request.setAttribute("metrica_id", m.getId());
			request.setAttribute("metrica_nome",m.getNome());
			request.setAttribute("metrica_tipo",m.getTipo());
			request.setAttribute("metrica_processoColeta",m.getProcessoColeta());
			request.setAttribute("metrica_processoAnalise",m.getProcessoAnalise());
			request.setAttribute("metrica_id_indicador",m.getIndicador().getId());
			request.setAttribute("indicadores",iDAO.listarIndicadores());
			
			request.getRequestDispatcher("editarMetrica.jsp").forward(request, response);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	public void editarMetrica(HttpServletRequest request,
			HttpServletResponse response) {
		
		
		int id = Integer.valueOf(request.getParameter("id"));

		
		Metrica m = new Metrica();
		m.setId(id);
		m.setNome(request.getParameter("nome"));
		m.setProcessoColeta(request.getParameter("processoColeta"));
		m.setProcessoAnalise(request.getParameter("processoAnalise"));
		m.setTipo(request.getParameter("tipoMetrica"));
		Indicador i = new Indicador();
		i.setId(Integer.valueOf(request.getParameter("indicador")));
		m.setIndicador(i);
		MetricaDAO mDAO = new MetricaDAO();
		try {
			mDAO.editarMetrica(m);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		
		listarMetricas(request, response);
		
	}

	

}
