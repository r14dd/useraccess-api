package com.spring.useraccess_api.service.impl;

import com.spring.useraccess_api.dto.UserRequestDTO;
import com.spring.useraccess_api.dto.UserResponseDTO;
import com.spring.useraccess_api.entity.User;
import com.spring.useraccess_api.entity.Role;
import com.spring.useraccess_api.repository.UserRepository;
import com.spring.useraccess_api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponseDTO createUser(UserRequestDTO dto) {
        User user = User.builder()
                .email(dto.getEmail())
                .password(dto.getPassword()) // TODO: encode password later
                .role(dto.getRole() != null ? dto.getRole() : Role.USER)
                .active(true)
                .build();

        userRepository.save(user);
        return mapToResponse(user);
    }

    @Override
    public UserResponseDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        return mapToResponse(user);
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void deactivateUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        user.setActive(false);
        userRepository.save(user);
    }

    // ---------------- Mapping Methods ----------------

    private UserResponseDTO mapToResponse(User user) {
        return UserResponseDTO.builder()
                .id(user.getId())
                .email(user.getEmail())
                .role(user.getRole())
                .active(user.isActive())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();
    }
}
