package fr.takima.codereview.main;

import fr.takima.codereview.exceptions.DaoException;
import fr.takima.codereview.exceptions.ServiceException;
import fr.takima.codereview.model.Member;
import fr.takima.codereview.service.MembreService;

import java.time.LocalDate;

public class main {

    static MembreService membreService = MembreService.getInstance();

    public static void main(String args[]) throws ServiceException {

        Member paul = new Member(8, "Paul", "paul@takima.fr", LocalDate.now(), 2);
        System.out.println(paul.toString());
        membreService.create(paul);

        System.out.println(membreService.findById(8));

        membreService.delete(8);

    }
}