package com.AuthorsDB.AuthorsDB.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AuthorsDB.AuthorsDB.documents.Author;
import com.AuthorsDB.AuthorsDB.repository.AuthorRepo;
import com.AuthorsDB.AuthorsDB.repository.customRepo;


@Service
public class AuthorService {

	@Autowired
	private AuthorRepo authorRepo;
	
	@Autowired
	private customRepo customAuthorRepo;
	
	public Author findById(String id) {
	
		return authorRepo.findById(id).get();
	}

	public List<Author> findAll() {

		return authorRepo.findAll();
	}

	public Author insert(Author entity) {

		if (entity.getId() != null) {

			throw new RuntimeException();
		}

		return authorRepo.insert(entity);
	}

	public List<Author> insertAll(List<Author> entity) {

		return authorRepo.saveAll(entity);
	}

	public Author update(Author entity) {
		
		Author author = findById(entity.getId());
		author.setName(entity.getName());
		author.setEmail(entity.getEmail());
		author.setPhone(entity.getPhone());
		
		return authorRepo.save(author);
	}
	
	public void updateEmail(String email, String name , String phone) {
		
		customAuthorRepo.updateEmail(email, name, phone);
	}
	
	public Author findAuthorByEmail (String email) {
		
		return authorRepo.findAuthorByEmail(email);
	}

	public void deleteById(String id) {

		authorRepo.deleteById(id);;
	}
	
	
	
	
	
}
