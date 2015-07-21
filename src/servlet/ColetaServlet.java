package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.net.httpserver.HttpServer;

import dao.ColetaDAO;
import dao.MetricaDAO;
import model.Coleta;
import model.Metrica;

@WebServlet("/coleta/coleta")

public class ColetaServlet extends HttpServlet{
	
private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	{
		String acao = (String) request.getParameter("acao");
		
		
		if (acao != null)
		{
			switch (acao)
			{
				/*case "listarColetas":
					listarMetricas(request, response);
					break;
				case "editarColeta":
					getMetrica(request, response);
					break; */
				case "listarMetricas":
					MetricaDAO mDAO = new MetricaDAO();
					ArrayList<Metrica> metricas = mDAO.listarMetricas();
					request.setAttribute("metricas", metricas);
					
					try {
						request.getRequestDispatcher("coletar.jsp").forward(request, response);
					} catch (ServletException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					break;
				case "Criar":
					criarColeta(request, response);
					break;
				case "listarColetas":
					listarColetas(request, response);
					break;
				case "editarColeta":
					getColeta(request, response);
					break;
				case "Editar":
					editarColeta(request, response);
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
				/*case "listarColetas":
					listarMetricas(request, response);
					break;
				case "editarColeta":
					getMetrica(request, response);
					break; */
				case "listarMetricas":
					MetricaDAO mDAO = new MetricaDAO();
					ArrayList<Metrica> metricas = mDAO.listarMetricas();
					request.setAttribute("metricas", metricas);
					
					try {
						request.getRequestDispatcher("coletar.jsp").forward(request, response);
					} catch (ServletException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					break;
				case "Criar":
					criarColeta(request, response);
					break;
				case "listarColetas":
					listarColetas(request, response);
					break;
				case "editarColeta":
					getColeta(request, response);
					break;
				case "Editar":
					editarColeta(request, response);
				default:
					break;
			}
		}
	}

	private void criarColeta(HttpServletRequest request,
			HttpServletResponse response) {
		String message = "Coleta registrada com sucesso.";
		
		Coleta coleta = new Coleta();
		coleta.setMetrica(Integer.parseInt(request.getParameter("metrica")));
		coleta.setValor(Float.parseFloat(request.getParameter("valorColeta")));
		coleta.setObservacao(request.getParameter("observacao"));
		
		
		ColetaDAO cDAO = new ColetaDAO();
		try {
			cDAO.adicionarMetrica(coleta);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			message = "Erro ao salvar coleta. Tente novamente mais tarde";
		}
		
		request.setAttribute("message", message);
		
		listarColetas(request, response);

	}
	
	private void listarColetas(HttpServletRequest request,
			HttpServletResponse response) {
		
		ColetaDAO cDAO = new ColetaDAO();
		ArrayList<Coleta> coletas = cDAO.listarColetas();
		
		request.setAttribute("coletas", coletas);
		
		try {
			request.getRequestDispatcher("/coleta/listarColetas.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void getColeta(HttpServletRequest request, HttpServletResponse response){
		
		int id = Integer.valueOf(request.getParameter("id"));
		
		ColetaDAO cDAO = new ColetaDAO();
		Coleta coleta;
		try {
			coleta = cDAO.getColeta(id);
			request.setAttribute("coleta_id", coleta.getId());
			request.setAttribute("coleta_metrica",coleta.getMetrica());
			request.setAttribute("coleta_valor",coleta.getValor());
			request.setAttribute("coleta_observacao",coleta.getObservacao());
			
			request.getRequestDispatcher("editarColeta.jsp").forward(request, response);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	private void editarColeta(HttpServletRequest request, HttpServletResponse response){
		
		ColetaDAO cDAO = new ColetaDAO();
		Coleta coleta = new Coleta();
		coleta.setId(Integer.parseInt(request.getParameter("id")));
		coleta.setObservacao(request.getParameter("observacao"));
		coleta.setValor(Float.parseFloat(request.getParameter("valorColeta")));
		
		try {
			cDAO.editarColeta(coleta);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		listarColetas(request, response);
		
	}
	
		
		
	
}