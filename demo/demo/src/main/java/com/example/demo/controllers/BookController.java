package com.example.demo.controllers;

import com.example.demo.constants.ErrorMessage;
import com.example.demo.constants.ResponseMessage;
import com.example.demo.constants.UrlConstant;
import com.example.demo.dtos.requests.book.BookCreationRequest;
import com.example.demo.dtos.requests.book.BookGetInformationRequest;
import com.example.demo.dtos.requests.category.CategoryCreationRequest;
import com.example.demo.dtos.responses.ApiResponse;
import com.example.demo.dtos.responses.author.AuthorResponse;
import com.example.demo.dtos.responses.book.BookResponse;
import com.example.demo.dtos.responses.category.CategoryResponse;
import com.example.demo.exceptions.CustomException;
import com.example.demo.services.BookService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BookController {
    BookService bookService;

    @GetMapping(UrlConstant.Book.GET_BOOKS)
    public ResponseEntity<ApiResponse<List<BookResponse>>> getBooks(){
        return ResponseEntity.ok(ApiResponse.
                <List<BookResponse>>builder()
                .status(HttpStatus.OK)
                .result(bookService.getBooks())
                .message(ResponseMessage.Messgae.GET_SUCCESS)
                .build());
    }

    @PostMapping(UrlConstant.Book.CREATE_BOOK)
    public ResponseEntity<ApiResponse<BookResponse>> createBook(@Valid @RequestBody BookCreationRequest request){
        return ResponseEntity.ok(ApiResponse.<BookResponse>builder()
                .result(bookService.createBook(request))
                .status(HttpStatus.CREATED)
                .message(ResponseMessage.Messgae.CREATE_SUCCESS)
                .build());
    }

    @DeleteMapping(UrlConstant.Book.DELETE_BOOK)
    public ResponseEntity<ApiResponse<?>> deleteBook(@RequestParam(name = "id") Long id){
        if (bookService.deleteBook(id))
            return ResponseEntity.ok(ApiResponse.builder()
                    .status(HttpStatus.OK)
                    .message(ResponseMessage.Messgae.DELETE_SUCCESS)
                    .build());
        throw new CustomException(ErrorMessage.Book.ERR_DELETE_FAIL, HttpStatus.BAD_REQUEST);
    }

    @GetMapping(UrlConstant.Book.SEARCH_BOOK)
    public ResponseEntity<ApiResponse<List<BookResponse>>> searchEmployee(@RequestBody BookGetInformationRequest request){
        return ResponseEntity.ok(ApiResponse.<List<BookResponse>>builder()
                .result(bookService.getBook(request))
                .status(HttpStatus.OK)
                .message("Get data success")
                .build());
    }

    @GetMapping(UrlConstant.Book.GET_BOOK)
    public ResponseEntity<ApiResponse<BookResponse>> getBook(@PathVariable(name = "id") Long id){
        return ResponseEntity.ok(ApiResponse.
                <BookResponse>builder()
                .status(HttpStatus.OK)
                .result(bookService.getBookById(id))
                .message(ResponseMessage.Messgae.GET_SUCCESS)
                .build());
    }
}
