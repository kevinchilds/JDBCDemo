package com.revature.daos;

import java.util.List;

import com.revature.models.Todo;

public interface TodoDAO {
    //CRUD
    List<Todo> selectAll();
    Todo createOne(Todo credentials);
    Todo selectOne(int todoId);
    Todo updateOne(int todoId);
    void deleteOne(int todoId);
}
