package com.ezen.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*CREATE TABLE subscrlist (
		  subscrlistid      VARCHAR(36) DEFAULT (UUID()),
		  subscrid          varchar(36),
		  memberid          varchar(50),
		  selldate          date,
		  subscrstartdate   date,
		  subscrenddate     date,
		        
		  constraint subscrlist_pk primary key(subscrlistid),
		  constraint subscrlist_subscrid_fk FOREIGN KEY(subscrid)REFERENCES subscr(subscrid)ON DELETE set null,
		  constraint subscrlist_memberid_fk FOREIGN KEY(memberid)REFERENCES member(memberid)ON DELETE set null
		);*/

@Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubscribListVO {

	private String subscrlistid;
	private String subscrid;
	private String memberid;
	private String selldate;
	private String subscrstartdate;
	private String subscrenddate;
}
