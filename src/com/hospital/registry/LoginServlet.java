package com.hospital.registry;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usermobile = request.getParameter("userMobile");
		String userpassword = request.getParameter("userPassword");
		String userposition = request.getParameter("userPosition");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		switch(userposition) {
		case "doctor":
			try {
				DoctorDAO DoctorDao = new DoctorDAOImp();
				long mobile = Long.parseLong(usermobile);
				Doctor doc = DoctorDao.findDoctor(mobile);
				if(DoctorDao.validate(mobile, userpassword)) {
					HttpSession session = request.getSession();
					session.setAttribute("docMobile", usermobile);
					session.setAttribute("docName", doc.getdocName());
					System.out.println("log in successful");
					response.sendRedirect("docProfile.jsp");
				}else {
					out.println("Invalid Username/password");
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
			break;
		case "patient":
			try {
				PatientDAO patientDao = new PatientDAOImp();
				long mobile = Long.parseLong(usermobile);
				Patient pat = patientDao.findPatient(mobile);
				if(patientDao.validate(mobile, userpassword)) {
					HttpSession session = request.getSession();
					session.setAttribute("patMobile", usermobile);
					session.setAttribute("patName", pat.getpatName());
					System.out.println("log in successful");
					response.sendRedirect("patProfile.jsp"); 
				}else {
					out.println("<h1>Invalid Username/password</h1>");
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
			break;
		case "technician":
			try {
				DoctorDAO DoctorDao = new DoctorDAOImp();
				long mobile = Long.parseLong(usermobile);
				if(DoctorDao.validate(mobile, userpassword)) {
					HttpSession session = request.getSession();
					session.setAttribute("daocMobile", mobile);
					System.out.println("log in successful");
					request.setAttribute("usermobile", Long.toString(mobile));
			        RequestDispatcher rd=request.getRequestDispatcher("docProfile.jsp");  
			        rd.forward(request, response);  
				}else {
					out.println("Invalid Username/password");
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
			break;
		}
	}

}
