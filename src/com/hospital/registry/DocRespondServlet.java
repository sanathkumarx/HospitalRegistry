package com.hospital.registry;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DocRespondServlet")
public class DocRespondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DocRespondServlet() {
        super();

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Reports rep = new Reports();
		rep.setappId(Integer.parseInt(request.getParameter("appId")));
		rep.setrepStatus(0);
		rep.settechMobile(777777777);
		rep.setPath("");
		String[] tname = new String[6];
		tname[0] = request.getParameter("Ultra-sonogram");
		tname[1] = request.getParameter("X-Ray");
		tname[2] = request.getParameter("Platelet Count");
		tname[3] = request.getParameter("Haemoglobin");
		tname[4] = request.getParameter("ECG");
		tname[5] = request.getParameter("Cholesterol Test");
		ReportsDAO reportsDAO = new ReportsDAOImp();
		AppointmentDAO appointmentDAO = new AppointmentDAOImp(); 
		for(int i=0;i<6;i++) {
			rep.settestName(tname[i]);
			if(reportsDAO.insert(rep)) {
				appointmentDAO.update(request.getParameter("appId"));
				System.out.println("Reported added succesfully");
				request.setAttribute("docMobile", request.getParameter("docMobile"));
		        RequestDispatcher rd=request.getRequestDispatcher("docProfile.jsp");  
		        rd.forward(request, response);  
			} else {
				PrintWriter out = response.getWriter();
				out.println("An error occoured please try again");
			}
		}
	}

}
