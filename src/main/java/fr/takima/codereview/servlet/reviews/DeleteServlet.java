package fr.takima.codereview.servlet.reviews;

import fr.takima.codereview.exceptions.ServiceException;
import fr.takima.codereview.service.CodeReviewService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/review/delete")
public class DeleteServlet extends HttpServlet {
    private CodeReviewService codeReviewService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.codeReviewService = new CodeReviewService();
        try {

            int id = Integer.parseInt(request.getParameter("id"));

            this.codeReviewService.delete(id);

        } catch (ServiceException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/code-review-1.0-SNAPSHOT/home");

    }

    public void destroy() {
    }
}
