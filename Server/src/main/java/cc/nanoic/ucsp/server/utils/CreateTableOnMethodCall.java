package cc.nanoic.ucsp.server.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTableOnMethodCall {

    // JDBC连接信息
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/ucsp";
    static final String USER = "root";
    static final String PASS = "123456";

    public void createTableOnMethodCall(int a) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);

            // 打开一个连接
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // 执行查询
            stmt = conn.createStatement();
            String sql = "CREATE TABLE `post_"+a+"`  (\n" +
                    "  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',\n" +
                    "  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '标题',\n" +
                    "  `author_id` int NOT NULL COMMENT '作者id',\n" +
                    "  `intro` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '摘要',\n" +
                    "  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '内容',\n" +
                    "  `status` int NULL DEFAULT 1 COMMENT '文章状态',\n" +
                    "  `post_cover` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '文章封面',\n" +
                    "  `auth` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '访问权限',\n" +
                    "  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',\n" +
                    "  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',\n" +
                    "  `like_num` int NULL DEFAULT NULL COMMENT '点赞数量',\n" +
                    "  `comment_num` int NULL DEFAULT NULL COMMENT '评论数量',\n" +
                    "  `collection_num` int NULL DEFAULT NULL COMMENT '收藏数量',\n" +
                    "  PRIMARY KEY (`id`, `author_id`) USING BTREE\n" +
                    ") ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;"
                    ;
            stmt.executeUpdate(sql);

            System.out.println("表创建成功");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
