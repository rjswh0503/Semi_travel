package com.kh.city.Sapporo.res;

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

public class SapporoResDAO {
	private static final String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String jdbcUsername = "TOUR";
	private static final String jdbcPassword = "1234";

	    public SapporoResDAO() {
	        try {
	            Class.forName("oracle.jdbc.OracleDriver");
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	    }

	    public List<SapporoRes> getAllRess() {
	    	List<SapporoRes> ress = new ArrayList<>();
	        try {
	            Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
	            String sql = "SELECT * FROM RESTAURANT  WHERE City_name = 'Sapporo'";
	            PreparedStatement ps = connection.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	              
	                int res_id = rs.getInt("res_id");
	                String user_id = rs.getString("user_id");
	                String res_name = rs.getString("res_name");
	                String city_name = rs.getString("city_name");
	                String res_location = rs.getString("res_location");
	                String res_phone = rs.getString("res_phone");
	                String res_time = rs.getString("res_time");
	                String res_date = rs.getString("res_date");
	                String res_comment = rs.getString("res_comment");
	                
	                Blob blob1 = rs.getBlob("res_img1");
	                 byte[] imageBytes1 = blob1.getBytes(1, (int) blob1.length());

	                 String imageBase641 = java.util.Base64.getEncoder().encodeToString(imageBytes1);
	                 String res_img1 = ("data:image/jpeg;base64, " + imageBase641);
	                 
	                 Blob blob2 = rs.getBlob("res_img2");
	                 byte[] imageBytes2 = blob2.getBytes(1, (int) blob2.length());

	                 String imageBase642 = java.util.Base64.getEncoder().encodeToString(imageBytes2);
	                 String res_img2 = ("data:image/jpeg;base64, " + imageBase642);
	                 
	                 Blob blob3 = rs.getBlob("res_img3");
	                 byte[] imageBytes3 = blob3.getBytes(1, (int) blob3.length());

	                 String imageBase64 = java.util.Base64.getEncoder().encodeToString(imageBytes3);
	                 String res_img3 = ("data:image/jpeg;base64, " + imageBase64);
	                 SapporoRes res =new SapporoRes(res_id,user_id,city_name,res_name,res_location,res_phone,res_time,res_date,res_comment, res_img1,res_img2, res_img3);
	                ress.add(res);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return ress;
	    }
		
		

	    public SapporoRes getRes(int res_id) {
	    	SapporoRes res = null;
	    	
	    	try {
				Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
				String sql = "SELECT USER_ID, CITY_NAME, res_NAME, res_LOCATION, res_PHONE, res_TIME, res_DATE, res_COMMENT, res_IMG1, res_IMG2, res_IMG3  FROM RESTAURANT WHERE res_id = ?";
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setInt(1, res_id);
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
	                String user_id = rs.getString("user_id");
	                String city_name = rs.getString("city_name");
	                String res_name = rs.getString("res_name");
	                String res_location = rs.getString("res_location");
	                String res_phone = rs.getString("res_phone");
	                String res_time = rs.getString("res_time");
	                String res_date = rs.getString("res_date");
	                String res_comment = rs.getString("res_comment");
	                
	                Blob blob1 = rs.getBlob("res_img1");
	                 byte[] imageBytes1 = blob1.getBytes(1, (int) blob1.length());

	                 String imageBase641 = java.util.Base64.getEncoder().encodeToString(imageBytes1);
	                 String res_img1 = ("data:image/jpeg;base64, " + imageBase641);
	                 
	                 Blob blob2 = rs.getBlob("res_img2");
	                 byte[] imageBytes2 = blob2.getBytes(1, (int) blob2.length());

	                 String imageBase642 = java.util.Base64.getEncoder().encodeToString(imageBytes2);
	                 String res_img2 = ("data:image/jpeg;base64, " + imageBase642);
	                 
	                 Blob blob3 = rs.getBlob("res_img3");
	                 byte[] imageBytes3 = blob3.getBytes(1, (int) blob3.length());

	                 String imageBase64 = java.util.Base64.getEncoder().encodeToString(imageBytes3);
	                 String res_img3 = ("data:image/jpeg;base64, " + imageBase64);
	                 
	                 res =new SapporoRes(res_id,user_id,city_name,res_name,res_location,res_phone,res_time,res_date,res_comment, res_img1, res_img2, res_img3);
	                 
				}
				
	    	
	    	} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
	    	
	    	return res;
	    }
	    
	    
	    
	    
	    public void insertRes(SapporoRes res) {
	        try {
	            Connection conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
	            String sql = "INSERT INTO RESTAURANT(res_ID, USER_ID, CITY_NAME, res_NAME, res_LOCATION, res_PHONE, res_TIME, res_DATE, res_COMMENT, res_IMG)"
	                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	            PreparedStatement ps = conn.prepareStatement(sql);

	            ps.setInt(1, res.getRes_id());
	            ps.setString(2, res.getUser_id());
	            ps.setString(3, res.getCity_name());
	            ps.setString(4, res.getRes_name());
	            ps.setString(5, res.getRes_location());
	            ps.setString(6, res.getRes_phone());
	            ps.setString(7, res.getRes_time());
	            ps.setTimestamp(8, new Timestamp(System.currentTimeMillis()));
	            ps.setString(9, res.getRes_comment());
	            //ps.setBlob(10, res.getTour_img().getBinaryStream(), tour.getTour_img().length());

	            ps.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}