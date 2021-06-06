package com.example.quotes.controllers;

import com.example.quotes.client.QuotesClient;
import com.example.quotes.dto.QuoteTagsDTO;
import com.example.quotes.dto.QutesDetailsResponse;
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
@RequestMapping(path = "/api")
public class QuoteController {

    @Autowired
    private QuotesClient quotesClient;

    @GetMapping("/tags")
    public ResponseEntity getAllTags() {

        final Optional<QuoteTagsDTO> tags = this.quotesClient.getTags();
        if (!tags.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tags not found!");
        }

        return ResponseEntity.ok(tags.get());
    }

    @GetMapping("/quotes")
    public ResponseEntity getAllQuotesByTag(
            final @RequestParam(required = true) String tag
    ) {

        final Optional<QutesDetailsResponse> quotes = this.quotesClient.getQuoteByTag(tag);
        if (!quotes.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Quotes not found!");
        }

        return ResponseEntity.ok(quotes.get());
    }
}
