package com.mirea.solovyevia.controller;

import com.mirea.solovyevia.entity.UserEntity;
import com.mirea.solovyevia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<UserEntity> getUserById(@RequestParam(required = false) Integer id, @RequestBody(required = false) UserRequest userRequest) {
        if (id == null && userRequest == null) {
            return ResponseEntity.badRequest().body(null);
        }

        int userId = id == null ? userRequest.getId() : id;
        UserEntity user = userService.getUser(userId);

        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<UserEntity> addUser(@RequestBody UserRequest userRequest) {
        UserEntity user = userService.addUser(userRequest);
        return ResponseEntity.ok(user);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleConflict(IllegalArgumentException e) {
        return e.getMessage();
    }
}
