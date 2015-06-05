package com.dstevens;

import java.util.ArrayList;
import java.util.List;

public class PrimesSupplier {

	public List<Integer> primesLessThan(int max) {
		List<Integer> primes = new ArrayList<Integer>();
		if(max < 3) {
			return primes;
		}
		primes.add(2);
		
		for(int i=3;i<max;i+=2) {
			if(!isDivisibleByValueIn(i, primes)) {
				primes.add(i);
			}
		}
		
		return primes;
	}

	private boolean isDivisibleByValueIn(int i, List<Integer> primes) {
		for (Integer prime : primes) {
			if(i % prime == 0) {
				return true;
			}
		}
		return false;
	}
	
}
