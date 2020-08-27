package com.anthonynavarro.lifehack.repository;
import com.anthonynavarro.lifehack.views.UserNameCountHowtos;
import com.anthonynavarro.lifehack.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * The CRUD repository connecting User to the rest of the application
 */
public interface UserRepository
        extends CrudRepository<User, Long>
{

    @Query(value = "SELECT u.username as usernamerpt, count(h.howtooid) as counttodos " +
            "FROM users u LEFT JOIN howtos h " +
            "ON u.userid = h.userid " +
            "WHERE NOT h.completed GROUP BY u.username " +
            "ORDER BY u.username ", nativeQuery = true)
    List<UserNameCountHowtos> getCountUserTodos();

    User findByUsername(String username);

    /**
     * Find all users whose name contains a given substring ignoring case
     *
     * @param name the substring of the names (String) you seek
     * @return List of users whose name contain the given substring ignoring case
     */
    List<User> findByUsernameContainingIgnoreCase(String name);
}
