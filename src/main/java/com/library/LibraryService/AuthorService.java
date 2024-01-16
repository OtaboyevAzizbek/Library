package com.library.LibraryService;

import com.library.LibraryModel.Author;

import java.util.List;

public interface AuthorService {
    void createAuthor(Author author);
    Author getAuthorById(int authorId);
    void updateAuthorById(Author author);
    void deleteAuthorById(int authorId);
    List<Author> getAuthorList();
}
