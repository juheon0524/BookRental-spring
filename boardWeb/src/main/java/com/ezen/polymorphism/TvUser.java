package com.ezen.polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TvUser {
	public static void main(String[] args) {
		
		//1. 스프링 컨테이너 구동 
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		//2. 스프링 컨테이너 필요한 빈을 요청.
		TV tv1 = (TV) factory.getBean("tv1");
		TV tv2 = (TV)factory.getBean("tv2");
//		TV tv = factory.getBean("tv2", LgTV.class);
		
//		System.out.println(tv1);
//		System.out.println(tv2);
//		tv.poweron();
//		tv1.volumeUp(); 
		tv1.volumeDown();
		
		
//		lazy-init="true" 는 객체를 생성하지 않고, 필요한 시점에 생성함.
//		scope="prototype" 원래 싱글톤 패턴이었던 객체를 여러개 생성시킴.
		factory.close();
	}
	
	
}
