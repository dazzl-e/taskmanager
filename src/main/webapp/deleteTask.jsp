<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%@ page import="main.*" %>
    
    <%
        String task = (String) request.getParameter("taskToDelete");
            	DeleteTask remove = new DeleteTask(getServletContext());
            	
            	remove.remove(task);
        %>