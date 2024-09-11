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
  <link rel="stylesheet" href="/css/bootstrap.min.css"/>
  <title>The Vinyl Countdown</title>
</head>
<body>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container">
    <a class="navbar-brand" href="/">Vinyl Countdown</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav ms-auto">
        <li class="nav-item">
          <a class="nav-link" href="/albums">All Albums</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/albums/new">Add an Album</a>
        </li>
      </ul>
    </div>
  </div>
</nav>
<header class="py-2 bg-body-secondary">
  <div class="d-flex justify-content-between align-items-center container">
    <span>${user.email}</span>
    <a class="nav-link" href="/logout">Log Out</a>
  </div>
</header>
<main class="container py-3">
  <h1 class="display-4 mb-3">Album Details</h1>
  <div class="card shadow">
    <div class="card-body">
      <h2 class="card-title">${album.title}</h2>
      <h3 class="card-subtitle mb-3">${album.artist}</h3>
      <p class="card-text">${album.description}</p>
      <p class="card-text">Uploaded by: ${album.creator.firstName}</p>
      <p class="card-text">${album.likingUsers.size()} likes</p>

      <c:if test="${!album.hasLikedAlbum(user.id) && !album.creator.id.equals(user.id)}">
        <form action="/likes/create" method="post">
          <input type="hidden" name="likerId" value="${user.id}" />
          <input type="hidden" name="albumId" value="${album.id}" />
          <button class="btn btn-sm btn-primary">Like</button>
        </form>
      </c:if>

      <p class="card-text">Average Rating: ${average}</p>
      <c:if test="${!album.hasRatedAlbum(user.id)}">
        <form action="/ratings/create" method="post">
          <input type="hidden" name="raterId" value="${user.id}" />
          <input type="hidden" name="albumId" value="${album.id}" />
          <div class="mb-3">
            <label for="score" class="form-label">Rate this album:</label>
            <input type="number" class="form-control" min="1" max="5" name="score" id="score" />
          </div>
          <div class="text-end">
            <button type="submit" class="btn btn-primary">Rate</button>
          </div>
        </form>
      </c:if>

    </div>
  </div>
</main>
<script src="/js/bootstrap.bundle.min.js"></script>
</body>
</html>
