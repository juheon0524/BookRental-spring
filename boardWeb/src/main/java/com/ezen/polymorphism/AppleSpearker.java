package com.ezen.polymorphism;
public class AppleSpearker implements Spearker {
	@Override
	public void volumeUp() {
		System.out.println("apple ������");
		
	}

	@Override
	public void volumeDown() {
		System.out.println("apple �����ٿ�");
		
	}
}