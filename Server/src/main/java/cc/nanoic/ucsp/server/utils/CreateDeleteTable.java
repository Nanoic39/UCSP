package cc.nanoic.ucsp.server.utils;

import cc.nanoic.ucsp.server.common.Confignature;
import cc.nanoic.ucsp.server.common.Result;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateDeleteTable {

    @Resource
    static private Confignature confignature;

    // JDBC连接信息
    static final String JDBC_DRIVER = confignature.DATASOURCE_DRIVER_CLASS_NAME;
    static final String DB_URL = confignature.DATASOURCE_URL;
    static final String USER = confignature.DATASOURCE_USERNAME;
    static final String PASS = confignature.DATASOURCE_PASSWORD;

    public Result CreateTable(String tableName,String sql){
        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL,USER,PASS);
            statement = connection.createStatement();
            statement.executeUpdate(sql);
            return Result.success("建表成功");
        } catch (Exception e) {
            return Result.error("建表失败");
        }
    }

    public Result DeleteTable(String tableName){
        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL,USER,PASS);
            statement = connection.createStatement();
            String sql = "drop table " + tableName;
            statement.executeUpdate(sql);
            return Result.success("删表成功");
        } catch (Exception e) {
            return Result.error("删表失败");
        }
    }
}