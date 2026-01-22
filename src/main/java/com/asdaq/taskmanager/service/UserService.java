package com.asdaq.taskmanager.service;

import java.util.List;

import com.asdaq.taskmanager.dto.UserDto;

public interface UserService {

    UserDto createUser(UserDto userDto);

    List<UserDto> getAllUsers();

    UserDto getUserById(Long id);

    void deleteUser(Long id);

    UserDto updateUser(Long id, UserDto userDto);

}
