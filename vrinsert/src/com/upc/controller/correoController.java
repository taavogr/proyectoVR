package com.upc.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.upc.dto.Correo;

import com.upc.model.correoModel;

/**
 * Servlet implementation class correoController
 */
@WebServlet({ "/insertc", "/newc", "/listc" })
public class correoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private correoModel cmodel = null;
	private String destino = "/index.jsp";
	private String mensaje = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public correoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		cmodel = new correoModel();
		
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = request.getServletPath();
		
		try {
			if (path.equals("/insertc")) {
				insert(request);
				destino ="/index.jsp";
			}else if (path.equals("/listc")){
				mensaje=list(request,cmodel);
				destino = "/panel.jsp";
			}
			System.out.println(path);
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(destino);
		rd.forward(request, response);
		
		
	}
	
	protected void insert(HttpServletRequest request) throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
		Correo c= new Correo();
		c.setNombrecorreo(request.getParameter("correo"));
		cmodel.registrarCorreo(c);
	}
	
	protected String list(HttpServletRequest request, correoModel cmodel) throws SQLException {
		String error = null;

		List<Correo> list = cmodel.listarCorreo();

		if (list != null) {
			request.setAttribute("listcorreos", list);
		} else {
			error = "Sin acceso a Base de Datos";
		}

		return error;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
