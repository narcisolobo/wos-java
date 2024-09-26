package com.nlobo.testingdemo.services;

import com.nlobo.testingdemo.models.Todo;
import com.nlobo.testingdemo.repositories.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TodoService {
    private final TodoRepository todoRepository;
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public void createTodo(Todo todo) {
        this.todoRepository.save(todo);
    }

    public List<Todo> getTodos() {
        return (List<Todo>) this.todoRepository.findAll();
    }

    public Todo getTodoById(Long id) {
        return this.todoRepository.findById(id).orElse(null);
    }

    public void toggleTodo(Long id, boolean isComplete) {
        Todo todoToUpdate = this.todoRepository.findById(id).orElse(new Todo());
        todoToUpdate.setIsComplete(isComplete);
        todoToUpdate.setUpdatedAt(new Date());
        this.todoRepository.save(todoToUpdate);
    }

    public void deleteTodo(Long id) {
        this.todoRepository.deleteById(id);
    }
}
