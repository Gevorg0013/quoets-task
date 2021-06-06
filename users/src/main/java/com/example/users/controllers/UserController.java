package com.example.users.controllers;

import com.example.users.dao.UserDBManager;
import com.example.users.domain.UserDetails;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gev
 */
@RestController
@RequestMapping(path = "/api/user")
public class UserController {

    @Autowired
    private UserDBManager userDBManager;

    @PostMapping
    public ResponseEntity createUser(
            final @RequestBody UserDetails user
    ) {
        final Optional<UserDetails> savedUser = this.userDBManager.saveUser(user);

        if (!savedUser.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create user");
        }

        return ResponseEntity.ok(savedUser.get());
    }

    @PutMapping
    public ResponseEntity updateUser(
            final @RequestBody UserDetails user
    ) {
        final Optional<UserDetails> savedUser = this.userDBManager.updateUser(user);

        if (!savedUser.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create user");
        }

        return ResponseEntity.ok(savedUser.get());
    }

    @DeleteMapping
    public ResponseEntity deleteUserById(
            final @RequestParam String id
    ) {
        final boolean state = this.userDBManager.deleteUser(id);
        if (!state) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("There is no user with the provided ID");
        }

        return ResponseEntity.ok("User has been deleted successfully: " + id);
    }
}
