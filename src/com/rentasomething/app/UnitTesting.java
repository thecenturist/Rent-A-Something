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
		Person p1 = new Person("Jamie", "Finnicky", 983022304);
		assertEquals(983022304, p1.getSSN());
		assertEquals("Finnicky", p1.getLastName());
		assertEquals("Jamie", p1.getFirstName());
		assertEquals("Jamie Finnicky", p1.getFullName());
	}
}
