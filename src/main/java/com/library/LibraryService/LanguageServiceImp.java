package com.library.LibraryService;

import com.library.LibraryDao.LanguageDao;
import com.library.LibraryModel.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageServiceImp implements LanguageService{

    @Autowired
    LanguageDao languageDao;

    @Override
    public void createLanguage(Language language) {
        languageDao.createLanguage(language);
    }

    @Override
    public Language getLanguageById(int languageId) {
        return languageDao.getLanguageById(languageId);
    }

    @Override
    public void updateLanguageById(Language language) {
        languageDao.updateLanguageById(language);
    }

    @Override
    public void deleteLanguageById(int languageId) {
        languageDao.deleteLanguageById(languageId);
    }

    @Override
    public List<Language> getLanguageList() {
        return languageDao.getLanguageList();
    }
}
