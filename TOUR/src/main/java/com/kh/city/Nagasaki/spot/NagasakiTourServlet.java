package com.kh.city.Nagasaki.spot;

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
@WebServlet("/NagasakiTourServlet")
@MultipartConfig 

public class NagasakiTourServlet extends HttpServlet {
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
			String sql = "SELECT tour_img FROM tour";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Blob blob = rs.getBlob("tour_img");
				
				byte[] imageData = blob.getBytes(1, (int) blob.length());
				
				response.setContentType("image/jpeg");
				response.getOutputStream().write(imageData);
			}
			
		
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public List<NagasakiTour> getAllTours() {
        List<NagasakiTour> tours = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            String sql = "SELECT * FROM tour WHERE city_name = 'Kyoto'";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
              
                int tour_id = rs.getInt("tour_id");
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
                 NagasakiTour tour =new NagasakiTour(tour_id,user_id,city_name,tour_name,tour_location,tour_phone,tour_time,tour_date,tour_comment, tour_img1,tour_img2, tour_img3);
                tours.add(tour);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tours;
    }
    
	
	
		
	public NagasakiTour getTour(int tour_id) {
		NagasakiTour tour = null;
    	
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
                 
                 tour =new NagasakiTour(tour_id,user_id,city_name,tour_name,tour_location,tour_phone,tour_time,tour_date,tour_comment, tour_img1, tour_img2, tour_img3);
                 
			}
			
    	
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
    	
    	return tour;
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
			
			int tour_id = Integer.parseInt(request.getParameter("tour_id"));
		    
		    int city_id = Integer.parseInt(request.getParameter("city_id"));
		   
			
			
			String user_id = request.getParameter("user_id");
			String tour_name = request.getParameter("tour_name");
			String tour_location = request.getParameter("tour_location");
			String tour_phone = request.getParameter("tour_phone");
			String tour_time = request.getParameter("tour_time");
			String tour_date = request.getParameter("tour_date");
			String tour_comment = request.getParameter("tour_comment");
			Part tour_img1 = request.getPart("tour_img1");
			Part tour_img2 = request.getPart("tour_img2");
			Part tour_img3 = request.getPart("tour_img3");
			
			
			String sql = "INSERT INTO TOUR(tour_id, user_id, city_id, tour_name, tour_location, tour_phone, tour_time, tour_date, tour_comment,tour_img1, tour_img2, tour_img3)"
					+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, tour_id);
			ps.setString(2, user_id);
			ps.setInt(3, city_id);
			ps.setString(4, tour_name);
			ps.setString(5, tour_location);
			ps.setString(6, tour_phone);
			ps.setString(7, tour_time);
			ps.setTimestamp(8, new Timestamp(new Date().getTime()));
			ps.setString(9,tour_comment);
			ps.setBinaryStream(10, tour_img1.getInputStream(),(int) tour_img1.getSize());
			ps.setBinaryStream(11, tour_img2.getInputStream(),(int) tour_img2.getSize());
			ps.setBinaryStream(12, tour_img3.getInputStream(),(int) tour_img3.getSize());
			
			ps.executeUpdate();
			
			response.sendRedirect("input_tour_info.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
						
			
		
	}
}
