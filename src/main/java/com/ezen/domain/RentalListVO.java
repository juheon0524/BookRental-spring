package com.ezen.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*CREATE TABLE rentallist (
		  rentallistid      VARCHAR(36) DEFAULT (UUID()),
		  rentdate          date,
		  plannedreturndate date,
		  isbn              varchar(13),
		  memberid          varchar(50),
		  subscrlistid      varchar(36),
		  actualreturndate  date,
		  deliverydate      date,
		  deliveryinvno     varchar(30),
		  
		  constraint rentallist_pk primary key(rentallistid),
		  constraint rentallist_isbn_fk FOREIGN KEY(isbn)REFERENCES book(isbn) ON DELETE set null,
		  constraint rentallist_memberid_fk FOREIGN KEY(memberid)REFERENCES member(memberid)ON DELETE set null,
		  constraint rentallist_subscrlistid_fk FOREIGN KEY(subscrlistid)REFERENCES subscrlist(subscrlistid)ON DELETE set null
		  
		);*/

@Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RentalListVO {

	private String rentallistid;
	private String rentdate;
	private String plannedreturndate;
	private String isbn;
	private String memberid;
	private String subscrlistid;
	private String actualreturndate;
	private String deliverydate;
	private String deliveryinvno;
}
