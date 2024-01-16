package com.library.LibraryDao;

import com.library.LibraryMapper.AuthorMapper;
import com.library.LibraryModel.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthorDaoImp implements AuthorDao{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void createAuthor(Author author) {
        jdbcTemplate.update("INSERT INTO author(last_name, first_name, address) VALUES(?,?,?);",new Object[]{author.getLastName(),author.getFirstName(),author.getAddress()});
    }

    @Override
    public Author getAuthorById(int authorId) {
        return jdbcTemplate.queryForObject("SELECT * FROM author WHERE author_id=?;",new Object[]{authorId},new AuthorMapper());
    }

    @Override
    public void updateAuthorById(Author author) {
        jdbcTemplate.update("UPDATE author SET last_name=?,first_name=?,address=? WHERE author_id=?;",new Object[]{author.getLastName(),author.getFirstName(),author.getAddress(),author.getAuthorId()});
    }

    @Override
    public void deleteAuthorById(int authorId) {
        jdbcTemplate.update("DELETE FROM author WHERE author_id=?;",new Object[]{authorId});
    }

    @Override
    public List<Author> getAuthorList() {
        return jdbcTemplate.query("SELECT * FROM author;",new AuthorMapper());
    }
}
