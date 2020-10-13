package com.capgemini.assignment.hotelreservation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class HotelReservationTest {
	@Test
	public void addHotelForRegularCustomerTest() {
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel("Lakewood", 110);
		hotelReservation.addHotel("Bridgewood", 160);
		hotelReservation.addHotel("Ridgewood", 220);
		int size = hotelReservation.getHotelList().size();
		assertEquals(3, size);
		
	}
	
	@Test
	public void findCheapestHotelTest() {
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel("Lakewood", 110);
		hotelReservation.addHotel("Bridgewood", 160);
		hotelReservation.addHotel("Ridgewood", 220);
		String output = hotelReservation.findCheapestHotel("10Sep2020, 11Sep2020");
		boolean check = output.equals("Lakewood, Total Rates: $220");
		assertTrue(check);
	}
}
