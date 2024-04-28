package com.AuthorsDB.AuthorsDB.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Document(collation = "author")
@Setter
@Getter
@ToString
public class Author {
	
    @Id
	private String id ;
    
    @NotEmpty
	private String name;
	
    @Email
    @Indexed(unique = true)
	private String email;
	
	private String phone;
	
	
}
