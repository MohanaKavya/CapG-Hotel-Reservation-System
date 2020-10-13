package com.capgemini.assignment.hotelreservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class HotelReservation {
	private List<Hotel> hotelList = new ArrayList<Hotel>();
	
	// Adding new Hotel to Hotel Reservation Program
	public void addHotel(String hotelName, int rating, int weekdaysRatesRegularCustomer, int weekendRatesRegularCustomer) {
		Hotel hotel = new Hotel(hotelName, rating, weekdaysRatesRegularCustomer, weekendRatesRegularCustomer);
		hotelList.add(hotel);
	}
	// Find Cheapest Hotel for Customer
	public String findCheapestHotel(String stayDates) {
		int[] duration = findStayDuration(stayDates);
		findTotalRates(duration);
		int minRate = getHotelList().stream().mapToInt(Hotel::getTotalRate).min().orElse(0);
		Hotel hotel = getHotelList().stream().filter(i -> (i.TotalRate==minRate)).max(Comparator.comparingInt(Hotel::getRating)).orElse(null);
		String output = hotel.getHotelName()+", Rating: "+hotel.getRating()+" and Total Rates: $"+hotel.getTotalRate();
		System.out.println(output);
		return output;		
	}
	// Find High Rating Hotel for Customer
		public String findHighestRatingHotel(String stayDates) {
			int[] duration = findStayDuration(stayDates);
			findTotalRates(duration);
			Hotel hotel = getHotelList().stream().max(Comparator.comparingInt(Hotel::getRating)).orElse(null);
			String output = hotel.getHotelName()+" & Total Rates: $"+hotel.getTotalRate();
			System.out.println(output);
			return output;		
		}
	// Finding Total Rates for all Hotels for Stay Duration
	private void findTotalRates(int[] duration) {
		getHotelList().stream().forEach(i -> i.setTotalRate(duration[0]*i.getWeekdaysRatesRegularCustomer()+duration[1]*i.getWeekendRatesRegularCustomer()));		
	}
	// Finding Numbers of days stay Based on Start and End Date
	private int[] findStayDuration(String stayDates) {
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
		Calendar cal = Calendar.getInstance();
		int[] duration = new int[2];
		long diff = ((endDate.getTime()-startDate.getTime())/1000/60/60/24)+1;
		Date start = startDate;
		while(diff>0) {
			if(start.getDay()!=0 && start.getDay()!=6)
				duration[0]++;
			else
				duration[1]++;
			
	        cal.setTime(start);
	        cal.add(Calendar.DATE, 1); 
	        start = cal.getTime();	
	        diff--;
		}
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
