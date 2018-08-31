package com.revature.ressources;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.revature.logic.ServiceLink;

/**
 * Servlet implementation class AddReimbursmentServlet
 */
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
maxFileSize=1024*1024*10,      // 10MB
maxRequestSize=1024*1024*50)
public class AddReimbursmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddReimbursmentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("addReimbursment.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServiceLink obj = new ServiceLink();
		HttpSession session = request.getSession(false);
		String reimbReaso = request.getParameter("reimbReason");
		String email = (String) session.getAttribute("email");
		
		Part content =  request.getPart("reimbEvidence");

		InputStream is = null;
		ByteArrayOutputStream os = null;

		try {
			is = content.getInputStream();
			os = new ByteArrayOutputStream();

			byte[] buffer = new byte[1024];

			while (is.read(buffer) != -1) {
				os.write(buffer);
			}}catch (Exception e) {
				
				e.printStackTrace();
			}finally {
				if (is != null)
					is.close();
				if (os != null)
					os.close();
			}
			
			byte[] reeimbEvindence = (os.toByteArray());
		
		if (obj.addReimb(reimbReaso, reeimbEvindence, email)) {
			 response.sendRedirect("transaction");
		}else {
			 response.sendRedirect("addReimbursment.html");
		}
		
	}

}
