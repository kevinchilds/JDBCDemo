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

        for(Todo todo : todos){
            System.out.println(todo);
        }
    }

    public Todo createTodo(Todo credentials) {
        return this.todoRepository.createOne(credentials);
    }

    public Todo updateTodo(Todo updatedCreds) {
        //check Id exists
        Todo todoFromDb = this.todoRepository.selectOne(updatedCreds.getTodoId());
        
        if(todoFromDb == null){
            System.out.println("Todo with id " + updatedCreds.getTodoId() + " does not exist in system");
            return null;
        }

        return this.todoRepository.updateOne(updatedCreds);
    }

    public void deleteTodo(int todoId) {
        System.out.println("deleted todo with id " + todoId + " if exists");
        this.todoRepository.deleteOne(todoId);
    }
    
}
