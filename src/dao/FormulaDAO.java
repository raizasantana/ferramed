package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Formula;
import model.Metrica;

public class FormulaDAO {

	java.sql.Connection con;
	
	public void adicionarFormula(Formula f) throws SQLException{
		
		con = ConnectionFactory.getConnection();
		
		String sql = "INSERT INTO formula (nome, metrica1_id, metrica2_id,operador, metrica_associada) values (?,?,?,?,?)";
		
	
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1,f.getNome());
		ps.setInt(2, f.getMetrica1().getId());
		ps.setInt(3, f.getMetrica2().getId());
		ps.setString(4,f.getOperador());
		ps.setInt(5,f.getMetricaAssociada().getId());
		ps.executeUpdate();
		
		ps.close();
		con.close();
	}
	
	public ArrayList<Formula> listarFormulas() throws SQLException{
		con = ConnectionFactory.getConnection();
		
		ArrayList<Formula> formulas = new ArrayList<Formula>();
		
		String sql = "SELECT * FROM formula";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next())
		{
			Formula f = new Formula();
			f.setId(rs.getInt("id"));
			f.setNome(rs.getString("nome"));
			Metrica m1 = new Metrica();
			Metrica m2 = new Metrica();
			Metrica mA = new Metrica();
			MetricaDAO mDAO = new MetricaDAO();
			m1 = mDAO.getMetrica(rs.getInt("metrica1_id"));
			m2 = mDAO.getMetrica(rs.getInt("metrica2_id"));
			mA = mDAO.getMetrica(rs.getInt("metrica_associada"));
			f.setMetrica1(m1);
			f.setMetrica2(m2);
			f.setMetricaAssociada(mA);
			f.setOperador(rs.getString("operador"));
						
			formulas.add(f);
		}
		ps.close();
		rs.close();
		con.close();
		return formulas;
	}
	
	public Formula getFormula(Integer id) throws SQLException{
		con = ConnectionFactory.getConnection();
		
		Formula f = new Formula();
			
		String sql = "SELECT * FROM formula where id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next())
		{
			
			f.setId(rs.getInt("id"));
			f.setNome(rs.getString("nome"));
			Metrica m1 = new Metrica();
			Metrica m2 = new Metrica();
			Metrica mA = new Metrica();
			MetricaDAO mDAO = new MetricaDAO();
			m1 = mDAO.getMetrica(rs.getInt("metrica1_id"));
			m2 = mDAO.getMetrica(rs.getInt("metrica2_id"));
			mA = mDAO.getMetrica(rs.getInt("metrica_associada"));
			f.setMetrica1(m1);
			f.setMetrica2(m2);
			f.setMetricaAssociada(mA);
			f.setOperador(rs.getString("operador"));
		}
		ps.close();
		rs.close();
		con.close();
		return f;
	}
	
	public void editarFormula(Formula f) throws SQLException
	{
		con = ConnectionFactory.getConnection();
		String sql = "update formula set nome = ?, metrica1_id = ?, metrica2_id = ?, operador = ?, metrica_associada = ? where id = ?"; 
		
		
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1,f.getNome());
			ps.setInt(2,f.getMetrica1().getId());
			ps.setInt(3,f.getMetrica2().getId());
			ps.setString(4,f.getOperador());
			ps.setInt(5,f.getMetricaAssociada().getId());
			ps.setInt(6,f.getId());
			
			
			ps.executeUpdate();
			
			ps.close();
			
			con.close();
		
	}
}