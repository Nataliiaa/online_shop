package ua.danit.dao.jdbc;

import ua.danit.dao.CommentDao;
import ua.danit.dao.DataSource;
import ua.danit.mappers.Mapper;
import ua.danit.model.Comment;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CommentJdbcDao extends SkeletonJdbcDao implements CommentDao {

    private final DataSource dataSource;
    private final Mapper<Comment> mapper;

    public CommentJdbcDao(DataSource dataSource, Mapper<Comment> mapper) {
        this.dataSource = dataSource;
        this.mapper = mapper;
    }

    @Override
    public List<Comment> getCommentsByProductId(Long id) {
        List<Comment> result = new ArrayList<>();
        String sql = "select * from comments where product_id = " + id;

        try (ResultSet resultSet = getResultSetBySqlQuery(sql)) {

            while (resultSet.next()) {
                result.add(mapper.map(resultSet));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    Connection getDataSource() throws SQLException {
        return dataSource.getConnection();
    }
}
