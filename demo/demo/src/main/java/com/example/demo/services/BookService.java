package com.example.demo.services;

import com.example.demo.dtos.requests.book.BookCreationRequest;
import com.example.demo.dtos.requests.book.BookGetInformationRequest;
import com.example.demo.dtos.responses.book.BookResponse;

import java.util.List;

public interface BookService {
    BookResponse createBook(BookCreationRequest request);
    boolean deleteBook(Long id);
    List<BookResponse> getBooks();
    List<BookResponse> getBook(BookGetInformationRequest request);
    BookResponse getBookById(Long id);
}
