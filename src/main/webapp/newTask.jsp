<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%@ page import="main.*" %>
    
    <%
        String item = (String) request.getParameter("addTask");
            	NewTask add = new NewTask(getServletContext());
            	
            	add.addItem(item);
        %>