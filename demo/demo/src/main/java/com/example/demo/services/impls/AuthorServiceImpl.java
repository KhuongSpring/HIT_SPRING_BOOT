package com.example.demo.services.impls;

import com.example.demo.constants.ErrorMessage;
import com.example.demo.dtos.requests.author.AuthorCreationRequest;
import com.example.demo.dtos.requests.author.AuthorUpdationRequest;
import com.example.demo.dtos.responses.author.AuthorResponse;
import com.example.demo.dtos.responses.category.CategoryResponse;
import com.example.demo.entities.Author;
import com.example.demo.entities.Category;
import com.example.demo.exceptions.CustomException;
import com.example.demo.repositories.AuthorRepository;
import com.example.demo.services.AuthorService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    ModelMapper modelMapper;
    AuthorRepository authorRepository;

    @Override
    public AuthorResponse createAuthor(AuthorCreationRequest request) {
        Author author = modelMapper.map(request, Author.class);
        authorRepository.save(author);
        return modelMapper.map(author, AuthorResponse.class);
    }

    @Override
    public AuthorResponse updateAuthor(AuthorUpdationRequest request) {
        Author oldAuthor = authorRepository.findById(request.getId())
                .orElseThrow(() ->new CustomException(ErrorMessage.Author.ERR_AUTHOR_NOT_FOUND, HttpStatus.BAD_REQUEST));
        if (authorRepository.existsByName(request.getName()) && !oldAuthor.getName().equals(request.getName())){
            throw  new CustomException(ErrorMessage.Author.ERR_AUTHOR_NAME_EXISTED, HttpStatus.CONFLICT);
        }

        oldAuthor.setName(request.getName());
        oldAuthor.setBio(request.getBio());
        oldAuthor.setDob(request.getDob());
        authorRepository.save(oldAuthor);

        return modelMapper.map(oldAuthor, AuthorResponse.class);
    }

    @Override
    public boolean deleteAuthor(Long id) {
        if (authorRepository.existsById(id)){
            authorRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<AuthorResponse> getAuthors() {
        List<Author> authors = authorRepository.findAll();
        List<AuthorResponse> authorResponses = new ArrayList<>();
        for(Author a : authors){
            authorResponses.add(modelMapper.map(a, AuthorResponse.class));
        }
        return authorResponses;
    }

    @Override
    public AuthorResponse getAuthorById(Long id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorMessage.Author.ERR_AUTHOR_NOT_FOUND, HttpStatus.BAD_REQUEST));
        return modelMapper.map(author, AuthorResponse.class);
    }
}
