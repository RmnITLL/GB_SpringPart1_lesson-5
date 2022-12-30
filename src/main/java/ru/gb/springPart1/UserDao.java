package ru.gb.springPart1;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    Optional<User> findById(Long id);
    Optional<User> findByName(String name);

    List<User> findAll();
}
