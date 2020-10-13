package com.capgemini.assignment.hotelreservation;

public class Hotel {

	private String hotelName;
	private int weekdaysRatesRegularCustomer, weekendRatesRegularCustomer;
	public int TotalRate;
	private int rating;

	public int getTotalRate() {
		return TotalRate;
	}

	public void setTotalRate(int totalRate) {
		TotalRate = totalRate;
	}

	public Hotel(String hotelName, int rating, int weekdaysRatesRegularCustomer, int weekendRatesRegularCustomer) {
		this.hotelName = hotelName;
		this.rating = rating;
		this.weekdaysRatesRegularCustomer = weekdaysRatesRegularCustomer;
		this.weekendRatesRegularCustomer = weekendRatesRegularCustomer;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getWeekdaysRatesRegularCustomer() {
		return weekdaysRatesRegularCustomer;
	}

	public void setWeekdaysRatesRegularCustomer(int weekdaysRatesRegularCustomer) {
		this.weekdaysRatesRegularCustomer = weekdaysRatesRegularCustomer;
	}

	public int getWeekendRatesRegularCustomer() {
		return weekendRatesRegularCustomer;
	}

	public void setWeekendRatesRegularCustomer(int weekendRatesRegularCustomer) {
		this.weekendRatesRegularCustomer = weekendRatesRegularCustomer;
	}
	
}
