package com.kh.city.Osaka.spot;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Part;

public class OsakaTourDAO {
	private static final String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String jdbcUsername = "TOUR";
	private static final String jdbcPassword = "1234";

	    public OsakaTourDAO() {
	        try {
	            Class.forName("oracle.jdbc.OracleDriver");
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	    }

	    public List<OsakaTour> getAllTours() {
	    	List<OsakaTour> tours = new ArrayList<>();
	        try {
	            Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
	            String sql = "SELECT * FROM tour WHERE city_name= 'Osaka'";
	            PreparedStatement ps = connection.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	              
	                int tour_id = rs.getInt("tour_id");
	                String user_id = rs.getString("user_id");
	                String tour_name = rs.getString("tour_name");
	                String city_name = rs.getString("city_name");
	                String tour_location = rs.getString("tour_location");
	                String tour_phone = rs.getString("tour_phone");
	                String tour_time = rs.getString("tour_time");
	                String tour_date = rs.getString("tour_date");
	                String tour_comment = rs.getString("tour_comment");
	                
	                Blob blob1 = rs.getBlob("tour_img1");
	                 byte[] imageBytes1 = blob1.getBytes(1, (int) blob1.length());

	                 String imageBase641 = java.util.Base64.getEncoder().encodeToString(imageBytes1);
	                 String tour_img1 = ("data:image/jpeg;base64, " + imageBase641);
	                 
	                 Blob blob2 = rs.getBlob("tour_img2");
	                 byte[] imageBytes2 = blob2.getBytes(1, (int) blob2.length());

	                 String imageBase642 = java.util.Base64.getEncoder().encodeToString(imageBytes2);
	                 String tour_img2 = ("data:image/jpeg;base64, " + imageBase642);
	                 
	                 Blob blob3 = rs.getBlob("tour_img3");
	                 byte[] imageBytes3 = blob3.getBytes(1, (int) blob3.length());

	                 String imageBase64 = java.util.Base64.getEncoder().encodeToString(imageBytes3);
	                 String tour_img3 = ("data:image/jpeg;base64, " + imageBase64);
	                 OsakaTour tour =new OsakaTour(tour_id,user_id,city_name,tour_name,tour_location,tour_phone,tour_time,tour_date,tour_comment, tour_img1,tour_img2, tour_img3);
	                tours.add(tour);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return tours;
	    }
		
		

	    public OsakaTour getTour(int tour_id) {
	    	OsakaTour tour = null;
	    	
	    	try {
				Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
				String sql = "SELECT USER_ID, city_name, TOUR_NAME, TOUR_LOCATION, TOUR_PHONE, TOUR_TIME, TOUR_DATE, TOUR_COMMENT, TOUR_IMG1, TOUR_IMG2, TOUR_IMG3  FROM tour WHERE tour_id = ?";
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setInt(1, tour_id);
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
	                String user_id = rs.getString("user_id");
	                String city_name = rs.getString("city_name");
	                String tour_name = rs.getString("tour_name");
	                String tour_location = rs.getString("tour_location");
	                String tour_phone = rs.getString("tour_phone");
	                String tour_time = rs.getString("tour_time");
	                String tour_date = rs.getString("tour_date");
	                String tour_comment = rs.getString("tour_comment");
	                
	                Blob blob1 = rs.getBlob("tour_img1");
	                 byte[] imageBytes1 = blob1.getBytes(1, (int) blob1.length());

	                 String imageBase641 = java.util.Base64.getEncoder().encodeToString(imageBytes1);
	                 String tour_img1 = ("data:image/jpeg;base64, " + imageBase641);
	                 
	                 Blob blob2 = rs.getBlob("tour_img2");
	                 byte[] imageBytes2 = blob2.getBytes(1, (int) blob2.length());

	                 String imageBase642 = java.util.Base64.getEncoder().encodeToString(imageBytes2);
	                 String tour_img2 = ("data:image/jpeg;base64, " + imageBase642);
	                 
	                 Blob blob3 = rs.getBlob("tour_img3");
	                 byte[] imageBytes3 = blob3.getBytes(1, (int) blob3.length());

	                 String imageBase64 = java.util.Base64.getEncoder().encodeToString(imageBytes3);
	                 String tour_img3 = ("data:image/jpeg;base64, " + imageBase64);
	                 
	                 tour =new OsakaTour(tour_id,user_id,city_name,tour_name,tour_location,tour_phone,tour_time,tour_date,tour_comment, tour_img1, tour_img2, tour_img3);
	                 
				}
				
	    	
	    	} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
	    	
	    	return tour;
	    }
	    
	    
	    
	    
	    public void insertTour(OsakaTour tour) {
	        try {
	            Connection conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
	            String sql = "INSERT INTO TOUR(TOUR_ID, USER_ID, city_name, TOUR_NAME, TOUR_LOCATION, TOUR_PHONE, TOUR_TIME, TOUR_DATE, TOUR_COMMENT, TOUR_IMG)"
	                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	            PreparedStatement ps = conn.prepareStatement(sql);

	            ps.setInt(1, tour.getTour_id());
	            ps.setString(2, tour.getUser_id());
	            ps.setInt(3, tour.getCity_id());
	            ps.setString(4, tour.getTour_name());
	            ps.setString(5, tour.getTour_location());
	            ps.setString(6, tour.getTour_phone());
	            ps.setString(7, tour.getTour_time());
	            ps.setTimestamp(8, new Timestamp(System.currentTimeMillis()));
	            ps.setString(9, tour.getTour_comment());
	            //ps.setBlob(10, tour.getTour_img().getBinaryStream(), tour.getTour_img().length());

	            ps.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}