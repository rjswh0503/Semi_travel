package com.kh.board;

import java.sql.Date;
import java.sql.Timestamp;

import oracle.sql.TIMESTAMP;

public class BoardComment {
	private  int review_number;
	private int post_number;
	private	 String user_id;
	private	 String review_content;
	private  String review_writer;
	private Timestamp review_date;
	
	
	
	public BoardComment() {
		// TODO Auto-generated constructor stub
	}

	
	
	public BoardComment(int review_number, int post_number, String user_id, String review_writer,String review_content, Timestamp review_date) {
		this.review_number = review_number;
		this.post_number = post_number;
		this.user_id = user_id;
		this.review_writer = review_writer;
		this.review_content = review_content;
		this.review_date = review_date;
	}




	public BoardComment(int review_number, String user_id, String review_writer, String review_content, Timestamp review_date) {
		this.review_number = review_number;
		this.user_id = user_id;
		this.review_writer = review_writer;
		this.review_content = review_content;
		this.review_date = review_date;
	}



	public int getPost_Number() {
		return post_number;
	}

	public void setPost_Number(int post_Number) {
		this.post_number = post_Number;
	}

	public Timestamp getReview_date() {
		return review_date;
	}

	public void setReview_date(Timestamp review_date) {
		this.review_date = review_date;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getReview_content() {
		return review_content;
	}

	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}

	public String getReview_writer() {
		return review_writer;
	}

	public void setReview_writer(String review_writer) {
		this.review_writer = review_writer;
	}

	public int getReview_number() {
		return review_number;
	}

	public void setReview_number(int review_number) {
		this.review_number = review_number;
	}




	

	

	

	
	
	
}
