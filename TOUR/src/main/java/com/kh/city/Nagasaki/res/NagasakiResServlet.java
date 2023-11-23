package com.kh.city.Nagasaki.res;

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
@WebServlet("/NagasakiResServlet")
@MultipartConfig 

public class NagasakiResServlet extends HttpServlet {
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
			String sql = "SELECT res_img FROM res";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Blob blob = rs.getBlob("res_img");
				
				byte[] imageData = blob.getBytes(1, (int) blob.length());
				
				response.setContentType("image/jpeg");
				response.getOutputStream().write(imageData);
			}
			
		
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public List<NagasakiRes> getAllRess() {
    	List<NagasakiRes> ress = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            String sql = "SELECT * FROM RESTAURANT  WHERE city_name= 'Nagasaki'";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
              
                int res_id = rs.getInt("res_id");
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
                 NagasakiRes res =new NagasakiRes(res_id,user_id,city_name,res_name,res_location,res_phone,res_time,res_date,res_comment, res_img1,res_img2, res_img3);
                ress.add(res);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ress;
    }
    
	
	
		
	public NagasakiRes getRes(int res_id) {
    	NagasakiRes res = null;
    	
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
                 
                 res =new NagasakiRes(res_id,user_id,city_name,res_name,res_location,res_phone,res_time,res_date,res_comment, res_img1, res_img2, res_img3);
                 
			}
			
    	
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
    	
    	return res;
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
			
			int res_id = Integer.parseInt(request.getParameter("res_id"));
		    
		    String city_name = request.getParameter("city_name");
		   
			
			
			String user_id = request.getParameter("user_id");
			String res_name = request.getParameter("res_name");
			String res_location = request.getParameter("res_location");
			String res_phone = request.getParameter("res_phone");
			String res_time = request.getParameter("res_time");
			String res_date = request.getParameter("res_date");
			String res_comment = request.getParameter("res_comment");
			Part res_img1 = request.getPart("res_img1");
			Part res_img2 = request.getPart("res_img2");
			Part res_img3 = request.getPart("res_img3");
			
			
			String sql = "INSERT INTO RESTAURANT(res_id, user_id, city_name, res_name, res_location, res_phone, res_time, res_date, res_comment,res_img1, res_img2, res_img3)"
					+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, res_id);
			ps.setString(2, user_id);
			ps.setString(3, city_name);
			ps.setString(4, res_name);
			ps.setString(5, res_location);
			ps.setString(6, res_phone);
			ps.setString(7, res_time);
			ps.setTimestamp(8, new Timestamp(new Date().getTime()));
			ps.setString(9,res_comment);
			ps.setBinaryStream(10, res_img1.getInputStream(),(int) res_img1.getSize());
			ps.setBinaryStream(11, res_img2.getInputStream(),(int) res_img2.getSize());
			ps.setBinaryStream(12, res_img3.getInputStream(),(int) res_img3.getSize());
			
			ps.executeUpdate();
			
			response.sendRedirect("input_res_info.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
						
			
		
	}
}
