package org.NewCore;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;



public class ValidateTest {
	private Validator validatorTest = new DefaultValidator();
	private User user;
	private User user2;
	private User user3;

	
	@Test
	public void shouldValidateFirstName() {
		user = new DefaultUser("Dina", "Mohamed", "dhagag16@gmail.com", "1234");
		user2 = new DefaultUser("Dina1", "Mohamed", "dhagag16@gmail.com", "1234");
		user3= new DefaultUser("Din@a", "Mohamed", "dhagag16@gmail.com", "1234");
		
		assertTrue(validatorTest.isValid(user));
		assertFalse(validatorTest.isValid(user2));
//		assertFalse(validatorTest.isValid(user3));
		
	}
	
	
	@Test
	public void shouldValidateLastName() {
		user = new DefaultUser("Dina", "Mohamed", "dhagag16@gmail.com", "1234");
		user2 = new DefaultUser("Dina", "Moh4amed", "dhagag16@gmail.com", "1234");
		user3= new DefaultUser("Dina", "Mo-hamed", "dhagag16@gmail.com", "1234");
		
		assertTrue(validatorTest.isValid(user));
//		assertFalse(validatorTest.isValid(user2));
//		assertFalse(validatorTest.isValid(user3));
//		
	}
	
	@Test
	public void shouldValidateEmail() {
		user = new DefaultUser("Dina", "Mohamed", "dhagag16@gmail.com", "1234");
		user2 = new DefaultUser("Dina", "Mohamed", "dhagag16.com", "1234");
		user3= new DefaultUser("Dina", "Mohamed", "dhagag16@gmail", "1234");
		
		assertTrue(validatorTest.isValid(user));
//		assertFalse(validatorTest.isValid(user2));
//		assertFalse(validatorTest.isValid(user3));
		
	}
}
