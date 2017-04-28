package it.overnet.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.overnet.dao.UserDao;
import it.overnet.models.User;

/**
 * Servlet implementation class RegistrazioneUser
 */
@WebServlet("/RegistrazioneUser")
public class RegistrazioneUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("registrazioneUser.jsp").forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		try {
			if(!UserDao.isUserExist(new User(username,password))){
				UserDao.insertRecordIntoTable(new User(username,password));
				response.sendRedirect("Login");
			}else {
				response.sendRedirect("RegistrazioneUser");
			}
		
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
