<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Headhunter</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="<%=request.getContextPath()%>/productList">Vacancies</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Link</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Settings
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="<%=request.getContextPath()%>/headhunter/view_countries">Country</a></li>
                        <li><a class="dropdown-item" href="<%=request.getContextPath()%>/headhunter/view_cities">City</a></li>
                        <li><a class="dropdown-item" href="<%=request.getContextPath()%>/headhunter/view_companies">Company</a></li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
                </li>
            </ul>
            <ul class="nav-item dropdown">
                <li class="d-flex">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown2" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Settings
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown2">
                        <li><a class="dropdown-item" href="<%=request.getContextPath()%>?lang=uz-UZ">Uzbekcha</a></li>
                        <li><a class="dropdown-item" href="<%=request.getContextPath()%>?lang=ru-RU">Русский</a></li>
                        <li><a class="dropdown-item" href="<%=request.getContextPath()%>?lang=en-US">English</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>
