package com.library.LibraryService;

import com.library.LibraryModel.Language;

import java.util.List;

public interface LanguageService {
    void createLanguage(Language language);
    Language getLanguageById(int languageId);
    void updateLanguageById(Language language);
    void deleteLanguageById(int languageId);
    List<Language> getLanguageList();
}
