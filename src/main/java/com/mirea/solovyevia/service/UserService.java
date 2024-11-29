package com.mirea.solovyevia.service;

import com.mirea.solovyevia.controller.UserRequest;
import com.mirea.solovyevia.entity.UserEntity;

public interface UserService {

    UserEntity getUser(int id);
    UserEntity addUser(UserRequest userRequest);
}
