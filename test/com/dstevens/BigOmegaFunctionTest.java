package com.dstevens;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class BigOmegaFunctionTest {

	@Test
	public void testBigOmegaFunction() {
		BigOmegaFunction function = new BigOmegaFunction(new PrimesSupplier().primesLessThan(2005));
		
		assertEquals(0, function.apply(1));
		assertEquals(1, function.apply(2));
		assertEquals(1, function.apply(3));
		assertEquals(2, function.apply(4));
		assertEquals(4, function.apply(16));
		assertEquals(3, function.apply(20));
		assertEquals(3, function.apply(27));
		assertEquals(6, function.apply(144));
		assertEquals(7, function.apply(2000));
		assertEquals(3, function.apply(2001));
		assertEquals(4, function.apply(2002));
		assertEquals(1, function.apply(2003));
	}
	
}
