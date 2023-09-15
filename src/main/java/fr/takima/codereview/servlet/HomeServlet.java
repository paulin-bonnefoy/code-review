package fr.takima.codereview.servlet;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello plp!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        this.getServletContext().getRequestDispatcher("/resources/views/home.jsp").forward(request, response);
    }

    public void destroy() {
    }
}