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
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// request.getRequestDispatcher("edit.jsp").forward(request, response);
		String id = request.getParameter("id");

		try {
			Contact c = Crud.selectRecordById(Integer.parseInt(id));
			request.setAttribute("contact", c);
			request.getRequestDispatcher("edit.jsp").forward(request, response);

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Contact contatto = null;
		String nome = request.getParameter("contactNome");
		String cognome = request.getParameter("contactCognome");
		String tel = request.getParameter("contactTel");
		String mail = request.getParameter("contactMail");
		String id = request.getParameter("contactId");
		contatto = new Contact (nome,cognome,tel,mail);
		contatto.setId(Integer.parseInt(id));
		try {
			if(Crud.insertRecordIntoTable(contatto)){
				response.sendRedirect("List");
			}else {
				//errore
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
