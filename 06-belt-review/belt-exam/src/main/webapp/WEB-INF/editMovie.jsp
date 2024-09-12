<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
  <h1 class="display-4 mb-3">Edit Movie</h1>
  <div class="card shadow">
    <div class="card-body">
      <form:form action="/movies/${movie.id}/update" method="post" modelAttribute="movie">

        <form:input type="hidden" path="creator" value="${user.id}" />
        <form:input type="hidden" path="id" value="${movie.id}" />

        <div class="mb-3">
          <form:label path="title" cssClass="form-label">Movie Title:</form:label>
          <form:input path="title" cssClass="form-control" />
          <form:errors path="title" cssClass="form-text text-warning" />
        </div>
        <div class="mb-3">
          <form:label path="genre" cssClass="form-label">Genre:</form:label>
          <form:input path="genre" cssClass="form-control" />
          <form:errors path="genre" cssClass="form-text text-warning" />
        </div>
        <div class="mb-3">
          <form:label path="releaseDate" cssClass="form-label">Release Year:</form:label>
          <form:input type="date" path="releaseDate" cssClass="form-control" value="${movie.releaseDate}" />
          <form:errors path="releaseDate" cssClass="form-text text-warning" />
        </div>
        <div class="mb-3">
          <form:label path="description" cssClass="form-label">Description:</form:label>
          <form:textarea path="description" cssClass="form-control" />
          <form:errors path="description" cssClass="form-text text-warning" />
        </div>
        <div class="text-end">
          <button type="submit" class="btn btn-primary">Edit Movie</button>
        </div>
      </form:form>
    </div>
  </div>

</main>
<script src="/js/bootstrap.bundle.min.js"></script>
</body>
</html>