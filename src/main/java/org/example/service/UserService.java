package org.example.service;

import org.example.model.User;

import java.util.List;

public interface UserService {

    void save(User user);

    User findById(Long id);

    public List<User> findAll();

    public User updateById(Long id, User newUser);

    void deleteById(Long id);
}
