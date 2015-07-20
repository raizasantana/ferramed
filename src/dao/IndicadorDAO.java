package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Indicador;

import com.mysql.jdbc.Connection;

public class IndicadorDAO {
	
	java.sql.Connection con;
	
	public void criarIndicador(Indicador i) throws SQLException
	{
		
		con = ConnectionFactory.getConnection();
		
		String sql = "insert into indicador(descricao, meta) values(?,?)";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1,i.getDescricao());
		ps.setFloat(2,i.getMeta());
		
		ps.executeUpdate();
		
		ps.close();
		
		con.close();
		
	}
	
	public ArrayList<Indicador> listarIndicadores() throws SQLException
	{
		con = ConnectionFactory.getConnection();
		
		String sql = "select * from indicador";
		ArrayList<Indicador> ids = new ArrayList<Indicador>();
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next())
		{
			Indicador i = new Indicador();
			i.setDescricao(rs.getString("indicador.descricao"));
			i.setId(rs.getInt("indicador.id"));
			i.setMeta(rs.getFloat("indicador.meta"));

			ids.add(i);
			
		}
		
		rs.close();
		ps.close();
		con.close();
		
		return ids;
	
	}
	
	public Indicador getIndicador(int id) throws SQLException
	{
		con = ConnectionFactory.getConnection();
		
		String sql = "select * from indicador where id = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setInt(1,id);
		
		ResultSet rs = ps.executeQuery();
		
		Indicador i = null;
		if(rs.next())
		{
			i = new Indicador();
			i.setDescricao(rs.getString("descricao"));
			i.setMeta(rs.getFloat("meta"));
			i.setId(rs.getInt("id"));
		}
		
		return i;
	}
	
	public void editarIndicador(Indicador i) throws SQLException
	{
		con = ConnectionFactory.getConnection();
		String sql = "update indicador set descricao = ?, meta = ? where id = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1,i.getDescricao());
		ps.setFloat(2,i.getMeta());
		ps.setInt(3, i.getId());
		
		ps.executeUpdate();
		
		ps.close();
		con.close();
		
		
	}

}
