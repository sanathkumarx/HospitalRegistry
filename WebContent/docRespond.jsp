<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.hospital.registry.*,java.util.Set,java.util.Enumeration"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <title>Hello, world!</title>
    <style>
    .padder{
        padding-top: 3em;
    }
    .little{
        margin-top: 2em;
    }
    </style>
  </head>
  <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
 
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
            <a class="nav-link active" href="docProfile.jsp">
            <%
        	String docMobile = (String)session.getAttribute("docMobile");
        	Doctor Doc = new DoctorDAOImp().findDoctor(Long.parseLong(docMobile));
        	out.println("<h5 offset-md-5>"+ session.getAttribute("docName")+"</h5><br>");
            %>
            </a>
            </ul>
            <a class="nav-link" href="logutServlet"><button class="btn btn-primary my-2 my-sm-0" data-toggle="modal" data-target="#registerModal" type="submit">Sign-Out</button></a>

        </div>
    	</nav>
	  <div class="col-md-6 mx-auto offset-md-6 ">
	  <h1>Suggest the patient tests</h1>
	  <form class="padder" method="post" action="DocRespondServlet">
		   <%
		   		out.println("<input type=\"hidden\" name=\"appId\" value=\""+ request.getParameter("appId") +"\"/>");
		   %>	
		   <%
		   		out.println("<input type=\"hidden\" name=\"docMobile\" value=\""+ request.getParameter("docMobile") +"\"/>");
		   %>	  				
           <div class="form-row">
                   <div class="form-checkcustom-control custom-checkbox  form-group col-md-3">
                   <input class="form-check-input custom-control-input"  name="Ultra-sonogram" value="Ultra-sonogram" type="checkbox" id="Ultra-sonogram">
                   <label class="form-check-label custom-control-label" for="Ultra-sonogram">Ultra-sonogram</label>
                   </div>
                   <div class="form-check custom-control custom-checkbox form-group col-md-3 offset-md-1">
                   <input class="form-check-input custom-control-input"  name ="X-Ray" value ="X-Ray" type="checkbox" id="X-Ray">
                   <label class="form-check-label custom-control-label" for="X-Ray">X-Ray</label>
                   </div>
                   <div class="form-check custom-control custom-checkbox form-group col-md-3">
                   <input class="form-check-input custom-control-input"  name="Platelet Count" value="Platelet Count"  type="checkbox" id="Platelet Count">
                   <label class="form-check-label custom-control-label" for="Platelet Count">Platelet Count</label>
                   </div>
           </div>
           <div class="form-row padder">
                   <div class="form-check custom-control custom-checkbox form-group col-md-3">
                   <input class="form-check-input custom-control-input"   name="Haemoglobin" value="Haemoglobin"  type="checkbox" id="Haemoglobin">
                   <label class="form-check-label custom-control-label" for="Haemoglobin">Haemoglobin</label>
                   </div>
                   <div class="form-check custom-control custom-checkbox form-group col-md-3 offset-md-1">
                   <input class="form-check-input custom-control-input"   name="ECG" value="ECG"  type="checkbox" id="ECG">
                   <label class="form-check-label custom-control-label" for="ECG">ECG</label>
                   </div>
                   <div class="form-check custom-control custom-checkbox form-group col-md-3">
                   <input class="form-check-input custom-control-input"   name="Cholesterol Test" value="Cholesterol Test"  type="checkbox" id="Cholesterol Test">
                   <label class="form-check-label custom-control-label" for="Cholesterol Test">Cholesterol Test</label>
                   </div>
           </div>
           <button type="submit" class="col-md-8  btn btn-primary little" >Submit</button>
	</form> 
	</div>


    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
  </body>
</html>