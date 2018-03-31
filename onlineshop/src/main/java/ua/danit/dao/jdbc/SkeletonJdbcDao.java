package ua.danit.dao.jdbc;

import java.sql.*;

public abstract class SkeletonJdbcDao {


    public ResultSet getResultSetBySqlQuery(String sql) throws SQLException {
        try (Connection connection = getDataSource()){
            Statement statement = connection.createStatement();
            return statement.executeQuery(sql);

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    abstract Connection getDataSource() throws SQLException;
}
