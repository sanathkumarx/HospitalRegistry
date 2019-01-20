package com.hospital.registry;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/patRegistrationServlet")
public class patRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public patRegistrationServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String patMobile = request.getParameter("patMobile");
		String patPassword = request.getParameter("patPassword");
		String patName = request.getParameter("patName");
		String patLocation = request.getParameter("patLocation");
		Patient Pat = new Patient();
		Pat.setpatLocation(patLocation);
		Pat.setpatMobile(Long.parseLong(patMobile));
		Pat.setpatName(patName);
		Pat.setpatPassword(patPassword);
		PatientDAO patientDAO = new PatientDAOImp();
		if(patientDAO.insert(Pat)) {
	        RequestDispatcher rd=request.getRequestDispatcher("index.html");  
	        rd.forward(request, response);
		}
		else {
			PrintWriter out = response.getWriter();
			out.print("<h1>An error occoured please try again.</h1>");
		}
	}

}
