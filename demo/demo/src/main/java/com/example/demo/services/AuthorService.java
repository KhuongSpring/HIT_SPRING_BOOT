package com.example.demo.services;

import com.example.demo.dtos.requests.author.AuthorCreationRequest;
import com.example.demo.dtos.requests.author.AuthorUpdationRequest;
import com.example.demo.dtos.responses.author.AuthorResponse;

import java.util.List;

public interface AuthorService {
    AuthorResponse createAuthor(AuthorCreationRequest request);
    AuthorResponse updateAuthor(AuthorUpdationRequest request);
    boolean deleteAuthor(Long id);
    List<AuthorResponse> getAuthors();
    AuthorResponse getAuthorById(Long id);
}
