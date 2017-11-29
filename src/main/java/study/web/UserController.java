package study.web;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import study.model.User;

@Controller
@RequestMapping("/users")
public class UserController {
	private ArrayList<User> users = new ArrayList<User>();

	@GetMapping("signup")
	public String newUser() {
		return "newUser";
	}

	@PostMapping("signup")
	public String signUp(User user) {
		System.out.println("user : " + user);
		users.add(user);
		return "redirect:/users/list";
	}

	@RequestMapping("list")
	public String showList(Model model) {
		model.addAttribute("users", users);
		return "userList";
	}
}