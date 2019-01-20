package com.hospital.registry;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/docRegistrationServlet")
public class docRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public docRegistrationServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String docMobile = request.getParameter("docMobile");
		String docPassword = request.getParameter("docPassword");
		String docName = request.getParameter("docName");
		String docSpecialization = request.getParameter("docSpecialization");
		String docLocation = request.getParameter("docLocation");
		String docDays = "";
		for(int i=1;i<8;i++) {
			if(request.getParameter(Integer.toString(i)) != null) 
			{
				docDays +=request.getParameter(Integer.toString(i));
			}
		}
		Doctor Doc = new Doctor();
		Doc.setdocDays(Integer.parseInt(docDays));
		Doc.setdocLocation(docLocation);
		Doc.setdocMobile(Long.parseLong(docMobile));
		Doc.setdocName(docName);
		Doc.setdocPassword(docPassword);
		Doc.setdocSpecialization(docSpecialization);
		DoctorDAO doctorDAO = new DoctorDAOImp();
		if(doctorDAO.insert(Doc)) {
	        RequestDispatcher rd=request.getRequestDispatcher("index.html");  
	        rd.forward(request, response);
		}
		else {
			PrintWriter out = response.getWriter();
			out.print("<h1>An error occoured please try again.</h1>");
		}
		
		
	}

}
