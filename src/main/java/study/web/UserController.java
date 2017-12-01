package study.web;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import study.web.model.User;
import study.web.model.UsersRepository;

@Controller
@RequestMapping("/user")
public class UserController {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UsersRepository usersRepository;

	@RequestMapping("loginForm")
	public String loginForm() {
		return "step3/user/login";
	}

	@PostMapping("login")
	public String login(String userId, String password, HttpSession session) {
		User user = usersRepository.findByUserId(userId);
		if (user == null) {
			log.debug("Login Fail (invalid userId)");
			return "redirect:/user/loginForm";
		}

		if (!password.equals(user.getPassword())) {
			log.debug("Login Fail (invalid password)");
			return "redirect:/user/loginForm";
		}
		log.debug("Login Success");
		session.setAttribute("sessionedUser", user);
		return "redirect:/";
	}

	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.removeAttribute("sessionedUser");
		log.debug("Logout Success");
		return "redirect:/";
	}

	@RequestMapping("signup")
	public String newUser() {
		return "step3/user/form";
	}

	@PostMapping("signup")
	public String signUp(User user) {
		usersRepository.save(user);
		return "redirect:/user/list";
	}

	@RequestMapping("list")
	public String showList(Model model) {
		model.addAttribute("users", usersRepository.findAll());
		return "step3/user/list";
	}

	@RequestMapping("{id}/edit")
	public String edit(@PathVariable Long id, Model model) {
		model.addAttribute("user", usersRepository.findOne(id));
		return "step3/user/edit";
	}

	@PostMapping("{id}/update")
	public String update(@PathVariable Long id, User updateUser) {
		User user = usersRepository.findOne(id);
		user.update(updateUser);
		usersRepository.save(user);
		return "redirect:/user/list";
	}
}