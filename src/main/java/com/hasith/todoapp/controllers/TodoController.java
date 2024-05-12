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
@RequestMapping("/users/{username}/todos")
@CrossOrigin("http://localhost:5173")
public class TodoController {

    private TodoService todoService;

    @Autowired
    public TodoController(@Qualifier("jpaService") TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/get")
    public Todo getTodo() {
        return new Todo(1, "Complete todo app Project", "Hasith Malsha", LocalDate.now(), false);
    }

    @GetMapping("/get/all")
    public List<Todo> getAllTodos(@PathVariable String username) {
        return todoService.getAllTodos(username);
    }
    @GetMapping("/get/{id}")
    public Todo getSingleTodo(@PathVariable("id") Integer id,@PathVariable String username) {
        return todoService.getSingleTodo(id,username);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletetodo(@PathVariable("id") Integer id, @PathVariable String username){
        todoService.deleteTodo(id,username);
        return ResponseEntity.ok("Todo Deleted");
    }

    @PostMapping
    public ResponseEntity<Todo> addTodo(@RequestBody TodoDao todoDao,@PathVariable String username){
        Todo todo = todoService.addTodo(todoDao,username);
        return ResponseEntity.status(HttpStatus.CREATED).body(todo);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateTodo(@RequestBody Todo todo){
        System.out.println(todo.getId());
        todoService.updateTodo(todo,todo.getUsername());
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}
