package com.hasith.todoapp.service;

import com.hasith.todoapp.dao.TodoDao;
import com.hasith.todoapp.model.Todo;

import java.util.List;

public interface TodoService {
    public List<Todo> getAllTodos();
    public Todo getSingleTodo(Integer id);
    public void deleteTodo(Integer id);
    public Todo addTodo(TodoDao todoDao);
}
