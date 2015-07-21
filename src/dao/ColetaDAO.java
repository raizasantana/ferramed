package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Coleta;
import model.Metrica;

public class ColetaDAO {
	
	java.sql.Connection con;
	
	public void adicionarMetrica(Coleta coleta) throws SQLException
	{
		con = ConnectionFactory.getConnection();
		
		String sql = "INSERT INTO coleta (id_metrica, valor, observacao, data) values (?,?,?,now())";
		
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,coleta.getMetrica().getId());
			ps.setFloat(2, coleta.getValor());
			ps.setString(3,coleta.getObservacao());
			
			ps.executeUpdate();
			
			ps.close();
			con.close();
		
	}
	
	public ArrayList<Coleta> listarColetas()
	{
		con = ConnectionFactory.getConnection();
		ArrayList<Coleta> coletas = new ArrayList<Coleta>();
		
		String sql = "select * from coleta";
		

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				Coleta c = new Coleta();
				c.setId(rs.getInt("id"));
				c.setMetrica(rs.getInt("id_metrica"));
				c.setValor(rs.getFloat("valor"));
				c.setObservacao(rs.getString("observacao"));
				c.setData(rs.getDate("data"));
	
				coletas.add(c);
			}
			
			ps.close();
			rs.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return coletas;
		
	}
	
	public Coleta getColeta(int id)
	{
		con = ConnectionFactory.getConnection();
		Coleta coleta = null;
		
		String sql = "select * from coleta where id = ?";
	
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				coleta = new Coleta();
				coleta.setId(rs.getInt("id"));
				coleta.setMetrica(rs.getInt("id_metrica"));
				coleta.setValor(rs.getFloat("valor"));
				coleta.setObservacao(rs.getString("observacao"));
				coleta.setData(rs.getDate("data"));
				
			}
			ps.close();
			rs.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return coleta;
	}
	
	public void editarColeta(Coleta coleta) throws SQLException
	{
		con = ConnectionFactory.getConnection();
		String sql = "update coleta set valor = ?, observacao = ? where id = ?"; 
		
		
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setFloat(1,coleta.getValor());
			ps.setString(2,coleta.getObservacao());
			ps.setInt(3, coleta.getId());
			
			ps.executeUpdate();
			
			ps.close();
			
			con.close();
		
	}

}
