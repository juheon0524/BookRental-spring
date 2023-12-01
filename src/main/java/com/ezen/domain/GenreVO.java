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

	private String genrecode;
	private String genredesc;
	private String genredetail;
}
