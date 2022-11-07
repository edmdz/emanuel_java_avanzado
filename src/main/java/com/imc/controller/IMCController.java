package com.imc.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imc.database.PostgreSQLJDBC;
import com.imc.model.ImcRecord;
import com.imc.model.Person;

/**
 * Servlet implementation class IMCController
 */
@WebServlet("/IMCController")
public class IMCController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IMCController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	public ArrayList<ImcRecord> getPersonImcRecords(long personId) throws ServletException, IOException, ParseException {
		// TODO Auto-generated method stub
		PostgreSQLJDBC database = new PostgreSQLJDBC();
		
		ArrayList<ImcRecord> records = new ArrayList<ImcRecord>();
		try {
			Statement stmt = database.connection.createStatement();
			ResultSet keys = stmt.executeQuery("SELECT * FROM PUBLIC.IMC_RECORD WHERE PERSON_ID = " + personId);
			
			while (keys.next()) {
				ImcRecord record = new ImcRecord();
				record.setImcResult(keys.getDouble(3));
				Date date1= new SimpleDateFormat("yyyy-MM-dd").parse(keys.getString(2));
				Calendar c = Calendar.getInstance();
				c.setTime(date1);
				record.setRecorDate(c);
				records.add(record);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return records;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Person person = new Person();
		person.setHeight(Integer.valueOf(request.getParameter("height").equals("") ? "0" : request.getParameter("height")));
		person.setWeight(Integer.valueOf(request.getParameter("weight").equals("") ? "0" : request.getParameter("weight")));
		
		double imc = ((double)person.getWeight() / 1000) / ( ((double)person.getHeight() / 100) * ((double)person.getHeight() / 100) );
        imc =  Math.floor(imc * 100) / 100;
		Calendar c = Calendar.getInstance();
		String recordDateStr = c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH) + 1) + "-" + c.get(Calendar.DAY_OF_MONTH) ;
		
		long personId = Long.valueOf(request.getParameter("personId"));
		PostgreSQLJDBC database = new PostgreSQLJDBC();
		

		try {
			Statement stmt = database.connection.createStatement();
			stmt.executeQuery("INSERT INTO PUBLIC.IMC_RECORD(record_date, imc_result,person_id) VALUES('" + recordDateStr + "'," + imc + "," + personId + ") RETURNING imc_record_id;");
			response.sendRedirect("/JavaAvanzadoEmanuel/landing.jsp?personId=" + personId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		doGet(request, response);
	}

}
