package it.overnet.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/*Contact contatto = request.getParameter("nome");
		
		
		try {
			Crud.createTable();
			Crud.insertRecordIntoTable(contatto);

			response.sendRedirect("edit.jsp");

		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("login.jsp");
		}*/
	}

}
