package com.servlets.Root;

import com.metier.GestionProduit;
import com.metier.Produit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletUpdateArticle", urlPatterns = "/ServletUpdateArticle")
public class ServletUpdateArticle extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GestionProduit gp = new GestionProduit();
        int code = Integer.parseInt(request.getParameter("code"));
        String nom = request.getParameter("nom");
        String description = request.getParameter("description");
        int quantite = Integer.parseInt(request.getParameter("quantite"));
        float prix = Float.parseFloat(request.getParameter("prix"));
        gp.update(code, nom, description, quantite, prix);
        response.sendRedirect("ServletGestionArticles");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int code = Integer.parseInt(request.getParameter("prodcode"));
        GestionProduit gp = new GestionProduit();
        request.setAttribute("produit", gp.find(code));
        request.getRequestDispatcher("/WEB-INF/vue/updateProd.jsp").forward(request, response);
    }
}