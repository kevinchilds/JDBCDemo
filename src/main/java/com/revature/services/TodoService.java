package com.revature.services;

import com.revature.models.Todo;

public interface TodoService {
    void getAllTodos();
    Todo createTodo(Todo credentials);
    Todo updateTodo(int todoId);
    void deleteTodo(int todoId);
}
