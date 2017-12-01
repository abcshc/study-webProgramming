package study.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import study.web.model.QuestionRepository;

@Controller
@RequestMapping("/qna")
public class QuestionController {
	
	@Autowired
	private QuestionRepository questionRepository;

	@RequestMapping("form")
	public String questionForm() {
		return "step3/question/form";
	}
}
