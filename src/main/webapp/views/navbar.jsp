<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#"><%=messageSource.getMessage("library",null,lang)%></a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="<%=request.getContextPath()%>/library/view_bookList"><%=messageSource.getMessage("books",null,lang)%></a>
                </li>
<%--                <li class="nav-item">--%>
<%--                    <a class="nav-link" href="#">Link</a>--%>
<%--                </li>--%>
<%--                <li class="nav-item dropdown">--%>
<%--                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">--%>
<%--                        <%=messageSource.getMessage("settings",null,lang)%>--%>
<%--                    </a>--%>
<%--                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">--%>
<%--                        <li><a class="dropdown-item" href="<%=request.getContextPath()%>/headhunter/view_countries"><%=messageSource.getMessage("change_language",null,lang)%></a></li>--%>
<%--                        <li><a class="dropdown-item" href="<%=request.getContextPath()%>/headhunter/view_cities"><%=messageSource.getMessage("change_language",null,lang)%></a></li>--%>
<%--                        <li><a class="dropdown-item" href="<%=request.getContextPath()%>/headhunter/view_companies"><%=messageSource.getMessage("change_language",null,lang)%></a></li>--%>
<%--                    </ul>--%>
<%--                </li>--%>
<%--                <li class="nav-item">--%>
<%--                    <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>--%>
<%--                </li>--%>
            </ul>
            <ul class="navbar-nav mb-lg-0">
                <li class="nav-item dropdown d-flex">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown2" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        <%=messageSource.getMessage("change_language",null,lang)%>
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown2">
                        <li><a class="dropdown-item" href="<%=request.getContextPath()%>?lang=uz-UZ"><img src="/images/uzbekistan.svg" height="30" width="30"> Uzbekcha</a></li>
                        <li><a class="dropdown-item" href="<%=request.getContextPath()%>?lang=ru-RU"><img src="/images/russia.svg" height="30" width="30"> Русский</a></li>
                        <li><a class="dropdown-item" href="<%=request.getContextPath()%>?lang=en-US"><img src="/images/kingdom.svg" height="30" width="30"> English</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>
