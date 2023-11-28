package com.ezen.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*CREATE TABLE queryanswer (
		  queryid           int not null auto_increment,
		  memberid          varchar(50),
		  querydate         date,
		  categoryid        varchar(3),
		  title             varchar(500),
		  content           varchar(4000),
		  replyqueryid      int,
		  replylev          int,
		  replyseq          int,
		  
		  constraint queryanswer_pk primary key(queryid),
		  constraint queryanswer_categoryid_fk FOREIGN KEY(categoryid)REFERENCES querycat(categoryid) ON DELETE set null,
		  constraint queryanswer_memberid_fk FOREIGN KEY(memberid)REFERENCES member(memberid)ON DELETE set null,
		  constraint queryanswer_replyid_fk FOREIGN KEY(replyqueryid)REFERENCES queryanswer(queryid)ON DELETE set null
		);*/

@Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QueryAnswerVO {

	public int queryid;
	public String memberid;
	public String querydate;
	public String categoryid;
	public String title;
	public String content;
	public int replyqueryid;
	public int replylev;
	public int replyseq;
}
