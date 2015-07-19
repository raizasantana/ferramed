package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Metrica;

import com.mysql.jdbc.Connection;

public class MetricaDAO {

	java.sql.Connection con;
	
	public void adicionarMetrica(Metrica m) throws SQLException
	{
		con = ConnectionFactory.getConnection();
		
		String sql = "INSERT INTO metrica (processo_coleta, processo_analise, valor, tipo, nome) values (?,?,?,?,?)";
		
	
		
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,m.getProcessoColeta());
			ps.setString(2,m.getProcessoAnalise());
			ps.setFloat(3,m.getValor());
			ps.setString(4,m.getTipo());
			ps.setString(5, m.getNome());
			
			ps.executeUpdate();
			
			ps.close();
			con.close();
		
		
	}
	
	public ArrayList<Metrica> listarMetricas()
	{
		con = ConnectionFactory.getConnection();
		ArrayList<Metrica> ms = null;
		
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
				m.setValor(rs.getFloat("valor"));
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
				m.setNome(rs.getString("nome"));
				m.setProcessoAnalise(rs.getString("processo_analise"));
				m.setProcessoColeta(rs.getString("processo_coleta"));
				m.setValor(rs.getFloat("valor"));
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
	
}
