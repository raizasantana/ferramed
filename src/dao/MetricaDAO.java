package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Indicador;
import model.Metrica;

import com.mysql.jdbc.Connection;

public class MetricaDAO {

	java.sql.Connection con;
	
	public void adicionarMetrica(Metrica m) throws SQLException
	{
		con = ConnectionFactory.getConnection();
		
		String sql = "INSERT INTO metrica (processo_coleta, processo_analise, valor, tipo, nome, id_indicador) values (?,?,?,?,?,?)";
		
	
		
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,m.getProcessoColeta());
			ps.setString(2,m.getProcessoAnalise());
			ps.setFloat(3,m.getValor());
			ps.setString(4,m.getTipo());
			ps.setString(5, m.getNome());
			ps.setInt(6,m.getIndicador().getId());
			
			ps.executeUpdate();
			
			ps.close();
			con.close();
		
		
	}
	
	public ArrayList<Metrica> listarMetricas()
	{
		con = ConnectionFactory.getConnection();
		ArrayList<Metrica> ms = new ArrayList<Metrica>();
		
		String sql = "select * from metrica";
		

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				Metrica m = new Metrica();
				m.setId(rs.getInt("id"));
				m.setTipo(rs.getString("tipo"));
				m.setProcessoAnalise(rs.getString("processo_analise"));
				m.setProcessoColeta(rs.getString("processo_coleta"));
				//m.setValor(rs.getFloat("valor"));
				m.setNome(rs.getString("nome"));
				
				ms.add(m);
			}
			ps.close();
			rs.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ms;
		
	}
	
	public Metrica getMetrica(int id)
	{
		con = ConnectionFactory.getConnection();
		Metrica m = null;
		
		String sql = "select * from metrica where id = ?";
	
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				m = new Metrica();
				m.setId(rs.getInt("id"));
				m.setNome(rs.getString("nome"));
				m.setProcessoAnalise(rs.getString("processo_analise"));
				m.setProcessoColeta(rs.getString("processo_coleta"));
				m.setValor(rs.getFloat("valor"));
				Indicador i = new Indicador();
				i.setId(Integer.valueOf(rs.getString("id_indicador")));
				m.setIndicador(i);
			}
			ps.close();
			rs.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return m;
	}
	
	public void editarMetrica(Metrica m) throws SQLException
	{
		con = ConnectionFactory.getConnection();
		String sql = "update metrica set nome = ?, tipo = ?, processo_coleta = ?, processo_analise = ?, id_indicador = ? where id = ?"; 
		
		
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1,m.getNome());
			ps.setString(2,m.getTipo());
			ps.setString(3,m.getProcessoColeta());
			ps.setString(4,m.getProcessoAnalise());
			ps.setInt(5,m.getIndicador().getId());
			ps.setInt(6,m.getId());
			
			
			ps.executeUpdate();
			
			ps.close();
			
			con.close();
		
	}
	
}
