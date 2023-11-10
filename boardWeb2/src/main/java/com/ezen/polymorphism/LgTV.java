package com.ezen.polymorphism;

import org.springframework.stereotype.Component;

@Component
public class LgTV implements TV{
	
	public LgTV() {
		System.out.println("LgTV »ý¼ºÀÚ");
	}
	
	@Override
	public void poweron() {
		System.out.println("LgTV powerOn");
		
	}

	@Override
	public void poweroff() {
		System.out.println("LgTV poweroff");
		
	}

	@Override
	public void volumeUp() {
		System.out.println("LgTV volumeUp");
		
	}

	@Override
	public void volumeDown() {
		System.out.println("LgTV volumeDown");
		
	}

}
