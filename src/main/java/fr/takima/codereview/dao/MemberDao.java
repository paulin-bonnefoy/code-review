package fr.takima.codereview.dao;

import fr.takima.codereview.connection.ConnectionManager;
import fr.takima.codereview.exceptions.DaoException;
import fr.takima.codereview.model.Member;

import java.sql.*;
import java.time.LocalDate;

public class MemberDao {

    public static MemberDao instance;

    private static final String CREATE_MEMBER_QUERY = "INSERT INTO member(name, email, birthdate, idmember, promo_promo_id) VALUES(?, ?, ?, ?, ?);";
    private static final String MODIFY_MEMBER_QUERY = "UPDATE member SET name=?, email=?, birthdate=?, idmember=?, promo_promo_id=? WHERE idmember=?;";
    private static final String DELETE_MEMBER_QUERY = "DELETE FROM member WHERE idmember=?;";
    private static final String FIND_MEMBER_QUERY = "SELECT name, email, birthdate, idmember, promo_promo_id FROM member WHERE idmember=?;";
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

    public void modify(Member member) throws DaoException {

        try(Connection connection = ConnectionManager.getConnection();){

            PreparedStatement statement = connection.prepareStatement(MODIFY_MEMBER_QUERY);

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

    public void delete(long id) throws DaoException {

        try(Connection connection = ConnectionManager.getConnection();){
            PreparedStatement statement = connection.prepareStatement(DELETE_MEMBER_QUERY);
            statement.setLong(1, id);

            statement.execute();

            connection.close();
            statement.close();
        }
        catch (SQLException e){
            e.printStackTrace();
            throw new DaoException(e);
        }
    }

    public Member findById(int id) throws DaoException {

        try(Connection connection = ConnectionManager.getConnection();){

            PreparedStatement statement = connection.prepareStatement(FIND_MEMBER_QUERY);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();

            rs.next();
            String name = rs.getString("name");
            String email = rs.getString("email");
            LocalDate birthdate = rs.getDate("birthdate").toLocalDate();
            int promo_promo_id = rs.getInt("promo_promo_id");

            rs.close();
            return new Member(id, name, email, birthdate, promo_promo_id);
        }
        catch (SQLException e){
            e.printStackTrace();
            throw new DaoException(e);
        }
    }

    public int getCount() throws DaoException {

        try(Connection connection = ConnectionManager.getConnection();){

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(COUNT_MEMBER_QUERY);

            rs.next();
            int count = rs.getInt("total");

            return count;
        }
        catch (SQLException e){
            e.printStackTrace();
            throw new DaoException(e);
        }
    }

}
