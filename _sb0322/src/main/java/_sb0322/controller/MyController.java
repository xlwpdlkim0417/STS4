package _sb0322.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import _sb0322.dto.Member2;
import _sb0322.service.DeleteService;
import _sb0322.service.InsertService;
import _sb0322.service.ListService;
import _sb0322.service.SelectById;
import _sb0322.service.UpdateService;

@Controller
public class MyController {

	@Autowired
	public ListService listService;

	@Autowired
	public InsertService insertService;

	@Autowired
	public UpdateService updateService;

	@Autowired
	public DeleteService deleteService;

	@Autowired
	public SelectById selectById;

	@GetMapping("/")
	public String root(Model model) {
		model.addAttribute("members", listService.selectAll());
		return "root";
	}

	@PostMapping("/insert")
	public String insert(Model model, Member2 member) {
		insertService.insertService(member);
		return "redirect:/";
	}

	@PostMapping("/updateForm")
	public String updateForm(Model model, int id) {
		model.addAttribute("member", selectById.selectById(id));
		model.addAttribute("members", listService.selectAll());
		return "updateForm";
	}

	@PostMapping("/update")
	public String update(Model model, Member2 member) {
		updateService.updateService(member);
		return "redirect:/";
	}

	@PostMapping("/delete")
	public String delete(Model model, Member2 member) {
		deleteService.deleteService(member);
		return "redirect:/";
	}

}
