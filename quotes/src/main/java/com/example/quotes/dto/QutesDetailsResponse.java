package com.example.quotes.dto;

import java.util.Collections;
import java.util.List;

/**
 *
 * @author gev
 */
public class QutesDetailsResponse {

    private List<QuteDetailsResponse> quotes = Collections.EMPTY_LIST;

    public QutesDetailsResponse() {
    }

    public List<QuteDetailsResponse> getQuotes() {
        return this.quotes;
    }

    public void setQuotes(final List<QuteDetailsResponse> quotes) {
        this.quotes = quotes;
    }
}
