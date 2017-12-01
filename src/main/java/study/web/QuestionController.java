package study.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import study.model.QuestionRepository;

@Controller
@RequestMapping("/qna")
public class QuestionController {
	
	@Autowired
	private QuestionRepository questionRepository;

	@RequestMapping("form")
	public String questionForm() {
		return "step3/question/form";
	}
	
	@RequestMapping("{id}/contents")
	public String contents(@PathVariable Long id, Model model) {
		model.addAttribute("question", questionRepository.findOne(id));
		return "step3/question/show";
	}
	
	@RequestMapping("{id}/edit")
	public String edit(@PathVariable Long id, Model model) {
		model.addAttribute("question", questionRepository.findOne(id));
		return "step3/question/edit";
	}
}
