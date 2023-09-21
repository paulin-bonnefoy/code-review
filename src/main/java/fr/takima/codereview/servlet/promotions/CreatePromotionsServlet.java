package fr.takima.codereview.servlet.promotions;

import java.io.*;
import java.time.LocalDate;
import fr.takima.codereview.exceptions.ServiceException;

import fr.takima.codereview.model.Promotion;
import fr.takima.codereview.service.PromotionService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/promotions")
public class CreatePromotionsServlet extends HttpServlet {

    private PromotionService promotionService = PromotionService.getInstance();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        this.getServletContext().getRequestDispatcher("/WEB-INF/views/promotions/details.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name;
        name = request.getParameter("name");
        Promotion promotion = new Promotion(name);
        try {
            this.promotionService.create(promotion);
            this.getServletContext().getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
        } catch (ServiceException e) {

            throw new RuntimeException(e);
        }

    }

    public void destroy() {
    }
}