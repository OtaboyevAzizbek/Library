package com.library.LibraryDao;

import com.library.LibraryMapper.LanguageMapper;
import com.library.LibraryModel.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LanguageDaoImp implements LanguageDao{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void createLanguage(Language language) {
        jdbcTemplate.update("INSERT INTO language(language_name) VALUES(?);",new Object[]{language.getLanguageName()});
    }

    @Override
    public Language getLanguageById(int languageId) {
        return jdbcTemplate.queryForObject("SELECT * FROM language WHERE language_id=?;",new Object[]{languageId},new LanguageMapper());
    }

    @Override
    public void updateLanguageById(Language language) {
        jdbcTemplate.update("UPDATE language SET language_name=? WHERE language_id=?;",new Object[]{language.getLanguageName(),language.getLanguageId()});
    }

    @Override
    public void deleteLanguageById(int languageId) {
        jdbcTemplate.update("DELETE FROM language WHERE language_id=?;",new Object[]{languageId});
    }

    @Override
    public List<Language> getLanguageList() {
        return jdbcTemplate.query("SELECT * FROM language;",new LanguageMapper());
    }
}
