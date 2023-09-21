
package fr.takima.codereview.dao;

        import fr.takima.codereview.connection.ConnectionManager;
        import fr.takima.codereview.exceptions.DaoException;
        import fr.takima.codereview.exceptions.ServiceException;
        import fr.takima.codereview.model.CodeReview;
        import fr.takima.codereview.model.Promotion;


        import java.sql.*;
        import java.time.LocalDate;
        import java.util.ArrayList;
        import java.util.List;
public class CodeReviewDao {

    private static final String CREATE_CODE_REVIEW_QUERY = "INSERT INTO codeReview(name, description, datetime, promo_id) VALUES(?, ?, ?, ?);";
    private static final String DELETE_CODE_REVIEW_QUERY = "DELETE FROM codeReview WHERE id=? SET FOREIGN_KEY_CHECKS=0;";
    private static final String FIND_CODE_REVIEWS_QUERY = "SELECT name, description, datetime, promo_promo_id FROM codeReview;";
    public void create(CodeReview codeReview) throws DaoException {
        Connection connexion = null;
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

    public void delete(CodeReview codeReview) throws DaoException {
        try {
            Connection connexion = ConnectionManager.getConnection();
            PreparedStatement pstmt = connexion.prepareStatement(DELETE_CODE_REVIEW_QUERY);

            pstmt.setLong(1, codeReview.getId());
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
                String description = rs.getString("description");
                LocalDate datetime = rs.getDate("debut").toLocalDate();
                //Promotion promotion = servicePromotion.findById(rs.getLong('id_promo'));
                //codeReviews.add(new CodeReview(id, name, description, datetime, promotion));
            }
            return codeReviews;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
