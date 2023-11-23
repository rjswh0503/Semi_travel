package com.kh.board;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class deleteServlet
 */
@WebServlet("/board/deleteServlet")
public class deleteServlet extends HttpServlet {
	private static final String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String jdbcUsername = "tour";
	private static final String jdbcPassword = "1234";
    

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection connection = null;
		

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			
			
			int post_number = Integer.parseInt(request.getParameter("post_number"));
		
			String sql = "DELETE FROM boards WHERE post_number = ?" ;
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, post_number);
			
			ps.executeUpdate();
			
			response.sendRedirect("boardList.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
