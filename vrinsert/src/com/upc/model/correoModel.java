package com.upc.model;

import java.sql.SQLException;
import java.util.List;

import com.upc.dao.ICorreodao;
import com.upc.dto.Correo;
import com.upc.factory.Factory;

public class correoModel {
	
	ICorreodao cdao =null;
	
	public correoModel(){
		cdao = Factory.getInstance().getCorreodao();
	}
	
	public void registrarCorreo(Correo c) throws SQLException{
		cdao.create(c);
	}
	
	public List<Correo> listarCorreo() throws SQLException{
		
		return cdao.getAll();
	}

}
