<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html lang="en" data-bs-theme="dark">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <link rel="stylesheet" href="/css/bootstrap.min.css" />
  <title>Upload to Amazon S3 Bucket</title>
</head>
<body>

  <nav class="navbar bg-body-tertiary">
    <div class="container">
      <a class="navbar-brand" href="">Upload to S3</a>
    </div>
  </nav>

  <main class="container py-5">
    <c:choose>
      <c:when test="${message.equals('not-authenticated')}">
        <div class="alert alert-warning alert-dismissible fade show" role="alert">
          <p class="mb-0">You must be logged in to view that page.</p>
          <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
      </c:when>
      <c:when test="${message.equals('logged-out')}">
        <div class="alert alert-warning alert-dismissible fade show" role="alert">
          <p class="mb-0">You have been successfully logged out.</p>
          <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
      </c:when>
    </c:choose>
    <div class="row">
      <div class="col-12 col-lg-6">
        <h2 class="display-6 mb-3">Register</h2>
        <div class="card shadow mb-3">
          <div class="card-body">
            <form:form action="/accounts/register" method="post" modelAttribute="registerUser">
              <div class="mb-3">
                <form:label class="form-label" path="username">Username:</form:label>
                <form:input cssClass="form-control" path="username" />
                <form:errors path="username" cssClass="form-text text-warning" element="div" />
              </div>
              <div class="mb-3">
                <form:label class="form-label" path="email">Email:</form:label>
                <form:input cssClass="form-control" path="email"/>
                <form:errors path="email" cssClass="form-text text-warning" element="div" />
              </div>
              <div class="mb-3">
                <form:label class="form-label" path="password">Password:</form:label>
                <form:input type="password" cssClass="form-control" path="password"/>
                <form:errors path="password" cssClass="form-text text-warning" element="div" />
              </div>
              <div class="mb-3">
                <form:label class="form-label" path="confirm">Confirm Password:</form:label>
                <form:input type="password" cssClass="form-control" path="confirm"/>
                <form:errors path="confirm" cssClass="form-text text-warning" element="div" />
              </div>
              <button type="submit" class="btn btn-primary w-100">Register</button>
            </form:form>
          </div>
        </div>
      </div>
      <div class="col-12 col-lg-6">
        <h2 class="display-6 mb-3">Login</h2>
        <div class="card shadow mb-3">
          <div class="card-body">
            <form:form action="/accounts/login" method="post" modelAttribute="loginUser">
              <div class="mb-3">
                <form:label class="form-label" path="loginEmail">Email:</form:label>
                <form:input cssClass="form-control" path="loginEmail"/>
                <form:errors path="loginEmail" cssClass="form-text text-warning" element="div" />
              </div>
              <div class="mb-3">
                <form:label class="form-label" path="loginPassword">Password:</form:label>
                <form:input type="password" cssClass="form-control" path="loginPassword"/>
                <form:errors path="loginPassword" cssClass="form-text text-warning" element="div" />
              </div>
              <button type="submit" class="btn btn-primary w-100">Login</button>
            </form:form>
          </div>
        </div>
      </div>
    </div>
  </main>

  <script src="/js/bootstrap.bundle.min.js"></script>
</body>
</html>
