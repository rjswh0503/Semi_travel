package com.kh.mainPage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class tourServlet
 */
@WebServlet("/tourServlet")
public class mainPageServlet extends HttpServlet {
	private static String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String jdbcUser = "tour";
	private static String jdbcPass = "1234";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection connection = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
				connection = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPass);
				
				String sql = "select * from tour where city_id = 1";
				PreparedStatement ps = connection.prepareStatement(sql);
				ResultSet resultset = ps.executeQuery();
				
				
				ArrayList<mainPage> tourList = new ArrayList<>();
				
				while(resultset.next()) {
					int tourId = resultset.getInt("tour_id");
					int cityId = resultset.getInt("city_id");
					String tourName = resultset.getString("tour_name");
					String tourLocation = resultset.getString("tour_location");
					String tourPhone = resultset.getString("tour_phone");
					String tourTime = resultset.getString("tour_time");
					String tourComment = resultset.getString("tour_comment");
					
					mainPage Tour = new mainPage(tourId,cityId,tourName, tourLocation, tourPhone, tourTime);
					tourList.add(Tour);
					
				}
				request.setAttribute("tourList", tourList);
				request.getRequestDispatcher("tour/tour.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}