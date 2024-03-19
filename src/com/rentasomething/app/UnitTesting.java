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
}
