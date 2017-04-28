package it.overnet.servlet;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.overnet.dao.ContactDao;
import it.overnet.dao.UserDao;
import it.overnet.models.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {

	public static final Logger logger = Logger.getLogger(Logger.class.getName());
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			if (UserDao.isTableExist("USERTABLE") == false || ContactDao.isTableExist("CONTACT") == false) {
				UserDao.createTable();
				ContactDao.createTable();
				logger.info("Tables created!");
			} else {
				logger.info("Tables exists!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			HttpSession session = request.getSession();
			
			if(UserDao.isUserExist(new User(username,password))){
				session.setAttribute("userId", (UserDao.findUserByUsernameAndPassword(new User(username,password))).getId());
				session.setAttribute("logged", true);
				response.sendRedirect("List");
				logger.info("allow access to:" + username);
				
			}else {
				response.sendRedirect("login.jsp");
				logger.warning("access denied");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
