package com.asdaq.taskmanager.service.impl;

import com.asdaq.taskmanager.dto.UserDto;
import com.asdaq.taskmanager.entity.User;
import com.asdaq.taskmanager.repository.UserRepository;
import com.asdaq.taskmanager.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setRole(userDto.getRole());
        user.setPassword("encrypted"); // TEMP (will fix later)

        User savedUser = userRepository.save(user);

        return new UserDto(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getEmail(),
                savedUser.getRole()
        );
    }
}
