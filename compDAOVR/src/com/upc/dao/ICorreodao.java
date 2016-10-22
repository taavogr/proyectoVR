package com.upc.dao;

import java.sql.SQLException;

import com.upc.dto.Correo;

public interface ICorreodao extends ICruddao<Correo>,IRowmapper<Correo> {

	void create(Correo o) throws SQLException;
	
	

}
