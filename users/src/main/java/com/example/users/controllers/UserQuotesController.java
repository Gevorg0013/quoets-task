package com.example.users.controllers;

import com.example.users.dto.QutesDetailsResponse;
import com.example.users.services.UserQuotesService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gev
 */
@RestController
@RequestMapping("/api/quotes")
public class UserQuotesController {

    @Autowired
    private UserQuotesService userQuotesService;

    @GetMapping("/user")
    public ResponseEntity getQuotesForUser(
            final @RequestParam String userId
    ) {

        final Optional<QutesDetailsResponse> quotes = this.userQuotesService.getQuotesForUser(userId);
        if (!quotes.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Quotes for the user are not available!");
        }

        return ResponseEntity.ok(quotes.get());
    }
}
