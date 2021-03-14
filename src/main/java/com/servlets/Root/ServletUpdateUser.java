package com.servlets.Root;

import com.metier.GestionUser;
import com.metier.Utilisateur;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ServletUpdateUser", urlPatterns = {"/ServletUpdateUser"})
public class ServletUpdateUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GestionUser gu = new GestionUser();
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Utilisateur user = gu.find(Integer.parseInt(request.getParameter("id")));
        if(request.getParameter("update")!=null) gu.update(user.getId(), nom, prenom, email, password);
        response.sendRedirect("ServletGestionUsers");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("userid"));
        GestionUser gu = new GestionUser();
        Utilisateur user = gu.find(id);
        request.setAttribute("user", user);
        request.getRequestDispatcher("/WEB-INF/vue/updateUser.jsp").forward(request, response);
    }
}
