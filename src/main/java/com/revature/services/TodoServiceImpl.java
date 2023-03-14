package com.revature.services;

import java.util.List;

import com.revature.daos.TodoDAO;
import com.revature.daos.TodoDAOJavaImpl;
import com.revature.models.Todo;

public class TodoServiceImpl implements TodoService{
    private TodoDAO todoDAO; 

    public TodoServiceImpl(){
        this.todoDAO = new TodoDAOJavaImpl();
    }

    public TodoServiceImpl(TodoDAO todoDAO) {
        this.todoDAO = todoDAO;
    }

    public void getAllTodos() {
        List<Todo> todos = this.todoDAO.selectAll();
        System.out.println("\nDisplaying All Todos...");
        for(Todo todo : todos){
            System.out.println(todo);
        }
    }

    public Todo createTodo(Todo credentials) {
        return this.todoDAO.createOne(credentials);
    }

    public Todo updateTodo(int todoId) {
        //check Id exists
        Todo todoFromDb = this.todoDAO.selectOne(todoId);
        
        if(todoFromDb == null){
            return null;
        }

        return this.todoDAO.updateOne(todoId);
    }

    public void deleteTodo(int todoId) {
        System.out.println("Deleted todo with id " + todoId + " if exists");
        this.todoDAO.deleteOne(todoId);
    }
    
}
