package com.HRmanagement.HRmanagement.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.HRmanagement.HRmanagement.entities.Token;

@Repository
public interface TokenRepo extends JpaRepository<Token, Long> {

	@Query("""
			select t from Token t inner join Employee e on t.emp.id = e.id
			where e.id = :user_id and (t.expired =false or t.revoked = false)
			""")
	List<Token> getAllvalidtokensByUser(Long user_id);

	Optional<Token> findByToken(String token);

}
