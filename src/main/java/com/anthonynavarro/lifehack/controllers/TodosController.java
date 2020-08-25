package com.anthonynavarro.lifehack.controllers;

import com.anthonynavarro.lifehack.models.Todo;
import com.anthonynavarro.lifehack.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodosController {

    @Autowired
    TodoService todoService;

    @GetMapping(value = "/todos",
            produces = {"application/json"})
    public ResponseEntity<?> listAllTodos() {
        List<Todo> myTodos = todoService.findAll();
        return new ResponseEntity<>(myTodos, HttpStatus.OK);
    }

    @PutMapping(value = "/todo/{todoid}",
            consumes = {"application/json"})
    public ResponseEntity<?> updateTodo(@RequestBody Todo updateTodo,
                                        @PathVariable long todoid) {

        todoService.update(updateTodo, todoid);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}