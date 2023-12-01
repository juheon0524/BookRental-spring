package com.ezen.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*CREATE TABLE bookdonation (
		  donateid          varchar(36) DEFAULT (UUID()),
		  isbn              varchar(13),
		  memberid          varchar(50), 
		  donatedate        date,
		  donatebookcnt		int,
		  procdate			date,                    관리자가 처리한 일자 
		  subscrlistid      varchar(36),			 관리자가 지급한 구독권리스트 
		  adminmemberid     varchar(50),             기부도서에 대한 구독권 지급자 id 
		  
		  constraint bookdonation_pk primary key(donateid),
		  constraint bookdonation_isbn_fk FOREIGN KEY(isbn)REFERENCES book(isbn)ON DELETE cascade,
		  constraint bookdonation_memberid_fk FOREIGN KEY(memberid)REFERENCES member(memberid)ON DELETE cascade,
		  constraint bookdonation_adminmemberid_fk FOREIGN KEY(adminmemberid)REFERENCES member(memberid)ON DELETE cascade,
		  constraint bookdonation_subscrlistid FOREIGN KEY(subscrlistid)REFERENCES subscrlist(subscrlistid)ON DELETE cascade
		);*/


@Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDonationVO {

	private String donateid;
	private String isbn;
	private String memberid;
	private String donatedate;
	private int donatebookcnt;
	private String procdate;
	private String subscrlistid;
	private String adminmemberid;
}
