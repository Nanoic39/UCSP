package cc.nanoic.ucsp.server.utils;

import java.sql.*;

/**
 * 描述：JDBC工具类
 * 提供getConnection方法
 * 提供close方法
 * 开发步骤：
 *         1.私有化构造函数，防止外界直接new对象
 *         2.提供getConnection，用来对外界提供获取数据连接
 *         3.提供close方法，用来关闭资源
 *
 * @author 猿医生
 * @date 2018年10月31日
 *
 */
public class JDBCUtils {

    /** 数据库驱动 */
    private final static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";


    /**
     * 私有化构造函数,防止外界直接new对象
     */
    private JDBCUtils(){}

    /**
     * 获得Connection
     * @param url：数据库连接地址
     * @param username：用户名
     * @param password：密码
     * @return
     */
    public static Connection getConnection(String url, String username, String password){
        /** 数据库连接 */
        Connection conn = null;
        try{
            /** 加载数据库驱动，注册到驱动管理器 */
            Class.forName(JDBC_DRIVER);
            /** 创建Connection连接,数据库连接参数：地址/用户名/密码 */
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        /** 返回连接 */
        return conn;
    }

    /**
     * 关闭资源
     * @param conn
     * @param st
     * @param rs
     */
    public static void close(Connection conn, Statement st, ResultSet rs){
        if(conn != null){
            try {
                /** 关闭资源 */
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }finally{
                /** 保证资源一定会被释放 */
                conn=null;
            }
        }

        if(st != null){
            try {
                /** 关闭资源 */
                st.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }finally{
                /** 保证资源一定会被释放 */
                st = null;
            }
        }

        if(rs != null){
            try {
                /** 关闭资源 */
                rs.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }finally{
                /** 保证资源一定会被释放 */
                rs = null;
            }
        }
    }
}