package lk.harshana.app.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import lk.harshana.app.model.User;

public interface UserRepository extends CrudRepository<User, Integer>{

	@Query("SELECT u FROM User u WHERE username=:username AND active=1")
	public User getActiveUser(@Param("username") String username); 
	
}
