package com.hasith.todoapp.controllers;

import com.hasith.todoapp.model.Todo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/todos")
public class TodoController {
    @GetMapping("/get")
    public Todo getTodo() {
        return new Todo(1 ,"Complete todo app Project", "Hasith Malsha" , LocalDate.now(), false);
    }


}
