package com.ezen.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*CREATE TABLE member (
		  memberid          varchar(50),
		  membername        varchar(50),
		  postalcode        varchar(6),   
		  postaladdress     varchar(200), 
		  detailaddress     varchar(300), 
		  mphone            varchar(15), 
		  birthdate         date, 		  
		  passcode          varchar(30),
		  joindate          date,
		  memberflag        varchar(2),    00: 사용자, 01: 고객 
		  email             varchar(50),
		  penaltysdate      date, 
		  penaltyedate      date,
		  penaltyrentalid   varchar(36),
		  statuscode        varchar(20),   active, inactive, closed : 회원가입 시 "active", 탈회 시 "closed" 
		  lastlogindate     date,          매 로그인 성공 시, sysdate로 update 
		  
		  constraint memberid_pk primary key(memberid)
		);*/

@Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberVO {

	public String memberid;
	public String membername;
	public String postalcode;
	public String postaladdress;
	public String detailaddress;
	public String mphone;
	public String birthdate;
	public String passcode;
	public String joindate;
	public String memberflag;
	public String email;
	public String penaltysdate;
	public String penaltyedate;
	public String penaltyrentalid;
	public String statuscode;
	public String lastlogindate;
}
