<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html lang="en" data-bs-theme="dark">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<c:url value='../../css/bootstrap.min.css' />"/>
    <title>Pets</title>
</head>
<body>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container">
        <a class="navbar-brand" href="">Pets</a>
    </div>
</nav>
<main class="container py-5">
    <div class="row">
        <div class="col">
            <h2 class="display-6 mb-3">Register</h2>
            <div class="card shadow mb-3">
                <div class="card-body">
                    <form:form action="/register" method="post" modelAttribute="user">
                        <div class="mb-3">
                            <form:label class="form-label" path="firstName">First Name:</form:label>
                            <form:input cssClass="form-control" path="firstName"/>
                            <form:errors path="firstName" cssClass="form-text text-warning" />
                        </div>
                        <div class="mb-3">
                            <form:label class="form-label" path="lastName">Last Name:</form:label>
                            <form:input cssClass="form-control" path="lastName"/>
                            <form:errors path="lastName" cssClass="form-text text-warning" />
                        </div>
                        <div class="mb-3">
                            <form:label class="form-label" path="email">Email:</form:label>
                            <form:input cssClass="form-control" path="email"/>
                            <form:errors path="email" cssClass="form-text text-warning" />
                        </div>
                        <div class="mb-3">
                            <form:label class="form-label" path="password">Password:</form:label>
                            <form:input type="password" cssClass="form-control" path="password"/>
                            <form:errors path="password" cssClass="form-text text-warning" />
                        </div>
                        <div class="mb-3">
                            <form:label class="form-label" path="confirm">Confirm Password:</form:label>
                            <form:input type="password" cssClass="form-control" path="confirm"/>
                            <form:errors path="confirm" cssClass="form-text text-warning" />
                        </div>
                        <button type="submit" class="btn btn-primary w-100">Register</button>
                    </form:form>
                </div>
            </div>
        </div>
        <div class="col">
            <h2 class="display-6 mb-3">Login</h2>
            <div class="card shadow mb-3">
                <div class="card-body">
                    <form:form action="/login" method="post" modelAttribute="loginUser">
                        <div class="mb-3">
                            <form:label class="form-label" path="loginEmail">Email:</form:label>
                            <form:input cssClass="form-control" path="loginEmail"/>
                            <form:errors path="loginEmail" cssClass="form-text text-warning" />
                        </div>
                        <div class="mb-3">
                            <form:label class="form-label" path="loginPassword">Password:</form:label>
                            <form:input type="password" cssClass="form-control" path="loginPassword"/>
                            <form:errors path="loginPassword" cssClass="form-text text-warning" />
                        </div>
                        <button type="submit" class="btn btn-primary w-100">Login</button>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</main>
<script src="<c:url value='../../js/bootstrap.bundle.min.js' />"></script>
</body>
</html>
