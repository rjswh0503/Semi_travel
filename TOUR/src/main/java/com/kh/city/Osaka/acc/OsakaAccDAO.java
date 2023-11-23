package com.kh.city.Osaka.acc;

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

public class OsakaAccDAO {
	private static final String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String jdbcUsername = "TOUR";
	private static final String jdbcPassword = "1234";

	    public OsakaAccDAO() {
	        try {
	            Class.forName("oracle.jdbc.OracleDriver");
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	    }

	    public List<OsakaAcc> getAllAccs() {
	    	List<OsakaAcc> accs = new ArrayList<>();
	        try {
	            Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
	            String sql = "SELECT * FROM accomodation WHERE city_name= 'Osaka'";
	            PreparedStatement ps = connection.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	              
	                int acc_id = rs.getInt("acc_id");
	                String user_id = rs.getString("user_id");
	                String acc_name = rs.getString("acc_name");
	                String city_name = rs.getString("city_name");
	                String acc_location = rs.getString("acc_location");
	                String acc_phone = rs.getString("acc_phone");
	                String acc_time = rs.getString("acc_time");
	                String acc_date = rs.getString("acc_date");
	                String acc_comment = rs.getString("acc_comment");
	                
	                Blob blob1 = rs.getBlob("acc_img1");
	                 byte[] imageBytes1 = blob1.getBytes(1, (int) blob1.length());

	                 String imageBase641 = java.util.Base64.getEncoder().encodeToString(imageBytes1);
	                 String acc_img1 = ("data:image/jpeg;base64, " + imageBase641);
	                 
	                 Blob blob2 = rs.getBlob("acc_img2");
	                 byte[] imageBytes2 = blob2.getBytes(1, (int) blob2.length());

	                 String imageBase642 = java.util.Base64.getEncoder().encodeToString(imageBytes2);
	                 String acc_img2 = ("data:image/jpeg;base64, " + imageBase642);
	                 
	                 Blob blob3 = rs.getBlob("acc_img3");
	                 byte[] imageBytes3 = blob3.getBytes(1, (int) blob3.length());

	                 String imageBase64 = java.util.Base64.getEncoder().encodeToString(imageBytes3);
	                 String acc_img3 = ("data:image/jpeg;base64, " + imageBase64);
	                 OsakaAcc acc =new OsakaAcc(acc_id,user_id,city_name,acc_name,acc_location,acc_phone,acc_time,acc_date,acc_comment, acc_img1,acc_img2, acc_img3);
	                accs.add(acc);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return accs;
	    }
		
		

	    public OsakaAcc getAcc(int acc_id) {
	    	OsakaAcc acc = null;
	    	
	    	try {
				Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
				String sql = "SELECT USER_ID, city_name, acc_NAME, acc_LOCATION, acc_PHONE, acc_TIME, acc_DATE, acc_COMMENT, acc_IMG1, acc_IMG2, acc_IMG3  FROM ACCOMODATION  WHERE acc_id = ?";
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setInt(1, acc_id);
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
	                String user_id = rs.getString("user_id");
	                String city_name = rs.getString("city_name");
	                String acc_name = rs.getString("acc_name");
	                String acc_location = rs.getString("acc_location");
	                String acc_phone = rs.getString("acc_phone");
	                String acc_time = rs.getString("acc_time");
	                String acc_date = rs.getString("acc_date");
	                String acc_comment = rs.getString("acc_comment");
	                
	                Blob blob1 = rs.getBlob("acc_img1");
	                 byte[] imageBytes1 = blob1.getBytes(1, (int) blob1.length());

	                 String imageBase641 = java.util.Base64.getEncoder().encodeToString(imageBytes1);
	                 String acc_img1 = ("data:image/jpeg;base64, " + imageBase641);
	                 
	                 Blob blob2 = rs.getBlob("acc_img2");
	                 byte[] imageBytes2 = blob2.getBytes(1, (int) blob2.length());

	                 String imageBase642 = java.util.Base64.getEncoder().encodeToString(imageBytes2);
	                 String acc_img2 = ("data:image/jpeg;base64, " + imageBase642);
	                 
	                 Blob blob3 = rs.getBlob("acc_img3");
	                 byte[] imageBytes3 = blob3.getBytes(1, (int) blob3.length());

	                 String imageBase64 = java.util.Base64.getEncoder().encodeToString(imageBytes3);
	                 String acc_img3 = ("data:image/jpeg;base64, " + imageBase64);
	                 
	                 acc =new OsakaAcc(acc_id,user_id,city_name,acc_name,acc_location,acc_phone,acc_time,acc_date,acc_comment, acc_img1, acc_img2, acc_img3);
	                 
				}
				
	    	
	    	} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
	    	
	    	return acc;
	    }
	    
	    
	    
	    
	    public void insertAcc(OsakaAcc acc) {
	        try {
	            Connection conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
	            String sql = "INSERT INTO accomodation(acc_ID, USER_ID, city_name, acc_NAME, acc_LOCATION, acc_PHONE, acc_TIME, acc_DATE, acc_COMMENT, acc_IMG)"
	                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	            PreparedStatement ps = conn.prepareStatement(sql);

	            ps.setInt(1, acc.getAcc_id());
	            ps.setString(2, acc.getUser_id());
	            ps.setString(3, acc.getCity_name());
	            ps.setString(4, acc.getAcc_name());
	            ps.setString(5, acc.getAcc_location());
	            ps.setString(6, acc.getAcc_phone());
	            ps.setString(7, acc.getAcc_time());
	            ps.setTimestamp(8, new Timestamp(System.currentTimeMillis()));
	            ps.setString(9, acc.getAcc_comment());
	            //ps.setBlob(10, tour.getTour_img().getBinaryStream(), tour.getTour_img().length());

	            ps.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}