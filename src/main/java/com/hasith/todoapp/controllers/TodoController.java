package com.hasith.todoapp.controllers;

import com.hasith.todoapp.dao.TodoDao;
import com.hasith.todoapp.model.Todo;
import com.hasith.todoapp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/todos/{username}")
public class TodoController {

    private TodoService todoService;

    @Autowired
    public TodoController(@Qualifier("staticService") TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/get")
    public Todo getTodo() {
        return new Todo(1, "Complete todo app Project", "Hasith Malsha", LocalDate.now(), false);
    }

    @GetMapping("/get/all")
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }
    @GetMapping("/get/{id}")
    public Todo getSingleTodo(@PathVariable("id") Integer id) {
        return todoService.getSingleTodo(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletetodo(@PathVariable("id") Integer id){
        todoService.deleteTodo(id);
        return ResponseEntity.ok("Todo Deleted");
    }

    @PostMapping("/create")
    public ResponseEntity<Todo> addTodo(@RequestBody TodoDao todoDao){
        Todo todo = todoService.addTodo(todoDao);
        return ResponseEntity.status(HttpStatus.CREATED).body(todo);
    }

    @PutMapping("/update")
    public ResponseEntity updateTodo(@RequestBody Todo todo){
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}
