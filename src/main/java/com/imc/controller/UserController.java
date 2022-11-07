package com.imc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.imc.database.PostgreSQLJDBC;
import com.imc.model.Person;
import com.imc.model.User;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public UserController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = new User();
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		
		PostgreSQLJDBC database = new PostgreSQLJDBC();
		try {
			Statement stmt = database.connection.createStatement();
			ResultSet keys = stmt.executeQuery("SELECT person_id FROM PUBLIC.USER WHERE USER_NAME = '" + user.getUsername() + "' AND PASSWORD = '" + user.getPassword() +"';");
			int person_id = keys.next() ? keys.getInt(1) : 0;
			
			if (person_id > 0) {
				response.sendRedirect("/JavaAvanzadoEmanuel/landing.jsp?personId=" + person_id);
			} else {
				response.sendRedirect("/JavaAvanzadoEmanuel/invalid_user.html");
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			response.sendRedirect("/JavaAvanzadoEmanuel/invalid_user.html");
			e.printStackTrace();
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub}
		Person person = new Person();
		person.setName(request.getParameter("name"));
		person.setAge(Integer.valueOf(request.getParameter("age").equals("") ? "0" : request.getParameter("age")));
		
		User user = new User();
		user.setUsername(request.getParameter("username"));
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		
		PostgreSQLJDBC database = new PostgreSQLJDBC();
		try {
			Statement stmt = database.connection.createStatement();
			
			ResultSet keys = stmt.executeQuery("INSERT INTO PUBLIC.PERSON(name,age) values('" + person.getName() + "'," + person.getAge() +") RETURNING person_id;");
			keys.next();
			int personId = keys.getInt(1);
			System.out.print("INSERT INTO PUBLIC.USER(user_name,email,person_id) values('" + user.getUsername() + "','" + user.getEmail() +"'," + personId + ");");
			
			stmt.executeQuery("INSERT INTO PUBLIC.USER(user_name,email,person_id,password) values('" + user.getUsername() + "','" + user.getEmail() +"'," + personId + ",'" + user.getPassword()+"') RETURNING user_id;");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("/JavaAvanzadoEmanuel/user_created.html");
	}

}
