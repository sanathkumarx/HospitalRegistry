package com.hospital.registry;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/techRegistrationServlet")
public class techRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public techRegistrationServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String techMobile = request.getParameter("techMobile");
		String techPassword = request.getParameter("techPassword");
		String techName = request.getParameter("techName");
		Technician Tech = new Technician();
		Tech.settechMobile(Long.parseLong(techMobile));
		Tech.settechName(techName);
		Tech.settechPassword(techPassword);
		TechnicianDAO technicianDAO = new TechnicianDAOImp();
		if(technicianDAO.insert(Tech)) {
	        RequestDispatcher rd=request.getRequestDispatcher("index.html");  
	        rd.forward(request, response);
		}
		else {
			PrintWriter out = response.getWriter();
			out.print("<h1>An error occoured please try again.</h1>");
		}
		
	}

}
