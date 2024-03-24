package _sb0322.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import _sb0322.service.ListService;

@Controller
public class AjaxController {

	@Autowired
	private ListService listService;

	@GetMapping("/ajax1")
	public String ajax1() {
		return "ajax1";
	}

	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("members", listService.selectAll());
		return "list";
	}
}
