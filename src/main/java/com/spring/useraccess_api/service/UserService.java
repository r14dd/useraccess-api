package com.spring.useraccess_api.service;

import com.spring.useraccess_api.dto.UserRequestDTO;
import com.spring.useraccess_api.dto.UserResponseDTO;
import java.util.List;

public interface UserService {
    UserResponseDTO createUser(UserRequestDTO dto);
    UserResponseDTO getUserById(Long id);
    List<UserResponseDTO> getAllUsers();
    void deactivateUser(Long id);
}