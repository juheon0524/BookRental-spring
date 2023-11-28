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

	public String isbn;
	public String title;
	public String genrecode;
	public String genrecrawled;
	public String author;
	public String publisher;
	public String publisheddate;
	public int totbookcnt;
	public int rentedbookcnt;
	public int curbookcnt;
	public int price;
	public int cumrentalcnt;
	public String registereddate;
	public String memberid;
	public String bookimgurl;
	public String bookcontent;
}
