package cc.nanoic.ucsp.server.utils;

import cc.nanoic.ucsp.server.common.Confignature;
import jakarta.annotation.Resource;

import java.sql.*;

public class CreateTableOnMethodCall {

    //读取yaml配置
    @Resource
    private static Confignature confignature;

    // JDBC连接信息
    static final String JDBC_DRIVER = Confignature.DATASOURCE_DRIVER_CLASS_NAME;
    static final String DB_URL = Confignature.DATASOURCE_URL;
    static final String USER = Confignature.DATASOURCE_USERNAME;
    static final String PASS = Confignature.DATASOURCE_PASSWORD;

    /**
     * 创建帖子表
     */
    public void Table(int a) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);

            // 打开一个连接
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // 执行查询
            stmt = conn.createStatement();
            String sql = "CREATE TABLE `post_" + a + "`  (\n" +
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
                    ") ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;";
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

    /**
     * 创建学习区帖子表
     */
    public void studyTable(int a) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);

            // 打开一个连接
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // 执行查询
            stmt = conn.createStatement();
            String sql = "CREATE TABLE `studypost_" + a + "`  (\n" +
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
                    "  `tag` varchar(255) NULL DEFAULT NULL COMMENT '标签',\n" +
                    "  PRIMARY KEY (`id`, `author_id`) USING BTREE\n" +
                    ") ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;";
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

    /**
     * 创建分享区帖子表
     */
    public void shareTable(int a) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);

            // 打开一个连接
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // 执行查询
            stmt = conn.createStatement();
            String sql = "CREATE TABLE `sharepost_" + a + "`  (\n" +
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
                    "  `tag` varchar(255) NULL DEFAULT NULL COMMENT '标签',\n" +
                    "  PRIMARY KEY (`id`, `author_id`) USING BTREE\n" +
                    ") ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;";
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
    } /**
     * 创建分享区帖子表
     */
    public void post_comments(int a) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);

            // 打开一个连接
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // 执行查询
            stmt = conn.createStatement();
            String sql =
                    "CREATE TABLE `post_comments_"+a+"`\n" +
                    "(\n" +
                    "    `id` int    NOT NULL AUTO_INCREMENT COMMENT '自增id',\n" +
                    "    `post_id` int  NULL DEFAULT NULL COMMENT '帖子id',\n" +
                    "    `user_id` int  NULL DEFAULT NULL COMMENT '评论者id',\n" +
                    "    `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '评论内容',\n" +
                    "    `create_time`  datetime  NULL DEFAULT NULL COMMENT '创建时间',\n" +
                    "    `like_num`int  NULL DEFAULT NULL COMMENT '点赞数量',\n" +
                    "    PRIMARY KEY (`id`) USING BTREE\n" +
                    ") ENGINE = InnoDB   CHARACTER SET = utf8mb4   COLLATE = utf8mb4_0900_ai_ci   ROW_FORMAT = DYNAMIC;";
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

    /**
     * 创建历年真题表
     */
    public void papersTable(int a) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);

            // 打开一个连接
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // 执行查询
            stmt = conn.createStatement();
            String sql = "CREATE TABLE `past_papers_" + a + "`  (\n" +
                    " `id`int NOT NULL COMMENT 'z'," +
                    " `title`varchar(255) DEFAULT NULL COMMENT '标题'," +
                    " `content`varchar(255) DEFAULT NULL COMMENT '内容'," +
                    " `cover`varchar(255) DEFAULT NULL COMMENT '封面图'," +
                    " `describe`varchar(255) DEFAULT NULL COMMENT '外部描述文本'," +
                    " `type`varchar(255) DEFAULT NULL COMMENT '类型'," +
                    " `views`bigint DEFAULT NULL COMMENT '浏览量'," +
                    " `create_time`datetime DEFAULT NULL COMMENT '创建时间'," +
                    " `update_time`datetime DEFAULT NULL COMMENT '更新时间'," +
                    " PRIMARY KEY(`id`)" +
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

    /**
     * 查询表是否存在
     */
    public boolean TableName(String tableName) {
        Connection con = null;
        ResultSet rs = null;
        try {
            con = DriverManager.getConnection(DB_URL, USER, PASS);
            rs = con.getMetaData().getTables(null, null, tableName, null);
            if (rs.next()) {
                return false;
            } else {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                con.close();
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
