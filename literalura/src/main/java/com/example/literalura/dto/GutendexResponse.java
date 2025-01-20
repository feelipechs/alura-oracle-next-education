package com.example.literalura.dto;

import lombok.Data;
import java.util.List;

@Data
public class GutendexResponse {
    private List<BookApiResponse> results;

    @Data
    public static class BookApiResponse {
        private String title;
        private List<Author> authors;
        private List<String> subjects;
    }

    @Data
    public static class Author {
        private String name;
    }
}