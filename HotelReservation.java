package com.capgemini.assignment.hotelreservation;

import java.util.ArrayList;
import java.util.List;

public class HotelReservation {

	private List<Hotel> hotelList = new ArrayList<Hotel>();

	public void addHotel(String hotelName, int rateForRegularCustomer) {
		Hotel hotel = new Hotel(hotelName, rateForRegularCustomer);
		hotelList.add(hotel);
	}
	
	public List<Hotel> getHotelList() {
		return hotelList;
	}

	public void setHotelList(List<Hotel> hotelList) {
		this.hotelList = hotelList;
	}

	public static void main(String[] args) {
		// Display Message
		System.out.println("Welcome to Hotel Reservation Program");
	}

}
