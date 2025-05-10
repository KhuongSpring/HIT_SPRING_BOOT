package com.example.demo.constants;

public class UrlConstant {
    public static class Author{
        public static final String PREFIX = "/author";
        public static final String GET_AUTHORS = PREFIX;
        public static final String GET_AUTHOR = PREFIX + "/{id}";
        public static final String CREATE_AUTHOR = PREFIX;
        public static final String UPDATE_AUTHOR = PREFIX;
        public static final String DELETE_AUTHOR = PREFIX;

    }

    public static class Category{
        public static final String PREFIX = "/category";
        public static final String GET_CATEGORYS = PREFIX;
        public static final String GET_CATEGORY = PREFIX + "/{id}";
        public static final String CREATE_CATEGORY = PREFIX;
        public static final String UPDATE_CATEGORY = PREFIX;
        public static final String DELETE_CATEGORY = PREFIX;
    }

    public static class Book{
        public static final String PREFIX = "/book";
        public static final String GET_BOOKS = PREFIX;
        public static final String GET_BOOK = PREFIX + "/{id}";
        public static final String CREATE_BOOK = PREFIX;
        public static final String UPDATE_BOOK = PREFIX;
        public static final String DELETE_BOOK = PREFIX;
        public static final String SEARCH_BOOK = "/seach";
    }
}
