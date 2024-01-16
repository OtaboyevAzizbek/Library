package com.library.LibraryModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Author {
    private int authorId;
    private String lastName;
    private String firstName;
    private String address;
}
