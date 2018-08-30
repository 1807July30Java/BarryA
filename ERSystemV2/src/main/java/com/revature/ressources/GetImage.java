package com.revature.ressources;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.ReimbursmentDAO;
import com.revature.dao.ReimbursmentDAOImp;

/**
 * Servlet implementation class GetImage
 */
public class GetImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetImage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double reimbID = Double.parseDouble(request.getParameter("ticketId"));
		ReimbursmentDAOImp reim = new ReimbursmentDAOImp();
		byte[] objFromDb = reim.getImage(reimbID);

		response.setContentType("image/jpg");
		response.getOutputStream().write(objFromDb);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
