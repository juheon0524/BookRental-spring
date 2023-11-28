package com.ezen.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*CREATE TABLE genre (
		  genrecode         varchar(3),
		  genredesc         varchar(50),
		  genredetail       varchar(200),
		  
		  constraint genre_pk primary key(genrecode)
		);*/

@Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GenreVO {

	public String genrecode;
	public String genredesc;
	public String genredetail;
}
