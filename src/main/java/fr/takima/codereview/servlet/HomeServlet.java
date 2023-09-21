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
    private MembreService membreService = MembreService.getInstance();
    private PromotionService promotionService = PromotionService.getInstance();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try{
            request.setAttribute("listMembers", membreService.findAll());
            request.setAttribute("listPromotions", promotionService.findAll());
        }
        catch (ServiceException e){
            throw new ServletException();
        }

        this.getServletContext().getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
    }

    public void destroy() {
    }
}