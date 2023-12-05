package com.ezen.polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TvUser {
	public static void main(String[] args) {
		
		//1. ������ �����̳� ���� 
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		//2. ������ �����̳� �ʿ��� ���� ��û.
		TV tv1 = (TV) factory.getBean("tv1");
		TV tv2 = (TV)factory.getBean("tv2");
//		TV tv = factory.getBean("tv2", LgTV.class);
		
//		System.out.println(tv1);
//		System.out.println(tv2);
//		tv.poweron();
//		tv1.volumeUp(); 
		tv1.volumeDown();
		
		
//		lazy-init="true" �� ��ü�� �������� �ʰ�, �ʿ��� ������ ������.
//		scope="prototype" ���� �̱��� �����̾��� ��ü�� ������ ������Ŵ.
		factory.close();
	}
	
	
}