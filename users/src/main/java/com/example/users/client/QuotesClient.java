package com.example.users.client;

import com.example.users.dto.QuoteTagsDTO;
import com.example.users.dto.QuteDetailsResponse;
import com.example.users.dto.QutesDetailsResponse;
import io.vavr.control.Try;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author gev
 */
@Service
public class QuotesClient {

    @Autowired
    private RestTemplate restTemplate;

    private static final String QUOTES_ALL_API = "http://quotes:8081/api/quotes";

    private static final String QUOTE_TAGS_API = "http://quotes:8081/api/tags";

    /**
     * Get quotes by provided tag
     *
     * @param tag
     * @return Collection of quotes
     */
    public Optional<QutesDetailsResponse> getQuoteByTag(final String tag) {

        if (tag == null) {
            return Optional.empty();
        }

        final UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(QUOTES_ALL_API);
        builder.queryParam("tag", tag);

        final Try<QutesDetailsResponse> response = Try.of(()
                -> this.restTemplate.getForObject(builder.toUriString(), QutesDetailsResponse.class));

        if (!response.isSuccess()) {
            System.out.print("Error to get quotes: " + response.getCause().getLocalizedMessage());
            return Optional.empty();
        }

        System.out.print("Quote has been received successfully: " + response.get().getQuotes().size());
        return Optional.of(response.get());
    }

    public Optional<QuoteTagsDTO> getTags() {

        final Try<QuoteTagsDTO> response = Try.of(()
                -> this.restTemplate.getForObject(QUOTE_TAGS_API, QuoteTagsDTO.class));

        if (!response.isSuccess()) {
            System.out.print("Error to get quote tags: " + response.getCause().getLocalizedMessage());
            return Optional.empty();
        }

        System.out.print("Quote tags have been received successfully: " + response.get().getTags().size());
        return Optional.of(response.get());
    }
}
