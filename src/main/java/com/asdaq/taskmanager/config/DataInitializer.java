package com.asdaq.taskmanager.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.asdaq.taskmanager.entity.User;
import com.asdaq.taskmanager.repository.UserRepository;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initUsers(UserRepository userRepository,
            PasswordEncoder passwordEncoder) {
        return args -> {

            if (userRepository.findByEmail("admin@test.com").isEmpty()) {
                User admin = new User();
                admin.setName("Admin");
                admin.setEmail("admin@test.com");
                admin.setPassword(passwordEncoder.encode("password123"));
                admin.setRole("ADMIN");

                userRepository.save(admin);
                System.out.println("✅ Admin user created");
            }
        };
    }
}
