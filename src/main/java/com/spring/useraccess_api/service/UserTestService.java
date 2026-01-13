package com.spring.useraccess_api.service;

import com.spring.useraccess_api.entity.User;
import com.spring.useraccess_api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserTestService implements CommandLineRunner {

    private final UserRepository userRepository;

    @Override
    public void run(String... args) {
        if (userRepository.count() == 0) {
            User user = User.builder()
                    .email("test@example.com")
                    .password("password")
                    .build();

            userRepository.save(user);
            System.out.println("Test user inserted");
        }
    }
}
