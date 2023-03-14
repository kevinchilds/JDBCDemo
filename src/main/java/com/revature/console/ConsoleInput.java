package com.revature.console;

import java.util.Scanner;

public class ConsoleInput implements Input {
    Scanner scanner;

    public ConsoleInput(){
        this.scanner = new Scanner(System.in);
    }

    @Override
    public int retrieveNum(String output){
        
        boolean validNum = false;
        int num = -1;
        while(!validNum){
            System.out.print(output);
            String input = scanner.nextLine();
            try{
                num = Integer.parseInt(input);
                validNum = true;
            }catch(Exception e){
                System.out.println("Invalid input...");
            }
        }

        return num;
    }

    @Override
    public String retrieveString(String output){
        System.out.print(output);
        return scanner.nextLine();
    }

    @Override
    public void cleanup() {
        this.scanner.close();
    }
}
