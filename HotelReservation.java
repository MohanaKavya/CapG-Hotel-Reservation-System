package com.capgemini.assignment.hotelreservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
// Type of Customers
enum Customer {
	REGULAR, REWARD
}
public class HotelReservation {
	private List<Hotel> hotelList = new ArrayList<Hotel>();
	private Customer customerType;
	
	// Adding new Hotel to Hotel Reservation Program
	public void addHotel(String hotelName, int rating, int weekdaysRatesRegularCustomer, int weekendRatesRegularCustomer,
						int weekdaysRatesRewardCustomer, int weekendRatesRewardCustomer) {
		Hotel hotel = new Hotel(hotelName, rating, weekdaysRatesRegularCustomer, 
								weekendRatesRegularCustomer, weekdaysRatesRewardCustomer, weekendRatesRewardCustomer);
		hotelList.add(hotel);
	}
	// Find Cheapest Hotel for Customer
	public String findCheapestHotel(String stayDates) {
		int[] duration = findStayDuration(stayDates);
		findTotalRates(duration);
		int minRate = getHotelList().stream().mapToInt(Hotel::getTotalRate).min().orElse(0);
		Hotel hotel = getHotelList().stream().filter(i -> (i.TotalRate==minRate)).max(Comparator.comparingInt(Hotel::getRating)).orElse(null);
		String output = hotel.getHotelName()+", Rating: "+hotel.getRating()+" and Total Rates: $"+hotel.getTotalRate();
		return output;		
	}
	// Find High Rating Hotel for Customer
		public String findHighestRatingHotel(String stayDates) {
			int[] duration = findStayDuration(stayDates);
			findTotalRates(duration);
			Hotel hotel = getHotelList().stream().max(Comparator.comparingInt(Hotel::getRating)).orElse(null);
			String output = hotel.getHotelName()+" & Total Rates: $"+hotel.getTotalRate();
			return output;		
		}
	// Finding Total Rates for all Hotels for Stay Duration
	private void findTotalRates(int[] duration) {
		if(customerType.equals(Customer.REGULAR))
		getHotelList().stream().forEach(i -> i.setTotalRate(duration[0]*i.getWeekdaysRatesRegularCustomer()+duration[1]*i.getWeekendRatesRegularCustomer()));		
		if(customerType.equals(Customer.REWARD))
			getHotelList().stream().forEach(i -> i.setTotalRate(duration[0]*i.getWeekdaysRatesRewardCustomer()+duration[1]*i.getWeekendRatesRewardCustomer()));		
	}
	// Finding Numbers of days stay Based on Start and End Date
	private int[] findStayDuration(String stayDates) {
		String [] date = stayDates.split(", ", 3);
		Date startDate = null;
		Date endDate = null;
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMMyyyy");
		try {
			startDate = formatter.parse(date[1]);
			endDate= formatter.parse(date[2]);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		setCustomerType(date[0]);
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
	private void setCustomerType(String cusType) {
		if(cusType.equals("regular"))
			customerType = Customer.REGULAR;
		if(cusType.equals("reward"))
			customerType = Customer.REWARD;	
	}
	// Getter & Setters
	public List<Hotel> getHotelList() {
		return hotelList;
	}

	public void setHotelList(List<Hotel> hotelList) {
		this.hotelList = hotelList;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel("Lakewood", 3, 110, 90, 80, 80);
		hotelReservation.addHotel("Bridgewood", 4, 150, 50, 110, 50);
		hotelReservation.addHotel("Ridgewood", 5, 220, 150, 100, 40);
		String input = "";
		// Display Message
		System.out.println("Welcome to Hotel Reservation Program");
		try {
			System.out.println("Select your Customer Membership Reward/Regular");
			String type = sc.next();
			boolean typeRegex = type.matches("^regular|reward|Regular|Reward$");
			System.out.println("Enter Check-in Date in Date 'ddMMMyyy' Format");
			String startDate = sc.next();
			boolean startRegex = startDate.matches("^([0][1-9]|[1-2][0-9]|[3][0-1])[A-Z][a-z]{2}[1-2][0-9]{3}$");
			System.out.println("Enter Check-out Date in Date 'ddMMMyyy' Format");
			String endDate = sc.next();
			boolean endRegex = endDate.matches("^([0][1-9]|[1-2][0-9]|[3][0-1])[A-Z][a-z]{2}[1-2][0-9]{3}$");
			if(!(typeRegex && startRegex && endRegex))
					throw new InvalidUserInputException("Invalid Customer Type or Date Format. Try Again");
			input = type.toLowerCase() +", "+ startDate +", "+ endDate;
		} catch (InvalidUserInputException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(hotelReservation.findCheapestHotel(input));
		}

}









