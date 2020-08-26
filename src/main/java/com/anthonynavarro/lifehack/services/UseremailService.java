package com.anthonynavarro.lifehack.services;

import com.anthonynavarro.lifehack.models.Useremail;
import java.util.List;


/**
 * The Service that works with the Useremail Model
 * <p>
 * Note: Emails are added through the add user process
 */
public interface UseremailService
{

    List<Useremail> findAll();


    Useremail findUseremailById(long id);


    void delete(long id);

    Useremail update(
            long useremailid,
            String emailaddress);


    Useremail save(
            long userid,
            String emailaddress);
}
