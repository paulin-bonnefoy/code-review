package fr.takima.codereview.service;

import fr.takima.codereview.dao.MemberDao;
import fr.takima.codereview.dao.PromotionDao;
import fr.takima.codereview.exceptions.DaoException;
import fr.takima.codereview.exceptions.ServiceException;
import fr.takima.codereview.model.Member;
import fr.takima.codereview.model.Promotion;

import java.util.List;

public class PromotionService {

    private PromotionDao promotionDao = PromotionDao.getInstance();
    public static PromotionService instance;
    public static PromotionService getInstance() {
        if (instance == null) {
            instance = new PromotionService();
        }
        return instance;
    }

    public void create(Promotion promotion) throws ServiceException {

        try{
            promotionDao.create(promotion);
        }
        catch (DaoException e){
            throw new ServiceException(e);
        }
    }

    public void modify(Promotion promotion) throws ServiceException {

        try{
            promotionDao.modify(promotion);
        }
        catch (DaoException e){
            throw new ServiceException(e);
        }
    }

    public void delete(int id) throws ServiceException {

        try{
            promotionDao.delete(id);
        }
        catch (DaoException e){
            throw new ServiceException(e);
        }
    }

    public Promotion findById(int id) throws ServiceException {

        try{
            return (promotionDao.findById(id));
        }
        catch (DaoException e){
            throw new ServiceException(e);
        }
    }

    public List<Promotion> findAll() throws ServiceException {

        try{
            return (promotionDao.findAll());
        }
        catch (DaoException e){
            throw new ServiceException(e);
        }
    }

    public int getCount() throws ServiceException {

        try{
            return (promotionDao.getCount());
        }
        catch (DaoException e){
            throw new ServiceException(e);
        }
    }

}
