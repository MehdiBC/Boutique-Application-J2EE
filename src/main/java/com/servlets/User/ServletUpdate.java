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

@WebServlet(name = "ServletUpdate", urlPatterns = {"/update", "/ServletUpdate"})
public class ServletUpdate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GestionUser gu = new GestionUser();
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        HttpSession session = request.getSession(true);
        Utilisateur user = (Utilisateur) session.getAttribute("user");
        if(request.getParameter("update")!=null) gu.update(user.getId(), nom, prenom, email, password);
        session.setAttribute("user", gu.find(email, password));
        request.getRequestDispatcher("/WEB-INF/vue/acceuil.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        if(session.getAttribute("user") == null) request.getRequestDispatcher("/WEB-INF/vue/registeration.jsp").forward(request, response);
        else request.getRequestDispatcher("/WEB-INF/vue/update.jsp").forward(request, response);
    }
}
