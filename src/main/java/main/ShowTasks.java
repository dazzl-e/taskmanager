package main;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DBConnectionChirino;

/**
 * Servlet implementation class ShowTasks
 */
@WebServlet("/ShowTasks")
public class ShowTasks extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ServletContext contextR;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowTasks(ServletContext contextIn) {
        super();
        // TODO Auto-generated constructor stub
        this.contextR = contextIn;
    }
    



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			printlist(request, response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Prints the updated list of Item from the database;
	 */
	public void printlist(HttpServletRequest request,HttpServletResponse response) throws IOException , SQLException, ServletException
	{
		Connection connection = null;
		
		
		DBConnectionChirino.getDBConnection(this.contextR);
        connection = DBConnectionChirino.connection;
        PrintWriter out = response.getWriter();
        List<String> tasks = new ArrayList<String>();
        
		
		try 
		{
			String selectSQL = "SELECT * FROM tasks";
			PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next())
			{
				do 
				{
		            
		           String task = rs.getString("task").trim();
		           tasks.add(task);
		           out.println("<div class=\"task\">" +
		        		   "<li class=\"task-item\">" + this.removeLastChar(task) + "</li>" +
		        		   "<button class=\"delete-btn\"> <i class=\"fas fa-trash\"></i></button>"+
		        		   
		        		   "</div>");
		            
		          
		         }while (rs.next());
			}
			
			
			connection.close();
			
			
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private String removeLastChar(String s)   
	{  
		return s.substring(0, s.length() - 1);  
	}   

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
