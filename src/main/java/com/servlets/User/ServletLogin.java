package com.servlets.User;

import com.metier.GestionUser;
import com.metier.Utilisateur;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ServletLogin", urlPatterns = {"/", "/ServletLogin"})
public class ServletLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GestionUser gu = new GestionUser();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Utilisateur user = gu.find(email, password);
        if(user == null)  request.getRequestDispatcher("/WEB-INF/vue/registeration.jsp");
        else {
            HttpSession session = request.getSession(true);
            session.setAttribute("user", user);
            if(user.getId() != 1) request.getRequestDispatcher("/WEB-INF/vue/acceuil.jsp").forward(request, response);
            else response.sendRedirect("ServletGestionUsers");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        if(session.getAttribute("user") == null) request.getRequestDispatcher("/WEB-INF/vue/connexion.jsp").forward(request, response);
        else {
            Utilisateur user = (Utilisateur) session.getAttribute("user");
            if(user.getId() != 1) request.getRequestDispatcher("/WEB-INF/vue/acceuil.jsp").forward(request, response);
            else response.sendRedirect("ServletGestionUsers");
        }

    }
}
