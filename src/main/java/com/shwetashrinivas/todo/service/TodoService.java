package com.shwetashrinivas.todo.service;

import com.shwetashrinivas.todo.model.TodoPO;

import java.util.Optional;

public interface TodoService {

    TodoPO createTodo(TodoPO todo);

    boolean deleteTodo(int todoId);

    TodoPO updateTodo(TodoPO todo, int id);

    Optional<TodoPO> getTodoByTodoId(int todoId);

}

