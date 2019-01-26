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
      <nav class="navbar navbar-expand-lg navbar-light bg-light">
 
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
            <%
        	String patMobile = (String)request.getAttribute("usermobile");
        	Patient Pat = new PatientDAOImp().findPatient(Long.parseLong(patMobile));
        	out.println("<h5 offset-md-5>"+ Pat.getpatName()+"</h5><br>");
            %>
            </ul>
            <a class="nav-link" href="#"><button class="btn btn-primary my-2 my-sm-0" data-toggle="modal" data-target="#registerModal" type="submit">Sign-Out</button></a>

        </div>
    </nav>
	<%
	AppointmentDAO appointmentDAO = new AppointmentDAOImp();
	Set<Appointment> appointments = appointmentDAO.findAppointmentByPatMobile(Long.parseLong(patMobile));
	out.println("<h7>Appointments</h7>");
	out.println("<table class=\"table table-hover table-borderless table-dark\">");
	out.println(" <thead>");
	out.println("   <tr>");
	out.println("     <th scope=\"col\">App Id</th>");
	out.println("     <th scope=\"col\">Doctor</th>");
	out.println("     <th scope=\"col\">Appointment date</th>");
	out.println("     <th scope=\"col\">Status</th>");
	out.println("     <th scope=\"col\">Report</th>");
	out.println("   </tr>");
	out.println(" </thead>");
	out.println(" <tbody>");
	for(Appointment app:appointments){
		out.println("   <tr>");
		out.println("     <th scope=\"row\">"+app.getappId()+"</th>");
		Doctor Doc = new DoctorDAOImp().findDoctor(app.getdocMobile());
		out.println("     <td>"+Doc.getdocName()+"</td>");
		out.println("     <td>"+app.getappDate()+"</td>");
		if(app.getappStatus()==1){
			out.println("     <td>Completed</td>");
		}
		else{
			out.println("     <td>Pending</td>");	
		}
		out.println("<td><form action=\"getReportServlet\">");
		out.println("<input type=\"hidden\" name=\"docMobile\" value=\""+ (String)request.getAttribute("") +"\"/>");		
		out.println("     <button type=\"submit\" class=\"btn btn-primary\" name=\"appId\" value=\""+app.getappId()+"\">Respond</button>");
		out.println("</form></td>");
		out.println("   </tr>");
		
	}

	%>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
  </body>
</html>