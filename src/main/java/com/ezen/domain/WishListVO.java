package com.ezen.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*CREATE TABLE wishlist (
		  wishlistid        VARCHAR(36) DEFAULT (UUID()),
		  isbn              varchar(13),
		  memberid          varchar(50),
		  createdate        date,
		    
		  constraint wishlist_pk primary key(wishlistid),
		  constraint wishlist_isbn_fk FOREIGN KEY(isbn)REFERENCES book(isbn)ON DELETE cascade,
		  constraint wishlist_memberid_fk FOREIGN KEY(memberid)REFERENCES member(memberid)ON DELETE cascade
		);*/

@Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WishListVO {

	private String wishlistid;
	private String isbn;
	private String memberid;
	private String createdate;
}
