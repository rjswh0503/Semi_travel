package com.kh.city.Tokyo.acc;

import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.catalina.connector.Response;

/**
 * Servlet implementation class TourServlet
 */
@WebServlet("/TokyoAccServlet")
@MultipartConfig 

public class TokyoAccServlet extends HttpServlet {
	private static final String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String jdbcUsername = "tour";
	private static final String jdbcPassword = "1234";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Connection connection = null;
		try {
		Class.forName("oracle.jdbc.OracleDriver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		try {
			Connection conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			
			//sql
			String sql = "SELECT acc_img FROM accomodation";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Blob blob = rs.getBlob("acc_img");
				
				byte[] imageData = blob.getBytes(1, (int) blob.length());
				
				response.setContentType("image/jpeg");
				response.getOutputStream().write(imageData);
			}
			
		
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	 public List<TokyoAcc> getAllAccs() {
	    	List<TokyoAcc> accs = new ArrayList<>();
	        try {
	            Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
	            String sql = "SELECT * FROM accomodation WHERE CITY_NAME = 'Tokyo'";
	            PreparedStatement ps = connection.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	              
	                int acc_id = rs.getInt("acc_id");
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
	                 TokyoAcc acc =new TokyoAcc(acc_id,user_id,city_name,acc_name,acc_location,acc_phone,acc_time,acc_date,acc_comment, acc_img1,acc_img2, acc_img3);
	                accs.add(acc);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return accs;
	    }
    
	
	
		
	 public TokyoAcc getAcc(int acc_id) {
	    	TokyoAcc acc = null;
	    	
	    	try {
				Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
				String sql = "SELECT USER_ID, city_name, acc_NAME, acc_LOCATION, acc_PHONE, acc_TIME, acc_DATE, acc_COMMENT, acc_IMG1, acc_IMG2, acc_IMG3  FROM ACCOMODATION WHERE acc_id = ?";
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
	                 
	                 acc =new TokyoAcc(acc_id,user_id,city_name,acc_name,acc_location,acc_phone,acc_time,acc_date,acc_comment, acc_img1, acc_img2, acc_img3);
	                 
				}
				
	    	
	    	} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
	    	
	    	return acc;
	    }
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		try {
			Connection conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			
			int acc_id = Integer.parseInt(request.getParameter("acc_id"));
		    
		    String city_name = request.getParameter("city_name");
		   
			
			
			String user_id = request.getParameter("user_id");
			String acc_name = request.getParameter("acc_name");
			String acc_location = request.getParameter("acc_location");
			String acc_phone = request.getParameter("acc_phone");
			String acc_time = request.getParameter("acc_time");
			String acc_date = request.getParameter("acc_date");
			String acc_comment = request.getParameter("acc_comment");
			Part acc_img1 = request.getPart("acc_img1");
			Part acc_img2 = request.getPart("acc_img2");
			Part acc_img3 = request.getPart("acc_img3");
			
			
			String sql = "INSERT INTO accomodation(acc_id, user_id, city_name, acc_name, acc_location, acc_phone, acc_time, acc_date, acc_comment,acc_img1, acc_img2, acc_img3)"
					+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, acc_id);
			ps.setString(2, user_id);
			ps.setString(3, city_name);
			ps.setString(4, acc_name);
			ps.setString(5, acc_location);
			ps.setString(6, acc_phone);
			ps.setString(7, acc_time);
			ps.setTimestamp(8, new Timestamp(new Date().getTime()));
			ps.setString(9,acc_comment);
			ps.setBinaryStream(10, acc_img1.getInputStream(),(int) acc_img1.getSize());
			ps.setBinaryStream(11, acc_img2.getInputStream(),(int) acc_img2.getSize());
			ps.setBinaryStream(12, acc_img3.getInputStream(),(int) acc_img3.getSize());
			
			ps.executeUpdate();
			
			response.sendRedirect("input_acc_info.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
						
			
		
	}
}
