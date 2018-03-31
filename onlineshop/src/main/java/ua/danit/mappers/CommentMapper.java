package ua.danit.mappers;

import ua.danit.model.Comment;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommentMapper implements Mapper<Comment>{

    @Override
    public Comment map(ResultSet resultSet) throws SQLException {
        return new Comment(
                resultSet.getString("text"),
                null,
                resultSet.getInt("rating")
        );
    }
}
