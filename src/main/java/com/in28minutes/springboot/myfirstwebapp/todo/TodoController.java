package com.in28minutes.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoController {

	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}

	private TodoService todoService;

	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {
		List<Todo> todos = todoService.findByUsername("in28minutes");
		model.addAttribute("todos", todos);

		return "listTodos";
	}

	// GET
	@RequestMapping(value = "add-todo", method = RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {
		String username = (String)model.get("name");
		Todo todo = new Todo(0, username, "", 
			LocalDate.now().plusYears(1), false );
		model.put("todo", todo);
		return "todo";
	}

	// POST
	@RequestMapping(value = "add-todo", method = RequestMethod.POST)
	public String addNewTodo(ModelMap model, 
			@Valid Todo todo, BindingResult result) {
		
		if(result.hasErrors()) {
			model.addAttribute("message", "10String up plese");
			return "todo";
		}
		
		String username = (String) model.get("name");
		todoService.addTodo(username, todo.getDescription(), 
			LocalDate.now().plusYears(1), false);
		return "redirect:list-todos";
	}
	
	

}
