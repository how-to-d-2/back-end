package com.anthonynavarro.lifehack.repository;

import com.anthonynavarro.lifehack.models.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Long> {
}