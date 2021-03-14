<%@ page import="java.util.Vector" %><%--

  Created by IntelliJ IDEA.
  User: msi
  Date: 23/12/2020
  Time: 13:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.metier.Produit" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Articles</title>
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
            <a class="nav-item nav-link" href="ServletGestionUsers">Utilisateurs</a>
            <a class="nav-item nav-link active" href="ServletGestionArticles">Articles</a>
            <a class="nav-item nav-link" href="ServletDisconnect">LOGOUT</a>
        </div>
    </div>
</nav>
<!--         Article           -->
<input type="text" id="searchElement" class="form-control" placeholder="search" onkeyup="search()">
<table class="table">
    <thead class="thead-dark">
    <tr>
        <th scope="col">Code</th>
        <th scope="col">Nom</th>
        <th scope="col">Description</th>
        <th scope="col">Quantite</th>
        <th scope="col">Prix</th>
        <th scope="col">Update</th>
        <th scope="col">Delete</th>
    </tr>
    </thead>
    <tbody>
    <% Vector<Produit> produits = (Vector<Produit>) request.getAttribute("products");
        for(Produit produit : produits){%>
    <tr id="<%=produit.getCode()%>">
        <th scope="row"> <%=produit.getCode()%>
        <td><%=produit.getNom()%></td>
        <td><%=produit.getDescription()%></td>
        <td><%=produit.getQuantite()%></td>
        <td><%=produit.getPrix()%></td>
        <td><a href="ServletDeleteArticle?prodcode=<%=produit.getCode()%>">delete</a></td>
        <td><a href="ServletUpdateArticle?prodcode=<%=produit.getCode()%>">update</a></td>
    </tr>
    <% } %>
    </tbody>
</table>
<a href="ServletAddArticle"><button type="button" class="btn btn-primary">add Article</button></a>

</body>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script>
    function search(){
        input=document.getElementById("searchElement")
        filter = input.value.toUpperCase();
        ul = document.querySelector(".table");
        li = ul.getElementsByTagName("tr")
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
