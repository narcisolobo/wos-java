<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html lang="en" data-bs-theme="dark">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="/css/bootstrap.min.css" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css" />
    <title>Document</title>
</head>
<body>
    <nav class="navbar bg-body-tertiary">
        <div class="container">
            <h1 class="fs-3 fw-normal text-uppercase mb-0">Testing Todos</h1>
        </div>
    </nav>
    <main class="container py-5">
        <div class="row">
            <div class="col-12 col-md-8">
                <h2 class="display-2">All Todos</h2>
                <ul class="list-group list-group-flush">
                    <c:forEach var="eachTodo" items="${allTodos}">
                        <li class="list-group-item d-flex justify-content-between align-items-center
                            <c:if test='${eachTodo.isComplete}'>text-muted text-decoration-line-through</c:if>">
                            <p class="lead mb-0">${eachTodo.task}</p>
                            <div class="d-flex align-items-center gap-2">
                                <form action="/todos/${eachTodo.id}/toggle" method="post">
                                    <input type="hidden" name="isComplete" value="${!eachTodo.isComplete}" />
                                    <button type="submit" class="btn btn-sm btn-warning"><i class="bi bi-check2"></i></button>
                                </form>
                                <form action="/todos/${eachTodo.id}/delete" method="post">
                                    <button type="submit" class="btn btn-sm btn-danger"><i class="bi bi-trash"></i></button>
                                </form>
                            </div>
                        </li>
                    </c:forEach>
                </ul>
            </div>
            <div class="col-12 col-md-4">
                <h3 class="display-4">Add Todo</h3>
                <div class="card shadow mb-3">
                    <div class="card-body">
                        <form:form action="/todos/create" method="post" modelAttribute="todo">
                            <div class="mb-3">
                                <form:label path="task" cssClass="form-label">What needs to get done?</form:label>
                                <form:input path="task" cssClass="form-control" />
                                <form:errors path="task" cssClass="form-text text-warning" element="div" />
                            </div>
                            <div class="text-end">
                                <button type="submit" class="btn btn-primary">Add Todo</button>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </main>
    <script src="/js/bootstrap.bundle.min.js"></script>
    <script>
        const taskInput = document.getElementById("task");
        taskInput.focus();
    </script>
</body>
</html>
