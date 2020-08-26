package com.anthonynavarro.lifehack.services;

import com.anthonynavarro.lifehack.models.Howtos;
import com.anthonynavarro.lifehack.repository.HowtoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "HowtoService")
public class HowtoServiceImpl implements HowtoService
{

    @Autowired
    HowtoRepository howtorepos;

    @Autowired
    UserService userService;

    @Transactional
    @Override
    public List<Howtos> findAll() {
        List<Howtos> list = new ArrayList<>();
        howtorepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    public Howtos update(Howtos howto, long howtoid) {
        Howtos currentHowto = howtorepos.findById(howtoid).orElseThrow(() ->
                new EntityNotFoundException(Long.toString(howtoid)));

        if (howto.getDescription() != null) {
            currentHowto.setDescription(howto.getDescription());
        }

        return howtorepos.save(currentHowto);
    }

    @Override
    public Howtos save(Howtos howto, long userid) {
        Howtos addHowto = new Howtos();

        addHowto.setDescription(howto.getDescription());

        addHowto.setUser(userService.findUserById(userid));
        return howtorepos.save(addHowto);
    }
}