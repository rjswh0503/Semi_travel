package com.kh.city.Shizuoka.acc;

import java.sql.Blob;

import javax.servlet.http.Part;

public class ShizuokaAcc {
	private int acc_id;
	private String user_id;
	private String city_name;
	private int city_id;

	private String acc_name;
	private String acc_location;
	private String acc_phone;
	private String acc_time;
	private String acc_date;
	private int tour_like;
	private String acc_comment;
	
	private String acc_img1;
	private String acc_img2;
	private String acc_img3;
	
	public ShizuokaAcc(int acc_id, String user_id, String city_name, String acc_name, String acc_location, String acc_phone, String acc_time, String acc_date, String acc_comment, String acc_img1, String acc_img2, String acc_img3) {
		this.acc_id = acc_id;
		this.user_id = user_id;
		this.city_name = city_name;
		this.acc_name = acc_name;
		this.acc_location = acc_location;
		this.acc_phone = acc_phone;
		this.acc_time = acc_time;
		this.acc_date = acc_date;
		this.acc_comment = acc_comment;
		this.acc_img1 = acc_img1;
		this.acc_img2 = acc_img2;
		this.acc_img3 = acc_img3;
	}
	
	
	

	public ShizuokaAcc() {
		
	}
	
	public int getCity_id() {
		return city_id;
	}
	


	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}

	public String getCity_name() {
		return city_name;
	}


	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}




	public int getAcc_id() {
		return acc_id;
	}




	public void setAcc_id(int acc_id) {
		this.acc_id = acc_id;
	}




	public String getUser_id() {
		return user_id;
	}




	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}




	public String getAcc_name() {
		return acc_name;
	}




	public void setAcc_name(String acc_name) {
		this.acc_name = acc_name;
	}




	public String getAcc_location() {
		return acc_location;
	}




	public void setAcc_location(String acc_location) {
		this.acc_location = acc_location;
	}




	public String getAcc_phone() {
		return acc_phone;
	}




	public void setAcc_phone(String acc_phone) {
		this.acc_phone = acc_phone;
	}




	public String getAcc_time() {
		return acc_time;
	}




	public void setAcc_time(String acc_time) {
		this.acc_time = acc_time;
	}




	public String getAcc_date() {
		return acc_date;
	}




	public void setAcc_date(String acc_date) {
		this.acc_date = acc_date;
	}




	public int getTour_like() {
		return tour_like;
	}




	public void setTour_like(int tour_like) {
		this.tour_like = tour_like;
	}




	public String getAcc_comment() {
		return acc_comment;
	}




	public void setAcc_comment(String acc_comment) {
		this.acc_comment = acc_comment;
	}




	public String getAcc_img1() {
		return acc_img1;
	}




	public void setAcc_img1(String acc_img1) {
		this.acc_img1 = acc_img1;
	}




	public String getAcc_img2() {
		return acc_img2;
	}




	public void setAcc_img2(String acc_img2) {
		this.acc_img2 = acc_img2;
	}




	public String getAcc_img3() {
		return acc_img3;
	}




	public void setAcc_img3(String acc_img3) {
		this.acc_img3 = acc_img3;
	}
	

	
	
}
