<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%-- c:out ; c:forEach etc. --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en" data-bs-theme="dark">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Forms and Session</title>
</head>
<body>
    <main class="container py-5">
        <h1 class="display-4 mb-3">Forms and Session</h1>
        <div class="card shadow">
            <div class="card-body">
                <c:if test="${message != null}">
                    <c:if test="${message.equals('username-not-found')}">
                        <div class="alert alert-warning" role="alert">
                            Please submit your username.
                        </div>
                    </c:if>
                </c:if>
                <h2 class="card-title" id="username-label">What is your name?</h2>
                <%--
                    action points to route that processes the form
                    method must be post
                --%>
                <form action="/usernames/create" method="post">
                    <div class="form-floating mb-3">
                        <input required aria-labelledby="username-label" type="text" name="username" id="username" class="form-control form-control-lg" placeholder="Kermit the Frog" />
                        <label for="username">Kermit the Frog</label>
                    </div>
                    <div class="text-end">
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </div>
                </form>
            </div>
        </div>
    </main>
</body>
</html>
