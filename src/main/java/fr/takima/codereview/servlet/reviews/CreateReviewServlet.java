package fr.takima.codereview.servlet.reviews;

import fr.takima.codereview.exceptions.ServiceException;
import fr.takima.codereview.model.CodeReview;
import fr.takima.codereview.model.Member;
import fr.takima.codereview.model.Promotion;
import fr.takima.codereview.service.CodeReviewService;
import fr.takima.codereview.service.MemberService;
import fr.takima.codereview.service.PromotionService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/add_review")
public class CreateReviewServlet extends HttpServlet {
    private MemberService memberService;
    private PromotionService promotionService;
    private CodeReviewService codeReviewService;
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        this.promotionService = new PromotionService();

        try {
            request.setAttribute("listPromotions", this.promotionService.findAll());
        } catch (fr.takima.codereview.exceptions.ServiceException e) {
            throw new RuntimeException(e);
        }

        this.getServletContext().getRequestDispatcher("/WEB-INF/views/reviews/add_review.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.codeReviewService = new CodeReviewService();
        Promotion promotion;
        LocalDate start;

        String name = request.getParameter("name");
        String description = request.getParameter("description");
        start = LocalDate.parse(request.getParameter("start"));

        try {
            System.out.println(Integer.parseInt(request.getParameter( "promotion")));
            promotion= promotionService.findById(Integer.parseInt(request.getParameter( "promotion")));

        } catch (fr.takima.codereview.exceptions.ServiceException e) {
            throw new RuntimeException(e);
        }
        CodeReview codeReview = new CodeReview(name,description,start,promotion);
        try {
            codeReviewService.create( codeReview);
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }


        response.sendRedirect("/code-review-1.0-SNAPSHOT/home");
    }
    public void destroy() {
    }
}