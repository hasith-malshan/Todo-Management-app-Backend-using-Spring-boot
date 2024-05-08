package com.hasith.todoapp.dao;

import lombok.Data;

import java.beans.ConstructorProperties;
import java.time.LocalDate;

@Data
public class TodoDao {
    private String description;
    private String username;
    private LocalDate targetDate;
}
