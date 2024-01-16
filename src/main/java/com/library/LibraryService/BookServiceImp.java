package com.library.LibraryService;

import com.library.LibraryDao.BookDao;
import com.library.LibraryModel.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImp implements BookService{

    @Autowired
    BookDao bookDao;

    @Override
    public void createBook(Book book) {
       bookDao.createBook(book);
    }

    @Override
    public Book getBookById(int bookId) {
        return bookDao.getBookById(bookId);
    }

    @Override
    public void updateBookById(Book book) {
        bookDao.updateBookById(book);
    }

    @Override
    public void deleteBookById(int bookId) {
        bookDao.deleteBookById(bookId);
    }

    @Override
    public List<Book> getBookList() {
        return bookDao.getBookList();
    }
}
