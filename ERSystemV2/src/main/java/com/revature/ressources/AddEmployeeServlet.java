package com.revature.ressources;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.logic.ServiceLink;
import com.revature.pojo.*;

/**
 * Servlet implementation class AddEmployeeServlet
 */
public class AddEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("add.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServiceLink obj = new ServiceLink();
		HttpSession session = request.getSession(false);
		String email = (String) session.getAttribute("email");
		
	
		 String empTitle = request.getParameter("empTitle");
		 String empPassword = request.getParameter("empPassword");
		 String empEmail = request.getParameter("empEmail");
		 String empFirstName = request.getParameter("empFirstName");
		 String empLastName = request.getParameter("empLastName");
		 double managerID = obj.getManagerId(email);
		 Employee employee = new Employee(empFirstName, empLastName, empEmail, empPassword, empTitle, managerID);
		 
		 if (obj.addEmployee(employee)) {
			 response.sendRedirect("profile");
		}else {
			response.sendRedirect("add.html");
		}
		
	}

}
