package es.bootcamp.springboot;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/")
public class UserRestController {
	
	@Autowired
	UserService userService;
	
	@GetMapping(value = "users")
	public ResponseEntity<List<User>> getAllUsers(){
		
		List<User> lista = new ArrayList<User>();
		lista = userService.getAllUsers();
		return new ResponseEntity<>(lista, HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") long id){
		Optional<User> user = Optional.of(userService.getUserById(id));
		return new ResponseEntity<User>(user.get(), HttpStatus.OK);
	}
	
	@PostMapping(value = "/users/create")
	public ResponseEntity<String> createUser(@RequestBody User user){
		return ResponseEntity.status(HttpStatus.OK).body(userService.createUser(user));
	}
	
	@PutMapping(value = "/users/update")
	public ResponseEntity<String> updateUser(@RequestBody User user){
		return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(user));
	}
	
	
	@DeleteMapping(value = "users/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id")long id){
		return ResponseEntity.status(HttpStatus.OK).body(userService.deleteUserById(id));
	}
	
	
	
	
	
}
