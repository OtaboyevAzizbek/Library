package com.library.LibraryDao;

import com.library.LibraryMapper.BookMapper;
import com.library.LibraryModel.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookDaoImp implements BookDao{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void createBook(Book book) {
        jdbcTemplate.update("INSERT INTO book(title, author_id, category_id, published_year, language_id) VALUES(?,?,?,?,?);",new Object[]{book.getTitle(),book.getAuthor().getAuthorId(),book.getCategory().getCategoryId(),book.getYear(),book.getLanguage().getLanguageId()});
    }

    @Override
    public Book getBookById(int bookId) {
        return jdbcTemplate.queryForObject("SELECT book_id,title,a.author_id,last_name,first_name,c.category_id,category_name,published_year,l.language_id,language_name FROM book b LEFT JOIN author a on b.author_id = a.author_id LEFT JOIN category c on b.category_id = c.category_id LEFT JOIN language l on b.language_id = l.language_id WHERE book_id=?;",new Object[]{bookId},new BookMapper());
    }

    @Override
    public void updateBookById(Book book) {
        jdbcTemplate.update("UPDATE book SET title=?,author_id=?,category_id=?,published_year=?,language_id=? WHERE book_id=?;",new Object[]{book.getTitle(),book.getAuthor().getAuthorId(),book.getCategory().getCategoryId(),book.getYear(),book.getLanguage().getLanguageId(),book.getBookId()});
    }

    @Override
    public void deleteBookById(int bookId) {
        jdbcTemplate.update("DELETE FROM book WHERE book_id=?;",new Object[]{bookId});
    }

    @Override
    public List<Book> getBookList() {
        return jdbcTemplate.query("SELECT book_id,title,a.author_id,last_name,first_name,c.category_id,category_name,published_year,l.language_id,language_name FROM book b LEFT JOIN author a on b.author_id = a.author_id LEFT JOIN category c on b.category_id = c.category_id LEFT JOIN language l on b.language_id = l.language_id;",new BookMapper());
    }
}
