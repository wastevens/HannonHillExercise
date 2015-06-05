package com.dstevens;

import java.util.List;

public class SecretCheck {

	private final PrimesSupplier supplier;
	private final AdditiveCheck check;

	public SecretCheck(PrimesSupplier supplier, AdditiveCheck check) {
		this.supplier = supplier;
		this.check = check;
	}
	
	public boolean check(Secret secret, int max) {
		List<Integer> primes = supplier.primesLessThan(max);
		for(int i=0;i<primes.size();i++) {
			for(int j=i;j<primes.size();j++) {
				if(!check.check(secret, primes.get(i), primes.get(j))) {
					return false;
				}
			}
		}
		return true;
	}
	
}
