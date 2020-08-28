package com.anthonynavarro.lifehack.repository;

import com.anthonynavarro.lifehack.models.Howtos;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface HowtoRepository extends CrudRepository<Howtos, Long>
{

    @Transactional
    @Modifying
    @Query(value = "UPDATE howtos SET name = :name, " +
                   "last_modified_by = :uname, last_modified_date = CURRENT_TIMESTAMP WHERE howtoid = :howtoid",
            nativeQuery = true)
    void updateRoleName(
            String uname,
            long howtoid,
            String name);

}