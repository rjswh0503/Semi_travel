package com.kh.city.Nagasaki.spot;

import java.sql.Blob;

import javax.servlet.http.Part;

public class NagasakiTour {
	private int tour_id;
	private String user_id;
	private String city_name;
	private int city_id;
	
	private String tour_name;
	private String tour_location;
	private String tour_phone;
	private String tour_time;
	private String tour_date;
	private int tour_like;
	private String tour_comment;
	
	private String tour_img1;
	private String tour_img2;
	private String tour_img3;
	
	public NagasakiTour(int tour_id, String user_id, String city_name, String tour_name, String tour_location, String tour_phone, String tour_time, String tour_date, String tour_comment, String tour_img1, String tour_img2, String tour_img3) {
		this.tour_id = tour_id;
		this.user_id = user_id;
		this.city_name = city_name;
		this.tour_name = tour_name;
		this.tour_location = tour_location;
		this.tour_phone = tour_phone;
		this.tour_time = tour_time;
		this.tour_date = tour_date;
		this.tour_comment = tour_comment;
		this.tour_img1 = tour_img1;
		this.tour_img2 = tour_img2;
		this.tour_img3 = tour_img3;
	}
	
	
	public String getTour_img1() {
		return tour_img1;
	}


	public void setTour_img1(String tour_img1) {
		this.tour_img1 = tour_img1;
	}


	public String getTour_img2() {
		return tour_img2;
	}


	public void setTour_img2(String tour_img2) {
		this.tour_img2 = tour_img2;
	}


	public String getTour_img3() {
		return tour_img3;
	}


	public void setTour_img3(String tour_img3) {
		this.tour_img3 = tour_img3;
	}


	public NagasakiTour() {
		
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
	

	
	
	public int getTour_id() {
		return tour_id;
	}
	public void setTour_id(int tour_id) {
		this.tour_id = tour_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getTour_name() {
		return tour_name;
	}
	public void setTour_name(String tour_name) {
		this.tour_name = tour_name;
	}
	public String getTour_location() {
		return tour_location;
	}
	public void setTour_location(String tour_location) {
		this.tour_location = tour_location;
	}
	public String getTour_phone() {
		return tour_phone;
	}
	public void setTour_phone(String tour_phone) {
		this.tour_phone = tour_phone;
	}
	public String getTour_time() {
		return tour_time;
	}
	public void setTour_time(String tour_time) {
		this.tour_time = tour_time;
	}
	public String getTour_date() {
		return tour_date;
	}
	public void setTour_date(String tour_date) {
		this.tour_date = tour_date;
	}
	public int getTour_like() {
		return tour_like;
	}
	public void setTour_like(int tour_like) {
		this.tour_like = tour_like;
	}
	public String getTour_comment() {
		return tour_comment;
	}
	public void setTour_comment(String tour_comment) {
		this.tour_comment = tour_comment;
	}
}
