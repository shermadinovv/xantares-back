package com.boogoo.xantares.service;

import com.boogoo.xantares.entity.User;
import com.boogoo.xantares.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Регистрация
    public User register(User user) {
        // Шифруем пароль перед сохранением
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    // Вход (упрощенно, пока без токена)
    public Optional<User> login(String username, String password) {
        Optional<User> userOpt = userRepository.findByUsername(username);

        if (userOpt.isPresent()) {
            // Проверяем: совпадает ли введенный пароль с хэшем в базе
            if (passwordEncoder.matches(password, userOpt.get().getPassword())) {
                return userOpt;
            }
        }
        return Optional.empty();
    }
}