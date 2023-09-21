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

        Member paul = new Member(8,"Paul", "paul@takima.fr", LocalDate.now(), 2);
        System.out.println(paul.toString());

        //membreService.create(paul);
        System.out.println(membreService.findById(3));
        membreService.delete(8);

        Promotion P2024 = new Promotion("P2024");

        promotionService.create(P2024);
        System.out.println(promotionService.findById(3));
        promotionService.delete(4);

        System.out.println(membreService.findAll());
    }
}