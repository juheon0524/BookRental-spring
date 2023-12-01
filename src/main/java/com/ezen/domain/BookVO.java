package com.ezen.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*CREATE TABLE book (
		  isbn              varchar(13),
		  title             varchar(200),
		  genrecode         varchar(3),
		  genrecrawled		varchar(200),
		  author            varchar(100),
		  publisher         varchar(100),
		  publisheddate     date,
		  totbookcnt        int,
		  rentedbookcnt     int,
		  curbookcnt        int,   totbookcnt = rentedbookcnt + curbookcnt 
		  price             int,   도서정가, 도서정보조회용 
		  cumrentalcnt      int,   누적 대여 횟수 
		  registereddate    date,        관리자가 등록한 날짜 
		  memberid          varchar(50),   등록한 관리자 아이디, FK refers member tab 
		  bookimgurl        varchar(500),
		  bookcontent       varchar(4000),
		  
		  constraint isbn_pk primary key(isbn)
		);*/


@Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookVO {

	private String isbn;
	private String title;
	private String genrecode;
	private String genrecrawled;
	private String author;
	private String publisher;
	private String publisheddate;
	private int totbookcnt;
	private int rentedbookcnt;
	private int curbookcnt;
	private int price;
	private int cumrentalcnt;
	private String registereddate;
	private String memberid;
	private String bookimgurl;
	private String bookcontent;
}
