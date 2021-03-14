package com.servlets.Root;

import com.metier.GestionUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletDeleteUser", urlPatterns = {"/deleteUser", "/ServletDeleteUser"})
public class ServletDeleteUser extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("userid"));
        GestionUser gu = new GestionUser();
        gu.delete(id);
        response.sendRedirect("ServletGestionUsers");
    }
}
