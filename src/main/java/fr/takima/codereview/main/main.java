package fr.takima.codereview.main;

import fr.takima.codereview.dao.MemberDao;
import fr.takima.codereview.exceptions.DaoException;
import fr.takima.codereview.model.Member;

import java.time.LocalDate;

public class main {

    static MemberDao memberDao = MemberDao.getInstance();

    public static void main(String args[]) throws DaoException {

//        Member paul = new Member(8, "Paul", "paul@takima.fr", LocalDate.now(), 2);
//        System.out.println(paul.toString());
//        memberDao.create(paul);

        System.out.println(memberDao.findById(8));

    }
}