package fr.takima.codereview.service;


import fr.takima.codereview.dao.CodeReviewDao;
import fr.takima.codereview.exceptions.DaoException;
import fr.takima.codereview.exceptions.ServiceException;
import fr.takima.codereview.model.CodeReview;

import java.util.List;

public class CodeReviewService {

    private final CodeReviewDao codeReviewDao = CodeReviewDao.getInstance();
    private static CodeReviewService instance;
    public static CodeReviewService getInstance() {
        if (instance == null) {
            instance = new CodeReviewService();
        }
        return instance;
    }

    public void create(CodeReview codeReview) throws ServiceException {

        try{
            codeReviewDao.create(codeReview);
        }
        catch (DaoException e){
            throw new ServiceException(e);
        }
    }
    /*
    public void modify(CodeReview codeReview) throws ServiceException {

        try{
            codeReviewDao.modify(codeReview);
        }
        catch (DaoException e){
            throw new ServiceException(e);
        }
    }*/

    public void delete(int id) throws ServiceException {

        try{
            codeReviewDao.delete(id);
        }
        catch (DaoException e){
            throw new ServiceException(e);
        }
    }

    public CodeReview findById(int id) throws ServiceException {

        try{
            return (codeReviewDao.findById(id));
        }
        catch (DaoException e){
            throw new ServiceException(e);
        }
    }
    public List<CodeReview> findAll() throws ServiceException {

        try{
            return (codeReviewDao.findAll());
        }
        catch (DaoException e){
            throw new ServiceException(e);
        }
    }
    /*
    public int getCount() throws ServiceException {

        try{
            return (codeReviewDao.getCount());
        }
        catch (DaoException e){
            throw new ServiceException(e);
        }
    }*/
}
