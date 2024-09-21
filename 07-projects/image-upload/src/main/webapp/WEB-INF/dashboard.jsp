<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" data-bs-theme="dark">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<c:url value='../../css/bootstrap.min.css'>"/>
    <title>Pets</title>
</head>
<body>
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
        <div class="container">
            <a class="navbar-brand" href="">Pets</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value='/pets/dashboard' />">Movie Dashboard</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value='/pets/new' />">Add a Pet</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <header class="py-2 bg-body-secondary">
        <div class="d-flex justify-content-between align-items-center container">
            <span>Welcome, ${user.firstName} ${user.lastName}!</span>
            <a class="nav-link" href="<c:url value='/logout' />">Log Out</a>
        </div>
    </header>
    <main class="container py-3">
        <h1 class="display-4 mb-3">All Pets</h1>
        <div class="pet-grid">
            <c:forEach var="pet" items="${pets}">
                <div class="card shadow">
                    <img class="card-img-top" src="<c:url value='../../images/jinja.webp' />" alt="Jinja" />
                    <div class="card-body">
                        <h2 class="card-title">${randomFileName}</h2>
                    </div>
                </div>
            </c:forEach>
        </div>
    </main>
    <script src="<c:url value='../../js/bootstrap.bundle.min.js' />"></script>
</body>
</html>