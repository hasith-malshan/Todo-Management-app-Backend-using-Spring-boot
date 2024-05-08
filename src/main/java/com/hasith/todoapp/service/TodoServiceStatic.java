package com.hasith.todoapp.service;

import com.hasith.todoapp.dao.TodoDao;
import com.hasith.todoapp.model.Todo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service("staticService")
public class TodoServiceStatic implements TodoService{
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
    public Todo getSingleTodo(Integer id) {
        return searchSingleTodo(id);
    }
    private Todo searchSingleTodo(Integer id){
       return todoList.stream().filter(todo -> todo.getId().equals(id)).findFirst().get();
    }

    @Override
    public void deleteTodo(Integer id) {
        todoList.remove(searchSingleTodo(id));
    }

    @Override
    public Todo addTodo(TodoDao todoDao) {
        Todo newTodo = new Todo(++todoCount,todoDao.getDescription(),todoDao.getUsername(),todoDao.getTargetDate(),false);
        todoList.add(newTodo);
        return newTodo;
    }

    @Override
    public void updateTodo(Todo todo) {
       Todo todoToUpdate = searchSingleTodo(todo.getId());
       todoList.remove(todoToUpdate);
       todoList.add(todo);
    }
}
