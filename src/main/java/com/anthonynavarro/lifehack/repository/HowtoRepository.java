package com.anthonynavarro.lifehack.repository;

import com.anthonynavarro.lifehack.models.Howtos;
import org.springframework.data.repository.CrudRepository;

public interface HowtoRepository extends CrudRepository<Howtos, Long>
{
}