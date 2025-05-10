package com.example.demo.controllers;

import com.example.demo.constants.ErrorMessage;
import com.example.demo.constants.ResponseMessage;
import com.example.demo.constants.UrlConstant;
import com.example.demo.dtos.requests.author.AuthorCreationRequest;
import com.example.demo.dtos.requests.author.AuthorUpdationRequest;
import com.example.demo.dtos.responses.ApiResponse;
import com.example.demo.dtos.responses.author.AuthorResponse;
import com.example.demo.exceptions.CustomException;
import com.example.demo.services.AuthorService;
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
public class AuthorController {
    AuthorService authorService;

    @GetMapping(UrlConstant.Author.GET_AUTHORS)
    public ResponseEntity<ApiResponse<List<AuthorResponse>>> getAuthors(){
        return ResponseEntity.ok(ApiResponse.
                <List<AuthorResponse>>builder()
                        .status(HttpStatus.OK)
                        .result(authorService.getAuthors())
                        .message(ResponseMessage.Messgae.GET_SUCCESS)
                .build());
    }

    @PostMapping(UrlConstant.Author.CREATE_AUTHOR)
    public ResponseEntity<ApiResponse<AuthorResponse>> createAuthor(@Valid @RequestBody AuthorCreationRequest request){
        return ResponseEntity.ok(ApiResponse.<AuthorResponse>builder()
                        .result(authorService.createAuthor(request))
                        .status(HttpStatus.CREATED)
                        .message(ResponseMessage.Messgae.CREATE_SUCCESS)
                .build());
    }

    @PutMapping(UrlConstant.Author.UPDATE_AUTHOR)
    public ResponseEntity<ApiResponse<AuthorResponse>> updateAuthor(@Valid @RequestBody AuthorUpdationRequest request){
        return ResponseEntity.ok(ApiResponse.<AuthorResponse>builder()
                        .result(authorService.updateAuthor(request))
                        .message(ResponseMessage.Messgae.UPDATE_SUCCESS)
                        .status(HttpStatus.OK)
                .build());
    }

    @DeleteMapping(UrlConstant.Author.DELETE_AUTHOR)
    public ResponseEntity<ApiResponse<?>> deleteAuthor(@RequestParam(name = "id") Long id){
        if (authorService.deleteAuthor(id))
            return ResponseEntity.ok(ApiResponse.builder()
                            .status(HttpStatus.OK)
                            .message(ResponseMessage.Messgae.DELETE_SUCCESS)
                    .build());
        throw new CustomException(ErrorMessage.Author.ERR_DELETE_FAIL, HttpStatus.BAD_REQUEST);
    }

    @GetMapping(UrlConstant.Author.GET_AUTHOR)
    public ResponseEntity<ApiResponse<AuthorResponse>> getAuthor(@PathVariable(name = "id") Long id){
        return ResponseEntity.ok(ApiResponse.
                <AuthorResponse>builder()
                .status(HttpStatus.OK)
                .result(authorService.getAuthorById(id))
                .message(ResponseMessage.Messgae.GET_SUCCESS)
                .build());
    }

}
