package com.shwetashrinivas.todo.controller;

import com.shwetashrinivas.todo.model.TodoPO;
import com.shwetashrinivas.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200") //For Front end
@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;
    private TodoPO todoPO;

    @PostMapping("/todos")
    public ResponseEntity<TodoPO> createTodo(@RequestBody TodoPO todo) {

        todoPO = todoService.createTodo(todo);
        return new ResponseEntity<>(todoPO, HttpStatus.CREATED);
    }

    @GetMapping("/todos/{id}")
    public Optional<TodoPO> getTodo(@PathVariable int id) {
        Optional<TodoPO> todoPOOptional = null;
        todoPOOptional = todoService.getTodoByTodoId(id);
        return todoPOOptional;
    }

    @PutMapping("/todos/{id}")
    public ResponseEntity<TodoPO> updateTodo(@PathVariable int id, @RequestBody TodoPO todo) {
        if(todoService.getTodoByTodoId(id) != null){
            todoPO = todoService.updateTodo(todo, id);
            return new ResponseEntity<>(todoPO, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(todoPO, HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/todos/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable int id) {

        boolean status = todoService.deleteTodo(id);
        if (status) {
            return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);

        } else
            return new ResponseEntity<>("Todo not found", HttpStatus.NOT_FOUND);
    }
}

