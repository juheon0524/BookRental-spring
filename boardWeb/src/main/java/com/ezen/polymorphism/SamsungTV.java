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
		System.out.println("SamsungTV ������");
	}
	
	
	public SamsungTV(Spearker spearker) {
		this.spearker = spearker;
		System.out.println("SamsungTV(Spearker spearker) ������");
	}
	
	public SamsungTV(Spearker spearker, int price) {
		this.price = price;
		this.spearker = spearker;
		System.out.println("SamsungTV(Spearker spearker) ������" + price);
	}
	
	public void initMethod() {
		System.out.println("������ initMethod ==> �ʱ�ȭ ���� ����");
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