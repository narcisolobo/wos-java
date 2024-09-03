<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%-- c:out ; c:forEach etc. --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en" data-bs-theme="dark">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="/css/bootstrap.min.css" />
    <title>The Great Number Game</title>
</head>
<body>
    <main class="container py-5">
        <h1 class="display-4 mb-3">The Great Number Game!</h1>
        <p class="lead">I'm thinking of a number between 1 and 100.</p>
        <div class="card shadow">
            <div class="card-body">
                <form action="" method="post">
                    <div class="form-floating mb-3">
                        <input
                                type="number"
                                name="number"
                                id="number"
                                min="1" max="100"
                                placeholder="Guess the number!"
                                class="form-control form-control-lg"
                                required
                        />
                        <label for="number">Guess the number!</label>
                    </div>
                    <div class="text-end">
                        <button type="submit" class="btn btn-lg btn-primary">
                            GUESS
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </main>
    <script src="/js/bootstrap.bundle.min.js"></script>
</body>
</html>
