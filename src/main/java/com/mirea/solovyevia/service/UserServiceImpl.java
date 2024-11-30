package com.mirea.solovyevia.service;

import com.mirea.solovyevia.controller.UserRequest;
import com.mirea.solovyevia.entity.UserEntity;
import com.mirea.solovyevia.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserEntity getUser(int id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public UserEntity addUser(UserRequest userRequest) {
        if (userRepository.existsByEmail(userRequest.getEmail())) {
            throw new IllegalArgumentException("User already exists");
        }

        UserEntity user = new UserEntity();
        user.setEmail(userRequest.getEmail());
        user.setJob(userRequest.getJob());
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());

        return userRepository.save(user);
    }
}
