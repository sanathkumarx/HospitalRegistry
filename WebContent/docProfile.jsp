<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.hospital.registry.*,java.util.Set,java.util.Enumeration"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <title>Doctor Profile</title>
  </head>
  <body>
      <nav class="navbar navbar-expand-lg navbar-light bg-dark text-light">
 
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto mt-auto">
            <a class="nav-link active" href="docProfile.jsp">
            <%
        	String docMobile = (String)session.getAttribute("docMobile");
        	Doctor Doc = new DoctorDAOImp().findDoctor(Long.parseLong(docMobile));
        	out.println("<h5 offset-md-5 class=\"text-light\">"+ session.getAttribute("docName")+"</h5><br>");
            %>
            </a>
            </ul>
            <a class="nav-link" href="logutServlet"><button class="btn btn-primary my-2 my-sm-0" type="submit">Sign-Out</button></a>

        </div>
    </nav>
	<%
	AppointmentDAO appointmentDAO = new AppointmentDAOImp();
	Set<Appointment> appointments = appointmentDAO.findAppointmentByDocMobile(Long.parseLong(docMobile));
	if(appointments.size()>0){
	out.println("<blockquote class=\"blockquote text-center\">");
	out.println("<h1 class=\"display-4 text-uppercase\">Appointments</h1>");
	out.println("</blockquote>");
	out.println("<table class=\"table table-hover table-borderless m-5 rounded table-dark col-md-11\">");
	out.println(" <thead>");
	out.println("   <tr>");
	out.println("     <th scope=\"col\">App Id</th>");
	out.println("     <th scope=\"col\">Patient</th>");
	out.println("     <th scope=\"col\">Appointment date</th>");
	out.println("     <th scope=\"col\">Status</th>");
	out.println("     <th scope=\"col\">Respond</th>");
	out.println("     <th scope=\"col\">Reports</th>");
	out.println("   </tr>");
	out.println(" </thead>");
	out.println(" <tbody>");
	for(Appointment app:appointments){
		out.println("   <tr>");
		out.println("     <th scope=\"row\">"+app.getappId()+"</th>");
		Patient pat = new PatientDAOImp().findPatient(app.getpatMobile());
		out.println("     <td>"+pat.getpatName()+"</td>");
		out.println("     <td>"+app.getappDate()+"</td>");
		if(app.getappStatus()==1){
			out.println("     <td>Completed</td>");
		}
		else{
			out.println("     <td>Pending</td>");	
		}
		out.println("<td><form action=\"docRespond.jsp\">");
		out.println("	  <input type=\"hidden\" name=\"docMobile\" value=\""+session.getAttribute("docMobile") +"\"/>");		
		out.println("     <button type=\"submit\" class=\"btn btn-primary\" name=\"appId\" value=\""+app.getappId()+"\">Respond</button>");
		out.println("</form></td>");
		out.println("<td>");
		out.println("     <a class=\"btn btn-success\" role=\"button\" href=\"Reports/"+app.getappId()+".rar\" download=\"Report.rar\">Dowload</a>");
		out.println("</td>");
		out.println("   </tr>");
	}
	out.println(" </table>");
	}
	else{
		out.println("<h1 class=\"text-monospace text-muted col-md-6 offset-md-4 text-uppercase\">NO APPOINTMENTS TODAY</h1>");
		out.println("<img src=\"Images/stethescope.png\" class=\"rounded mx-auto d-block\" alt=\"stethescope\">");
	}
	%>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
  </body>
</html>