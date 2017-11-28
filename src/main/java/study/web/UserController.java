package study.web;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.User;

@Controller
public class UserController {
	private ArrayList<User> users = new ArrayList<User>();

	@RequestMapping(value="/SignUp", method= {RequestMethod.GET, RequestMethod.POST})
	public String signUp(User user) {
		System.out.println("user : " + user);
		users.add(user);
		return "redirect:/UserList";
	}
	
	@GetMapping("/UserList")
	public String showList(Model model) {
		model.addAttribute("users", users);
		return "userList";
	}
}
