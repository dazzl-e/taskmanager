package main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DBConnectionChirino;

/**
 * Servlet implementation class DeleteTask
 */
@WebServlet("/DeleteTask")
public class DeleteTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ServletContext contextR;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTask(ServletContext contextIn) {
        super();
        // TODO Auto-generated constructor stub
        this.contextR = contextIn;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	public void remove(String task) 
	{
		Connection connection = null;
		DBConnectionChirino.getDBConnection(this.contextR);
        connection = DBConnectionChirino.connection;
        
		String removeSQL = "DELETE FROM tasks WHERE task = ?";
		
		try 
		{
			if(task != null) 
			{
				PreparedStatement preparedStatement = connection.prepareStatement(removeSQL);
				String taskToDelete = task + "%";
				preparedStatement.setString(1, taskToDelete);
				preparedStatement.execute();
			}
			
			connection.close();
			
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
