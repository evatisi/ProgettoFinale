package it.overnet.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.overnet.dao.ContactDao;
import it.overnet.models.Contact;

/**
 * Servlet implementation class List
 */
@WebServlet("/List")
public class List extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final Logger logger = Logger.getLogger(Logger.class.getName());
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			/*if(Crud.isTableExist("CONTACT")==false){
				Crud.createTable();
				logger.info("Table created!");
			}else {
				logger.info("Table exists!");
			}*/
			HttpSession session = request.getSession();
			int userId = Integer.parseInt(session.getAttribute("userId").toString());
			ArrayList<Contact> list = ContactDao.selectRecordIntoTable(userId);
			request.setAttribute("list", list);
			request.getRequestDispatcher("list.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

		

}
