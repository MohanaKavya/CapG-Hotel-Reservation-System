package com.capgemini.assignment.hotelreservation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class HotelReservationTest {
	@Test
	public void addHotelForRegularCustomerTest() {
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel("Lakewood", 3, 110, 90);
		hotelReservation.addHotel("Bridgewood", 4, 150, 50);
		hotelReservation.addHotel("Ridgewood", 5, 220, 150);
		int size = hotelReservation.getHotelList().size();
		assertEquals(3, size);		
	}
	
	@Test
	public void findCheapestHotelForRegCustomersforWeekdaysRatesTest() {
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel("Lakewood", 3, 110, 90);
		hotelReservation.addHotel("Bridgewood", 4, 150, 50);
		hotelReservation.addHotel("Ridgewood", 5, 220, 150);
		String output = hotelReservation.findCheapestHotel("10Sep2020, 11Sep2020");
		boolean check = output.equals("Lakewood, Total Rates: $220");
		assertTrue(check);
	}
	@Test
	public void findCheapestHotelForRegCustomersForBothWeekdaysAndWeekendRatesTest() {
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel("Lakewood", 3, 110, 90);
		hotelReservation.addHotel("Bridgewood", 4, 150, 50);
		hotelReservation.addHotel("Ridgewood", 5, 220, 150);
		String output = hotelReservation.findCheapestHotel("11Sep2020, 12Sep2020");
		boolean check = output.equals("Bridgewood, Total Rates: $200");
		assertTrue(check);
	}
}
