package com.hasith.todoapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Todo {
    private Integer id;
    private String description;
    private String username;
    private LocalDate targetDate;
    private Boolean isDone;
}
