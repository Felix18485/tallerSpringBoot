package es.bootcamp.springboot;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	//@Query("Select u From User u Where u.id = ?1")
	public User findUserById(Long id);

	List<User> findAll();
	
	public User save(User user);
	
	
	public void deleteById(long id);
	
}
