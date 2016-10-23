package com.upc.ds;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconexion {
	
	//private static final String url = "jdbc:mysql://localhost:3306/dbinsertvr";//corregir nombre de la bd
	private static final String url = "jdbc:mysql://mysql44006-insertvr.jelastic.websolute.net.br:3306/dbinsertvr";
	private static final String user = "root";
    private static final String passwd = "XIAgxt19417";
    //private static final String passwd = "root";
    
    private static Connection con;
        
    private Dbconexion(){}
    
   public static Connection getInstance() {
        if (con == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection(url, user, passwd);
            } catch (SQLException | ClassNotFoundException e) {
            }
        }
        return con;
    }

}
