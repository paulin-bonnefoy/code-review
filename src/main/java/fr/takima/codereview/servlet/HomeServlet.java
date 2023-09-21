package fr.takima.codereview.servlet;

import java.io.*;

import fr.takima.codereview.exceptions.ServiceException;
import fr.takima.codereview.service.MembreService;
import fr.takima.codereview.service.PromotionService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    private String message;
    MembreService membreService = MembreService.getInstance();
    PromotionService promotionService = PromotionService.getInstance();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {

            request.setAttribute("membersCount", membreService.getCount());
            request.setAttribute("promotionsCount", promotionService.getCount());


        } catch (ServiceException e) {
            e.printStackTrace();
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
    }

    public void destroy() {
    }
}