package com.revature.services;

import java.util.List;

import com.revature.models.Todo;
import com.revature.repositories.TodoRepository;

public class TodoService {
    private TodoRepository todoRepository; 

    public TodoService(){
        this.todoRepository = new TodoRepository();
    }

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public void getAllTodos() {
        List<Todo> todos = this.todoRepository.selectAll();
        System.out.println("\nDisplaying All Todos...");
        for(Todo todo : todos){
            System.out.println(todo);
        }
    }

    public Todo createTodo(Todo credentials) {
        return this.todoRepository.createOne(credentials);
    }

    public Todo updateTodo(int todoId) {
        //check Id exists
        Todo todoFromDb = this.todoRepository.selectOne(todoId);
        
        if(todoFromDb == null){
            return null;
        }

        return this.todoRepository.updateOne(todoId);
    }

    public void deleteTodo(int todoId) {
        System.out.println("Deleted todo with id " + todoId + " if exists");
        this.todoRepository.deleteOne(todoId);
    }
    
}
