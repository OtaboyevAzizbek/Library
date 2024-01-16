package com.library.LibraryService;

import com.library.LibraryDao.AuthorDao;
import com.library.LibraryModel.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImp implements AuthorService{

    @Autowired
    AuthorDao authorDao;

    @Override
    public void createAuthor(Author author) {
        authorDao.createAuthor(author);
    }

    @Override
    public Author getAuthorById(int authorId) {
        return authorDao.getAuthorById(authorId);
    }

    @Override
    public void updateAuthorById(Author author) {
        authorDao.updateAuthorById(author);
    }

    @Override
    public void deleteAuthorById(int authorId) {
        authorDao.deleteAuthorById(authorId);
    }

    @Override
    public List<Author> getAuthorList() {
        return authorDao.getAuthorList();
    }
}
