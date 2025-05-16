package com.yaksha.assessments.blogs.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class BlogDTO {

    private Long id;

    @NotNull(message = "Title cannot be null")
    @Size(min = 3, max = 100, message = "Title must be between 3 and 100 characters")
    private String title;

    @NotNull(message = "Content cannot be null")
    @Size(min = 3, max = 200, message = "Content must be between 3 and 200 characters")
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
