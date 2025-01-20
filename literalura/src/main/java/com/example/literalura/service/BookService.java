package com.example.literalura.service;

import com.example.literalura.dto.Book;
import com.example.literalura.dto.GutendexResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final RestTemplate restTemplate;

    public BookService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Book> fetchBooksFromApi() {
        String url = "https://gutendex.com/books";
        GutendexResponse response = restTemplate.getForObject(url, GutendexResponse.class);

        if (response != null && response.getResults() != null) {
            return response.getResults().stream()
                    .map(book -> new Book(
                            book.getTitle(),
                            book.getAuthors() != null && !book.getAuthors().isEmpty()
                                    ? book.getAuthors().get(0).getName()
                                    : "Autor Desconhecido",
                            book.getSubjects() != null
                                    ? String.join(", ", book.getSubjects())
                                    : "Sem assuntos"
                    ))
                    .collect(Collectors.toList());
        }

        return List.of(); // Retorna uma lista vazia se a resposta for nula
    }
}