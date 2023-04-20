package es.bootcamp.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userImpl;
	
	
	public User getUserById(long id) {
		return userImpl.findUserById(id);
	}
	
	
	public List<User> getAllUsers() {
		return userImpl.findAll();
	}
	
	public String createUser(User user) {
		return userImpl.save(user).getName();
	}
	
	public String updateUser(User user) {
		User usuarioActualizado = userImpl.findUserById(user.getId());
		usuarioActualizado.setName(user.getName());
		usuarioActualizado.setDateBirth(user.getDateBirth());
		userImpl.save(usuarioActualizado);
		return "Usuario actualizado";
	}
	
	
	@Transactional
	public String deleteUserById(long id) {
		String mensaje;
		
		if(userImpl.findById(id)!= null) {
			mensaje = "Se ha borrado el usuario "+id;
		} else {
			mensaje = "No se ha borrado el usuario "+id;
		}return mensaje;
	}

}
