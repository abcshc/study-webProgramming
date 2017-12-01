package study.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import study.model.QuestionRepository;

@Controller
@RequestMapping("")
public class HomeController {
	
	@Autowired
	QuestionRepository questionRepository;

	@RequestMapping("")
	public String hello(Model model) {
		model.addAttribute("questions", questionRepository.findAll());
		return "step3/index";
	}
}