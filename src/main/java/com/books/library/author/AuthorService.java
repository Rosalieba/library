package com.books.library.author;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthorService {

    public List<String> getAuthors() {
        return List.of("Hi", "Authors", ":-)");
    }
}
