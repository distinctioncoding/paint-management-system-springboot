package com.larry.paint_management_system.dto;

import com.larry.paint_management_system.entity.UserRole;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private String username;
    private String password;
    private UserRole role;
}
