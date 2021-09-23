package com.shwetashrinivas.todo.service;

import com.shwetashrinivas.todo.model.TodoPO;
import com.shwetashrinivas.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoRepository todoRepository;
    private TodoPO todos = null;
    private Optional<TodoPO> todoPOOptional = null;
    /*
     * This method should be used to save a new todo.
     */
    @Override
    public TodoPO createTodo(TodoPO todo) {
        if (!todoRepository.existsById(todo.getTodoId())) {
            todos = todoRepository.save(todo);
        }
        return todos;
    }


    @Override
    public boolean deleteTodo(int todoId) {
        boolean status = false;
        if (todoRepository.existsById(todoId)) {
            todoRepository.deleteById(todoId);
            status = true;
        }
        return status;
    }

    @Override
    public TodoPO updateTodo(TodoPO todo, int id) {
        if (todoRepository.existsById(id)) {
            todos = todoRepository.save(todo);
        }
        return todos;
    }

    @Override
    public Optional<TodoPO> getTodoByTodoId(int todoId) {
        if (todoRepository.existsById(todoId)) {
            todoPOOptional = todoRepository.findById(todoId);
        }
        return todoPOOptional;
    }
}
