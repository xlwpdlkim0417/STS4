package _sb0322_01.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import _sb0322_01.dto.Dept;
import _sb0322_01.dto.Emp;
import _sb0322_01.dto.State;
import _sb0322_01.service.CrudService;
import _sb0322_01.service.ListService;

@Controller
public class MyController {

	@Autowired
	ListService listService;

	@Autowired
	CrudService crudService;

	@Autowired
	State state;

	@GetMapping("/")
	public String root(Model model) {
		model.addAttribute("list", listService.selectAll());
		return "root";
	}

	@GetMapping("/selectEmp")
	public String selectEmp(Model model, int deptno) {
		model.addAttribute("list", listService.selectAll());
		model.addAttribute("list2", listService.selectAllByDeptNo(deptno));
		state.setDeptno(deptno);
		return "selectEmp";
	}

	@GetMapping("/updateForm")
	public String updateForm(Model model, int empno) {
		model.addAttribute("list", listService.selectAll());
		model.addAttribute("list2", listService.selectAllByDeptNo(state.getDeptno()));
		model.addAttribute("empp", listService.selectByEmpno(empno));
		return "updateForm";
	}

	@GetMapping("/input")
	public String input(Model model, Emp emp) {
		crudService.updateService(emp);
		System.out.println(emp);
		model.addAttribute("list", listService.selectAll());
		model.addAttribute("list2", listService.selectAllByDeptNo(state.getDeptno()));
		state.setDeptno(state.getDeptno());
		return "redirect:/";
	}
	
	@GetMapping("/insert")
	public String insert(Model model, Emp emp) {
		crudService.insertService(emp);
		return "redirect:/";
	}
}
