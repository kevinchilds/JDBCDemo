package com.revature.console;

import java.util.Scanner;

import com.revature.models.Todo;

public class ConsoleInput {
    Scanner scanner;

    public ConsoleInput(Scanner sc){
        this.scanner = sc;
    }

    public int getMenuOption(){
        System.out.print("Option: ");
        String input = scanner.nextLine();
        int num = -1;

        try{
            num = Integer.parseInt(input);
        }catch(Exception e){
            System.out.println("Invalid input...");
        }

        return num;
    }

    public Todo createTodoInputs() {
        System.out.print("Task Name: ");
        String task = scanner.nextLine();
        Todo todo = new Todo(task);
        return todo;
    }

    public Todo updateTodoInputs() {
        System.out.print("Id: ");
        String input = scanner.nextLine();
        int id = -1;

        try{
            id = Integer.parseInt(input);
        }catch(Exception e){
            System.out.println("Not a valid id...");
            return null;
        }
        System.out.print("Task Name: ");
        String task = scanner.nextLine();

        System.out.print("Is task completed? (y/n)");
        String completed = scanner.nextLine();
        if(!(completed.equals("y") || completed.equals("n"))){
            System.out.println("Not a valid input...");
            return null;
        }

        Todo todo = new Todo(id, task, completed.equals("y") ? true : false);
        return todo;
    }

    public int deleteTodoInputs() {
        System.out.print("todo id: ");
        String input = scanner.nextLine();
        int num = -1;

        try{
            num = Integer.parseInt(input);
        }catch(Exception e){
            System.out.println("Invalid input...");
        }

        return num;
    }
}
