<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html lang="en" data-bs-theme="dark">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/intl-tel-input@24.5.0/build/css/intlTelInput.css"/>
    <title>Mail Sender</title>
</head>
<body>
    <main class="container py-5">
        <c:if test="${message.equals('success')}">
            <div class="alert alert-success alert-dismissible fade show" role="alert">
                <p class="mb-0">Your message was sent successfully.</p>
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        </c:if>
        <div class="card shadow">
            <div class="card-body">
                <form:form action="/contact" method="post" modelAttribute="contactForm">
                    <div class="row mb-3">
                        <div class="col">
                            <form:label path="firstName" cssClass="form-label">First name:</form:label>
                            <form:input path="firstName" cssClass="form-control" placeholder="Kermit" />
                            <form:errors path="firstName" element="div" cssClass="form-text text-warning" />
                        </div>
                        <div class="col">
                            <form:label path="lastName" cssClass="form-label">Last name:</form:label>
                            <form:input path="lastName" cssClass="form-control" placeholder="the Frog" />
                            <form:errors path="lastName" element="div" cssClass="form-text text-warning" />
                        </div>
                    </div>
                    <div class="row mb-3">
                        <div class="col">
                            <form:label path="email" cssClass="form-label">Email address:</form:label>
                            <form:input path="email" cssClass="form-control" placeholder="kermit@thefrog.com" />
                            <form:errors path="email" element="div" cssClass="form-text text-warning" />
                        </div>
                        <div class="col-auto">
                            <form:label path="phoneNumber" cssClass="form-label d-block">Phone number:</form:label>
                            <form:input path="phoneNumber" type="tel" cssClass="form-control" placeholder="(213) 555-1234" />
                            <form:errors path="phoneNumber" element="div" cssClass="form-text text-warning" />
                        </div>
                    </div>
                    <div class="row mb-3">
                        <div class="col">
                            <form:label path="text" cssClass="form-label">Message:</form:label>
                            <form:textarea path="text" cssClass="form-control" />
                            <form:errors path="text" element="div" cssClass="form-text text-warning" />
                        </div>
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
