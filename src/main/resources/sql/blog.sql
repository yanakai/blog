/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : localhost:3306
 Source Schema         : blog

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 01/10/2019 16:35:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_article_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_article_info`;
CREATE TABLE `sys_article_info`  (
  `article_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
  `article_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文章标题',
  `article_abstract` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '文章摘要',
  `article_content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '文章内容',
  `img_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片名称',
  `img_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片路径',
  `point_num` int(10) NULL DEFAULT NULL COMMENT '点赞次数',
  `chick_num` int(10) NULL DEFAULT NULL COMMENT '浏览次数',
  `column_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属栏目',
  `tag_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属标签',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `create_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `last_modify_time` datetime(0) NULL DEFAULT NULL COMMENT '最后一次修改时间',
  `last_modify_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后一次修改人',
  `release_time` datetime(0) NULL DEFAULT NULL COMMENT '发布时间',
  `release_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发布人',
  `delete_status` int(1) NULL DEFAULT 0 COMMENT '删除状态：0：未删除；1：删除；默认值为0',
  `release_status` int(1) NULL DEFAULT 0 COMMENT '发布状态：0：未发布；1：已发布；默认值为0',
  `top_status` int(1) NULL DEFAULT 0 COMMENT '置顶状态：0：未置顶；1：已置顶；默认为0',
  PRIMARY KEY (`article_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sys_column_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_column_info`;
CREATE TABLE `sys_column_info`  (
  `column_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键Id',
  `column_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '栏目名称',
  `sort` int(2) NULL DEFAULT 0 COMMENT '排序码',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`column_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
