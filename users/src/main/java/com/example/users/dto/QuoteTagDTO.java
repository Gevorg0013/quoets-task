package com.example.users.dto;

/**
 *
 * @author gev
 */
public class QuoteTagDTO {

    private String name;

    private int count;

    public QuoteTagDTO() {
    }

    public String getName() {
        return this.name;
    }

    public int getCount() {
        return this.count;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setCount(final int count) {
        this.count = count;
    }
}
