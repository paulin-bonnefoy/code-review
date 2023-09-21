package fr.takima.codereview.servlet.members;

import java.io.*;
import java.time.LocalDate;

import fr.takima.codereview.exceptions.ServiceException;
import fr.takima.codereview.model.Member;
import fr.takima.codereview.model.Promotion;
import fr.takima.codereview.service.MemberService;
import fr.takima.codereview.service.PromotionService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/members")
public class CreateMembersServlet extends HttpServlet {
    private String message;
    private PromotionService promotionService = PromotionService.getInstance();
    private MemberService memberService = MemberService.getInstance();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


        this.promotionService = new PromotionService();

        try {
            request.setAttribute("listPromotions", this.promotionService.findAll());
            this.getServletContext().getRequestDispatcher("/WEB-INF/views/members/details.jsp").forward(request, response);
        } catch (fr.takima.codereview.exceptions.ServiceException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name;
        name = request.getParameter("name");
        String email = request.getParameter("email");
        LocalDate birthdate = LocalDate.parse(request.getParameter("birthdate"));
        try {
            Promotion promotion = promotionService.findById(Integer.parseInt(request.getParameter("promotion")));
            memberService.create(new Member(name,email,birthdate,promotion));
            this.getServletContext().getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }



    }

    public void destroy() {
    }
}