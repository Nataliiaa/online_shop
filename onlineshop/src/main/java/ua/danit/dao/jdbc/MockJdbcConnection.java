package ua.danit.dao.jdbc;

import java.sql.*;

public class MockJdbcConnection {

    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:mysql://danitinstance.ck6dqsqkvksf.eu-west-3.rds.amazonaws.com:3308/online_shop", "danit", "danit2018");

        Statement statement = connection.createStatement();

        String sql = "select tp.title tag_title,\n" +
                "      count(*) count_tags\n" +
                "from products p,\n" +
                "     tags tp,\n" +
                "     products_tags pt\n" +
                "where p.id = pt.product_id\n" +
                " and pt.tag_id = tp.id\n" +
                "group by tp.title;";



        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()){
            String title = resultSet.getString("tag_title");
            int count = resultSet.getInt("count_tags");

            System.out.println(String.format("Title: %s Count: %s", title, count));
        }


    }

}
