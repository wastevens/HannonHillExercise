package com.dstevens;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AdditiveCheckTest {

	@Test
	public void testIsAdditive() {
		AdditiveCheck check = new AdditiveCheck();
		
		assertEquals(true, check.check(new AdditiveFunction(), 2, 3));
		assertEquals(false, check.check(new NotAdditiveFunction(), 2, 3));
	}
	
	@Test
	public void testIsAdditiveOnlyConfirmsAdditivityOfGivenValues() {
		AdditiveCheck check = new AdditiveCheck();
		
		assertEquals(true, check.check(new NotAdditiveFunction(), 0, 0));
	}
	
	private static class AdditiveFunction implements Secret {
		@Override
		public int apply(int i) {
			return 0;
		}
	}
	
	private static class NotAdditiveFunction implements Secret {
		@Override
		public int apply(int i) {
			return i;
		}
	}
}
