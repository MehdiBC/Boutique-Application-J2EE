package com.servlets.User;

import com.metier.GestionProduit;
import com.metier.Produit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Vector;

@WebServlet(name = "ServletDelete", urlPatterns = {"/DeleteArticle", "/ServletDeleteArticleFromPanier"})
public class ServletDeleteArticleFromPanier extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GestionProduit gp = new GestionProduit();
        int code = Integer.parseInt(request.getParameter("prodcode"));
        HttpSession session = request.getSession(true);
        Vector<Produit> panier = (Vector<Produit>) session.getAttribute("panier");
        for(Produit produit : panier){
            if(produit.getCode()==code){
                panier.remove(produit);
                break;
            }
        }
        response.sendRedirect("ServletArticle");
    }
}
