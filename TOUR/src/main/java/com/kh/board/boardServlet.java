package com.kh.board;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class boardServlet
 */
@WebServlet("/board/boardServlet")
public class boardServlet extends HttpServlet {
	private static final String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String jdbcUsername = "tour";
	private static final String jdbcPassword = "1234";
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			int post_number =Integer.parseInt(request.getParameter("post_number"));
			String sql = "SELECT * FROM boards";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet resultSet = ps.executeQuery();
			
			ArrayList<BoardDTO> boardList = new ArrayList<>();
				
			while(resultSet.next()) {
				String user_id = resultSet.getString("user_id");
				String city_name = resultSet.getString("city_name");
				String title = resultSet.getString("title");
				String content = resultSet.getString("content");
				String post_time = resultSet.getString("post_time");
				String category = resultSet.getString("category");
				
			}
			
			request.setAttribute("boardList", boardList);
			request.getRequestDispatcher("/boardList/jsp").forward(request, response);
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
	}

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
			
			String user_id = request.getParameter("user_id");
			String city_name = request.getParameter("city_name");
			String title = request.getParameter("title");;
			String content = request.getParameter("content");;
			String post_time = request.getParameter("post_time");;
			String category = request.getParameter("category");;
	    
			String sql = "INSERT INTO boards"
						+"(user_id, city_name, title, content, post_time, category)"
						+"VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = connection	.prepareStatement(sql);
			ps.setString(1, user_id);
			ps.setString(2, city_name);
			ps.setString(3, title);
			ps.setString(4, content);
			ps.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
			ps.setString(6, category);
			
			ps.executeUpdate();
	    
			request.getSession().setAttribute("user_id", user_id);
			request.getSession().setAttribute("city_name", city_name);request.getSession().setAttribute("city_name", city_name);
			request.getSession().setAttribute("title", title);
			request.getSession().setAttribute("content", content);
			request.getSession().setAttribute("category", category);

			response.sendRedirect("boardList.jsp");
			
			
		} catch (SQLException e) {
			
			
			e.printStackTrace();
		}
		
		
	}
}
