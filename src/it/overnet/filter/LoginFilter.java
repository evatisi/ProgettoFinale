package it.overnet.filter;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter("/*")
public class LoginFilter implements Filter {
	
	public static final Logger logger = Logger.getLogger(Logger.class.getName());
	
	public void destroy() {
		logger.info("Destroy filter");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		HttpSession session = req.getSession();
		// se l'utente non è loggato e non è nella pagina di Login
		if (!Boolean.TRUE.equals(session.getAttribute("logged")) && !req.getRequestURL().toString().contains("Login")) {
			res.sendRedirect("Login");
		}else {
			// pass the request along the filter chain
			chain.doFilter(request, response);
		}
		
				
	}

	public void init(FilterConfig fConfig) throws ServletException {
		logger.info("Init filter");
	}

}
