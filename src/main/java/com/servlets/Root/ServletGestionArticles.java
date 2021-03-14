package com.servlets.Root;

import com.metier.GestionProduit;
import com.metier.Produit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Vector;

@WebServlet(name = "ServletGestionArticles", urlPatterns = {"/Articles", "/ServletGestionArticles"})
public class ServletGestionArticles extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GestionProduit gp = new GestionProduit();
        Vector<Produit> produits = gp.list();
        request.setAttribute("products", produits);
        request.getRequestDispatcher("/WEB-INF/vue/gestionArticles.jsp").forward(request, response);
    }
}
