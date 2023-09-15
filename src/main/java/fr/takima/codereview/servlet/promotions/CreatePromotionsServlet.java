package fr.takima.codereview.servlet.promotions;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/promotions")
public class CreatePromotionsServlet extends HttpServlet {
    private String message;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/views/promotions/details.jsp").forward(request, response);
    }

    public void destroy() {
    }
}