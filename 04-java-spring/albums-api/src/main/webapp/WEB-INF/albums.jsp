<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%-- c:out ; c:forEach etc. --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- Formatting (dates) --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%-- form:form --%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%-- for rendering errors on PUT routes --%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html lang="en" data-bs-theme="dark">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/bootstrap.min.css" />
    <title>Albums CRUD</title>
</head>
<body>
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
        <div class="container">
            <a class="navbar-brand" href="/">Albums CRUD</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/albums">All Albums</a>
                    </li>
                </ul>
            </div>
            <form class="d-flex" role="search" action="/albums/search" method="post">
                <input class="form-control me-2" type="search" placeholder="Search by title" aria-label="Search" name="title" />
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </nav>
    <main class="container py-3">
        <h1 class="display-4 mb-3">Albums</h1>

        <div class="card shadow mb-3">
            <div class="card-body">
                <h2 class="card-title mb-3">Create Album</h2>
                <form:form action="/albums/create" method="post" modelAttribute="album">
                    <div class="form-floating mb-3">
                        <form:input path="title" cssClass="form-control" placeholder="Title" />
                        <form:label path="title">Title</form:label>
                        <span class="form-text text-warning">
                            <form:errors path="title" />
                        </span>
                    </div>
                    <div class="form-floating mb-3">
                        <form:input path="artist" cssClass="form-control" placeholder="Artist" />
                        <form:label path="artist">Artist</form:label>
                        <span class="form-text text-warning">
                            <form:errors path="artist" />
                        </span>
                    </div>
                    <div class="form-floating mb-3">
                        <form:input path="releaseDate" cssClass="form-control" type="date" placeholder="Release Date" />
                        <form:label path="releaseDate">Release Date</form:label>
                        <span class="form-text text-warning">
                            <form:errors path="releaseDate" />
                        </span>
                    </div>
                    <div class="text-end">
                        <button type="submit" class="btn btn-primary">Create Album</button>
                    </div>
                </form:form>
            </div>
        </div>

        <table class="table table-striped table-hover">
            <thead>
                <tr>
                    <th>
                        <span>Title </span>
                        <a href="/albums/sort/title">Sort by title</a>
                    </th>
                    <th>
                        <span>Artist </span>
                        <a href="/albums/sort/artist">Sort by artist</a>
                    </th>
                    <th>
                        <span>Release Date </span>
                        <a href="/albums/sort/release-date">Sort by release date</a>
                    </th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="album" items="${albums}">
                    <tr>
                        <td class="align-middle">
                            <a href="/albums/${album.id}">${album.title}</a>
                        </td>
                        <td class="align-middle">${album.artist}</td>
                        <td class="align-middle">
                            <fmt:formatDate type="date" value="${album.releaseDate}" />
                        </td>
                        <td class="align-middle d-flex">
                            <a href="/albums/${album.id}/edit" class="btn btn-sm btn-warning me-2">Edit</a>
                            <form action="/albums/${album.id}/delete" method="post">
                                <input type="hidden" name="_method" value="delete">
                                <button type="submit" class="btn btn-sm btn-danger">Delete</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </main>



    <script src="/js/bootstrap.bundle.min.js"></script>
</body>
</html>
