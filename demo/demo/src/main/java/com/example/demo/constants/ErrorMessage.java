package com.example.demo.constants;

public class ErrorMessage {
    public static class Category{
        public static final String ERR_CATEGORY_NAME_BLANK = "Category's name must not blank";
        public static final String ERR_CATEGORY_NAME_EXISTED = "Category's name existed";
        public static final String ERR_DELETE_FAIL = "Delete category fail";
        public static final String ERR_CATEGORY_NOT_FOUND = "Category not found";
    }

    public static class Author{
        public static final String ERR_AUTHOR_NAME_BLANK = "Author's name must not blank";
        public static final String ERR_DOB_NULL = "Author's dob must not null";
        public static final String ERR_NULL_ID = "Author's id must not null";
        public static final String ERR_AUTHOR_NOT_FOUND = "Author not found";
        public static final String ERR_AUTHOR_NAME_EXISTED = "Author's name existed";
        public static final String ERR_DELETE_FAIL = "Delete author fail";
    }

    public static class Book{
        public static final String ERR_BOOK_NAME_BLANK = "Book's name must not blank";
        public static final String ERR_AUTHOR_ID_NULL = "Author's id must not null";
        public static final String ERR_CATEGORY_ID_NULL  = "Category's id must not null";
        public static final String ERR_PRICE_NOT_VALID  = "Price not valid";
        public static final String ERR_DELETE_FAIL = "Delete book fail";
        public static final String ERR_BOOK_NOT_FOUND = "Book not found";
    }
}
