<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="main.*" %>

			
<link rel="stylesheet" href="../style.css">				
				
				
				
				
				<%
																								ShowTasks print = new ShowTasks(getServletContext());
																										print.printlist(request, response);
																								%>
					
				
			