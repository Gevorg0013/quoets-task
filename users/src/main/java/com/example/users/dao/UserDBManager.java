package com.example.users.dao;

import com.example.users.domain.UserDetails;
import java.util.Map;
import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 *
 * @author gev
 */
@Service
public class UserDBManager {

    private final Map<String, UserDetails> idToUser = new HashMap<>();

    public Optional<UserDetails> saveUser(final UserDetails user) {

        if (user.getId() != null) {
            System.out.println("User ID should be null!");
            return Optional.empty();
        }

        user.setId(UUID.randomUUID().toString());
        idToUser.put(user.getId(), user);

        System.out.println("User has been created successfully! " + user.getId());
        return Optional.of(user);
    }

    public Optional<UserDetails> updateUser(final UserDetails user) {

        if (user.getId() == null) {
            System.out.println("User ID should be not null for update!");
            return Optional.empty();
        } else if (!this.idToUser.containsKey(user.getId())) {
            System.out.println("There is no user with the provided ID: " + user.getId());
            return Optional.empty();
        }

        idToUser.replace(user.getId(), user);

        System.out.println("User has been updated successfully! " + user.getId());
        return Optional.of(user);
    }

    public boolean deleteUser(final String userId) {

        if (userId == null) {
            System.out.println("User ID should be not null for delete!");
            return false;
        } else if (!this.idToUser.containsKey(userId)) {
            System.out.println("There is no user with the provided ID: " + userId);
            return false;
        }

        idToUser.remove(userId);

        System.out.println("User has been deleted successfully! " + userId);
        return true;
    }

    public Optional<UserDetails> getUserById(final String id) {
        return this.idToUser.containsKey(id) ? Optional.of(this.idToUser.get(id)) : Optional.empty();
    }
}
