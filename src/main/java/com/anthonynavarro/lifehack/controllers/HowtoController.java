package com.anthonynavarro.lifehack.controllers;

import com.anthonynavarro.lifehack.models.Howtos;
import com.anthonynavarro.lifehack.models.UserMinimum;
import com.anthonynavarro.lifehack.services.HowtoService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@JsonIgnoreProperties(value ="howtoid")
@RequestMapping("/howtos")
public class HowtoController

{
    @Autowired
    HowtoService howtoService;

    @PostMapping(value = "/howto/{howtoid}",
            consumes = {"application/json"},
            produces = {"application/json"})



    @GetMapping(value = "/howto",
            produces = {"application/json"})
    public ResponseEntity<?> listAllHowtos() {
        List<Howtos> myHowtos = howtoService.findAll();
        return new ResponseEntity<>(myHowtos, HttpStatus.OK);
    }

    @PutMapping(value = "/howto/{howtoid}",
            consumes = {"application/json"})
    public ResponseEntity<?> updateHowtos(@RequestBody Howtos updateHowto,
                                        @PathVariable long howtoid)
    {
        howtoService.update(updateHowto, howtoid);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping(value = "/howto/{howtoid}")
    public ResponseEntity<?> completeHowtos(@PathVariable long howtoid)
    {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/howto/{id}")
    public ResponseEntity<?> deleteUserById(
            @PathVariable
                    long id)
    {
//       howtoService.delete();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}