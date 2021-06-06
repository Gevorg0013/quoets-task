package com.example.users.dto;

import java.util.List;

/**
 *
 * @author gev
 */
public class QuoteTagsDTO {

    private List<QuoteTagDTO> tags;

    public QuoteTagsDTO() {
    }

    public List<QuoteTagDTO> getTags() {
        return this.tags;
    }

    public void setTags(final List<QuoteTagDTO> tags) {
        this.tags = tags;
    }
}
