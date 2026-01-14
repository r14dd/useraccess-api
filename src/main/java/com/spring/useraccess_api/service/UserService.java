package com.spring.useraccess_api.service;

import com.spring.useraccess_api.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User createUser(User user);

    Optional<User> getUserById(Long id);

    List<User> getAllUsers();

    void deactivateUser(Long id);
}
