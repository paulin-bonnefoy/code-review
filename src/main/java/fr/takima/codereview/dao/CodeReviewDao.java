
package fr.takima.codereview.dao;

        import fr.takima.codereview.connection.ConnectionManager;
        import fr.takima.codereview.exceptions.DaoException;
        import fr.takima.codereview.exceptions.ServiceException;
        import fr.takima.codereview.model.CodeReview;
        import fr.takima.codereview.model.CodeReview;
        import fr.takima.codereview.model.Promotion;
        import fr.takima.codereview.service.PromotionService;


        import java.sql.*;
        import java.time.LocalDate;
        import java.util.ArrayList;
        import java.util.List;
public class CodeReviewDao {
    public static CodeReviewDao instance;
    private static final String CREATE_CODE_REVIEW_QUERY = "INSERT INTO codeReview(name, description, datetime, promo_id) VALUES(?, ?, ?, ?);";
    private static final String DELETE_CODE_REVIEW_QUERY = "DELETE FROM codeReview WHERE id=? SET FOREIGN_KEY_CHECKS=0;";
    private static final String FIND_CODE_REVIEWS_QUERY = "SELECT name, description, datetime, promo_id FROM codeReview;";
    private static final String FIND_CODE_REVIEW_QUERY = "SELECT name, description, datetime, promo_id FROM codeReview WHERE id=?;";
    private PromotionService promotionService;


    public static CodeReviewDao getInstance() {
        if (instance == null) {
            instance = new CodeReviewDao();
        }
        return instance;
    }

    public void create() throws DaoException {
        Connection connexion = null;
        CodeReview codeReview = new CodeReview();
        try {
            connexion = ConnectionManager.getConnection();

            PreparedStatement pstmt = connexion.prepareStatement(CREATE_CODE_REVIEW_QUERY);

            pstmt.setString(1, codeReview.getName());
            pstmt.setString(2, codeReview.getDescription());
            pstmt.setString(3, String.valueOf(Date.valueOf(codeReview.getDatetime())));
            pstmt.setLong(4, codeReview.getPromotion().getId());

            pstmt.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void delete(int id) throws DaoException {
        try {
            Connection connexion = ConnectionManager.getConnection();
            PreparedStatement pstmt = connexion.prepareStatement(DELETE_CODE_REVIEW_QUERY);
            pstmt.setLong(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<CodeReview> findAll() throws DaoException {
        try {
            Connection connection = ConnectionManager.getConnection();

            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery(FIND_CODE_REVIEWS_QUERY);

            List<CodeReview> codeReviews = new ArrayList<>();

            while (rs.next()) {
                long id = rs.getLong("id");
                String name = rs.getString("name");
                String email = rs.getString("description");
                LocalDate birthdate = rs.getDate("datetime").toLocalDate();
                Promotion promotion = promotionService.findById(rs.getInt("promo_id"));
            }
            return codeReviews;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public CodeReview findById(int id) throws DaoException {

        try(Connection connection = ConnectionManager.getConnection();){

            PreparedStatement statement = connection.prepareStatement(FIND_CODE_REVIEW_QUERY);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();

            rs.next();
            String name = rs.getString("name");
            String email = rs.getString("description");
            LocalDate birthdate = rs.getDate("datetime").toLocalDate();
            Promotion promotion = promotionService.findById(rs.getInt("promo_id"));


            rs.close();
            return new CodeReview(id, name, email, birthdate, promotion);
        }
        catch (SQLException e){
            e.printStackTrace();
            throw new DaoException(e);
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
    }
}
