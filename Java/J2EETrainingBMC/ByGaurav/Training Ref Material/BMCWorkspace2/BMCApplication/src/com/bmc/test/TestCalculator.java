package com.bmc.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestCalculator {
	Calculator calculator=null;

	@Before
	public void setUp() throws Exception {
		calculator=new Calculator();
	}

	@After
	public void tearDown() throws Exception {
		calculator=null;
	}

	@Test
	public void test_add_positive() {
		
		assertEquals(15,calculator.add(10, 5),0);
	}
	
	@Test
	public void test_add_negative() {
		try{
		assertEquals(10005,calculator.add(1000, 5),0);
		}catch(RuntimeException e){
			assertEquals("Out of Range",e.getMessage());
		}
	}

}
