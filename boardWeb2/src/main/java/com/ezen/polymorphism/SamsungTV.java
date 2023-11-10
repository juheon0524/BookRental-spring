package com.ezen.polymorphism;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("Samsung")
public class SamsungTV implements TV{
	
	@Autowired
	@Qualifier("apple")
	private Spearker spearker;
	
	private int price;
	
	
	



	public SamsungTV() {
		System.out.println("SamsungTV 생성자");
	}
	
	

	
	public void initMethod() {
		System.out.println("생성자 initMethod ==> 초기화 문장 기입");
	}
	
	@Override
	public void poweron() {
		System.out.println("SamsungTV powerOn" + price);		
	}

	@Override
	public void poweroff() {
		System.out.println("SamsungTV powerOff");	
		
	}

	@Override
	public void volumeUp() {
		System.out.println("SamsungTV volumeUp");	
	}

	@Override
	public void volumeDown() {
//		spearker = new SonySpearker();
		spearker.volumeDown();
//		System.out.println("SamsungTV volumeDown");	
		
	}

}
