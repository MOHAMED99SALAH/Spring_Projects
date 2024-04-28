package com.AuthorsDB.AuthorsDB.repository;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.AuthorsDB.AuthorsDB.documents.Author;
import com.mongodb.client.result.UpdateResult;

@Component
public class customRepoIMPL implements customRepo {

	
	
	@Autowired
	MongoTemplate mongoTemplete;
	
	
	@Override
	public void updateEmail(String email, String name, String phone) {
		// TODO Auto-generated method stub
		
		
		Query query = new Query(Criteria.where("email").is(email));
        Update update = new Update();
        update.set("name", name);
        update.set("phone", phone);
        
        UpdateResult result = mongoTemplete.updateFirst(query, update, Author.class);
        
        if(result == null)
            System.out.println("No documents updated");
        else
            System.out.println(result.getModifiedCount() + " document(s) updated..");

	
		
	}

	
}
