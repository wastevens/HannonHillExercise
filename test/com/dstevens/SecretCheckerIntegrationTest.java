package com.dstevens;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

//This test is intended as an integration test, exercising a complete end-to-end scenario of the SecretChecker, 
//with both larger number of prime numbers and a relatively complex 'true' additive function (Big Omega)
//It runs significantly slower than would be acceptable for a unit test, and would ideally be segregated from the rest. 
public class SecretCheckerIntegrationTest {

	private AdditiveCheck additiveCheck = new AdditiveCheck();
	private PrimesSupplier supplier = new PrimesSupplier();
	
	private SecretCheck secretCheck;
	
	@Before
	public void setUp() {
		secretCheck = new SecretCheck(supplier, additiveCheck);
	}
	
	@Test
	public void testGivenAComplexAdditiveFunction() {
		Secret secretFunction = new BigOmegaFunction(supplier.primesLessThan(10000));
		
		assertEquals(true, secretCheck.check(secretFunction, 10000));
	}
}
