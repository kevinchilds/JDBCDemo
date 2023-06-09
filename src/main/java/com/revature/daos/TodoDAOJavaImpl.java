package com.revature.daos;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Todo;

public class TodoDAOJavaImpl implements TodoDAO{
    private static List<Todo> todos = new ArrayList<>();
    private static int serial = 1;

    public List<Todo> selectAll() {
        return todos;
    }

    public Todo createOne(Todo credentials) {
        credentials.setTodoId(serial);
        todos.add(credentials);
        serial++;
        return credentials;
    }

    public Todo selectOne(int todoId) {
        for(Todo todo : todos){
            if(todo.getTodoId() == todoId){
                return todo;
            }
        }
        return null;
    }

    public Todo updateOne(int todoId) {
        for(Todo todo : todos){
            if(todo.getTodoId() == todoId){
                todo.setCompleted(true);
                return todo;
            }
        }

        return null;
    }

    public void deleteOne(int todoId) {
        for(int i = 0; i < todos.size(); i++){
            Todo todo = todos.get(i);
            if(todo.getTodoId() == todoId){
                todos.remove(i);
            }
        }
    }
    
}
