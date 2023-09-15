
package fr.takima.codereview.dao;

        import fr.takima.codereview.model.CodeReview;


        import java.time.LocalDate;
        import java.util.ArrayList;
        import java.util.List;
public class CodeReviewDao {

    private static final String CREATE_CODE_REVIEW_QUERY = "INSERT INTO codeReview(name, description, datetime, promo_promo_id) VALUES(?, ?, ?, ?);";
    private static final String DELETE_CODE_REVIEW_QUERY = "DELETE FROM codeReview WHERE id=? SET FOREIGN_KEY_CHECKS=0;";
    private static final String FIND_CODE_REVIEWS_QUERY = "SELECT name, description, datetime, promo_promo_id FROM codeReview;";
    public void create(CodeReview codeReview) throws DaoException {
        Connection connexion = null;
        try {
            connexion = ConnectionManager.getConnection();

            PreparedStatement pstmt = connexion.prepareStatement(CREATE_CODE_REVIEW_QUERY);

            pstmt.setString(1, codeReview.getName());
            pstmt.setString(2, codeReview.getDescription());
            pstmt.setString(3, Date.valueOf(codeReview.getDatetime()));
            pstmt.setDate(4, codeReview.getPromo().getId());

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
                String name = rs.getName("name");
                String description = rs.getDescription("description");
                LocalDate datetime = rs.getDate("debut").toLocalDate();
                int promo_promo_id = CodeReview.getPromo().getId();

                codeReviews.add(new CodeReview(id, name, description, datetime, promo_promo_id));
            }
            return codeReviews;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
