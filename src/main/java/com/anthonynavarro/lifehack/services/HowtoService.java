package com.anthonynavarro.lifehack.services;

import com.anthonynavarro.lifehack.models.Howtos;
import java.util.List;

public interface HowtoService

{
    List<Howtos> findAll();

    Howtos update(Howtos howtos,
                  long howtoid);

    Howtos save(Howtos howtos,
                long userid);

//    Howtos addhowto(Howtos howtos);
//    void markComplete(long howtoid);

}