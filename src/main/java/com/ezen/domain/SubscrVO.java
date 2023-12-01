package com.ezen.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*CREATE TABLE subscr (
		  subscrid          VARCHAR(36) DEFAULT (UUID()),
		  subscrname        varchar(100),
		  price             int,
		  salefromdate      date,
		  saletodate        date,
		  subscrperiod      int,      30일, 90일, 180일, 365일 
		  memberid          varchar(50),
		  registereddate    date,
		  allowedbookcnt    int,
		  purpose			varchar(1),   고객 판매용 'S' , 기부자 지급용도 'A' 
		      
		  constraint subscr_pk primary key(subscrid),
		  constraint subscr_memberid_fk FOREIGN KEY(memberid)REFERENCES member(memberid)ON DELETE set null
		);*/

@Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubscrVO {

	private String subscrid;
	private String subscrname;
	private int price;
	private String salefromdate;
	private String saletodate;
	private int subscrperiod;
	private String memberid;
	private String registereddate;
	private int allowedbookcnt;
	private String purpose;
}
