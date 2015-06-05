package com.dstevens;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

public class SecretCheckerTest {

	@Mock private AdditiveCheck additiveCheck;
	@Mock private Secret secret;
	
	private PrimesSupplier supplier = new PrimesSupplier();
	
	private SecretCheck secretCheck;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		
		secretCheck = new SecretCheck(supplier, additiveCheck);
	}
	
	@Test
	public void testThatCheckVerifiesSecretIsAdditiveIfAdditiveCheckReturnsTrueForAllInput() {
		when(additiveCheck.check(any(Secret.class), anyInt(), anyInt())).thenReturn(true);
		
		assertEquals(true, secretCheck.check(secret, 1000));
	}
	
	@Test
	public void testThatCheckWillVerifyEveryCombinationOfPrimes() {
		when(additiveCheck.check(secret, 2, 2)).thenReturn(true);
		when(additiveCheck.check(secret, 2, 3)).thenReturn(true);
		when(additiveCheck.check(secret, 2, 5)).thenReturn(true);
		when(additiveCheck.check(secret, 2, 7)).thenReturn(true);
		when(additiveCheck.check(secret, 3, 3)).thenReturn(true);
		when(additiveCheck.check(secret, 3, 5)).thenReturn(true);
		when(additiveCheck.check(secret, 3, 7)).thenReturn(true);
		when(additiveCheck.check(secret, 5, 5)).thenReturn(true);
		when(additiveCheck.check(secret, 5, 7)).thenReturn(true);
		when(additiveCheck.check(secret, 7, 7)).thenReturn(true);
		
		assertEquals(true, secretCheck.check(secret, 10));
	}
	
	@Test
	public void testThatCheckVerifiesSecretIsNotAdditiveIfAdditiveCheckReturnsFalseForAnyInput() {
		when(additiveCheck.check(secret, 2, 2)).thenReturn(true);
		when(additiveCheck.check(secret, 2, 3)).thenReturn(true);
		when(additiveCheck.check(secret, 2, 5)).thenReturn(true);
		when(additiveCheck.check(secret, 2, 7)).thenReturn(true);
		when(additiveCheck.check(secret, 3, 3)).thenReturn(true);
		when(additiveCheck.check(secret, 3, 5)).thenReturn(false);
		when(additiveCheck.check(secret, 3, 7)).thenReturn(true);
		when(additiveCheck.check(secret, 5, 5)).thenReturn(true);
		when(additiveCheck.check(secret, 5, 7)).thenReturn(true);
		when(additiveCheck.check(secret, 7, 7)).thenReturn(true);
		
		assertEquals(false, secretCheck.check(secret, 10));
	}
}
