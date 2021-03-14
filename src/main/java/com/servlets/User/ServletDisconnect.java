package com.servlets.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ServletDisconnect", urlPatterns = {"/disconnect", "/ServletDisconnect"})
public class ServletDisconnect extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        session.removeAttribute("user");
        request.getRequestDispatcher("/WEB-INF/vue/connexion.jsp").forward(request, response);
    }
}
