package com.upc.dao.impl;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.upc.dao.ICorreodao;
import com.upc.ds.Dbconexion;
import com.upc.dto.Correo;

public class Correodao implements ICorreodao {

	@Override
	public void create(Correo o) throws SQLException {
		// TODO Auto-generated method stub
		String insert = "{call sp_insert_correo(?,?)}";

		Connection cn = Dbconexion.getInstance();

		cn.setAutoCommit(true);// Transaccion nivel BD.

		CallableStatement cs = cn.prepareCall(insert);

		cs.registerOutParameter(1, java.sql.Types.VARCHAR);
		cs.setString(2, o.getNombrecorreo());
		

		cs.execute();

		String estado = cs.getString(1);

		cs.close();
		cs = null;

		if (!estado.equals("ok")) {
			throw new SQLException(estado);
		}
		
	}

	@Override
	public List<Correo> getAll() throws SQLException {
		// TODO Auto-generated method stub
		List<Correo> lista = new ArrayList<>();
		String query = "{call sp_list_correo()}";
		Connection cn = Dbconexion.getInstance();
		
		CallableStatement cs = cn.prepareCall(query);
		
		ResultSet rs =cs.executeQuery();
		
		while (rs.next()) {
			lista.add(mapRow(rs));
			
		}
		return lista;
	}

	@Override
	public Correo mapRow(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		Correo correo = new Correo();
		
		correo.setIdcorreo(rs.getInt(1));
		correo.setNombrecorreo(rs.getString(2));
		return correo;
	}
	
	

}
