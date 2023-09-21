package fr.takima.codereview.servlet.reviews;

import fr.takima.codereview.exceptions.ServiceException;
import fr.takima.codereview.model.CodeReview;
import fr.takima.codereview.service.CodeReviewService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/review")
public class ReviewServlet extends HttpServlet {
    private CodeReviewService codeReviewService;
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        this.codeReviewService = new CodeReviewService();
        CodeReview codeReview = null;
        try {
            codeReview = codeReviewService.findById(id);
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("codeReview", codeReview);
        this.getServletContext().getRequestDispatcher("/WEB-INF/views/reviews/details.jsp").forward(request, response);
    }

    public void destroy() {
    }
}
