package com.anthonynavarro.lifehack.controllers;

import com.anthonynavarro.lifehack.models.Howtos;
import com.anthonynavarro.lifehack.services.HowtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/howtos")
public class HowtoController {

    @Autowired
    HowtoService howtoService;

    @GetMapping(value = "/howtos",
            produces = {"application/json"})
    public ResponseEntity<?> listAllTodos() {
        List<Howtos> myHowtos = howtoService.findAll();
        return new ResponseEntity<>(myHowtos, HttpStatus.OK);
    }

    @PutMapping(value = "/howto/{howtoid}",
            consumes = {"application/json"})
    public ResponseEntity<?> updateTodo(@RequestBody Howtos updateHowto,
                                        @PathVariable long howtoid) {

        howtoService.update(updateHowto, howtoid);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}