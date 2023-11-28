package com.ezen.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*CREATE TABLE board (
		  boardid           int not null auto_increment,
		  btitle            varchar(500),
		  bcontent          varchar(4000),
		  createdate        date,
		  readcnt           int,
		  memberid          varchar(50),
		  
		  constraint board_pk primary key(boardid),
		  constraint board_memberid_fk FOREIGN KEY(memberid)REFERENCES member(memberid)ON DELETE set null
		  
		);*/

@Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardVO {

	public int boardid;
	public String btitle;
	public String bcontent;
	public String createdate;
	public int readcnt;
	public String memberid;
}
