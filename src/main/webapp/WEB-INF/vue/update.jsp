<%@ page import="com.metier.Utilisateur" %><%--
  Created by IntelliJ IDEA.
  User: msi
  Date: 17/12/2020
  Time: 05:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<!--          Navbar            -->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#"><img src="https://www.biez-traiteur.com/wp-content/uploads/2018/07/logo.png" alt="logo"></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <div class="navbar-nav">
            <a class="nav-item nav-link" href="ServletLogin">ACCEUIL</a>
            <a class="nav-item nav-link active" href="ServletUpdate">UPDATE PROFILE</a>
            <a class="nav-item nav-link" href="ServletArticle">NOS ARTICLES</a>
            <a class="nav-item nav-link" href="ServletDisconnect">LOGOUT</a>
        </div>
    </div>
</nav>
<!--          Acceuil            -->
<%Utilisateur user = (Utilisateur) session.getAttribute("user");%>
<!--          Update FORM            -->
<form method="post" action="ServletUpdate">
    <div class="form-group">
        <label for="nom">Nom</label>
        <input type="text" class="form-control" name="nom" id="nom" value="<%=user.getNom()%>">
    </div>
    <div class="form-group">
        <label for="prenom">Prenom</label>
        <input type="text" class="form-control" name="prenom" id="prenom" value="<%=user.getPrenom()%>">
    </div>
    <div class="form-group">
        <label for="email">Adresse email</label>
        <input type="email" class="form-control" name="email" id="email" value="<%=user.getEmail()%>">
    </div>
    <div class="form-group">
        <label for="password">Password</label>
        <input type="password" class="form-control" name="password" id="password" value="<%=user.getPassword()%>">
    </div>
    <button type="submit" name="update" value="submit" class="btn btn-primary">Update</button>
</form>

</body>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</html>
