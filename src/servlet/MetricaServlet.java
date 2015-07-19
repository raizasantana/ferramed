package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MetricaDAO;
import model.Metrica;

@WebServlet("/metrica/metrica")
public class MetricaServlet extends HttpServlet{
	
private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	{
		String acao = (String) request.getParameter("acao");
		System.out.println(acao);
		
		if (acao != null)
		{
			switch (acao)
			{
				case "Criar":
					criarMetrica(request, response);
					break;
				case "listarCurso":
					//listarCursosDepartamentos(request, response);
					break;
				default:
					break;
			}
		}
	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	{
		
	}
	
	private void criarMetrica(HttpServletRequest request,
			HttpServletResponse response) {
		String message = "Metrica inserida com sucesso.";
		
		
		Metrica m = new Metrica();
		m.setNome(request.getParameter("nome"));
		m.setProcessoColeta(request.getParameter("processoColeta"));
		m.setProcessoAnalise(request.getParameter("processoAnalise"));
		m.setTipo(request.getParameter("tipoMetrica"));
		
		MetricaDAO mDAO = new MetricaDAO();
		try {
			mDAO.adicionarMetrica(m);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			message = "Erro ao inserir metrica. Tente novamente mais tarde";
		}
		
		request.setAttribute("message", message);
		
		try {
			request.getRequestDispatcher("/metrica/criarMetrica.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	

}
