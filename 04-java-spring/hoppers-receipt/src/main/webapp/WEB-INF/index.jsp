<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%-- c:out ; c:forEach etc. --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="en" data-bs-theme="dark">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hopper's Receipt</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
</head>
<body>
    <main class="container py-3">
        <div class="card shadow mb-3">
            <div class="card-body">
                <h1>Hopper's Receipt</h1>
                <h2>Customer name: <c:out value="${name}" /></h2>
                <p>Price: <fmt:formatNumber value="${price}" type="currency" /></p>
                <p>Description: ${description}</p>
                <p>Vendor: ${vendor}</p>
            </div>
        </div>
        <div class="card shadow mb-3">
            <div class="card-body">
                <c:forEach var="muppet" items="${muppets}">
                    <p class="card-text">${muppet.firstName} ${muppet.lastName}</p>
                </c:forEach>
            </div>
        </div>
    </main>

    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
