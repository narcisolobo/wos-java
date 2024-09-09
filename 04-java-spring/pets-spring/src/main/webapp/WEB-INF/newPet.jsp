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
    <title>Login-Reg</title>
</head>
<body>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container">
        <a class="navbar-brand" href="/">Pets Spring</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item">
                    <a class="nav-link" href="/pets">All Pets</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/pets/new">Create a Pet</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/logout">Log Out</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<main class="container">
    <h1 class="display-4 mb-3">Create a New Pet</h1>

    <form:form action="/pets/create" method="post" modelAttribute="pet">
        <form:hidden path="user" value="${user.id}" />
        <div class="mb-3">
            <form:label path="name" cssClass="form-label">Name:</form:label>
            <form:input path="name" cssClass="form-control" />
            <span class="form-text text-warning">
                <form:errors path="name" />
            </span>
        </div>
        <div class="mb-3">
            <form:label path="type" cssClass="form-label">Type:</form:label>
            <form:input path="type" cssClass="form-control" />
            <span class="form-text text-warning">
                <form:errors path="type" />
            </span>
        </div>
        <div class="mb-3">
            <form:label path="age" cssClass="form-label">Age:</form:label>
            <form:input path="age" cssClass="form-control" type="number" />
            <span class="form-text text-warning">
                <form:errors path="age" />
            </span>
        </div>
        <div class="text-end">
            <button type="submit" class="btn btn-primary">Create Pet</button>
        </div>
    </form:form>
</main>
<script src="/js/bootstrap.bundle.min.js"></script>
</body>
</html>
