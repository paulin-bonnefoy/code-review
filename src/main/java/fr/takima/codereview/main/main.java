package fr.takima.codereview.main;

import fr.takima.codereview.exceptions.ServiceException;
import fr.takima.codereview.model.Member;
import fr.takima.codereview.model.Promotion;
import fr.takima.codereview.service.MemberService;
import fr.takima.codereview.service.PromotionService;

import java.time.LocalDate;

public class main {

    static MemberService membreService = MemberService.getInstance();
    static PromotionService promotionService = PromotionService.getInstance();

    public static void main(String args[]) throws ServiceException {
        System.out.println("test");

    }
}