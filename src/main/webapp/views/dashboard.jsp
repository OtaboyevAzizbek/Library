<%@ page import="java.util.List" %>
<%@ page import="com.library.LibraryModel.Book" %>
<%@ page import="com.library.LibraryModel.Author" %>
<%@ page import="com.library.LibraryModel.Category" %>
<%@ page import="com.library.LibraryModel.Language" %>
<%@ include file="header.jsp"%>
<% List<Book> bookList = (List<Book>) request.getAttribute("bookList");%>
<% List<Author> authorList = (List<Author>) request.getAttribute("authorList");%>
<% List<Category> categoryList = (List<Category>) request.getAttribute("categoryList");%>
<% List<Language> languageList = (List<Language>) request.getAttribute("languageList");%>
<div class="d-grid gap-5 d-md-flex align-items-center justify-content-md-end m-2">
    <button class="btn btn-primary me-md-2" data-bs-toggle="modal" data-bs-target=".bd-example-modal-z" type="button"><i class="fa-solid fa-plus mx-sm-1"></i><%=messageSource.getMessage("create_book",null,lang)%></button>
</div>
<table class="table table-bordered border-2 table-striped">
    <thead>
    <tr>
        <th><%=messageSource.getMessage("book_id",null,lang)%></th>
        <th><%=messageSource.getMessage("book_title",null,lang)%></th>
        <th><%=messageSource.getMessage("author_firstName",null,lang)%></th>
        <th><%=messageSource.getMessage("author_lastName",null,lang)%></th>
        <th><%=messageSource.getMessage("book_genre",null,lang)%></th>
        <th><%=messageSource.getMessage("book_year",null,lang)%></th>
        <th><%=messageSource.getMessage("book_language",null,lang)%></th>
        <th><%=messageSource.getMessage("actions",null,lang)%></th>
    </tr>
    </thead>
    <tbody>
    <% for (Book book : bookList) {%>
    <tr>
        <td><%=book.getBookId()%></td>
        <td><%=book.getTitle()%></td>
        <td><%=book.getAuthor().getFirstName()%></td>
        <td><%=book.getAuthor().getLastName()%></td>
        <td><%=book.getCategory().getCategoryName()%></td>
        <td><%=book.getYear()%></td>
        <td><%=book.getLanguage().getLanguageName()%></td>
        <td>
            <button type="button" data-bs-toggle="modal" data-bs-target=".bd-example-modal-xx<%=book.getBookId()%>" class="btn btn-warning"><i class="fa-solid fa-pen mx-sm-1"></i><%=messageSource.getMessage("edit",null,lang)%></button>
            <button type="button" data-bs-toggle="modal" data-bs-target=".bd-example-modal-c<%=book.getBookId()%>" class="btn btn-danger"><i class="fa-solid fa-trash-can mx-sm-1"></i><%=messageSource.getMessage("delete",null,lang)%></button>
        </td>
<%--        Modal for delete--%>
        <div class="modal fade bd-example-modal-c<%=book.getBookId()%>" tabindex="-1">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title"><b><%=messageSource.getMessage("delete",null,lang)%></b></h4>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <h5><%=messageSource.getMessage("sure",null,lang)%></h5>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal"><%=messageSource.getMessage("close",null,lang)%></button>
                        <a href="<%=request.getContextPath()%>/library/delete_book/<%=book.getBookId()%>" class="btn btn-danger"><%=messageSource.getMessage("delete",null,lang)%></a>
                    </div>
                </div>
            </div>
        </div>
    <%--Modal for update--%>
        <div class="modal fade bd-example-modal-xx<%=book.getBookId()%>" aria-labelledby="exampleModalEditBook" tabindex="-1">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalEditBook"><%=messageSource.getMessage("edit",null,lang)%></h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <form action="update_book" method="post">
                        <input type="hidden" name="bookId" value="<%=book.getBookId()%>">
                        <div class="modal-body">
                            <div class="mb-3">
                                <label for="exampleBookTitle" class="form-label"><%=messageSource.getMessage("book_title",null,lang)%></label>
                                <input type="text" name="title" class="form-control" id="exampleBookTitle" value="<%=book.getTitle()%>" required>
                            </div>
                            <div class="mb-3">
                                <label for="exampleBookAuthor" class="form-label"><%=messageSource.getMessage("book_author",null,lang)%></label>
                                <select name="authorId" id="exampleBookAuthor" class="form-control" required>
                                    <option value="" selected><%=messageSource.getMessage("select_author",null,lang)%></option>
                                    <% for (Author author : authorList) {%>
                                    <option value="<%=author.getAuthorId()%>" <%=author.getAuthorId()==book.getAuthor().getAuthorId() ? "selected":"" %>><%=author.getFirstName()%> <%=author.getLastName()%></option>
                                    <%}%>
                                </select>
                            </div>
                            <div class="mb-3">
                                <label for="exampleBookCategory" class="form-label"><%=messageSource.getMessage("book_genre",null,lang)%></label>
                                <select name="categoryId" id="exampleBookCategory" class="form-control" required>
                                    <option value="" selected><%=messageSource.getMessage("select_genre",null,lang)%></option>
                                    <% for (Category category : categoryList) {%>
                                    <option value="<%=category.getCategoryId()%>" <%=category.getCategoryId()==book.getCategory().getCategoryId() ? "selected":"" %> ><%=category.getCategoryName()%></option>
                                    <%}%>
                                </select>
                            </div>
                            <div class="mb-3">
                                <label for="exampleBookYear" class="form-label"><%=messageSource.getMessage("book_year",null,lang)%></label>
                                <input type="text" name="year" class="form-control" id="exampleBookYear" value="<%=book.getYear()%>" required>
                            </div>
                            <div class="mb-3">
                                <label for="exampleBookLanguage" class="form-label"><%=messageSource.getMessage("book_language",null,lang)%></label>
                                <select name="languageId" id="exampleBookLanguage" class="form-control" required>
                                    <option value="" selected><%=messageSource.getMessage("select_language",null,lang)%></option>
                                    <% for (Language language : languageList) {%>
                                    <option value="<%=language.getLanguageId()%>" <%=language.getLanguageId()==book.getLanguage().getLanguageId() ? "selected":"" %>><%=language.getLanguageName()%></option>
                                    <%}%>
                                </select>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-danger" data-bs-dismiss="modal"><%=messageSource.getMessage("close",null,lang)%></button>
                            <button type="submit" class="btn btn-success"><%=messageSource.getMessage("save",null,lang)%></button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </tr>
    <%}%>
    <%--Modal for insert--%>
    <div class="modal fade bd-example-modal-z" aria-labelledby="exampleModalEditBook2" tabindex="-1">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalEditBook2"><%=messageSource.getMessage("create_book",null,lang)%></h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <form action="update_book" method="post">
                    <input type="hidden" name="bookId">
                    <div class="modal-body">
                        <div class="mb-3">
                            <label for="exampleBookTitle2" class="form-label"><%=messageSource.getMessage("book_title",null,lang)%></label>
                            <input type="text" name="title" class="form-control" id="exampleBookTitle2" required>
                        </div>
                        <div class="mb-3">
                            <label for="exampleBookAuthor2" class="form-label"><%=messageSource.getMessage("book_author",null,lang)%></label>
                            <select name="authorId" id="exampleBookAuthor2" class="form-control" required>
                                <option value="" selected><%=messageSource.getMessage("select_author",null,lang)%></option>
                                <% for (Author author : authorList) {%>
                                <option value="<%=author.getAuthorId()%>"><%=author.getFirstName()%> <%=author.getLastName()%></option>
                                <%}%>
                            </select>
                        </div>
                        <div class="mb-3">
                            <label for="exampleBookCategory2" class="form-label"><%=messageSource.getMessage("book_genre",null,lang)%></label>
                            <select name="categoryId" id="exampleBookCategory2" class="form-control" required>
                                <option value="" selected><%=messageSource.getMessage("select_genre",null,lang)%></option>
                                <% for (Category category : categoryList) {%>
                                <option value="<%=category.getCategoryId()%>"><%=category.getCategoryName()%></option>
                                <%}%>
                            </select>
                        </div>
                        <div class="mb-3">
                            <label for="exampleBookYear2" class="form-label"><%=messageSource.getMessage("book_year",null,lang)%></label>
                            <input type="text" name="year" class="form-control" id="exampleBookYear2" required>
                        </div>
                        <div class="mb-3">
                            <label for="exampleBookLanguage2" class="form-label"><%=messageSource.getMessage("book_language",null,lang)%></label>
                            <select name="languageId" id="exampleBookLanguage2" class="form-control" required>
                                <option value="" selected><%=messageSource.getMessage("select_language",null,lang)%></option>
                                <% for (Language language : languageList) {%>
                                <option value="<%=language.getLanguageId()%>"><%=language.getLanguageName()%></option>
                                <%}%>
                            </select>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger" data-bs-dismiss="modal"><%=messageSource.getMessage("close",null,lang)%></button>
                        <button type="submit" class="btn btn-success"><%=messageSource.getMessage("save",null,lang)%></button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    </tbody>
</table>
<%@ include file="footer.jsp"%>