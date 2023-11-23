package com.kh.board;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/board/AddCommentServlet")
public class AddCommentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=EUC-KR");
       
        try {

        	
       
        // 세션이 있고 사용자가 로그인한 상태인 경우에만 댓글 추가
		int review_number = Integer.parseInt(request.getParameter("review_number"));
		int post_number = Integer.parseInt(request.getParameter("post_number"));
		
        String user_id = request.getParameter("user_id");
		
		String review_writer = request.getParameter("review_writer");
		String review_content = request.getParameter("review_content");
		Timestamp  review_date = new Timestamp(System.currentTimeMillis());
            // 여기에서 댓글을 데이터베이스에 저장하는 등의 작업을 수행할 수 있습니다.
		BoardComment bReview = new BoardComment(review_number,post_number, user_id,review_writer,review_content,review_date);
		
	    BoardDAO boardDAO = new BoardDAO();
	    boardDAO.addComment(bReview);
	    
	    System.out.println("댓글추가");

	    response.sendRedirect("boardDetail.jsp?post_number=" + post_number);
        } catch (NumberFormatException e) {
        	e.printStackTrace();
        //	response.sendRedirect("error.jsp");
        }
	   
    }
}