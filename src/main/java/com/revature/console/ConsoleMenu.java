package com.revature.console;

import java.util.Scanner;

import com.revature.models.Todo;
import com.revature.services.TodoService;

public class ConsoleMenu {
    private TodoService todoService = new TodoService();
    

    public void init(){
        ConsoleInput consoleInput = new ConsoleInput(new Scanner(System.in));
        boolean running = true;

        while(running){
            todoService.getAllTodos();
            this.welcomeMenu();
            int option = consoleInput.retrieveNum("Option: ");

            switch(option){
                case 1: 
                    String taskName = consoleInput.retrieveString("Task Name: ");
                    Todo newTodo = todoService.createTodo(new Todo(taskName));
                    System.out.println("New Todo Created: " + newTodo);
                    break;
                case 2: 
                    int updateTodoId = consoleInput.retrieveNum("Todo Id To Update: ");
                    Todo updatedTodo = todoService.updateTodo(updateTodoId);
                    if(updatedTodo != null) System.out.println("Todo with id " + updateTodoId + " marked as complete");
                    else System.out.println("Todo with id " + updateTodoId + " does not exist in system");
                    break;
                case 3: 
                    int deletedTodoId = consoleInput.retrieveNum("Todo Id To Delete: ");
                    todoService.deleteTodo(deletedTodoId);
                    break;
                case 0:
                    running = false; 
                    break;
            }

        }

    }

    private void welcomeMenu(){
        System.out.println( "\n\n" +
                            "1) Create Todo\n" + 
                            "2) Mark Todo Complete\n" + 
                            "3) Delete Todo\n" +
                            "0) EXIT"
                          );
    }
}
