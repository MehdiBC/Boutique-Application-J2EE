package com.servlets.User;

import com.metier.GestionProduit;
import com.metier.GestionUser;
import com.metier.Produit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Vector;

@WebServlet(name = "ServletArticle", urlPatterns = {"/article", "/ServletArticle"})
public class ServletArticle extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        if(session.getAttribute("user")==null) request.getRequestDispatcher("/WEB-INF/vue/registeration.jsp").forward(request, response);
        else {
            GestionProduit gp = new GestionProduit();
            Vector<Produit> produits = null;
            if (request.getParameter("sort") != null) produits = gp.sort();
            else produits = gp.list();
            Vector<Produit> panier = (Vector<Produit>)session.getAttribute("panier");
            if(panier==null) panier=new Vector<Produit>();
            if(request.getParameter("prodcode")!=null) {
                Produit produit = gp.find(Integer.parseInt(request.getParameter("prodcode")));
                panier.add(produit);
                session.setAttribute("panier", panier);
            }
            request.setAttribute("products", produits);
            request.getRequestDispatcher("/WEB-INF/vue/article.jsp").forward(request, response);
        }
    }
}
