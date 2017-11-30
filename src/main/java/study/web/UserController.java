package study.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import study.web.model.User;
import study.web.model.UsersRepository;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UsersRepository usersRepository;

	@GetMapping("signup")
	public String newUser() {
		return "step3/user/form";
	}

	@PostMapping("signup")
	public String signUp(User user) {
		usersRepository.save(user);
		return "redirect:list";
	}

	@RequestMapping("list")
	public String showList(Model model) {
		model.addAttribute("users", usersRepository.findAll());
		return "step3/user/list";
	}
}