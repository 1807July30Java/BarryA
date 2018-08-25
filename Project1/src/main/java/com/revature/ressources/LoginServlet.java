package com.revature.ressources;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.logic.ServiceLink;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("index.html").forward(request, response);
	}

	/**m
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServiceLink obj = new ServiceLink();
		HttpSession session = request.getSession();
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		if (obj.authenticateUser(email, password)) {
			
			session.setAttribute("email", email);
			session.setAttribute("firstName", obj.firstName(email) );
			session.setAttribute("lastName", obj.lastName(email) );
			session.setAttribute("title", obj.getTitle(email));
			session.setAttribute("problem", null);
			response.sendRedirect("profile");
		}else {
			session.setAttribute("problem", "incorrect password");
			pw.println("<h1>Invalid username or password</h1>");
			response.sendRedirect("login");
		}
	}

}
