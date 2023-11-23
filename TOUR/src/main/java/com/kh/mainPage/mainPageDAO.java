package com.kh.mainPage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class mainPageDAO {
	private static final String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String jdbcUser = "tour";
	private static final String jdbcPass = "1234";
	
	

	
	public mainPageDAO() {
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public List<mainPage> getAlltours() {
		
		List<mainPage> tours = new ArrayList<>();
		
		try {
			Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPass);
			String sql = "Select * from tour where city_id = 1";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet resultset = ps.executeQuery();
			
			while(resultset.next()) {
				int tourId = resultset.getInt("tour_id");
				int cityId = resultset.getInt("city_id");
				String tourName = resultset.getString("tour_name");
				String tourLocation = resultset.getString("tour_location");
				String tourPhone = resultset.getString("tour_phone");
				String tourTime = resultset.getString("tour_time");
				int tourLike = resultset.getInt("tour_like");
				String tourComment = resultset.getString("tour_comment");
				
				mainPage Tour = new mainPage(tourId,cityId, tourName, tourLocation, tourPhone, tourTime);
				tours.add(Tour);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tours;
		
		
		
	}
	
	
	 public mainPage getTourById(int tourId) {
		 
		 mainPage tour = null;
		 
		 String Select_city_id ="Select * from tour where tour_id = ?";
		 try {
			Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPass);
			PreparedStatement ps = connection.prepareStatement(Select_city_id);
			ps.setInt(1, tourId);
			ResultSet resultset = ps.executeQuery();
			
			if(resultset.next()) {
				int city_id = resultset.getInt("city_id");
				String tour_name = resultset.getString("tour_name");
				String tour_location = resultset.getString("tour_location");
				String tour_phone = resultset.getString("tour_phone");
				String tour_time = resultset.getString("tour_time");
				
				tour = new mainPage(tourId, city_id,tour_name, tour_location, tour_phone, tour_time);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 return tour;
		 
		 
		

		
			
	}
}
