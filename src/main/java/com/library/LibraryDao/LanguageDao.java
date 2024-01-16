package com.library.LibraryDao;

import com.library.LibraryModel.Language;

import java.util.List;

public interface LanguageDao {
    void createLanguage(Language language);
    Language getLanguageById(int languageId);
    void updateLanguageById(Language language);
    void deleteLanguageById(int languageId);
    List<Language> getLanguageList();
}
