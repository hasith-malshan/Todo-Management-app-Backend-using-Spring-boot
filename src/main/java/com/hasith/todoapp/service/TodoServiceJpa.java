package com.hasith.todoapp.service;

import com.hasith.todoapp.dao.TodoDao;
import com.hasith.todoapp.model.Todo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service("jpaService")
public class TodoServiceJpa implements TodoService{
    private List<Todo> todoList = new ArrayList<>();
    private Integer todoCount = 0;

    {
    todoList.add(new Todo(++todoCount,"Complete AWS" , "Hasith Malshan" , LocalDate.now().plusYears(1), false));
    todoList.add(new Todo(++todoCount,"Complete MicroServices" , "Hasith Malshan" , LocalDate.now().plusYears(1).plusMonths(6), false));
    todoList.add(new Todo(++todoCount,"Complete Angular" , "Hasith Malshan" , LocalDate.now().plusMonths(6), false));
    }

    public List<Todo> getAllTodos(String username){
        return findTodosOfUser(username);
    }

    private List<Todo> findTodosOfUser(String username){
        return todoList.stream().filter(todo -> todo.getUsername().equals(username)).toList();
    }

    @Override
    public Todo getSingleTodo(Integer id,String username) {
        return searchSingleTodo(id,username);
    }
    private Todo searchSingleTodo(Integer id,String username){
       return todoList.stream().filter(todo -> todo.getId().equals(id) && todo.getUsername().equals(username)).findFirst().get();
    }

    @Override
    public void deleteTodo(Integer id, String username) {
        todoList.remove(searchSingleTodo(id,username));
    }

    @Override
    public Todo addTodo(TodoDao todoDao,String username) {
        Todo newTodo = new Todo(++todoCount,todoDao.getDescription(),username,todoDao.getTargetDate(),false);
        todoList.add(newTodo);
        return newTodo;
    }

    @Override
    public void updateTodo(Todo todo,String username) {
       Todo todoToUpdate = searchSingleTodo(todo.getId(),username);
       todoList.remove(todoToUpdate);
       todoList.add(todo);
    }
}
