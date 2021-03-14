package com.servlets.Root;

import com.metier.GestionProduit;
import com.metier.GestionUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ServletAddArticle", urlPatterns = {"/addArticle", "/ServletAddArticle"})
public class ServletAddArticle extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GestionProduit gp = new GestionProduit();
        int code = Integer.parseInt(request.getParameter("code"));
        String nom = request.getParameter("nom");
        String description = request.getParameter("description");
        int quantite = Integer.parseInt(request.getParameter("quantite"));
        float prix = Float.parseFloat(request.getParameter("prix"));
        gp.add(code, nom, description, quantite, prix);
        response.sendRedirect("ServletGestionArticles");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/vue/addArticle.jsp").forward(request, response);
    }
}
