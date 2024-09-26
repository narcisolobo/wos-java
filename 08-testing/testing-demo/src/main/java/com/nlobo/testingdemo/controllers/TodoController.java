package com.nlobo.testingdemo.controllers;

import com.nlobo.testingdemo.models.Todo;
import com.nlobo.testingdemo.services.TodoService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TodoController {
    private final TodoService todoService;
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/")
    public String index() {
        return "redirect:/todos";
    }

    @GetMapping("/todos")
    public String todos(@ModelAttribute("todo")Todo todo, Model model) {
        List<Todo> allTodos = this.todoService.getTodos();
        model.addAttribute("allTodos", allTodos);
        return "all-todos.jsp";
    }

    @PostMapping("/todos/create")
    public String createTodo(@Valid @ModelAttribute("todo") Todo todo, BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<Todo> allTodos = this.todoService.getTodos();
            model.addAttribute("allTodos", allTodos);
            return "all-todos.jsp";
        }

        this.todoService.createTodo(todo);
        return "redirect:/todos";
    }

    @PostMapping("/todos/{id}/toggle")
    public String toggleTodo(@PathVariable("id") Long id, @RequestParam("isComplete") boolean isComplete) {
        this.todoService.toggleTodo(id, isComplete);
        return "redirect:/todos";
    }

    @PostMapping("/todos/{id}/delete")
    public String deleteTodo(@PathVariable("id") Long id) {
        this.todoService.deleteTodo(id);
        return "redirect:/todos";
    }
}
