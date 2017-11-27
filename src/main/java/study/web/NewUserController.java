package study.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NewUserController {
	
	@GetMapping
	public String create() {
		return "newUser";
	}
}
