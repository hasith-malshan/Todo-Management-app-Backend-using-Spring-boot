package com.hasith.todoapp.repository;

import com.hasith.todoapp.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo,Integer> {
    public List<Todo> findByUsername(String username);
}
