<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html lang="en" data-bs-theme="dark">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <link rel="stylesheet" href="/css/bootstrap.min.css" />
  <link rel="stylesheet" href="/css/style.css" />
  <title>Upload to Amazon S3 Bucket</title>
</head>
<body>

  <nav class="navbar bg-body-tertiary">
    <div class="container d-flex justify-content-between">
      <a class="navbar-brand" href="">Upload to S3</a>
      <div class="btn-group">
        <button class="btn btn-secondary btn-sm dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
          ${user.username}
        </button>
        <ul class="dropdown-menu">
          <li><a class="dropdown-item" href="/accounts/profile">Your Profile</a></li>
          <li><a class="dropdown-item" href="/accounts/logout">Log Out</a></li>
        </ul>
      </div>
    </div>
  </nav>

  <main class="container py-5">
    <h1 class="display-4 mb-3">Your Profile</h1>
    <div class="row">
      <div class="col-12 col-lg-6">
        <div class="card shadow">
          <div class="card-body">
            <div class="d-flex align-items-center gap-3">
              <img src="${user.avatarUrl}" alt="${user.username}" class="rounded-circle avatar border border-light border-2" />
              <div>
                <h2 class="display-6 mb-0">${user.username}</h2>
                <p class="text-muted mb-0">${user.email}</p>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="col-12 col-lg-6">
        <div class="card shadow">
          <div class="card-body">
            <h3 class="card-title">Edit Your Profile</h3>

          </div>
        </div>
      </div>
    </div>
  </main>

<script src="/js/bootstrap.bundle.min.js"></script>
</body>
</html>
