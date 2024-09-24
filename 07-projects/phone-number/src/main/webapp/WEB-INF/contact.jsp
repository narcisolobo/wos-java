<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html lang="en" data-bs-theme="dark">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous"/>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/intl-tel-input@24.5.0/build/css/intlTelInput.css"/>
    <title>Phone Number</title>
    <style>
        .textarea {
            height: 7rem !important;
        }
    </style>
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
                        <a class="nav-link active" aria-current="page" href="/contact">Contact Us</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <main class="container py-5">
        <h1 class="display-1 mb-3">Contact Us</h1>
        <div class="card shadow">
            <div class="card-body">
                <form:form action="/contact" method="post" modelAttribute="contactForm">
                    <div class="row mb-3">
                        <div class="col">
                            <form:label path="name" cssClass="form-label">Your name:</form:label>
                            <form:input path="name" cssClass="form-control" placeholder="Kermit the Frog" />
                            <form:errors path="name" element="div" cssClass="form-text text-warning" />
                        </div>
                        <div class="col-auto">
                            <form:label path="phoneNumber" type="tel" cssClass="form-label d-block">Phone number:</form:label>
                            <form:input path="phoneNumber" cssClass="form-control" />
                            <form:errors path="phoneNumber" element="div" cssClass="form-text text-warning" />
                        </div>
                    </div>
                    <div class="mb-3">
                        <form:label path="message" type="tel" cssClass="form-label">Message:</form:label>
                        <form:textarea path="message" cssClass="form-control textarea" />
                        <form:errors path="message" element="div" cssClass="form-text text-warning" />
                    </div>
                    <div class="text-end">
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </div>
                </form:form>
            </div>
        </div>
    </main>
    <script src="https://cdn.jsdelivr.net/npm/intl-tel-input@24.5.0/build/js/intlTelInput.min.js"></script>
    <script>
        const phoneInput = document.querySelector("#phoneNumber");
        const iti = window.intlTelInput(phoneInput, {
            utilsScript: "https://cdn.jsdelivr.net/npm/intl-tel-input@24.5.0/build/js/utils.js",
            allowDropdown: false,
            initialCountry: "us"
        });

        phoneInput.addEventListener('input', () => {
            const number = iti.getNumber();
            console.log(number);
        })
    </script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
