package it.overnet.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.overnet.dao.ContactDao;
import it.overnet.models.Contact;
import it.overnet.models.User;


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
		HttpSession sessione = request.getSession();
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String tel = request.getParameter("tel");
		String mail = request.getParameter("mail");
		Contact c = new Contact(nome,cognome,tel,mail);
		int userId = Integer.parseInt(sessione.getAttribute("userId").toString());
		
		
		try {
			if(ContactDao.insertRecordIntoTable(c, userId)){
				response.sendRedirect("List");
			}else {
				//errore
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("add.jsp").forward(request, response);
		
	}

}
