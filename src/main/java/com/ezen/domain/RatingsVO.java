package com.ezen.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*CREATE TABLE ratings (
		  ratingsid         varchar(36) DEFAULT (UUID()),
		  isbn              varchar(13),
		  memberid          varchar(50), 
		  writedate         date,
		  content           varchar(1000),
		  score             int,             1 ~ 5 점까지 
		  
		  constraint ratings_pk primary key(ratingsid),
		  constraint ratings_isbn_fk FOREIGN KEY(isbn)REFERENCES book(isbn)ON DELETE cascade,
		  constraint ratings_memberid_fk FOREIGN KEY(memberid)REFERENCES member(memberid)ON DELETE cascade
		);*/

@Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RatingsVO {

	public String ratingsid;
	public String isbn;
	public String memberid;
	public String writedate;
	public String content;
	public int score;
}
