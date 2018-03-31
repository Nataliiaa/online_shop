package ua.danit.mappers;

import ua.danit.model.Product;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements Mapper<Product> {


    @Override
    public Product map(ResultSet resultSet) throws SQLException {
        return new Product(resultSet.getLong("id"),
                resultSet.getString("title"),
                null,
                resultSet.getString("description"),
                resultSet.getString("image_url"),
                resultSet.getInt("price"));
    }
}
