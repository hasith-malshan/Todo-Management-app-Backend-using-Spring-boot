package com.hasith.todoapp.service;

import com.hasith.todoapp.model.Todo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service("staticService")
public class TodoServiceStatic {
    private List<Todo> todoList = new ArrayList<>();

    {
    todoList.add(new Todo(1,"Complete AWS" , "Hasith Malshan" , LocalDate.now().plusYears(1), false));
    todoList.add(new Todo(2,"Complete MicroServices" , "Hasith Malshan" , LocalDate.now().plusYears(1).plusMonths(6), false));
    todoList.add(new Todo(3,"Complete Angular" , "Hasith Malshan" , LocalDate.now().plusMonths(6), false));
    }

    public List<Todo> getAllTodos(){
        return todoList;
    }
}
