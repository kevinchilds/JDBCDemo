package com.revature.models;

public class Todo {
    private int todoId;
    private String taskName;
    private boolean completed;

    public Todo(String taskName){
        this.taskName = taskName;
        this.completed = false;
    }

    public Todo(String taskName, boolean completed){
        this.taskName = taskName;
        this.completed = completed;
    }

    public Todo(int todoId, String taskName, boolean completed){
        this.todoId = todoId;
        this.taskName = taskName;
        this.completed = completed;
    }



    public int getTodoId() {
        return this.todoId;
    }

    public void setTodoId(int todoId) {
        this.todoId = todoId;
    }

    public String getTaskName() {
        return this.taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public boolean isCompleted() {
        return this.completed;
    }

    public boolean getCompleted() {
        return this.completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }


    @Override
    public String toString() {
        return "{" +
            " todoId='" + getTodoId() + "'" +
            ", taskName='" + getTaskName() + "'" +
            ", completed='" + isCompleted() + "'" +
            "}";
    }

    


}
