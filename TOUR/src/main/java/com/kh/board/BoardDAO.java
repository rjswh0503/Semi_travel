package com.kh.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
	private static final String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String jdbcUsername = "tour";
	private static final String jdbcPassword = "1234";
	
	public BoardDAO() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<BoardDTO> getAllBoards() {
		List<BoardDTO> boards = new ArrayList<>();
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			BoardDTO bd = null;
			String sql = "SELECT * FROM boards";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				bd = new BoardDTO();
				bd.setPost_number(rs.getInt("post_number"));
				bd.setUser_id(rs.getString("user_id"));
				bd.setCity_name(rs.getString("city_name"));
				bd.setTitle(rs.getString("title"));
				bd.setContent(rs.getString("content"));
				bd.setPost_time(rs.getString("post_time"));
				bd.setCategory(rs.getString("category"));
				boards.add(bd);
			
			}
			
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return boards;
	}
		
	public BoardDTO getBoard(int post_number) {
		
		BoardDTO bd = null;
		
		
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			String sql = "SELECT user_id, city_name, title, content, post_time, category  FROM boards WHERE post_number = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, post_number);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				bd = new BoardDTO();
				bd.setUser_id(rs.getString("user_id"));
				bd.setCity_name(rs.getString("city_name"));
				bd.setTitle(rs.getString("title"));
				bd.setContent(rs.getString("content"));
				bd.setPost_time(rs.getString("post_time"));
				bd.setCategory(rs.getString("category"));
			}
			
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bd;
	
}
	
	
	public BoardDTO getCity_name(int city_name) {
		BoardDTO board = null;
		
		return board;
	}
	public boolean addComment(BoardComment bReview) {
        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
       PreparedStatement ps = connection.prepareStatement(
       "INSERT INTO review (review_number, post_Number,user_id,review_writer,review_content,review_date) VALUES (review_seq.NEXTVAL,?,?,?,?,CURRENT_TIMESTAMP)")) {

                        
			 ps.setInt(1, bReview.getPost_Number());
			 ps.setString(2,  bReview.getUser_id());
			 ps.setString(3, bReview.getReview_writer());
			 ps.setString(4, bReview.getReview_content());
			

            int rowsAffected = ps.executeUpdate();
            System.out.println("rowsAffected : " + rowsAffected);
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
	public BoardComment getBoardCommentById(String user_id) {
		
		BoardComment bc = null;
		
		
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			String sql = "SELECT * FROM review WHERE user_id = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, user_id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				bc = new BoardComment();
				bc.setUser_id(rs.getString("user_id"));
				bc.setReview_content(rs.getString("review_content"));
				bc.setReview_writer(rs.getString("review_writer"));
			}
			
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bc;
	
	}
	   public ArrayList<BoardComment> getCommentsByProductId(int post_number) {
		   ArrayList<BoardComment> commentList = new ArrayList<>();

	        try {
	        	Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
	        	String sql = "SELECT * FROM review WHERE post_number = ?";
	            PreparedStatement preparedStatement = connection.prepareStatement(sql);
	        
	            preparedStatement.setInt(1, post_number);

	           
	            	ResultSet resultSet = preparedStatement.executeQuery();
	                while (resultSet.next()) {
	                	
	                    int review_number  = resultSet.getInt("review_number"); 
	                    int post_Number  = resultSet.getInt("post_Number"); 
	                    String user_id = resultSet.getString("user_id");
	                    String review_writer = resultSet.getString("review_writer");
	                    String review_content = resultSet.getString("review_content");
	                    Timestamp review_date  = resultSet.getTimestamp("review_date"); 

	                    BoardComment comment = new BoardComment(review_number,user_id,review_writer,review_content ,review_date);
	                    commentList.add(comment);
	                }
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return commentList;
	}
	   
	   public List<BoardDTO> getBoardsByUserId(String user_id) {
		    List<BoardDTO> userBoards = new ArrayList<>();
		    try {
		        Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		        String sql = "SELECT * FROM boards WHERE user_id = ?";
		        PreparedStatement ps = connection.prepareStatement(sql);
		        ps.setString(1, user_id);
		        ResultSet rs = ps.executeQuery();
		        while (rs.next()) {
		            BoardDTO board = new BoardDTO();
		            board.setPost_number(rs.getInt("post_number"));
		            board.setCity_name(rs.getString("city_name"));
		            board.setCategory(rs.getString("category"));
		            board.setTitle(rs.getString("title"));
		            board.setPost_time(rs.getString("post_time"));
		            userBoards.add(board);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return userBoards;
		}

}