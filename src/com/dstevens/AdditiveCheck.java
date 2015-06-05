package com.dstevens;

public class AdditiveCheck {

	public boolean check(Secret secret, int x, int y) {
		return secret.apply(x) + secret.apply(y) == secret.apply(x * y);
	}
	
}
