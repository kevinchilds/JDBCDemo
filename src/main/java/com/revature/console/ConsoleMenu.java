package com.revature.console;

import com.revature.models.Todo;
import com.revature.services.TodoService;
import com.revature.services.TodoServiceImpl;

public class ConsoleMenu implements Menu {
    private TodoService todoService;

    public ConsoleMenu(){
        this.todoService = new TodoServiceImpl();
    }

    public ConsoleMenu(TodoService todoService){
        this.todoService = todoService;
    }
    
    @Override
    public void display() {
        Input input = new ConsoleInput();
        boolean running = true;

        while(running){
            todoService.getAllTodos();
            System.out.println( "\n\n1) Create Todo\n2) Mark Todo Complete\n3) Delete Todo\n0) EXIT");
            int option = input.retrieveNum("Option: ");

            switch(option){
                //create todo case
                case 1: 
                    String taskName = input.retrieveString("Task Name: ");
                    Todo newTodo = todoService.createTodo(new Todo(taskName));
                    System.out.println("New Todo Created: " + newTodo);
                    break;
                //mark complete case
                case 2: 
                    int updateTodoId = input.retrieveNum("Todo Id To Update: ");
                    Todo updatedTodo = todoService.updateTodo(updateTodoId);
                    if(updatedTodo != null) System.out.println("Todo with id " + updateTodoId + " marked as complete");
                    else System.out.println("Todo with id " + updateTodoId + " does not exist in system");
                    break;
                //delte todo case
                case 3: 
                    int deletedTodoId = input.retrieveNum("Todo Id To Delete: ");
                    todoService.deleteTodo(deletedTodoId);
                    break;
                //exit app
                case 0:
                    running = false; 
                    break;
                //invalid input
                default:
                    System.out.println("invalid input...");
            }

        }

    }
}
