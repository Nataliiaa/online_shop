package ua.danit.dao.jdbc;

import ua.danit.dao.CategoryDao;
import ua.danit.model.CategoryType;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CategoryJdbcDao extends SkeletonJdbcDao implements CategoryDao {

    @Override
    public List<CategoryType> getAllCategories() {
        return null;
    }

    @Override
    Connection getDataSource() throws SQLException {
        return null;
    }
}
