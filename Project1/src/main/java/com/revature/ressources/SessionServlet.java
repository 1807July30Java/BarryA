package com.revature.ressources;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionServlet
 */
@WebServlet("/session")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null) {
			response.setContentType("application/json");
			
			response.getWriter().write("{\"firstName\":\""+session.getAttribute("firstName")+
					","+"\"email\":\""+session.getAttribute("email")+","+"\"lastName\":\""+
					session.getAttribute("lastName")+","+"\"title\":\""+session.getAttribute("title")+"\"}");
	
		} else {
			response.setContentType("application/json");
			response.getWriter().write("{\"firstName\":null}");
			response.getWriter().write("{\"email\":null}");
			response.getWriter().write("{\"lastName\":null}");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
