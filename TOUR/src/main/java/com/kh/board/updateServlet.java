package com.kh.board;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class updateServlet
 */
@WebServlet("/board/updateServlet")
public class updateServlet extends HttpServlet {
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

			String user_id = request.getParameter("user_id");
			String city_name = request.getParameter("city_name");
			String title = request.getParameter("title");;
			String content = request.getParameter("content");;
			String post_time = request.getParameter("post_time");;
			String category = request.getParameter("category");;
			int post_number = Integer.parseInt(request.getParameter("post_number"));
			
			
			String Ucity = "UPDATE boards set city_name = ? WHERE post_number = ?";
			PreparedStatement city_update = connection.prepareStatement(Ucity);
			city_update.setString(1, city_name);
			city_update.setInt(2, post_number);
			
			city_update.executeQuery();
			
			String Utitle = "UPDATE boards set title = ? WHERE post_number = ?";
			PreparedStatement title_update = connection.prepareStatement(Utitle);
			title_update.setString(1, title);
			title_update.setInt(2, post_number);
			
			title_update.executeQuery();
	    
			String Ucontent = "UPDATE boards set content = ? WHERE post_number = ?";
			PreparedStatement content_update = connection.prepareStatement(Ucontent);
			content_update.setString(1, title);
			content_update.setInt(2, post_number);
			
			content_update.executeQuery();
			
			String Ucategory = "UPDATE boards set category = ? WHERE post_number = ?";
			PreparedStatement category_update = connection.prepareStatement(Ucategory);
			category_update.setString(1, category);
			category_update.setInt(2, post_number);
			
			category_update.executeQuery();
			
			request.getSession().setAttribute("post_number", post_number);
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
