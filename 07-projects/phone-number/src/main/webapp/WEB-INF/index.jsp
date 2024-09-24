<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html lang="en" data-bs-theme="dark">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous" />
    <title>Phone Number</title>
</head>
<body>
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
        <div class="container">
            <a class="navbar-brand" href="">Phone Number</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="/contact">Contact Us</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <main class="container py-5">
        <h1 class="display-1 mb-3">Phone Number</h1>
        <div class="row">
            <div class="col-12 col-lg-6">
                <div class="card shadow">
                    <div class="card-body">
                        <form:form action="/register" method="post" modelAttribute="user">
                            <div class="mb-3">
                                <form:label class="form-label" path="username">Username:</form:label>
                                <form:input cssClass="form-control" path="username"/>
                                <span class="form-text text-warning">
                                    <form:errors path="username"/>
                                </span>
                            </div>
                            <div class="mb-3">
                                <form:label class="form-label" path="email">Email:</form:label>
                                <form:input cssClass="form-control" path="email"/>
                                <span class="form-text text-warning">
                                    <form:errors path="email"/>
                                </span>
                            </div>
                            <div class="mb-3">
                                <form:label class="form-label" path="password">Password:</form:label>
                                <form:input type="password" cssClass="form-control" path="password"/>
                                <span class="form-text text-warning">
                                    <form:errors path="password"/>
                                </span>
                            </div>
                            <div class="mb-3">
                                <form:label class="form-label" path="confirm">Confirm Password:</form:label>
                                <form:input type="password" cssClass="form-control" path="confirm"/>
                                <span class="form-text text-warning">
                                    <form:errors path="confirm"/>
                                </span>
                            </div>
                            <button type="submit" class="btn btn-primary w-100">Register</button>
                        </form:form>
                    </div>
                </div>
            </div>
            <div class="col-12 col-lg-6">
                <div class="card shadow">
                    <div class="card-body">
                        <form:form action="/login" method="post" modelAttribute="loginUser">
                            <div class="mb-3">
                                <form:label class="form-label" path="loginEmail">Email:</form:label>
                                <form:input cssClass="form-control" path="loginEmail"/>
                                <span class="form-text text-warning">
                                    <form:errors path="loginEmail"/>
                                </span>
                            </div>
                            <div class="mb-3">
                                <form:label class="form-label" path="loginPassword">Password:</form:label>
                                <form:input type="password" cssClass="form-control" path="loginPassword"/>
                                <span class="form-text text-warning">
                                    <form:errors path="loginPassword"/>
                                </span>
                            </div>
                            <button type="submit" class="btn btn-primary w-100">Login</button>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </main>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
