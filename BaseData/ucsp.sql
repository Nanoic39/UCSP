/*
 Navicat Premium Data Transfer

 Source Server         : LocalhostTestSQL
 Source Server Type    : MySQL
 Source Server Version : 80200
 Source Host           : localhost:3306
 Source Schema         : ucsp

 Target Server Type    : MySQL
 Target Server Version : 80200
 File Encoding         : 65001

 Date: 05/05/2024 13:58:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for attendance
-- ----------------------------
DROP TABLE IF EXISTS `attendance`;
CREATE TABLE `attendance`
(
    `id`        int                                                           NOT NULL AUTO_INCREMENT COMMENT 'id',
    `user_id`   int                                                           NULL DEFAULT NULL COMMENT '用户id',
    `day`       int                                                           NULL DEFAULT 0 COMMENT '总签到天数',
    `month_day` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '本月签到日期',
    `status`    int                                                           NULL DEFAULT 0 COMMENT '状态',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for authority
-- ----------------------------
DROP TABLE IF EXISTS `authority`;
CREATE TABLE `authority`
(
    `id`    int                                                           NOT NULL AUTO_INCREMENT COMMENT 'id',
    `level` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '权限等级',
    `intro` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '权限介绍',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for holiday
-- ----------------------------
DROP TABLE IF EXISTS `holiday`;
CREATE TABLE `holiday`
(
    `id`   int                                                           NOT NULL AUTO_INCREMENT COMMENT '自增id',
    `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '假期名称',
    `date` datetime                                                      NULL DEFAULT NULL COMMENT '假期日期（始）',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`
(
    `id`          int                                                           NOT NULL AUTO_INCREMENT COMMENT 'id',
    `parent_id`   int                                                           NULL DEFAULT NULL COMMENT '该菜单的父级菜单id',
    `name`        varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '菜单名称',
    `path`        varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '菜单路径',
    `icon`        varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '菜单图标',
    `auth`        varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '所需权限',
    `level`       varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '菜单层级',
    `sort`        varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '菜单排序',
    `status`      varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '菜单状态(0/1)',
    `creat_time`  datetime                                                      NULL DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime                                                      NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for post_1
-- ----------------------------
DROP TABLE IF EXISTS `post_1`;
CREATE TABLE `post_1`
(
    `id`             int                                                           NOT NULL AUTO_INCREMENT COMMENT 'id',
    `title`          varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '标题',
    `author_id`      int                                                           NOT NULL COMMENT '作者id',
    `intro`          varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '摘要',
    `content`        longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci     NULL COMMENT '内容',
    `status`         int                                                           NULL DEFAULT 1 COMMENT '文章状态',
    `post_cover`     varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '文章封面',
    `auth`           varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '访问权限',
    `create_time`    datetime                                                      NULL DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime                                                      NULL DEFAULT NULL COMMENT '更新时间',
    `like_num`       int                                                           NULL DEFAULT NULL COMMENT '点赞数量',
    `comment_num`    int                                                           NULL DEFAULT NULL COMMENT '评论数量',
    `collection_num` int                                                           NULL DEFAULT NULL COMMENT '收藏数量',
    PRIMARY KEY (`id`, `author_id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`
(
    `id`    int                                                           NOT NULL AUTO_INCREMENT COMMENT 'id',
    `name`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '角色名称',
    `intro` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '角色介绍',
    `icon`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '图标',
    `color` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '颜色',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for role_authority
-- ----------------------------
DROP TABLE IF EXISTS `role_authority`;
CREATE TABLE `role_authority`
(
    `id`           int NOT NULL AUTO_INCREMENT COMMENT 'id',
    `role_id`      int NULL DEFAULT NULL COMMENT '角色id',
    `authority_id` int NULL DEFAULT NULL COMMENT '权限id',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for sharepost_1
-- ----------------------------
DROP TABLE IF EXISTS `sharepost_1`;
CREATE TABLE `sharepost_1`
(
    `id`             int                                                           NOT NULL AUTO_INCREMENT COMMENT 'id',
    `title`          varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '标题',
    `author_id`      int                                                           NOT NULL COMMENT '作者id',
    `intro`          varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '摘要',
    `content`        longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci     NULL COMMENT '内容',
    `status`         int                                                           NULL DEFAULT 1 COMMENT '文章状态',
    `post_cover`     varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '文章封面',
    `auth`           varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '访问权限',
    `create_time`    datetime                                                      NULL DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime                                                      NULL DEFAULT NULL COMMENT '更新时间',
    `like_num`       int                                                           NULL DEFAULT NULL COMMENT '点赞数量',
    `comment_num`    int                                                           NULL DEFAULT NULL COMMENT '评论数量',
    `collection_num` int                                                           NULL DEFAULT NULL COMMENT '收藏数量',
    `tag`            varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '标签',
    PRIMARY KEY (`id`, `author_id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for sign
-- ----------------------------
DROP TABLE IF EXISTS `sign`;
CREATE TABLE `sign`
(
    `id`      int                                                           NOT NULL AUTO_INCREMENT COMMENT 'id',
    `user_id` int                                                           NOT NULL COMMENT '用户id',
    `sign`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '签到记录',
    `month`   int                                                           NULL DEFAULT NULL COMMENT '签到月份',
    PRIMARY KEY (`id`, `user_id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for studypost_1
-- ----------------------------
DROP TABLE IF EXISTS `studypost_1`;
CREATE TABLE `studypost_1`
(
    `id`             int                                                           NOT NULL AUTO_INCREMENT COMMENT 'id',
    `title`          varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '标题',
    `author_id`      int                                                           NOT NULL COMMENT '作者id',
    `intro`          varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '摘要',
    `content`        longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci     NULL COMMENT '内容',
    `status`         int                                                           NULL DEFAULT 1 COMMENT '文章状态',
    `post_cover`     varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '文章封面',
    `auth`           varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '访问权限',
    `create_time`    datetime                                                      NULL DEFAULT NULL COMMENT '创建时间',
    `update_time`    datetime                                                      NULL DEFAULT NULL COMMENT '更新时间',
    `like_num`       int                                                           NULL DEFAULT NULL COMMENT '点赞数量',
    `comment_num`    int                                                           NULL DEFAULT NULL COMMENT '评论数量',
    `collection_num` int                                                           NULL DEFAULT NULL COMMENT '收藏数量',
    `tag`            varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '标签',
    PRIMARY KEY (`id`, `author_id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for table_num
-- ----------------------------
DROP TABLE IF EXISTS `table_num`;
CREATE TABLE `table_num`
(
    `id`   int                                                           NOT NULL AUTO_INCREMENT COMMENT 'id',
    `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '类型(帖子表/动态表/评论表)',
    `num`  int                                                           NULL DEFAULT NULL COMMENT '数量',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 4
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `id`                int                                                           NOT NULL AUTO_INCREMENT COMMENT '用户唯一id',
    `account`           varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL     DEFAULT NULL COMMENT '账号',
    `password`          varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL     DEFAULT NULL COMMENT '密码',
    `avatar`            varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL     DEFAULT NULL COMMENT '头像路径',
    `status`            int                                                           NOT NULL DEFAULT 0 COMMENT '账号激活状态',
    `phone`             varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL     DEFAULT NULL COMMENT '绑定电话号',
    `email`             varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL     DEFAULT NULL COMMENT '绑定邮箱',
    `registration_date` datetime                                                      NULL     DEFAULT NULL COMMENT '注册时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`
(
    `id`      int                                                           NOT NULL AUTO_INCREMENT COMMENT 'id',
    `user_id` int                                                           NULL DEFAULT NULL COMMENT '用户id',
    `sex`     varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '性别',
    `age`     int                                                           NULL DEFAULT NULL COMMENT '年龄',
    `hobby`   varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '爱好',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`
(
    `id`      bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
    `user_id` int    NULL DEFAULT NULL COMMENT '用户id',
    `role_id` int    NULL DEFAULT NULL COMMENT '身份id',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = DYNAMIC;

SET FOREIGN_KEY_CHECKS = 1;

-- ----------------------------
-- Table structure for subjects_big
-- ----------------------------
DROP TABLE IF EXISTS `subjects_big`;
CREATE TABLE `subjects_big`
(
    `id` int    NOT NULL AUTO_INCREMENT COMMENT 'id',
    `subjects_big` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '大科目',
    `status`  int                                                           NOT NULL DEFAULT 1 COMMENT'状态码',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB   CHARACTER SET = utf8mb4   COLLATE = utf8mb4_0900_ai_ci   ROW_FORMAT = DYNAMIC;
DROP TABLE IF EXISTS `subjects_small`;
CREATE TABLE `subjects_small`  (
                                   `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
                                   `subjects_big` INT(255)  NULL DEFAULT NULL COMMENT '大科目ID',
                                   `subjects_small` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '小科目',
                                   `status`  int                                                           NOT NULL DEFAULT 1 COMMENT'状态码',
                                   PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;
insert into subjects_big (subjects_big) values('数学'),('英语'),('编程语言'),('计算机进阶'),('大学生竞赛'),('实验'),('物理'),('金融'),('设计'),('编辑');
insert into subjects_small (subjects_big,subjects_small) values
                                                             (1,'高等数学'),(1,'线性代数'),(1,'概率论与数理统计'),(1,'统计学'),
                                                             (2,'大学英语'),(2,'专业英语'),(2,'商务英语'),(2,'剑指CET-6'),(2,'剑指CET-4'),(2,'大学生英语能力进阶'),
                                                             (3,'Python语言程序设计'),(3,'JAVA语言程序设计'),(3,'C语言语言程序设计'),(3,'计算机'),(3,'Web技术'),(3,'程序设计（上机）'),
                                                             (4,'软件开发技术基础'),(4,'人工智能基础'),(4,'软件开发技术基础'),(4,'人工智能基础'),
                                                             (5,'算法竞赛入门'), (5,'蓝桥杯'),
                                                             (6,'通信技术综合实验'),(6,'物理实验'),
                                                             (7,'物理实验'),
                                                             (11,'通信电子线路'),(11,'交换技术基础与通信网'),(11,'通信电子线路'),(11,'通信电子线路')

DROP TABLE IF EXISTS `active`;
CREATE TABLE `active`
(
    `id` int    NOT NULL AUTO_INCREMENT COMMENT 'id',
    `sponsor` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '发起人',
    `active_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '活动名',
    `status`  int NOT NULL DEFAULT 1 COMMENT'状态码',
    `active_start_time` datetime  NULL DEFAULT NULL COMMENT '活动开始时间',
    `active_end_time` datetime NULL DEFAULT NULL COMMENT '活动结束时间',
    `active_range` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '活动范围',
    `authority` INT(255)  NULL DEFAULT NULL COMMENT '报名权限',
    `register_start_time` datetime NULL DEFAULT NULL COMMENT '报名开始时间',
    `register_end_time` datetime NULL DEFAULT NULL COMMENT '报名结束时间',
    `num`  INT(255) NULL DEFAULT NULL COMMENT '名额',
    `active_intro` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '活动简介',
    `active_content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '活动详情内容',
    `creat_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB   CHARACTER SET = utf8mb4   COLLATE = utf8mb4_0900_ai_ci   ROW_FORMAT = DYNAMIC;


DROP TABLE IF EXISTS post_comments_1;
CREATE TABLE `post_comments_1`
(
    `id` int    NOT NULL AUTO_INCREMENT COMMENT '自增id',
    `post_id` int  NULL DEFAULT NULL COMMENT '帖子id',
    `user_id` int  NULL DEFAULT NULL COMMENT '评论者id',
    `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '评论内容',
    `create_time`  datetime  NULL DEFAULT NULL COMMENT '创建时间',
    `like_num`int  NULL DEFAULT NULL COMMENT '点赞数量',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB   CHARACTER SET = utf8mb4   COLLATE = utf8mb4_0900_ai_ci   ROW_FORMAT = DYNAMIC;

DROP TABLE IF EXISTS `post_reply_1`;
CREATE TABLE `post_reply_1`
(
    `id` int    NOT NULL AUTO_INCREMENT COMMENT '自增id',
    `object_id` int  NULL DEFAULT NULL COMMENT '对应评论id',
    `user_id` int  NULL DEFAULT NULL COMMENT '评论者id',
    `type` int  NULL DEFAULT NULL COMMENT '评论属性',
    `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '评论内容',
    `create_time`  datetime  NULL DEFAULT NULL COMMENT '创建时间',
    `like_num`int  NULL DEFAULT NULL COMMENT '点赞数量',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB   CHARACTER SET = utf8mb4   COLLATE = utf8mb4_0900_ai_ci   ROW_FORMAT = DYNAMIC;

DROP TABLE IF EXISTS `post_comments_1`;
CREATE TABLE `post_comments_1`
(
    `id` int    NOT NULL AUTO_INCREMENT COMMENT '该评论id',
    `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '评论内容',
    `create_time`  datetime  NULL DEFAULT NULL COMMENT '评论时间',
    `user_id` int  NULL DEFAULT NULL COMMENT '评论者id',
    `post_id` int  NULL DEFAULT NULL COMMENT '所属帖子id',
    `like_num`int  NULL DEFAULT NULL COMMENT '点赞数量',

    `comments_id` int  NULL DEFAULT NULL COMMENT '评论ID',
#     `reply_id` int  NULL DEFAULT NULL COMMENT '回复ID',



    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB   CHARACTER SET = utf8mb4   COLLATE = utf8mb4_0900_ai_ci   ROW_FORMAT = DYNAMIC;