<%@ page import="com.metier.Produit" %>
<%@ page import="java.util.Vector" %><%--
  Created by IntelliJ IDEA.
  User: msi
  Date: 17/12/2020
  Time: 06:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Article</title>
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
            <a class="nav-item nav-link" href="ServletUpdate">UPDATE PROFILE</a>
            <a class="nav-item nav-link" href="ServletArticle">NOS ARTICLES</a>
            <a class="nav-item nav-link" href="ServletDisconnect">LOGOUT</a>
        </div>
    </div>
</nav>
<!--         Article           -->
<h1>Articles</h1>
<input type="text" id="searchElement" class="form-control" placeholder="search" onkeyup="search()">
<table class="table">
    <thead class="thead-dark">
    <tr>
        <th scope="col">Code</th>
        <th scope="col">Nom</th>
        <th scope="col">Description</th>
        <th scope="col">Quantite</th>
        <th scope="col">Prix</th>
        <th scope="col">Ajout Panier</th>
    </tr>
    </thead>
    <tbody>
    <% Vector<Produit> produits = (Vector<Produit>) request.getAttribute("products");
    for(Produit produit : produits){%>
        <tr>
            <th scope="row"> <%=produit.getCode()%>
            <td><%=produit.getNom()%></td>
            <td><%=produit.getDescription()%></td>
            <td><%=produit.getQuantite()%></td>
            <td><%=produit.getPrix()%></td>
            <td><a href="ServletArticle?prodcode=<%=produit.getCode()%>"><button type="button" class="btn btn-link">ajouter panier</button></a></td>
        </tr>
    <% } %>
    </tbody>
</table>
<div>
<a href="ServletArticle?sort=sort"><button type="button" class="btn btn-primary" style="position: absolute; right: 10%;">sort by prix</button></a>
</div>
<br>
<br>
<h1>Panier</h1>
<table class="table">
    <thead class="thead-dark">
    <tr>
        <th scope="col">Code</th>
        <th scope="col">Nom</th>
        <th scope="col">Description</th>
        <th scope="col">Quantite</th>
        <th scope="col">Prix</th>
        <th scope="col">Delete</th>
    </tr>
    </thead>
    <tbody class="pannier">
    <% Vector<Produit> panier = (Vector<Produit>)session.getAttribute("panier");
        if(panier!=null) for(Produit produit : panier){%>
    <tr>
        <th scope="row"> <%=produit.getCode()%>
        <td><%=produit.getNom()%></td>
        <td><%=produit.getDescription()%></td>
        <td><%=produit.getQuantite()%></td>
        <td><%=produit.getPrix()%></td>
        <td><a href="ServletDeleteArticleFromPanier?prodcode=<%=produit.getCode()%>"><button type="button" class="btn btn-link">delete</button></a></td>
    </tr>
    <% } %>
    </tbody>
</table>
</body>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script>
    function search(){
        input=document.getElementById("searchElement")
        filter = input.value.toUpperCase();
        ul = document.querySelector(".table");
        li = ul.getElementsByTagName("tr");
        for (i = 1; i < li.length; i++) {
            a = li[i]
            console.log(a)
            b=a.querySelector("td")
            console.log(b)
            a=b
            // a=a.querySelector("td")
            txtValue = a.textContent || a.innerText;
            if (txtValue.toUpperCase().indexOf(filter) > -1) {
                li[i].style.display = "";
            }
            else {
                li[i].style.display = "none";
            }
        }
    }
</script>
</html>