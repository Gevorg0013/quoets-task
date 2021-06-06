package com.example.users.domain;

/**
 * Entity to be saved in DB
 *
 * @author gev
 */
public class UserDetails {

    private String id;

    private String name;

    private String quoteTag;

    public UserDetails() {
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getQueryTag() {
        return this.quoteTag;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setQuoteTag(final String quoteTag) {
        this.quoteTag = quoteTag;
    }
}
