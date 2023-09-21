package fr.takima.codereview.servlet.reviews;

import com.google.protobuf.ServiceException;
import fr.takima.codereview.model.CodeReview;
import fr.takima.codereview.model.Member;
import fr.takima.codereview.model.Promotion;
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
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/views/reviews/details.jsp").forward(request, response);
    }
/*
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Member member;
        Promotion promotion;
        LocalDate start;

        try {
            member = memberService.findById(Long.parseLong(request.getParameter("member")));
             promotion= promotionService.findById(Long.parseLong(request.getParameter( promotion)));
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }

        start = LocalDate.parse(request.getParameter("start"));
        end = LocalDate.parse(request.getParameter("end"));

        CodeReview codeReview = new CodeReview(member promotion,end,start);

        try {
            this.codeReviewService.create(codeReview);
            response.sendRedirect("http://localhost:8080/rentmanager/rents");
        } catch (ServiceException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    public void destroy() {
    } */
}