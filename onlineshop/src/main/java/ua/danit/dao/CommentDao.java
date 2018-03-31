package ua.danit.dao;

import ua.danit.model.Comment;

import java.util.List;

public interface CommentDao {
    List<Comment> getCommentsByProductId(Long id);
}
