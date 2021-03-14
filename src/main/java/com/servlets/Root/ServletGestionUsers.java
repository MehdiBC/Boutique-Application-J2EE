package com.servlets.Root;

import com.metier.GestionUser;
import com.metier.Utilisateur;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Vector;

@WebServlet(name = "ServletGestionUsers", urlPatterns = {"/Users", "/ServletGestionUsers"})
public class ServletGestionUsers extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GestionUser gu = new GestionUser();
        Vector<Utilisateur> users = gu.list();
        request.setAttribute("users", users);
        request.getRequestDispatcher("/WEB-INF/vue/gestionUsers.jsp").forward(request, response);
    }
}
