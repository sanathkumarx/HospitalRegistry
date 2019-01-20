<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Enumeration"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	String mobile = (String)request.getAttribute("usermobile");
	String name = (String)request.getAttribute("docName");
	out.println("<h1>"+name+"</h1>");
	out.println("<h1>"+mobile+"</h1>");
%>
</body>
</html>