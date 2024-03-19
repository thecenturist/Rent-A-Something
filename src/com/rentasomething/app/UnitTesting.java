package com.rentasomething.app;

/**
 * Lead Author(s):
 * @author Kaitlyn Nguy
 * @author Anjolaoluwa Akinremi
 * 
 * References:
 * Version/date: March-18-2024
 * 
 * Responsibilities of class:
 * Define test methods for the project classes and their methods
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class UnitTesting {
	@Test
	void testPerson() {
		Person p1 = new Person("Jamie", "Finnicky", 983022304L);
		assertEquals(983022304, p1.getSSN());
		assertEquals("Finnicky", p1.getLastName());
		assertEquals("Jamie", p1.getFirstName());
		assertEquals("Jamie Finnicky", p1.getFullName());
		p1.setFirstName("Amie");
		assertNotEquals("Jamie Finnicky 983022304", p1.toString());
		p1.setLastName("Johnston");
		p1.setSSN(9998883332L);
		assertEquals(9998883332L, p1.getSSN());
		assertEquals("Johnston", p1.getLastName());
		assertEquals("Amie", p1.getFirstName());
		assertEquals("Amie Johnston", p1.getFullName());
		assertEquals("Amie Johnston 9998883332", p1.toString());
	}
	
	@Test
	void testVehicle() {
		Vehicle v1 = new Vehicle("Nissan", "Maxima", 2021);
		assertEquals("Nissan", v1.getManufacturer());
		assertEquals("Maxima", v1.getModel());
		assertEquals(2021, v1.getYear());
		v1.setManufacturer("Toyota");
		assertEquals("Toyota", v1.getManufacturer());
		v1.setModel("Camry");
		assertEquals("Camry", v1.getModel());
		v1.setYear(2022);
		assertEquals(2022, v1.getYear());
		assertEquals(0, v1.getRentAmount());
		assertEquals(0, v1.getDiscountPercentage());
		Vehicle v2 = new Vehicle("Acura", "TRX", 2020, 60.50, 4.0);
		assertEquals(60.5, v2.getRentAmount());
		assertEquals(4, v2.getDiscountPercentage());
	}
}
