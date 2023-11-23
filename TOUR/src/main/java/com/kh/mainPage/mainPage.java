package com.kh.mainPage;

public class mainPage {
	private int tour_id;
	private int city_id;
	



	private String tour_name;
	private String tour_location;
	private String tour_phone;
	private String tour_time;
	
	
	
	
	public mainPage(int tour_id,int city_id, String tour_name, String tour_location, String tour_phone, String tour_time) {
		this.tour_id = tour_id;
		this.city_id = city_id;
		this.tour_name = tour_name;
		this.tour_location = tour_location;
		this.tour_phone = tour_phone;
		this.tour_time = tour_time;
	

	}



	


	public int getTour_id() {
		return tour_id;
	}



	public void setTour_id(int tour_id) {
		this.tour_id = tour_id;
	}

	
	public int getCity_id() {
		return city_id;
	}





	public void setCity_id(int city_id) {
		this.city_id = city_id;
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



	
	
	
	
	
	

}
