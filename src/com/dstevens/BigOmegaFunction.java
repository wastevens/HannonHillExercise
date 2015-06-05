package com.dstevens;

import java.util.ArrayList;
import java.util.List;

//The Big Omega Function is defined as returning the total number of prime factors of n, counting multiple factors multiple times
//Examples drawn from http://en.wikipedia.org/wiki/Additive_function
public class BigOmegaFunction implements Secret {

	private List<Integer> primes;

	public BigOmegaFunction(List<Integer> primes) {
		this.primes = primes;
	}
	
	@Override
	public int apply(int i) {
		List<Integer> primeFactors = new ArrayList<Integer>();
		for (Integer prime : primes) {
			while(i >= prime && i % prime == 0) {
				i = i / prime;
				primeFactors.add(prime);
			}
		}
		
		return primeFactors.size();
	}

}
