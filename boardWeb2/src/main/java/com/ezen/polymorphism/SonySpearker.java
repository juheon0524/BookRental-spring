package com.ezen.polymorphism;

import org.springframework.stereotype.Component;

@Component("sony")
public class SonySpearker implements Spearker {
	public SonySpearker() {
		System.out.println("��Ͻ���Ŀ ������");
	}
	
	@Override
	public void volumeUp() {
		System.out.println("sony ������");
		
	}

	@Override
	public void volumeDown() {
		System.out.println("sony �����ٿ�");
		
	}
	
	
}