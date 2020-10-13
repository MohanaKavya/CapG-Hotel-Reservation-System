package com.capgemini.assignment.hotelreservation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class HotelReservationTest {
	@Test
	public void addHotelForRegularCustomerTest() {
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel("Lakewood", 3, 110, 90, 80, 80);
		hotelReservation.addHotel("Bridgewood", 4, 150, 50, 110, 50);
		hotelReservation.addHotel("Ridgewood", 5, 220, 150, 100, 40);
		int size = hotelReservation.getHotelList().size();
		assertEquals(3, size);		
	}
	
	@Test
	public void findCheapestHotelForRegCustomersForBothWeekdaysAndWeekendRatesTest() {
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel("Lakewood", 3, 110, 90, 80, 80);
		hotelReservation.addHotel("Bridgewood", 4, 150, 50, 110, 50);
		hotelReservation.addHotel("Ridgewood", 5, 220, 150, 100, 40);
		String output = hotelReservation.findCheapestHotel("11Sep2020, 12Sep2020");
		boolean check = output.equals("Bridgewood, Rating: 4 and Total Rates: $200");
		assertTrue(check);
	}
	@Test
	public void findHighestRatingHotelForRegCustomersTest() {
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel("Lakewood", 3, 110, 90, 80, 80);
		hotelReservation.addHotel("Bridgewood", 4, 150, 50, 110, 50);
		hotelReservation.addHotel("Ridgewood", 5, 220, 150, 100, 40);
		String output = hotelReservation.findHighestRatingHotel("11Sep2020, 12Sep2020");
		boolean check = output.equals("Ridgewood & Total Rates: $370");
		assertTrue(check);
	}
}
