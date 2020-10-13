package com.capgemini.assignment.hotelreservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class HotelReservation {
	private List<Hotel> hotelList = new ArrayList<Hotel>();
	
	// Adding new Hotel to Hotel Reservation Program
	public void addHotel(String hotelName, int rateForRegularCustomer) {
		Hotel hotel = new Hotel(hotelName, rateForRegularCustomer);
		hotelList.add(hotel);
	}
	// Find Cheapest Hotel for Customer
	public String findCheapestHotel(String stayDates) {
		int duration = findStayDuration(stayDates);
		findTotalRates(duration);
		Hotel hotel = getHotelList().stream().sorted(Comparator.comparing(Hotel::getTotalRate)).findFirst().orElse(null);
		String output = hotel.getHotelName()+", Total Rates: $"+hotel.getTotalRate();
		System.out.println(output);
		return output;		
	}
	// Finding Total Rates for all Hotels for Stay Duration
	private void findTotalRates(int duration) {
		getHotelList().stream().forEach(i -> i.setTotalRate(duration*i.getRateForRegularCustomer()));		
	}
	// Finding Numbers of days stay Based on Start and End Date
	private int findStayDuration(String stayDates) {
		String [] date = stayDates.split(", ", 2);
		Date startDate = null;
		Date endDate = null;
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMMyyyy");
		try {
			startDate = formatter.parse(date[0]);
			endDate= formatter.parse(date[1]);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int duration = (endDate.getDate() - startDate.getDate())+1;
		return duration;
	}
	// Getter & Setters
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
