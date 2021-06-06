package com.example.quotes.dto;

/**
 *
 * @author gev
 */
public class QuteDetailsResponse {

    public QuteDetailsResponse() {
    }

    public String getText() {
        return this.text;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getTag() {
        return this.tag;
    }

    public void setText(final String text) {
        this.text = text;
    }

    public void setAuthor(final String author) {
        this.author = author;
    }

    public void setTag(final String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "QuteDetailsResponse: Text-" + this.text + ", author-" + this.author + ", tag-" + this.tag;
    }

    private String text;

    private String author;

    private String tag;
}
