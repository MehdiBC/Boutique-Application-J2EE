<%@ page import="com.metier.Utilisateur" %>
<%@ page import="java.util.Vector" %><%--
  Created by IntelliJ IDEA.
  User: msi
  Date: 23/12/2020
  Time: 09:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gestion Utilisateurs</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<!--         Navbar           -->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#"><img src="https://www.biez-traiteur.com/wp-content/uploads/2018/07/logo.png" alt="logo"></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <div class="navbar-nav">
            <a class="nav-item nav-link active" href="ServletGestionUsers">Utilisateurs</a>
            <a class="nav-item nav-link" href="ServletGestionArticles">Articles</a>
            <a class="nav-item nav-link" href="ServletDisconnect">LOGOUT</a>
        </div>
    </div>
</nav>
<!--         Users           -->
<input type="text" class="form-control" id="search" onkeyup="search()" placeholder="Search">
<table class="table" id="myTable">
    <thead class="thead-dark">
    <tr>
        <th scope="col">Id</th>
        <th scope="col">Nom</th>
        <th scope="col">Prenom</th>
        <th scope="col">Email</th>
        <th scope="col">Password</th>
        <th scope="col">Update</th>
        <th scope="col">Delete</th>
    </tr>
    </thead>
    <tbody>
    <% Vector<Utilisateur> users = (Vector<Utilisateur>) request.getAttribute("users");
        for(Utilisateur user : users){%>
    <tr>
        <td><%=user.getId()%></td>
        <td><%=user.getNom()%></td>
        <td><%=user.getPrenom()%></td>
        <td><%=user.getEmail()%></td>
        <td><%=user.getPassword()%></td>
        <td><a href="ServletDeleteUser?userid=<%=user.getId()%>">delete</a></td>
        <td><a href="ServletUpdateUser?userid=<%=user.getId()%>">update</a></td>
    </tr>
    <% } %>
    </tbody>
</table>
<a href="ServletAddUser"><button type="button" class="btn btn-primary">add User</button></a>

</body>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script>
    function search(){
        var input, filter, table, tr, td, i, txtValue;
        input = document.getElementById("search");
        filter = input.value.toUpperCase();
        table = document.getElementById("myTable");
        tr = table.getElementsByTagName("tr");

        // Loop through all table rows, and hide those who don't match the search query
        for (i = 0; i < tr.length; i++) {
            td = tr[i].getElementsByTagName("td")[1];
            if (td) {
                txtValue = td.textContent || td.innerText;
                if (txtValue.toUpperCase().indexOf(filter) > -1) {
                    tr[i].style.display = "";
                } else {
                    tr[i].style.display = "none";
                }
            }
        }
    }
</script>
</html>
