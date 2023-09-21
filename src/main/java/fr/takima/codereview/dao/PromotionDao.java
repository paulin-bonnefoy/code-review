package fr.takima.codereview.dao;

import fr.takima.codereview.connection.ConnectionManager;
import fr.takima.codereview.exceptions.DaoException;
import fr.takima.codereview.model.Promotion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PromotionDao {
    private static PromotionDao instance = null;
    private PromotionDao() {}
    public static PromotionDao getInstance() {
        if(instance == null) {
            instance = new PromotionDao();
        }
        return instance;
    }

    private static final String CREATE_PROMOTION_QUERY = "INSERT INTO promo(name) VALUES (?);";
    private static final String DELETE_PROMOTION_QUERY = "DELETE FROM promo WHERE id=?;";
    private static final String FIND_PROMOTION_QUERY = "SELECT id, name FROM promo WHERE id=?;";
    private static final String FIND_PROMOTIONS_QUERY = "SELECT id, name FROM promo ORDER BY id DESC;";
    private static final String MODIFY_PROMOTION_QUERY = "UPDATE promo SET name=? WHERE id=?;";
    private static final String COUNT_PROMOTION_QUERY = "SELECT COUNT(*) AS total FROM promo;";





    public void create(Promotion promo) throws DaoException {

        try(Connection connection = ConnectionManager.getConnection();){

            PreparedStatement statement = connection.prepareStatement(CREATE_PROMOTION_QUERY);

            statement.setString(1, promo.getName());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DaoException(e);
        }
    }
    public long delete(int id) throws DaoException {

        try(Connection connection = ConnectionManager.getConnection();){

            PreparedStatement statement = connection.prepareStatement(DELETE_PROMOTION_QUERY);

            statement.setInt(1, id);

            return statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DaoException(e);
        }
    }
    public Promotion findById(int id) throws DaoException {

        try(Connection connection = ConnectionManager.getConnection();){

            PreparedStatement statement = connection.prepareStatement(FIND_PROMOTION_QUERY);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();

            rs.next();
            String name = rs.getString("name");

            rs.close();
            return new Promotion(id, name);
        }
        catch (SQLException e){
            e.printStackTrace();
            throw new DaoException(e);
        }
    }

    public List<Promotion> findAll() throws DaoException {

        List<Promotion> promotions = new ArrayList<Promotion>();

        try(Connection connection = ConnectionManager.getConnection();){

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(FIND_PROMOTIONS_QUERY);

            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");

                Promotion promotion = new Promotion(id, name);
                promotions.add(promotion);
            }

            return promotions;
        }
        catch (SQLException e){
            e.printStackTrace();
            throw new DaoException(e);
        }
    }

    public int getCount() throws DaoException {

        try(Connection connection = ConnectionManager.getConnection();){

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(COUNT_PROMOTION_QUERY);

            rs.next();
            int count = rs.getInt("total");

            return count;
        }
        catch (SQLException e){
            e.printStackTrace();
            throw new DaoException(e);
        }
    }

    public void modify(Promotion promotion) throws DaoException {

        try(Connection connection = ConnectionManager.getConnection();){

            PreparedStatement statement = connection.prepareStatement(MODIFY_PROMOTION_QUERY);

            statement.setString(1, promotion.getName());

            statement.execute();
        }
        catch (SQLException e){
            e.printStackTrace();
            throw new DaoException(e);
        }
    }

}