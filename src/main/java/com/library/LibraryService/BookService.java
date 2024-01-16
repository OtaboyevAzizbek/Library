package com.library.LibraryService;

import com.library.LibraryModel.Book;

import java.util.List;

public interface BookService {
    void createBook(Book book);
    Book getBookById(int bookId);
    void updateBookById(Book book);
    void deleteBookById(int bookId);
    List<Book> getBookList();
}
