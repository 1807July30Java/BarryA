package com.revature.ressources;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.logic.ServiceLink;

/**
 * Servlet implementation class DecidingServlet
 */
public class DecidingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DecidingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	ServiceLink obj = new ServiceLink();
		
		
		HttpSession session = request.getSession(false);
		ObjectMapper om = new ObjectMapper();
		
		if (session != null) {
			
			response.setContentType("application/json");
			String email = (String) session.getAttribute("email");
			
			String json = om.writeValueAsString(obj.viewByPending(email));
			response.getWriter().write(json);
		}else {
			System.out.println("DoneElse!");
			response.setContentType("application/json");
			String json = null;
			response.getWriter().write(json);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServiceLink obj = new ServiceLink();
		HttpSession session = request.getSession(false);
		String email = (String) session.getAttribute("email");
		String status = request.getParameter("status");
		double reimbID = Double.parseDouble(request.getParameter("reimbID"));
		

		
		if (obj.appDeny(reimbID, status, email)) {
			System.out.println("made it");
			request.getRequestDispatcher("action.html").forward(request, response);
		}else {
			response.sendRedirect("appro");
		}
		
	}

}
