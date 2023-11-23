package com.kh.city.Sapporo.res;

import java.sql.Blob;

import javax.servlet.http.Part;

public class SapporoRes {
	private int res_id;
	private String user_id;
	private String city_name;
	private int city_id;
	
	private String res_name;
	private String res_location;
	private String res_phone;
	private String res_time;
	private String res_date;
	private int res_like;
	private String res_comment;
	
	private String res_img1;
	private String res_img2;
	private String res_img3;
	
	public SapporoRes(int res_id, String user_id, String city_name, String res_name, String res_location, String res_phone, String res_time, String res_date, String res_comment, String res_img1, String res_img2, String res_img3) {
		this.res_id = res_id;
		this.user_id = user_id;
		this.city_name = city_name;
		this.res_name = res_name;
		this.res_location = res_location;
		this.res_phone = res_phone;
		this.res_time = res_time;
		this.res_date = res_date;
		this.res_comment = res_comment;
		this.res_img1 = res_img1;
		this.res_img2 = res_img2;
		this.res_img3 = res_img3;
	}

	public int getRes_id() {
		return res_id;
	}

	public void setRes_id(int res_id) {
		this.res_id = res_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getCity_name() {
		return city_name;
	}

	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}

	public int getCity_id() {
		return city_id;
	}

	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}

	public String getRes_name() {
		return res_name;
	}

	public void setRes_name(String res_name) {
		this.res_name = res_name;
	}

	public String getRes_location() {
		return res_location;
	}

	public void setRes_location(String res_location) {
		this.res_location = res_location;
	}

	public String getRes_phone() {
		return res_phone;
	}

	public void setRes_phone(String res_phone) {
		this.res_phone = res_phone;
	}

	public String getRes_time() {
		return res_time;
	}

	public void setRes_time(String res_time) {
		this.res_time = res_time;
	}

	public String getRes_date() {
		return res_date;
	}

	public void setRes_date(String res_date) {
		this.res_date = res_date;
	}

	public int getRes_like() {
		return res_like;
	}

	public void setRes_like(int res_like) {
		this.res_like = res_like;
	}

	public String getRes_comment() {
		return res_comment;
	}

	public void setRes_comment(String res_comment) {
		this.res_comment = res_comment;
	}

	public String getRes_img1() {
		return res_img1;
	}

	public void setRes_img1(String res_img1) {
		this.res_img1 = res_img1;
	}

	public String getRes_img2() {
		return res_img2;
	}

	public void setRes_img2(String res_img2) {
		this.res_img2 = res_img2;
	}

	public String getRes_img3() {
		return res_img3;
	}

	public void setRes_img3(String res_img3) {
		this.res_img3 = res_img3;
	}
	
	
}
	

	
	
