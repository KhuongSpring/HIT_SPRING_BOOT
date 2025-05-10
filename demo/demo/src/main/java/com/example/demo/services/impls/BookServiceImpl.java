package com.example.demo.services.impls;

import com.example.demo.constants.ErrorMessage;
import com.example.demo.dtos.requests.author.AuthorCreationRequest;
import com.example.demo.dtos.requests.book.BookCreationRequest;
import com.example.demo.dtos.requests.book.BookGetInformationRequest;
import com.example.demo.dtos.responses.author.AuthorResponse;
import com.example.demo.dtos.responses.book.BookResponse;
import com.example.demo.dtos.responses.category.CategoryResponse;
import com.example.demo.entities.Author;
import com.example.demo.entities.Book;
import com.example.demo.entities.Category;
import com.example.demo.exceptions.CustomException;
import com.example.demo.repositories.AuthorRepository;
import com.example.demo.repositories.BookRepository;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.services.BookService;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    ModelMapper modelMapper;
    BookRepository bookRepository;
    AuthorRepository authorRepository;
    CategoryRepository categoryRepository;

    @Override
    public BookResponse createBook(BookCreationRequest request) {
        if (request.getPrice() <= 0)
            throw new CustomException(ErrorMessage.Book.ERR_PRICE_NOT_VALID, HttpStatus.BAD_REQUEST);
        Author author = authorRepository.findById(request.getAuthor())
                .orElseThrow(() -> new CustomException(ErrorMessage.Author.ERR_AUTHOR_NOT_FOUND, HttpStatus.BAD_REQUEST));
        Category category = categoryRepository.findById(request.getCategory())
                .orElseThrow(() -> new CustomException(ErrorMessage.Category.ERR_CATEGORY_NOT_FOUND, HttpStatus.BAD_REQUEST));

        Book book = Book.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .author(author)
                .category(category)
                .build();
        bookRepository.save(book);
        return modelMapper.map(book, BookResponse.class);
    }

    @Override
    public boolean deleteBook(Long id) {
        if (bookRepository.existsById(id)){
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<BookResponse> getBooks() {
        List<Book> books = bookRepository.findAll();
        List<BookResponse> bookResponses = new ArrayList<>();
        for(Book a : books){
            bookResponses.add(modelMapper.map(a, BookResponse.class));
        }
        return bookResponses;
    }

    @Override
    public List<BookResponse> getBook(BookGetInformationRequest request) {
        Specification<Book> spec = build(request);
        List<Book> books= bookRepository.findAll(spec);
        List<BookResponse> bookResponses = new ArrayList<>();
        for (Book e : books) {
            bookResponses.add(modelMapper.map(e, BookResponse.class));
        }
        return bookResponses;
    }

    @Override
    public BookResponse getBookById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorMessage.Book.ERR_BOOK_NOT_FOUND, HttpStatus.BAD_REQUEST));
        return modelMapper.map(book, BookResponse.class);
    }


    public static Specification<Book> build(BookGetInformationRequest request) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (request.getName() != null)
                predicates.add(cb.equal(root.get("name"), request.getName()));

            if (request.getPrice() != 0) {
                predicates.add(cb.equal(root.get("price"), request.getPrice()));
            }

            if (request.getAuthorName() != null && !request.getAuthorName().isBlank()) {
                Join<Object, Object> authorJoin = root.join("author", JoinType.INNER);
                predicates.add(cb.like(cb.lower(authorJoin.get("name")), "%" + request.getAuthorName().toLowerCase() + "%"));
            }

            if (request.getCategoryName() != null && !request.getCategoryName().isBlank()) {
                Join<Object, Object> categoryJoin = root.join("category", JoinType.INNER);
                predicates.add(cb.like(cb.lower(categoryJoin.get("name")), "%" + request.getCategoryName().toLowerCase() + "%"));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }

}
