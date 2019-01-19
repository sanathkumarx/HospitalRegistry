package com.hospital.registry;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			DoctorDAO DoctorDao = new DoctorDAOImp();
			String usermobile = request.getParameter("userMobile");
			String userpassword = request.getParameter("userPassword");
			String userposition = request.getParameter("userPosition");
			long mobile = Long.parseLong(usermobile);
			if(DoctorDao.validate(mobile, userpassword)) {
				out.println("logged in");
			}else {
				out.println("Invalid Username/password");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
