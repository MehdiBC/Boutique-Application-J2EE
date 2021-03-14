package com.servlets.Root;

import com.metier.GestionProduit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletDeleteArticle", urlPatterns = "/ServletDeleteArticle")
public class ServletDeleteArticle extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int code = Integer.parseInt(request.getParameter("prodcode"));
        GestionProduit gp = new GestionProduit();
        gp.delete(code);
        response.sendRedirect("ServletGestionArticles");
    }
}
