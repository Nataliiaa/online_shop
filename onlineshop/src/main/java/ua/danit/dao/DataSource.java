package ua.danit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://danitinstance.ck6dqsqkvksf.eu-west-3.rds.amazonaws.com:3308/online_shop", "danit", "danit2018");
    }

}
