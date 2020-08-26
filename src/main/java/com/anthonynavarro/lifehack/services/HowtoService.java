package com.anthonynavarro.lifehack.services;


import com.anthonynavarro.lifehack.models.Howtos;

import java.util.List;

public interface HowtoService
{

    List<Howtos> findAll();

    Howtos update(Howtos todo, long todoid);

    Howtos save(Howtos todo, long userid);
}