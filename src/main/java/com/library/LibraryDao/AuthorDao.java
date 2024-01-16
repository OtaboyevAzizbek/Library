package com.library.LibraryDao;

import com.library.LibraryModel.Author;

import java.util.List;

public interface AuthorDao {
    void createAuthor(Author author);
    Author getAuthorById(int authorId);
    void updateAuthorById(Author author);
    void deleteAuthorById(int authorId);
    List<Author> getAuthorList();
}
