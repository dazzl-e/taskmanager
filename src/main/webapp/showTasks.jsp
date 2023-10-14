<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%@ page import="main.*" %>
    
   <%
       ShowTasks print = new ShowTasks(getServletContext());
       	print.printlist(request, response);
       %>