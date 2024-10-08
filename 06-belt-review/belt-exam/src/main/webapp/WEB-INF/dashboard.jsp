<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" data-bs-theme="dark">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/bootstrap.min.css"/>
    <title>Belt Exam</title>
</head>
<body>
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
        <div class="container">
            <a class="navbar-brand" href="/">Belt Exam</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="/movies/dashboard">Movie Dashboard</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/movies/new">Add a Movie to Your WatchList</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <header class="py-2 bg-body-secondary">
        <div class="d-flex justify-content-between align-items-center container">
            <span>Welcome, ${user.firstName} ${user.lastName}!</span>
            <a class="nav-link" href="/logout">Log Out</a>
        </div>
    </header>
    <main class="container py-3">
        <h1 class="display-4 mb-3">Global WatchList</h1>
        <table class="table">
            <thead>
                <tr>
                    <th>Movie Title</th>
                    <th>Genre</th>
                    <th>Release Year</th>
                    <th>Actions</th>
                    <th>Seen It?</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="movie" items="${movies}">
                <tr>
                    <td class="align-middle">
                        <a href="/movies/${movie.id}">${movie.title}</a>
                    </td>
                    <td class="align-middle">${movie.genre}</td>
                    <td class="align-middle">${movie.releaseDate.year}</td>
                    <td class="align-middle d-flex gap-2">
                        <c:choose>
                            <c:when test="${movie.creator.id.equals(user.id)}">
                                <a href="/movies/${movie.id}/edit" class="btn btn-sm btn-warning">Edit</a>
                                <form action="/movies/${movie.id}/delete" method="post">
                                    <button type="submit" class="btn btn-sm btn-danger">Delete</button>
                                </form>
                            </c:when>
                            <c:otherwise>
                                <a class="btn btn-sm btn-warning disabled">Edit</a>
                                <a class="btn btn-sm btn-danger disabled">Delete</a>
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <c:choose>
                            <c:when test="${!movie.watchers.contains(user)}">
                                <form action="/movies/watch" method="post">
                                    <input type="hidden" name="watcherId" value="${user.id}" />
                                    <input type="hidden" name="movieId" value="${movie.id}" />
                                    <button type="submit" class="btn btn-sm btn-primary">Seen</button>
                                </form>
                            </c:when>
                            <c:otherwise>
                                <form action="/movies/unwatch" method="post">
                                    <input type="hidden" name="watcherId" value="${user.id}" />
                                    <input type="hidden" name="movieId" value="${movie.id}" />
                                    <button type="submit" class="btn btn-sm btn-danger">Undo</button>
                                </form>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <h2 class="display-6 mb-3">Your WatchList</h2>
        <table class="table">
            <thead>
                <tr>
                    <th>Movie Title</th>
                    <th>Genre</th>
                    <th>Release Year</th>
                    <th>Actions</th>
                    <th>Seen It?</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="movie" items="${createdMovies}">
                    <tr>
                        <td class="align-middle">
                            <a href="/movies/${movie.id}">${movie.title}</a>
                        </td>
                        <td class="align-middle">${movie.genre}</td>
                        <td class="align-middle">${movie.releaseDate.year}</td>
                        <td class="d-flex align-items-center gap-2">
                            <a href="/movies/${movie.id}/edit" class="btn btn-sm btn-warning">Edit</a>
                            <form action="/movies/${movie.id}/delete" method="post">
                                <button type="submit" class="btn btn-sm btn-danger">Delete</button>
                            </form>
                        </td>
                        <td>
                            <c:choose>
                                <c:when test="${!movie.watchers.contains(user)}">
                                    <form action="/movies/watch" method="post">
                                        <input type="hidden" name="watcherId" value="${user.id}" />
                                        <input type="hidden" name="movieId" value="${movie.id}" />
                                        <button type="submit" class="btn btn-sm btn-primary">Seen</button>
                                    </form>
                                </c:when>
                                <c:otherwise>
                                    <form action="/movies/unwatch" method="post">
                                        <input type="hidden" name="watcherId" value="${user.id}" />
                                        <input type="hidden" name="movieId" value="${movie.id}" />
                                        <button type="submit" class="btn btn-sm btn-danger">Undo</button>
                                    </form>
                                </c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </main>
    <script src="/js/bootstrap.bundle.min.js"></script>
</body>
</html>