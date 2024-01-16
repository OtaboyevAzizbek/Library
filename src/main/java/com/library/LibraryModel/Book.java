package com.library.LibraryModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Book {
    private int bookId;
    private String title;
    private Author author;
    private Category category;
    private String year;
    private Language language;
}
