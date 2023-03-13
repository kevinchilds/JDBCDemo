package com.revature.console;

import java.util.Scanner;

import com.revature.models.Todo;
import com.revature.services.TodoService;

public class ConsoleMenu {
    private TodoService todoService = new TodoService();
    

    public void init(){
        ConsoleInput ci = new ConsoleInput(new Scanner(System.in));
        boolean running = true;

        while(running){
            this.welcomeMenu();
            int option = ci.getMenuOption();

            switch(option){
                case 1: 
                    todoService.getAllTodos();
                    break;
                case 2: 
                    Todo credentials = ci.createTodoInputs();
                    if(credentials != null)
                        todoService.createTodo(credentials);
                    
                    break;
                case 3: 
                    Todo updatedCreds = ci.updateTodoInputs();
                    if(updatedCreds != null)
                        todoService.updateTodo(updatedCreds);
                    break;
                case 4:
                    int todoId = ci.deleteTodoInputs();
                    if(todoId != -1) 
                        todoService.deleteTodo(todoId);
                    break;
                case 0:
                    running = false; 
                    break;
            }

        }

    }

    private void welcomeMenu(){
        System.out.println( "Welcome!\n" +
                            "1) Display Todos\n" + 
                            "2) Create Todo\n" + 
                            "3) Update Todo\n" + 
                            "4) Delete Todo\n" +
                            "0) EXIT"
                          );
    }
}
