package ua.danit.dao.jdbc;

import ua.danit.dao.DataSource;
import ua.danit.dao.ProductDao;
import ua.danit.mappers.Mapper;
import ua.danit.model.Category;
import ua.danit.model.Product;

import java.sql.*;
import java.util.List;

import static java.util.Objects.*;

public class ProductJdbcDaoImpl implements ProductDao {
    private final Mapper<Product> mapper;
    private final DataSource dataSource;

    public ProductJdbcDaoImpl(Mapper<Product> mapper, DataSource dataSource) {
        this.mapper = mapper;
        this.dataSource = dataSource;
    }


    @Override
    public List<Product> getAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Product> getByCategory(Category category) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(Product product) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(Long productId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Product getProductById(Long id) {
        Product product = null;

        if (isNull(id)) {
            throw new IllegalArgumentException();
        }

        try (Connection connection = dataSource.getConnection() ){
            String sql = "select * from products where id=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                preparedStatement.setLong(1, id);
                try (ResultSet resultSet = preparedStatement.executeQuery()){
                    if (resultSet.next()){
                     product = mapper.map(resultSet);
                    }

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;
    }
}
