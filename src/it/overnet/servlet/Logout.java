package it.overnet.servlet;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final Logger logger = Logger.getLogger(Logger.class.getName());
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessione = request.getSession();
		sessione.removeAttribute("logged");
		response.sendRedirect("Login");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		logger.info("log out");
	}

	
	
}
