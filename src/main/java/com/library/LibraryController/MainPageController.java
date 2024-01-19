package com.library.LibraryController;

import com.library.LibraryModel.Author;
import com.library.LibraryModel.Book;
import com.library.LibraryModel.Category;
import com.library.LibraryModel.Language;
import com.library.LibraryService.AuthorService;
import com.library.LibraryService.BookService;
import com.library.LibraryService.CategoryService;
import com.library.LibraryService.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/library")
public class MainPageController {

    @Autowired
    LanguageService languageService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    AuthorService authorService;

    @Autowired
    ReloadableResourceBundleMessageSource messageSource;
    @Autowired
    BookService bookService;

    @GetMapping("/main")
    public ModelAndView mainPage(){
        ModelAndView modelAndView = new ModelAndView("dashboard");
        modelAndView.addObject("bookList",bookService.getBookList());
        modelAndView.addObject("authorList",authorService.getAuthorList());
        modelAndView.addObject("categoryList",categoryService.getCategoryList());
        modelAndView.addObject("languageList",languageService.getLanguageList());
        return modelAndView;
    }

    @PostMapping("/create_language")
    public void createLanguage(@RequestParam("name") String name){
        languageService.createLanguage(Language.builder().languageName(name).build());
    }

    @GetMapping("/view_language")
    public Language viewLanguage(@RequestParam("languageId") int languageId){
        return languageService.getLanguageById(languageId);
    }

    @PostMapping("update_language")
    public void updateLanguage(@RequestParam("languageId") int languageId,@RequestParam("name") String name){
        languageService.updateLanguageById(new Language(languageId,name));
    }

    @GetMapping("/delete_language")
    public void deleteLanguage(@RequestParam("languageId") int languageId){
        languageService.deleteLanguageById(languageId);
    }

    @GetMapping("/view_languageList")
    public List<Language> viewLanguageList(){
        return languageService.getLanguageList();
    }

    @PostMapping("/create_category")
    public void createCategory(@RequestParam("name") String name){
        categoryService.createCategory(Category.builder().categoryName(name).build());
    }

    @GetMapping("/view_category")
    public Category viewCategory(@RequestParam("categoryId") int categoryId){
        return categoryService.getCategoryById(categoryId);
    }

    @PostMapping("update_category")
    public void updateCategory(@RequestParam("categoryId") int categoryId,@RequestParam("name") String name){
        categoryService.updateCategoryById(new Category(categoryId,name));
    }

    @GetMapping("/delete_category")
    public void deleteCategory(@RequestParam("categoryId") int categoryId){
        categoryService.deleteCategoryById(categoryId);
    }

    @GetMapping("/view_categoryList")
    public List<Category> viewCategoryList(){
        return categoryService.getCategoryList();
    }

    @PostMapping("/create_author")
    public void createAuthor(@RequestParam("lastName") String lastName,@RequestParam("firstName") String firstName,@RequestParam("address") String address){
        authorService.createAuthor(Author.builder().lastName(lastName).firstName(firstName).address(address).build());
    }

    @GetMapping("/view_author")
    public Author viewAuthor(@RequestParam("authorId") int authorId){
        return authorService.getAuthorById(authorId);
    }

    @PostMapping("update_author")
    public void updateAuthor(@RequestParam("authorId") int authorId,@RequestParam("lastName") String lastName,@RequestParam("firstName") String firstName,@RequestParam("address") String address){
        authorService.updateAuthorById(new Author(authorId,lastName,firstName,address));
    }

    @GetMapping("/delete_author")
    public void deleteAuthor(@RequestParam("authorId") int authorId){
        authorService.deleteAuthorById(authorId);
    }

    @GetMapping("/view_authorList")
    public List<Author> viewAuthorList(){
        return authorService.getAuthorList();
    }

    @PostMapping("/create_book")
    public ModelAndView createBook(@RequestParam("title") String title,@RequestParam("authorId") int authorId,@RequestParam("categoryId") int categoryId,@RequestParam("year") String year,@RequestParam("languageId") int languageId){
        bookService.createBook(Book.builder().title(title).author(Author.builder().authorId(authorId).build()).category(Category.builder().categoryId(categoryId).build()).year(year).language(Language.builder().languageId(languageId).build()).build());
        return new ModelAndView("redirect:/library/main");
    }

    @GetMapping("/view_book")
    public Book viewBook(@RequestParam("bookId") int bookId){
        return bookService.getBookById(bookId);
    }

    @PostMapping("update_book")
    public ModelAndView updateBook(@RequestParam("bookId") int bookId,@RequestParam("title") String title,@RequestParam("authorId") int authorId,@RequestParam("categoryId") int categoryId,@RequestParam("year") String year,@RequestParam("languageId") int languageId){
        bookService.updateBookById(new Book(bookId,title,Author.builder().authorId(authorId).build(),Category.builder().categoryId(categoryId).build(),year,Language.builder().languageId(languageId).build()));
        return new ModelAndView("redirect:/library/main");
    }

    @GetMapping("/delete_book/{bookId}")
    public ModelAndView deleteBook(@PathVariable("bookId") int bookId){
        bookService.deleteBookById(bookId);
        return new ModelAndView("redirect:/library/main");
    }

    @GetMapping("/view_bookList")
    public ModelAndView viewBookList(){
        return new ModelAndView("redirect:/library/main");
    }
}
