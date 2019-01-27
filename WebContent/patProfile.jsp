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
            <ul class="navbar-nav mr-auto ">
            <%
        	String patMobile = (String)session.getAttribute("patMobile");
        	Patient Pat = new PatientDAOImp().findPatient(Long.parseLong(patMobile));
        	out.println("<h5 offset-md-5>"+ Pat.getpatName()+"</h5><br>");
            %>
            </ul>
            
            <a class="nav-link" href="logutServlet"><button class="btn btn-primary my-2 my-sm-0" type="submit">Sign-Out</button></a>
        </div>
    </nav>
		<ul class="nav nav-fill mb-3 flex-column flex-sm-row" id="pills-tab" role="tablist">
		  <li class="flex-sm-fill text-sm-center nav-item">
		    <a class="nav-link active text-uppercase text-light btn-dark" id="app-home-tab" data-toggle="pill" href="#app-home" role="tab" aria-controls="app-home" aria-selected="true">My Appointments</a>
		  </li>
		  <li class="flex-sm-fill text-sm-center nav-item">
		    <a class="nav-link text-uppercase text-light btn-dark" id="book-app-tab" data-toggle="pill" href="#book-app" role="tab" aria-controls="book-app" aria-selected="false">Book Appointment</a>
		  </li>
		</ul>
		<div class="tab-content" id="pills-tabContent">
		  <div class="tab-pane fade show active" id="app-home" role="tabpanel" aria-labelledby="app-home-tab">
		  	<%
				AppointmentDAO appointmentDAO = new AppointmentDAOImp();
				Set<Appointment> appointments = appointmentDAO.findAppointmentByPatMobile(Long.parseLong(patMobile));
				if(appointments.size()>0){
				out.println("<blockquote class=\"blockquote text-center\">");
				out.println("</blockquote>");
				out.println("<table class=\"table table-hover table-borderless m-5 rounded table-dark col-md-11\">");
				out.println(" <thead>");
				out.println("   <tr>");
				out.println("     <th scope=\"col\">App Id</th>");
				out.println("     <th scope=\"col\">Doctor</th>");
				out.println("     <th scope=\"col\">Appointment date</th>");
				out.println("     <th scope=\"col\">Status</th>");
				out.println("     <th scope=\"col\">Reports</th>");
				out.println("   </tr>");
				out.println(" </thead>");
				out.println(" <tbody>");
				for(Appointment app:appointments){
					out.println("   <tr>");
					out.println("     <th scope=\"row\">"+app.getappId()+"</th>");
					Doctor doc = new DoctorDAOImp().findDoctor(app.getdocMobile());
					out.println("     <td>"+doc.getdocName()+"</td>");
					out.println("     <td>"+app.getappDate()+"</td>");
					if(app.getappStatus()==1){
						out.println("     <td>Completed</td>");
					}
					else{
						out.println("     <td>Pending</td>");	
					}
					out.println("<td>");
					out.println("     <a class=\"btn btn-success\" role=\"button\" href=\"Reports/"+app.getappId()+".rar\" download=\"Report.rar\">Dowload</a>");
					out.println("</td>");
					out.println("   </tr>");
				}
				out.println(" </table>");
				}
				else{
					out.println("<h1 class=\"text-monospace text-muted col-md-6 offset-md-4 text-uppercase\">NO APPOINTMENTS</h1>");
					out.println("<img src=\"Images/stethescope.png\" class=\"rounded mx-auto d-block\" alt=\"stethescope\">");
				}
			%>
		  </div>
		  <div class="tab-pane fade" id="book-app" role="tabpanel" aria-labelledby="book-app-tab">
		  	<%
				DoctorDAO doctorDAO = new DoctorDAOImp();
				Set<Doctor> doctors = doctorDAO.findDoctorsByFilters("%", "%", "%");
				if(doctors.size()>0){
				out.println("<blockquote class=\"blockquote text-center\">");
				out.println("</blockquote>");
				out.println("<table class=\"table table-hover table-borderless m-5 rounded table-dark col-md-11\">");
				out.println(" <thead>");
				out.println("   <tr>");
				out.println("     <th scope=\"col\"Doctor</th>");
				out.println("     <th scope=\"col\">Mobile</th>");
				out.println("     <th scope=\"col\">Speciality</th>");
				out.println("     <th scope=\"col\">Days of working</th>");
				out.println("     <th scope=\"col\">Book</th>");
				out.println("   </tr>");
				out.println(" </thead>");
				out.println(" <tbody>");
				
				for(Doctor doc:doctors){
					out.println("   <tr>");
					out.println("     <th scope=\"row\">"+doc.getdocName()+"</th>");
					out.println("     <td>"+doc.getdocMobile()+"</td>");
					out.println("     <td>"+doc.getdocSpecialization()+"</td>");
					StringBuilder num = new StringBuilder(Integer.toString(doc.getdocDays()));
					num.reverse();
					StringBuilder sb = new StringBuilder();
					while(num.length()>0){
						switch(num.charAt(num.length()-1)){
							case '1':
								sb.append("Monday");
								break;
							case '2':
								sb.append("Tuesday");
								break;
							case '3':
								sb.append("Wednesday");
								break;
							case '4':
								sb.append("Thursday");
								break;
							case '5':
								sb.append("Friday");
								break;
							case '6':
								sb.append("Saturday");
								break;
							case '7':
								sb.append("Sunday");
								break;
						}
						num.deleteCharAt(num.length()-1);
						if(num.length()>0) sb.append(", ");			
					}
					out.println("     <td>"+sb+"</td>");
					out.println("<td>");
					out.println("     <a class=\"btn btn-success\" role=\"button\" href=\"bookAppointmentServlet\">Book Appointment</a>");
					out.println("</td>");
					out.println("   </tr>");
				}
				out.println(" </table>");
				}
				else{
					out.println("<h1 class=\"text-monospace text-muted col-md-6 offset-md-4 text-uppercase\">NO DOCTORS AVAILABLE</h1>");
					out.println("<img src=\"Images/stethescope.png\" class=\"rounded mx-auto d-block\" alt=\"stethescope\">");
				}
		  	%>
		  </div>
		</div>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
  </body>
</html>