package com.anthonynavarro.lifehack.services;


import com.anthonynavarro.lifehack.models.Todo;

import java.util.List;

public interface TodoService {

    List<Todo> findAll();

    Todo update(Todo todo, long todoid);

    Todo save(Todo todo, long userid);
}