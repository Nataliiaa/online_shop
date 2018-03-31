package ua.danit.dao.jdbc;

import org.junit.Assert;
import org.junit.Test;
import ua.danit.dao.DataSource;
import ua.danit.dao.ProductDao;
import ua.danit.mappers.ProductMapper;
import ua.danit.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class ProductJdbcDaoImplTest {

    private final ProductDao productJdbcDao = new ProductJdbcDaoImpl(new ProductMapper(), new DataSource());

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWithEmptyId() {
        productJdbcDao.getProductById(null);
    }

    @Test
    public void shouldReturnNullWithUnknownId() {
        Product result = productJdbcDao.getProductById(-1L);
        Assert.assertNull(result);
    }

    @Test
    public void shouldReturnProductTitelById() throws SQLException {
        //mock
        ProductMapper productMapper = mock(ProductMapper.class);
        DataSource dataSource = mock(DataSource.class);
        Connection connection = mock(Connection.class);
        when(dataSource.getConnection()).thenReturn(connection);
        PreparedStatement ps = mock(PreparedStatement.class);
        when(connection.prepareStatement("select * from products where id=?")).thenReturn(ps);
        ResultSet resultSet = mock(ResultSet.class);
        when(ps.executeQuery()).thenReturn(resultSet);
        when(resultSet.next()).thenReturn(true);
        Product expected = new Product();
        expected.setTitle("Iphone");
        when(productMapper.map(resultSet)).thenReturn(expected);
        //class to test
        ProductJdbcDaoImpl productJdbcDao = new ProductJdbcDaoImpl(productMapper, dataSource);
        //method invocation
        Product result = productJdbcDao.getProductById(1L);
        //asserts
        Assert.assertThat("Iphone", is(result.getTitle()));
    }


    @Test
    public void shouldReturnProductById() throws SQLException {
        Product expected = new Product();
        expected.setTitle("Iphone");
        expected.setPrice(1);
        //mock
        ProductMapper productMapper = mock(ProductMapper.class);
        DataSource dataSource = mock(DataSource.class);
        Connection connection = mock(Connection.class);
        when(dataSource.getConnection()).thenReturn(connection);
        PreparedStatement ps = mock(PreparedStatement.class);
        when(connection.prepareStatement("select * from products where id=?")).thenReturn(ps);
        ResultSet resultSet = mock(ResultSet.class);
        when(ps.executeQuery()).thenReturn(resultSet);
        when(resultSet.next()).thenReturn(true);
        when(productMapper.map(resultSet)).thenReturn(expected);
        //class to test
        ProductJdbcDaoImpl productJdbcDao = new ProductJdbcDaoImpl(productMapper, dataSource);
        //method invocation
        Product result = productJdbcDao.getProductById(1L);
        //asserts
        Assert.assertThat(expected, is(result));
    }


}