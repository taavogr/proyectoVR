package com.upc.dao;

import java.sql.SQLException;
import java.util.List;

public interface ICruddao <T> {
	
	void create (T o) throws SQLException;
	List<T> getAll() throws SQLException;
	

}
