package fr.takima.codereview.dao;

import fr.takima.codereview.connection.ConnectionManager;
import fr.takima.codereview.exceptions.DaoException;
import fr.takima.codereview.model.Member;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MemberDao {

    public static MemberDao instance;

    private static final String CREATE_MEMBER_QUERY = "INSERT INTO member(name, email, birthdate, idmember, promo_promo_id) VALUES(?, ?, ?, ?, ?);";
    private static final String MODIFY_MEMBER_QUERY = "UPDATE member SET name=?, email=?, birthdate=?, idmember=?, promo_promo_id=? WHERE id=?;";
    private static final String DELETE_MEMBER_QUERY = "DELETE FROM member WHERE id=?;";
    private static final String FIND_MEMBER_QUERY = "SELECT name, email, birthdate, idmember, promo_promo_id FROM member WHERE id=?;";
    private static final String COUNT_MEMBER_QUERY = "SELECT COUNT(*) AS total FROM member;";

    public static MemberDao getInstance() {
        if (instance == null) {
            instance = new MemberDao();
        }
        return instance;
    }

    public void create(Member member) throws DaoException {

        try(Connection connection = ConnectionManager.getConnection();){

            PreparedStatement statement = connection.prepareStatement(CREATE_MEMBER_QUERY);

            statement.setString(1, member.getName());
            statement.setString(2, member.getEmail());
            statement.setDate(3, Date.valueOf(member.getBirthDate()));
            statement.setInt(4, member.getId());
            statement.setInt(5, member.getId_promotion());

            statement.execute();
        }
        catch (SQLException e){
            e.printStackTrace();
            throw new DaoException(e);
        }
    }

}
