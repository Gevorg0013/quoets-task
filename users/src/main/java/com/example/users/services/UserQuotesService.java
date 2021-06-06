package com.example.users.services;

import com.example.users.client.QuotesClient;
import com.example.users.dao.UserDBManager;
import com.example.users.domain.UserDetails;
import com.example.users.dto.QuteDetailsResponse;
import com.example.users.dto.QutesDetailsResponse;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gev
 */
@Service
public class UserQuotesService {

    @Autowired
    private UserDBManager userDBManager;

    @Autowired
    private QuotesClient quoteClient;

    public Optional<QutesDetailsResponse> getQuotesForUser(final String userId) {

        if (userId == null) {
            return Optional.empty();
        }

        final Optional<UserDetails> user = this.userDBManager.getUserById(userId);
        if (!user.isPresent()) {
            System.out.println("There is no user with the ID: " + userId);
            return Optional.empty();
        }

        final Optional<QutesDetailsResponse> quotes = this.quoteClient.getQuoteByTag(user.get().getQueryTag());
        if (!quotes.isPresent()) {
            System.out.println("There are not quotes for the tag: " + user.get().getQueryTag());
        } else {
            System.out.println("Quotes of the user's tag: " + quotes.get().getQuotes().size());
        }

        return quotes;
    }
}
