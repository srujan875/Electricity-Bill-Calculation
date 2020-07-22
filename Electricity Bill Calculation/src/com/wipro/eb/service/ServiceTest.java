package com.wipro.eb.service;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.wipro.eb.exception.InvalidConnectionException;
import com.wipro.eb.exception.InvalidReadingException;

public class ServiceTest {

	@Test
	public void testValidate1() throws InvalidReadingException, InvalidConnectionException {
	assertTrue(new ConnectionService().validate(180, 100,"Domestic"));	
	}
	@Test(expected= InvalidConnectionException.class)
	public void testValidate2() throws InvalidReadingException, InvalidConnectionException {
	new ConnectionService().validate(180, 100,"Housing");	
	}
	@Test(expected=InvalidReadingException.class)
	public void testValidate3() throws InvalidReadingException, InvalidConnectionException {
	new ConnectionService().validate(100, 180,"Domestic");	
	}
	
	

	
	@Test
	public void testCalculateBillAmt1() {
	Assert.assertEquals(69.0,new ConnectionService().calculateBillAmt(130,100,"Domestic"),0.1);
	}

	@Test
	public void testCalculateBillAmt2() {
		assertEquals(241.0,new ConnectionService().calculateBillAmt(180,100,"Domestic"),0.1);
		}
	@Test
	public void testCalculateBillAmt3() {
		assertEquals(600.0,new ConnectionService().calculateBillAmt(250,100,"Domestic"),0.1);
			
	}

	@Test
	public void testCalculateBillAmt4() {
		assertEquals(159.12,new ConnectionService().calculateBillAmt(130,100,"Commercial"),0.1);
		 
		}

	@Test
	public void testCalculateBillAmt5() {
		assertEquals(473.28,new ConnectionService().calculateBillAmt(180,100,"Commercial"),0.1);
			
	}
	@Test
	public void testCalculateBillAmt6() {
		assertEquals(1035.3,new ConnectionService().calculateBillAmt(250,100,"Commercial"),0.1);
		
		}
}
