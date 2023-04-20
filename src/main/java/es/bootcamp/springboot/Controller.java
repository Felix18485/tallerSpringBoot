package es.bootcamp.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/")
//@RequestMapping
public class Controller {
	
	@Autowired
	private MessageService service;
	
	//@Value("${course.message:No hay mensaje}")
	@Value("${course.defaultmessage:${course.message}}")
	private String message;
	
//	@Value("${course.perfil}")
//	private String perfil;
//	
//	@GetMapping(value = "message" )
//	public String hola() {
//		return message;
//	}
//	
//	@GetMapping(value = "mensaje")
//	public String adios() {
//		return "Adios mundo";
//	}
//	
//	@GetMapping(value = "perfil")
//	public String perfil() {
//		return perfil;
//	}
//	
//	@GetMapping("/messages")
//	public String mensaje() {
//		return service.getMessage();
//	}

	
}
