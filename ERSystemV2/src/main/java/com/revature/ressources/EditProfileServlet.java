package com.revature.ressources;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.EmployeeDAOImp;
import com.revature.logic.ServiceLink;

/**
 * Servlet implementation class EditProfileServlet
 */
@WebServlet("/edit")
public class EditProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("edit.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServiceLink obj = new ServiceLink();
		EmployeeDAOImp emp = new EmployeeDAOImp();
		 HttpSession session = request.getSession(false);
		 String firstName = request.getParameter("firstName");
		 String password = request.getParameter("password");
		 String lastName = request.getParameter("lastName");
		String email =  (String) session.getAttribute("email");

		if (obj.updateUser(firstName, lastName, password, email)) {
			session.setAttribute("email", email);
			session.setAttribute("firstName", obj.firstName(email) );
			session.setAttribute("lastName", obj.lastName(email) );
			session.setAttribute("title", obj.getTitle(email));
			response.sendRedirect("profile");
		}else {
			response.sendRedirect("edit.html");
		}
		
			
			
			
			}
	
}
