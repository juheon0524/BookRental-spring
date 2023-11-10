package com.ezen.polymorphism;

public class SamsungTV implements TV{
	
	private Spearker spearker;
	private int price;
	
	

	
	public void setSpearker(Spearker spearker) {
		this.spearker = spearker;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public SamsungTV() {
		System.out.println("SamsungTV 생성자");
	}
	
	
	public SamsungTV(Spearker spearker) {
		this.spearker = spearker;
		System.out.println("SamsungTV(Spearker spearker) 생성자");
	}
	
	public SamsungTV(Spearker spearker, int price) {
		this.price = price;
		this.spearker = spearker;
		System.out.println("SamsungTV(Spearker spearker) 생성자" + price);
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
		spearker.volumeUp();
//		System.out.println("SamsungTV volumeDown");	
		
	}

}
