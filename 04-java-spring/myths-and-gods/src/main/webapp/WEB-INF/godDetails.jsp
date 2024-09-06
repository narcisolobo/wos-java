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
  <title>Mythologies and Gods</title>
</head>
<body>
<nav class="navbar navbar-expand-lg text-bg-primary">
  <div class="container">
    <a class="navbar-brand" href="/">Mythologies and Gods</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav ms-auto">
        <li class="nav-item">
          <a class="nav-link" href="/mythologies">Mythologies</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/gods">Gods</a>
        </li>
      </ul>
    </div>
  </div>
</nav>

<main class="container py-3">
  <h1 class="display-4 mb-3">God Details</h1>

  <div class="card shadow">
    <div class="card-body">
      <h2 class="card-title">${god.name}</h2>

      <p class="card-text mb-0">
        <strong>Mythology: </strong>
        ${god.mythology.name}
      </p>
      <p class="card-text">
        <strong>Description: </strong>
        ${god.description}
      </p>
    </div>
  </div>
</main>
<script src="/js/bootstrap.bundle.min.js"></script>
</body>
</html>
