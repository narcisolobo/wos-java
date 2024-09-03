<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%-- c:out ; c:forEach etc. --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- Formatting (dates) --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en" data-bs-theme="dark">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/bootstrap.min.css" />
    <title>Ninja Gold</title>
    <style>
        .activities {
            height: 24rem;
            overflow: auto;
        }
    </style>
</head>
<body>
    <nav class="navbar bg-body-tertiary">
        <div class="container">
            <a class="navbar-brand" href="/">Ninja Gold</a>
            <div class="d-flex justify-content-end align-items-center gap-2">
                <label for="gold" class="text-nowrap">Your Gold:</label>
                <input class="form-control" type="search" id="gold" value="${gold}" disabled>
                <a href="/reset-game" class="btn btn btn-danger text-nowrap">RESET GAME</a>
            </div>
        </div>
    </nav>
    <main class="container py-4">
        <div class="row text-center">
            <div class="col-12 col-lg-3">
                <div class="card shadow mb-3">
                    <div class="card-body">
                        <h2>Farm</h2>
                        <p class="card-text">(earns 10-20 gold)</p>
                        <form action="/process-gold" method="post">
                            <input type="hidden" name="location" value="farm" />
                             <button type="submit" class="btn btn-warning w-100">Find Gold!</button>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-12 col-lg-3">
                <div class="card shadow mb-3">
                    <div class="card-body">
                        <h2>Cave</h2>
                        <p class="card-text">(earns 5-10 gold)</p>
                        <form action="/process-gold" method="post">
                            <input type="hidden" name="location" value="cave" />
                            <button type="submit" class="btn btn-warning w-100">Find Gold!</button>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-12 col-lg-3">
                <div class="card shadow mb-3">
                    <div class="card-body">
                        <h2>House</h2>
                        <p class="card-text">(earns 2-5 gold)</p>
                        <form action="/process-gold" method="post">
                            <input type="hidden" name="location" value="house" />
                            <button type="submit" class="btn btn-warning w-100">Find Gold!</button>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-12 col-lg-3">
                <div class="card shadow mb-3">
                    <div class="card-body">
                        <h2>Quest</h2>
                        <p class="card-text">(earns/takes 0-50 gold)</p>
                        <form action="/process-gold" method="post">
                            <input type="hidden" name="location" value="quest" />
                            <button type="submit" class="btn btn-warning w-100">Find Gold!</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <section>
            <h3>Activities:</h3>
            <div class="card shadow activities">
                <div class="card-body">
                    <c:forEach var="activity" items="${activities}">
                        <p class="text-success">${activity}</p>
                    </c:forEach>
                </div>
            </div>
        </section>
    </main>
    <script src="/js/bootstrap.bundle.min.js"></script>
</body>
</html>
