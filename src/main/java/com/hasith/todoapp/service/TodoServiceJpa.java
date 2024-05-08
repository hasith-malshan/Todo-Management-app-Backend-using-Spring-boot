package com.hasith.todoapp.service;

import com.hasith.todoapp.dao.TodoDao;
import com.hasith.todoapp.model.Todo;
import com.hasith.todoapp.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("jpaService")
public class TodoServiceJpa implements TodoService{
    private TodoRepository todoRepository;

    @Autowired
    public TodoServiceJpa(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getAllTodos(String username){
        return todoRepository.findByUsername(username);
    }

    @Override
    public Todo getSingleTodo(Integer id, String username) {
        return todoRepository.findById(id).get();
    }

    @Override
    public void deleteTodo(Integer id, String username) {
        Todo todoToDelete = getSingleTodo(id, username);
        todoRepository.delete(todoToDelete);
    }

    @Override
    public Todo addTodo(TodoDao todoDao,String username) {
        Todo newTodo = new Todo(null,todoDao.getDescription(),username,todoDao.getTargetDate(),false);
       todoRepository.save(newTodo);
        return newTodo;
    }

    @Override
    public void updateTodo(Todo todo,String username) {
       Todo todoToUpdate = todoRepository.findById(todo.getId()).get();
       todoRepository.delete(todoToUpdate);
       todoRepository.save(todo);
    }
}
