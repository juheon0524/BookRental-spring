package com.ezen.polymorphism;

import org.springframework.stereotype.Component;

@Component("apple")
public class AppleSpearker implements Spearker {
	
	public AppleSpearker() {
		System.out.println();
	}
	
	@Override
	public void volumeUp() {
		System.out.println("apple ������");
		
	}

	@Override
	public void volumeDown() {
		System.out.println("apple �����ٿ�");
		
	}
}
