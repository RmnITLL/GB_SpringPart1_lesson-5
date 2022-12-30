package ru.gb.springPart1;

import java.util.List;

public interface UserDao {
    User findById(Long id);
    List<User> findAll();
}
