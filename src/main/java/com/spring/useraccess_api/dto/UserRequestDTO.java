package com.spring.useraccess_api.dto;

import com.spring.useraccess_api.entity.Role;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequestDTO {
    private String email;
    private String password;
    private Role role;
}