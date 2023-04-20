package es.bootcamp.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Service
public class MessageServiceImpl implements MessageService{

	@Value("${course.message:${course.defaultmessage}}")
	private String message;
	
	@Override
	public String getMessage() {
		return message;
	}
}
