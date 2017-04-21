package it.overnet.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.overnet.dao.Crud;
import it.overnet.models.Contact;


/**
 * Servlet implementation class SaveContact
 */
@WebServlet("/SaveContact")
public class SaveContact extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

	/*	Contact contatto = request.getParameter("");
	
		
		try {
			Crud.createTable();
			Crud.insertRecordIntoTable(contatto);

			response.sendRedirect("add.jsp");

		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("login.jsp");
		}*/
	}

}
