package fr.takima.codereview.service;


import fr.takima.codereview.dao.MemberDao;
import fr.takima.codereview.exceptions.DaoException;
import fr.takima.codereview.exceptions.ServiceException;
import fr.takima.codereview.model.Member;

public class MemberService {

    private MemberDao memberDao = MemberDao.getInstance();
    public static MemberService instance;
    public static MemberService getInstance() {
        if (instance == null) {
            instance = new MemberService();
        }
        return instance;
    }

    public void create(Member member) throws ServiceException {

        try{
            memberDao.create(member);
        }
        catch (DaoException e){
            throw new ServiceException(e);
        }
    }

    public void modify(Member member) throws ServiceException {

        try{
            memberDao.modify(member);
        }
        catch (DaoException e){
            throw new ServiceException(e);
        }
    }

    public void delete(int id) throws ServiceException {

        try{
            memberDao.delete(id);
        }
        catch (DaoException e){
            throw new ServiceException(e);
        }
    }

    public Member findById(int id) throws ServiceException {
        
        try{
            return (memberDao.findById(id));
        }
        catch (DaoException e){
            throw new ServiceException(e);
        }
    }

    public int getCount() throws ServiceException {

        try{
            return (memberDao.getCount());
        }
        catch (DaoException e){
            throw new ServiceException(e);
        }
    }
}
