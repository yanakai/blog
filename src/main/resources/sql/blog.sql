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

 Date: 20/11/2019 22:01:26
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
-- Records of sys_article_info
-- ----------------------------
INSERT INTO `sys_article_info` VALUES ('eb13b4db-aa34-4016-9860-5855952a82aa', '出现又离开', '我跟你 本应该\r\n各自好 各自坏\r\n各自生活的自在\r\n毫无关联的存在\r\n直到你 出现在\r\n我眼中 躲不开', '<div class=\"para\" label-module=\"para\" style=\"font-size: 14px; overflow-wrap: break-word; color: rgb(51, 51, 51); margin-bottom: 15px; text-indent: 2em; line-height: 24px; zoom: 1; font-family: arial, 宋体, sans-serif;\">我跟你 本应该</div><div class=\"para\" label-module=\"para\" style=\"font-size: 14px; overflow-wrap: break-word; color: rgb(51, 51, 51); margin-bottom: 15px; text-indent: 2em; line-height: 24px; zoom: 1; font-family: arial, 宋体, sans-serif;\">各自好 各自坏</div><div class=\"para\" label-module=\"para\" style=\"font-size: 14px; overflow-wrap: break-word; color: rgb(51, 51, 51); margin-bottom: 15px; text-indent: 2em; line-height: 24px; zoom: 1; font-family: arial, 宋体, sans-serif;\">各自生活的自在</div><div class=\"para\" label-module=\"para\" style=\"font-size: 14px; overflow-wrap: break-word; color: rgb(51, 51, 51); margin-bottom: 15px; text-indent: 2em; line-height: 24px; zoom: 1; font-family: arial, 宋体, sans-serif;\">毫无关联的存在</div><div class=\"para\" label-module=\"para\" style=\"font-size: 14px; overflow-wrap: break-word; color: rgb(51, 51, 51); margin-bottom: 15px; text-indent: 2em; line-height: 24px; zoom: 1; font-family: arial, 宋体, sans-serif;\">直到你 出现在</div><div class=\"para\" label-module=\"para\" style=\"font-size: 14px; overflow-wrap: break-word; color: rgb(51, 51, 51); margin-bottom: 15px; text-indent: 2em; line-height: 24px; zoom: 1; font-family: arial, 宋体, sans-serif;\">我眼中 躲不开</div><div class=\"para\" label-module=\"para\" style=\"font-size: 14px; overflow-wrap: break-word; color: rgb(51, 51, 51); margin-bottom: 15px; text-indent: 2em; line-height: 24px; zoom: 1; font-family: arial, 宋体, sans-serif;\">我也占领你的心海</div><div class=\"para\" label-module=\"para\" style=\"font-size: 14px; overflow-wrap: break-word; color: rgb(51, 51, 51); margin-bottom: 15px; text-indent: 2em; line-height: 24px; zoom: 1; font-family: arial, 宋体, sans-serif;\">充实着你的空白</div><div class=\"para\" label-module=\"para\" style=\"font-size: 14px; overflow-wrap: break-word; color: rgb(51, 51, 51); margin-bottom: 15px; text-indent: 2em; line-height: 24px; zoom: 1; font-family: arial, 宋体, sans-serif;\">为何出现在彼此的生活又离开</div><div class=\"para\" label-module=\"para\" style=\"font-size: 14px; overflow-wrap: break-word; color: rgb(51, 51, 51); margin-bottom: 15px; text-indent: 2em; line-height: 24px; zoom: 1; font-family: arial, 宋体, sans-serif;\">只留下在心里深深浅浅的表白</div><div class=\"para\" label-module=\"para\" style=\"font-size: 14px; overflow-wrap: break-word; color: rgb(51, 51, 51); margin-bottom: 15px; text-indent: 2em; line-height: 24px; zoom: 1; font-family: arial, 宋体, sans-serif;\">谁也没有想过再更改</div><div class=\"para\" label-module=\"para\" style=\"font-size: 14px; overflow-wrap: break-word; color: rgb(51, 51, 51); margin-bottom: 15px; text-indent: 2em; line-height: 24px; zoom: 1; font-family: arial, 宋体, sans-serif;\">谁也没有想过再想回来</div><div class=\"para\" label-module=\"para\" style=\"font-size: 14px; overflow-wrap: break-word; color: rgb(51, 51, 51); margin-bottom: 15px; text-indent: 2em; line-height: 24px; zoom: 1; font-family: arial, 宋体, sans-serif;\">哦 我不明白</div><div class=\"para\" label-module=\"para\" style=\"font-size: 14px; overflow-wrap: break-word; color: rgb(51, 51, 51); margin-bottom: 15px; text-indent: 2em; line-height: 24px; zoom: 1; font-family: arial, 宋体, sans-serif;\">我跟你 不应该</div><div class=\"para\" label-module=\"para\" style=\"font-size: 14px; overflow-wrap: break-word; color: rgb(51, 51, 51); margin-bottom: 15px; text-indent: 2em; line-height: 24px; zoom: 1; font-family: arial, 宋体, sans-serif;\">制造感觉 表达爱</div><div class=\"para\" label-module=\"para\" style=\"font-size: 14px; overflow-wrap: break-word; color: rgb(51, 51, 51); margin-bottom: 15px; text-indent: 2em; line-height: 24px; zoom: 1; font-family: arial, 宋体, sans-serif;\">试探未知和未来</div><div class=\"para\" label-module=\"para\" style=\"font-size: 14px; overflow-wrap: break-word; color: rgb(51, 51, 51); margin-bottom: 15px; text-indent: 2em; line-height: 24px; zoom: 1; font-family: arial, 宋体, sans-serif;\">相信那胡言一派</div><div class=\"para\" label-module=\"para\" style=\"font-size: 14px; overflow-wrap: break-word; color: rgb(51, 51, 51); margin-bottom: 15px; text-indent: 2em; line-height: 24px; zoom: 1; font-family: arial, 宋体, sans-serif;\">当天空暗下来</div><div class=\"para\" label-module=\"para\" style=\"font-size: 14px; overflow-wrap: break-word; color: rgb(51, 51, 51); margin-bottom: 15px; text-indent: 2em; line-height: 24px; zoom: 1; font-family: arial, 宋体, sans-serif;\">当周围又安静起来</div><div class=\"para\" label-module=\"para\" style=\"font-size: 14px; overflow-wrap: break-word; color: rgb(51, 51, 51); margin-bottom: 15px; text-indent: 2em; line-height: 24px; zoom: 1; font-family: arial, 宋体, sans-serif;\">当我突然梦里醒来</div><div class=\"para\" label-module=\"para\" style=\"font-size: 14px; overflow-wrap: break-word; color: rgb(51, 51, 51); margin-bottom: 15px; text-indent: 2em; line-height: 24px; zoom: 1; font-family: arial, 宋体, sans-serif;\">就等着太阳出来</div><div class=\"para\" label-module=\"para\" style=\"font-size: 14px; overflow-wrap: break-word; color: rgb(51, 51, 51); margin-bottom: 15px; text-indent: 2em; line-height: 24px; zoom: 1; font-family: arial, 宋体, sans-serif;\">为何出现在彼此的生活又离开</div><div class=\"para\" label-module=\"para\" style=\"font-size: 14px; overflow-wrap: break-word; color: rgb(51, 51, 51); margin-bottom: 15px; text-indent: 2em; line-height: 24px; zoom: 1; font-family: arial, 宋体, sans-serif;\">只留下在心里深深浅浅的表白</div><div class=\"para\" label-module=\"para\" style=\"font-size: 14px; overflow-wrap: break-word; color: rgb(51, 51, 51); margin-bottom: 15px; text-indent: 2em; line-height: 24px; zoom: 1; font-family: arial, 宋体, sans-serif;\">谁也没有想过再更改</div><div class=\"para\" label-module=\"para\" style=\"font-size: 14px; overflow-wrap: break-word; color: rgb(51, 51, 51); margin-bottom: 15px; text-indent: 2em; line-height: 24px; zoom: 1; font-family: arial, 宋体, sans-serif;\">谁也没有想过再想回来</div><div class=\"para\" label-module=\"para\" style=\"font-size: 14px; overflow-wrap: break-word; color: rgb(51, 51, 51); margin-bottom: 15px; text-indent: 2em; line-height: 24px; zoom: 1; font-family: arial, 宋体, sans-serif;\">哦 我不明白</div><div class=\"para\" label-module=\"para\" style=\"font-size: 14px; overflow-wrap: break-word; color: rgb(51, 51, 51); margin-bottom: 15px; text-indent: 2em; line-height: 24px; zoom: 1; font-family: arial, 宋体, sans-serif;\">我们紧紧相拥</div><div class=\"para\" label-module=\"para\" style=\"font-size: 14px; overflow-wrap: break-word; color: rgb(51, 51, 51); margin-bottom: 15px; text-indent: 2em; line-height: 24px; zoom: 1; font-family: arial, 宋体, sans-serif;\">头也不抬</div><div class=\"para\" label-module=\"para\" style=\"font-size: 14px; overflow-wrap: break-word; color: rgb(51, 51, 51); margin-bottom: 15px; text-indent: 2em; line-height: 24px; zoom: 1; font-family: arial, 宋体, sans-serif;\">因为不想告别</div><div class=\"para\" label-module=\"para\" style=\"font-size: 14px; overflow-wrap: break-word; color: rgb(51, 51, 51); margin-bottom: 15px; text-indent: 2em; line-height: 24px; zoom: 1; font-family: arial, 宋体, sans-serif;\">就悄然离开</div><div class=\"para\" label-module=\"para\" style=\"font-size: 14px; overflow-wrap: break-word; color: rgb(51, 51, 51); margin-bottom: 15px; text-indent: 2em; line-height: 24px; zoom: 1; font-family: arial, 宋体, sans-serif;\">不用认真的说</div><div class=\"para\" label-module=\"para\" style=\"font-size: 14px; overflow-wrap: break-word; color: rgb(51, 51, 51); margin-bottom: 15px; text-indent: 2em; line-height: 24px; zoom: 1; font-family: arial, 宋体, sans-serif;\">多舍不得你</div><div class=\"para\" label-module=\"para\" style=\"font-size: 14px; overflow-wrap: break-word; color: rgb(51, 51, 51); margin-bottom: 15px; text-indent: 2em; line-height: 24px; zoom: 1; font-family: arial, 宋体, sans-serif;\">每一个未来</div><div class=\"para\" label-module=\"para\" style=\"font-size: 14px; overflow-wrap: break-word; color: rgb(51, 51, 51); margin-bottom: 15px; text-indent: 2em; line-height: 24px; zoom: 1; font-family: arial, 宋体, sans-serif;\">都有人在</div><div class=\"para\" label-module=\"para\" style=\"font-size: 14px; overflow-wrap: break-word; color: rgb(51, 51, 51); margin-bottom: 15px; text-indent: 2em; line-height: 24px; zoom: 1; font-family: arial, 宋体, sans-serif;\">每一个未来</div><div class=\"para\" label-module=\"para\" style=\"font-size: 14px; overflow-wrap: break-word; color: rgb(51, 51, 51); margin-bottom: 15px; text-indent: 2em; line-height: 24px; zoom: 1; font-family: arial, 宋体, sans-serif;\">都有人在</div><div class=\"para\" label-module=\"para\" style=\"font-size: 14px; overflow-wrap: break-word; color: rgb(51, 51, 51); margin-bottom: 15px; text-indent: 2em; line-height: 24px; zoom: 1; font-family: arial, 宋体, sans-serif;\">那你无需感慨</div><div class=\"para\" label-module=\"para\" style=\"font-size: 14px; overflow-wrap: break-word; color: rgb(51, 51, 51); margin-bottom: 15px; text-indent: 2em; line-height: 24px; zoom: 1; font-family: arial, 宋体, sans-serif;\">我别徘徊</div><div class=\"para\" label-module=\"para\" style=\"font-size: 14px; overflow-wrap: break-word; color: rgb(51, 51, 51); margin-bottom: 15px; text-indent: 2em; line-height: 24px; zoom: 1; font-family: arial, 宋体, sans-serif;\">因为谁也没有想过再更改</div><div class=\"para\" label-module=\"para\" style=\"font-size: 14px; overflow-wrap: break-word; color: rgb(51, 51, 51); margin-bottom: 15px; text-indent: 2em; line-height: 24px; zoom: 1; font-family: arial, 宋体, sans-serif;\">谁也没有想过再想回来</div>', '', '', NULL, 1, '2d92cfc7-bbad-4c5b-9c11-9c841c78e94b', NULL, '2019-10-01 10:21:06', '目前没有登录系统', '2019-10-01 10:21:06', '目前没有登录系统', '2019-10-01 10:31:20', '暂时没有问题登录系统', 0, 0, 0);

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

-- ----------------------------
-- Records of sys_column_info
-- ----------------------------
INSERT INTO `sys_column_info` VALUES ('2d92cfc7-bbad-4c5b-9c11-9c841c78e94b', '歌词', 0, '');

-- ----------------------------
-- Table structure for sys_dept_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept_info`;
CREATE TABLE `sys_dept_info`  (
  `dept_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门id',
  `parent_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '父部门id',
  `ancestors` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '祖级列表',
  `dept_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '部门名称',
  `order_num` int(4) NULL DEFAULT 0 COMMENT '显示顺序',
  `leader` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '负责人',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '部门状态（0正常 1停用）',
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`dept_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '部门表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_login_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_login_info`;
CREATE TABLE `sys_login_info`  (
  `info_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '访问ID',
  `login_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '登录账号',
  `ipaddr` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '登录IP地址',
  `login_location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '登录地点',
  `browser` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '浏览器类型',
  `os` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '操作系统',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '登录状态（0成功 1失败）',
  `msg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '提示消息',
  `login_time` datetime(0) NULL DEFAULT NULL COMMENT '访问时间',
  PRIMARY KEY (`info_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 129 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统访问记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_menu_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu_info`;
CREATE TABLE `sys_menu_info`  (
  `menu_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单ID',
  `menu_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单名称',
  `parent_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '父菜单ID',
  `order_num` int(4) NULL DEFAULT 0 COMMENT '显示顺序',
  `url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '#' COMMENT '请求地址',
  `target` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '打开方式（menuItem页签 menuBlank新窗口）',
  `menu_type` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '菜单类型（M目录 C菜单 F按钮）',
  `visible` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
  `perms` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限标识',
  `icon` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '#' COMMENT '菜单图标',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu_info
-- ----------------------------
INSERT INTO `sys_menu_info` VALUES ('03acecc5-15ec-4902-bc72-6ac08453c266', '文章查询', '7721b1d9-b3c1-499b-9b4d-8b2f48f12566', 1, '', 'menuItem', 'F', '0', 'sys:article:list', '', '暂时没有登录者', '2019-11-16 14:02:57', '', NULL, '');
INSERT INTO `sys_menu_info` VALUES ('1893fc3f-2b1b-4971-a91c-e7c4d7974dcc', '用户分配', '646428ba-ff5e-4a81-a9d2-68c0ef31a439', 4, '', 'menuItem', 'F', '0', 'sys:role:addUser', '', '暂时没有登录者', '2019-11-16 13:57:18', '', NULL, '');
INSERT INTO `sys_menu_info` VALUES ('197e7325-9867-4d1e-8875-e18b83e0ddd8', '用户查询', 'fb1f89bf-fdcd-4994-b57b-1c228b54dfaa', 11, '#', 'menuItem', 'F', '0', 'sys:user:list', '', '', '2019-08-10 18:17:09', '', '2019-08-10 19:47:46', '');
INSERT INTO `sys_menu_info` VALUES ('1a03644c-6e98-430f-98c3-99295567e0a7', '用户添加', 'fb1f89bf-fdcd-4994-b57b-1c228b54dfaa', 12, '#', 'menuItem', 'F', '0', 'sys:user:add', '', '', '2019-08-10 19:47:34', '', NULL, '');
INSERT INTO `sys_menu_info` VALUES ('1f442996-7d1e-4250-b4b5-ae1c11a1350f', '菜单查询', 'ca345f90-0100-4eda-8ebd-b73f1cb7fa29', 1, '', 'menuItem', 'F', '0', 'sys:menu:list', '', '暂时没有登录者', '2019-11-16 13:59:27', '', NULL, '');
INSERT INTO `sys_menu_info` VALUES ('26ac5406-7bc4-4963-9c19-63826c75ec4e', '文章新增', '7721b1d9-b3c1-499b-9b4d-8b2f48f12566', 2, '', 'menuItem', 'F', '0', 'sys:article:add', '', '暂时没有登录者', '2019-11-16 14:05:03', '', NULL, '');
INSERT INTO `sys_menu_info` VALUES ('3cc0cc85-ebbe-4dc4-a350-3da6770230c7', '角色编辑', '646428ba-ff5e-4a81-a9d2-68c0ef31a439', 3, '', 'menuItem', 'F', '0', 'sys:role:edit', '', '暂时没有登录者', '2019-11-16 13:55:31', '', NULL, '');
INSERT INTO `sys_menu_info` VALUES ('3f49aa82-0029-466d-89b0-733b77fdc278', '菜单-子菜单添加', 'ca345f90-0100-4eda-8ebd-b73f1cb7fa29', 3, '', 'menuItem', 'F', '0', 'sys:menu:addChild', '', '暂时没有登录者', '2019-11-16 14:02:08', '暂时没有登录者', '2019-11-16 14:02:22', '');
INSERT INTO `sys_menu_info` VALUES ('49d7030c-7a22-48f3-8b4b-487f9f61ac0b', '文章预览', '7721b1d9-b3c1-499b-9b4d-8b2f48f12566', 6, '', 'menuItem', 'F', '0', 'sys:article:pre', '', '暂时没有登录者', '2019-11-16 14:08:08', '', NULL, '');
INSERT INTO `sys_menu_info` VALUES ('4bac578d-1052-448f-91f6-6b4129c58d40', '文章管理', 'root', 1, '', 'menuItem', 'M', '0', '', 'fa fa-server', '暂时没有登录者', '2019-11-16 12:23:07', '暂时没有登录者', '2019-11-16 12:34:06', '');
INSERT INTO `sys_menu_info` VALUES ('53d60f5a-014b-45d4-87af-4439d079fd7c', '菜单添加', 'ca345f90-0100-4eda-8ebd-b73f1cb7fa29', 2, '', 'menuItem', 'F', '0', 'sys:menu:add', '', '暂时没有登录者', '2019-11-16 13:59:59', '', NULL, '');
INSERT INTO `sys_menu_info` VALUES ('5a951602-4815-4bb1-9e2b-07cf2091528a', '用户删除', 'fb1f89bf-fdcd-4994-b57b-1c228b54dfaa', 13, '#', 'menuItem', 'F', '0', 'sys:user:del', '', '', '2019-08-10 19:48:40', '', NULL, '');
INSERT INTO `sys_menu_info` VALUES ('646428ba-ff5e-4a81-a9d2-68c0ef31a439', '角色管理', 'eb2d09f8-5211-4591-8802-3c7231fe90ac', 2, '/sys/role/list', 'menuItem', 'C', '0', 'sys:role:view', '', '', '2019-08-04 17:52:04', '', '2019-08-04 18:07:15', '');
INSERT INTO `sys_menu_info` VALUES ('7721b1d9-b3c1-499b-9b4d-8b2f48f12566', '文章列表', '4bac578d-1052-448f-91f6-6b4129c58d40', 1, '/sys/article/list', 'menuItem', 'C', '0', 'sys:article:view', '', '暂时没有登录者', '2019-11-16 12:23:25', '暂时没有登录者', '2019-11-16 12:25:55', '');
INSERT INTO `sys_menu_info` VALUES ('7e897877-8cb5-4bf0-8a1a-d382198640e9', '角色删除', '646428ba-ff5e-4a81-a9d2-68c0ef31a439', 5, '', 'menuItem', 'F', '0', 'sys:role:del', '', '暂时没有登录者', '2019-11-16 13:58:35', '', NULL, '');
INSERT INTO `sys_menu_info` VALUES ('8314746a-0aeb-4c54-9f92-c32fce41183e', '重置密码', 'fb1f89bf-fdcd-4994-b57b-1c228b54dfaa', 15, '#', 'menuItem', 'F', '0', 'sys:user:restPwd', '', '', '2019-08-10 19:50:54', '', NULL, '');
INSERT INTO `sys_menu_info` VALUES ('837a0833-6ce2-4f72-b959-cb900c229818', '文章删除', '7721b1d9-b3c1-499b-9b4d-8b2f48f12566', 7, '', 'menuItem', 'F', '0', 'sys:article:del', '', '暂时没有登录者', '2019-11-16 14:08:32', '', NULL, '');
INSERT INTO `sys_menu_info` VALUES ('9b63400a-8c9b-45af-aafb-dd9e481c9935', '栏目新增', 'd832be47-75b7-4145-85f0-940a4bdcf7cb', 2, '', 'menuItem', 'F', '0', 'sys:column:add', '', '暂时没有登录者', '2019-11-16 14:09:31', '', NULL, '');
INSERT INTO `sys_menu_info` VALUES ('a0aea9d9-9836-4c56-8f72-bae046525321', '菜单删除', 'ca345f90-0100-4eda-8ebd-b73f1cb7fa29', 5, '', 'menuItem', 'F', '0', 'sys:menu:del', '', '暂时没有登录者', '2019-11-16 14:01:00', '暂时没有登录者', '2019-11-16 14:01:31', '');
INSERT INTO `sys_menu_info` VALUES ('a5a7a52a-7c87-4c70-8043-00f20c3ffdb7', '文章置顶', '7721b1d9-b3c1-499b-9b4d-8b2f48f12566', 4, '', 'menuItem', 'F', '0', 'sys:article:top', '', '暂时没有登录者', '2019-11-16 14:06:52', '', NULL, '');
INSERT INTO `sys_menu_info` VALUES ('b82ce26b-9c21-4662-bf15-1ee6f6781e8a', '角色查询', '646428ba-ff5e-4a81-a9d2-68c0ef31a439', 1, '', 'menuItem', 'F', '0', 'sys:role:list', '', '暂时没有登录者', '2019-11-16 13:54:24', '', NULL, '');
INSERT INTO `sys_menu_info` VALUES ('b85e77a6-31fc-43d3-9de1-b9ef4fee372f', '栏目编辑', 'd832be47-75b7-4145-85f0-940a4bdcf7cb', 3, '', 'menuItem', 'F', '0', 'sys:column:edit', '', '暂时没有登录者', '2019-11-16 14:09:53', '', NULL, '');
INSERT INTO `sys_menu_info` VALUES ('ca345f90-0100-4eda-8ebd-b73f1cb7fa29', '菜单管理', 'eb2d09f8-5211-4591-8802-3c7231fe90ac', 3, '/sys/menu/list', 'menuItem', 'C', '0', 'sys:menu:view', '', '', '2019-08-04 17:52:53', '', '2019-08-04 18:07:29', '');
INSERT INTO `sys_menu_info` VALUES ('cfd727d1-7a4a-4812-823c-ce78b19faff3', '用户编辑', 'fb1f89bf-fdcd-4994-b57b-1c228b54dfaa', 14, '#', 'menuItem', 'F', '0', 'sys:user:edit', '', '', '2019-08-10 19:48:13', '', '2019-08-10 19:48:57', '');
INSERT INTO `sys_menu_info` VALUES ('d4ea59ce-45dc-4dc8-b6a3-d33368b2892e', '栏目查询', 'd832be47-75b7-4145-85f0-940a4bdcf7cb', 1, '', 'menuItem', 'F', '0', 'sys:column:list', '', '暂时没有登录者', '2019-11-16 14:09:09', '', NULL, '');
INSERT INTO `sys_menu_info` VALUES ('d832be47-75b7-4145-85f0-940a4bdcf7cb', '栏目列表', '4bac578d-1052-448f-91f6-6b4129c58d40', 2, '/sys/column/list', 'menuItem', 'C', '0', 'sys:column:view', '', '暂时没有登录者', '2019-11-16 12:24:47', '暂时没有登录者', '2019-11-16 12:26:47', '');
INSERT INTO `sys_menu_info` VALUES ('e41cb303-c561-4385-a645-22250c52277c', '文章发布', '7721b1d9-b3c1-499b-9b4d-8b2f48f12566', 3, '', 'menuItem', 'F', '0', 'sys:article:rel', '', '暂时没有登录者', '2019-11-16 14:06:18', '', NULL, '');
INSERT INTO `sys_menu_info` VALUES ('e5ec2ddb-bbc2-40b9-a22d-71e0f7d58c5f', '栏目删除', 'd832be47-75b7-4145-85f0-940a4bdcf7cb', 4, '', 'menuItem', 'F', '0', 'sys:column:del', '', '暂时没有登录者', '2019-11-16 14:10:13', '', NULL, '');
INSERT INTO `sys_menu_info` VALUES ('eb2d09f8-5211-4591-8802-3c7231fe90ac', '系统管理', 'root', 2, '#', 'menuItem', 'M', '0', '', 'fa fa-cog', '', '2019-08-04 17:44:51', '暂时没有登录者', '2019-11-16 12:33:59', '');
INSERT INTO `sys_menu_info` VALUES ('fb1f89bf-fdcd-4994-b57b-1c228b54dfaa', '用户管理', 'eb2d09f8-5211-4591-8802-3c7231fe90ac', 1, '/sys/user/list', 'menuItem', 'C', '0', 'sys:user:view', '', '', '2019-08-04 17:51:36', '', '2019-08-04 18:07:00', '');
INSERT INTO `sys_menu_info` VALUES ('fb4625e2-ee79-463d-8fc3-f011521b2d1f', '文章编辑', '7721b1d9-b3c1-499b-9b4d-8b2f48f12566', 5, '', 'menuItem', 'F', '0', 'sys:article:edit', '', '暂时没有登录者', '2019-11-16 14:07:30', '', NULL, '');
INSERT INTO `sys_menu_info` VALUES ('fb93c087-841f-4b6d-b81a-5b9d5a09626a', '角色增加', '646428ba-ff5e-4a81-a9d2-68c0ef31a439', 2, '', 'menuItem', 'F', '0', 'sys:role:add', '', '暂时没有登录者', '2019-11-16 13:55:07', '暂时没有登录者', '2019-11-16 13:55:44', '');
INSERT INTO `sys_menu_info` VALUES ('ffa65704-de6c-461a-85c1-af55fb007dbf', '菜单编辑', 'ca345f90-0100-4eda-8ebd-b73f1cb7fa29', 4, '', 'menuItem', 'F', '0', 'sys:menu:edit', '', '暂时没有登录者', '2019-11-16 14:00:37', '暂时没有登录者', '2019-11-16 14:01:20', '');

-- ----------------------------
-- Table structure for sys_oper_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_oper_log`;
CREATE TABLE `sys_oper_log`  (
  `oper_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志主键',
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '模块标题',
  `business_type` int(2) NULL DEFAULT 0 COMMENT '业务类型（0其它 1新增 2修改 3删除）',
  `method` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '方法名称',
  `request_method` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '请求方式',
  `operator_type` int(1) NULL DEFAULT 0 COMMENT '操作类别（0其它 1后台用户 2手机端用户）',
  `oper_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '操作人员',
  `dept_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '部门名称',
  `oper_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '请求URL',
  `oper_ip` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '主机地址',
  `oper_location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '操作地点',
  `oper_param` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '请求参数',
  `json_result` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '返回参数',
  `status` int(1) NULL DEFAULT 0 COMMENT '操作状态（0正常 1异常）',
  `error_msg` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '错误消息',
  `oper_time` datetime(0) NULL DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`oper_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '操作日志记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_role_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_dept`;
CREATE TABLE `sys_role_dept`  (
  `role_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色ID',
  `dept_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门ID',
  PRIMARY KEY (`role_id`, `dept_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色和部门关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_role_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_info`;
CREATE TABLE `sys_role_info`  (
  `role_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色ID',
  `role_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `role_key` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色权限字符串',
  `role_sort` int(4) NOT NULL COMMENT '显示顺序',
  `data_scope` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '数据范围（1：全部数据权限 2：自定数据权限）',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色状态（0正常 1停用）',
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_info
-- ----------------------------
INSERT INTO `sys_role_info` VALUES ('1', '管理员', 'admin', 1, '1', '1', '0', 'admin', '2018-03-16 11:33:00', '暂无登录者', '2019-11-19 15:19:44', '');
INSERT INTO `sys_role_info` VALUES ('7106387b-3bb3-4416-9d79-a2501abadd01', '测试角色', 'test', 1, '1', '0', '0', '暂无登录者', '2019-11-16 14:54:57', '暂无登录者', '2019-11-17 06:44:13', '');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `menu_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单ID',
  `role_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色id',
  PRIMARY KEY (`menu_id`, `role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色和菜单关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('03acecc5-15ec-4902-bc72-6ac08453c266', '7106387b-3bb3-4416-9d79-a2501abadd01');
INSERT INTO `sys_role_menu` VALUES ('1893fc3f-2b1b-4971-a91c-e7c4d7974dcc', '7106387b-3bb3-4416-9d79-a2501abadd01');
INSERT INTO `sys_role_menu` VALUES ('197e7325-9867-4d1e-8875-e18b83e0ddd8', '7106387b-3bb3-4416-9d79-a2501abadd01');
INSERT INTO `sys_role_menu` VALUES ('1a03644c-6e98-430f-98c3-99295567e0a7', '7106387b-3bb3-4416-9d79-a2501abadd01');
INSERT INTO `sys_role_menu` VALUES ('1f442996-7d1e-4250-b4b5-ae1c11a1350f', '7106387b-3bb3-4416-9d79-a2501abadd01');
INSERT INTO `sys_role_menu` VALUES ('26ac5406-7bc4-4963-9c19-63826c75ec4e', '7106387b-3bb3-4416-9d79-a2501abadd01');
INSERT INTO `sys_role_menu` VALUES ('3cc0cc85-ebbe-4dc4-a350-3da6770230c7', '7106387b-3bb3-4416-9d79-a2501abadd01');
INSERT INTO `sys_role_menu` VALUES ('3f49aa82-0029-466d-89b0-733b77fdc278', '7106387b-3bb3-4416-9d79-a2501abadd01');
INSERT INTO `sys_role_menu` VALUES ('49d7030c-7a22-48f3-8b4b-487f9f61ac0b', '7106387b-3bb3-4416-9d79-a2501abadd01');
INSERT INTO `sys_role_menu` VALUES ('4bac578d-1052-448f-91f6-6b4129c58d40', '7106387b-3bb3-4416-9d79-a2501abadd01');
INSERT INTO `sys_role_menu` VALUES ('53d60f5a-014b-45d4-87af-4439d079fd7c', '7106387b-3bb3-4416-9d79-a2501abadd01');
INSERT INTO `sys_role_menu` VALUES ('5a951602-4815-4bb1-9e2b-07cf2091528a', '7106387b-3bb3-4416-9d79-a2501abadd01');
INSERT INTO `sys_role_menu` VALUES ('646428ba-ff5e-4a81-a9d2-68c0ef31a439', '7106387b-3bb3-4416-9d79-a2501abadd01');
INSERT INTO `sys_role_menu` VALUES ('7721b1d9-b3c1-499b-9b4d-8b2f48f12566', '7106387b-3bb3-4416-9d79-a2501abadd01');
INSERT INTO `sys_role_menu` VALUES ('7e897877-8cb5-4bf0-8a1a-d382198640e9', '7106387b-3bb3-4416-9d79-a2501abadd01');
INSERT INTO `sys_role_menu` VALUES ('8314746a-0aeb-4c54-9f92-c32fce41183e', '7106387b-3bb3-4416-9d79-a2501abadd01');
INSERT INTO `sys_role_menu` VALUES ('837a0833-6ce2-4f72-b959-cb900c229818', '7106387b-3bb3-4416-9d79-a2501abadd01');
INSERT INTO `sys_role_menu` VALUES ('9b63400a-8c9b-45af-aafb-dd9e481c9935', '7106387b-3bb3-4416-9d79-a2501abadd01');
INSERT INTO `sys_role_menu` VALUES ('a0aea9d9-9836-4c56-8f72-bae046525321', '7106387b-3bb3-4416-9d79-a2501abadd01');
INSERT INTO `sys_role_menu` VALUES ('a5a7a52a-7c87-4c70-8043-00f20c3ffdb7', '7106387b-3bb3-4416-9d79-a2501abadd01');
INSERT INTO `sys_role_menu` VALUES ('b82ce26b-9c21-4662-bf15-1ee6f6781e8a', '7106387b-3bb3-4416-9d79-a2501abadd01');
INSERT INTO `sys_role_menu` VALUES ('b85e77a6-31fc-43d3-9de1-b9ef4fee372f', '7106387b-3bb3-4416-9d79-a2501abadd01');
INSERT INTO `sys_role_menu` VALUES ('ca345f90-0100-4eda-8ebd-b73f1cb7fa29', '7106387b-3bb3-4416-9d79-a2501abadd01');
INSERT INTO `sys_role_menu` VALUES ('cfd727d1-7a4a-4812-823c-ce78b19faff3', '7106387b-3bb3-4416-9d79-a2501abadd01');
INSERT INTO `sys_role_menu` VALUES ('d4ea59ce-45dc-4dc8-b6a3-d33368b2892e', '7106387b-3bb3-4416-9d79-a2501abadd01');
INSERT INTO `sys_role_menu` VALUES ('d832be47-75b7-4145-85f0-940a4bdcf7cb', '7106387b-3bb3-4416-9d79-a2501abadd01');
INSERT INTO `sys_role_menu` VALUES ('e41cb303-c561-4385-a645-22250c52277c', '7106387b-3bb3-4416-9d79-a2501abadd01');
INSERT INTO `sys_role_menu` VALUES ('e5ec2ddb-bbc2-40b9-a22d-71e0f7d58c5f', '7106387b-3bb3-4416-9d79-a2501abadd01');
INSERT INTO `sys_role_menu` VALUES ('eb2d09f8-5211-4591-8802-3c7231fe90ac', '7106387b-3bb3-4416-9d79-a2501abadd01');
INSERT INTO `sys_role_menu` VALUES ('eb2d09f8-5211-4591-8802-3c7231fe90ac', 'b5365e0d-c291-4539-9df7-25e33bd596b7');
INSERT INTO `sys_role_menu` VALUES ('fb1f89bf-fdcd-4994-b57b-1c228b54dfaa', '7106387b-3bb3-4416-9d79-a2501abadd01');
INSERT INTO `sys_role_menu` VALUES ('fb1f89bf-fdcd-4994-b57b-1c228b54dfaa', 'b5365e0d-c291-4539-9df7-25e33bd596b7');
INSERT INTO `sys_role_menu` VALUES ('fb4625e2-ee79-463d-8fc3-f011521b2d1f', '7106387b-3bb3-4416-9d79-a2501abadd01');
INSERT INTO `sys_role_menu` VALUES ('fb93c087-841f-4b6d-b81a-5b9d5a09626a', '7106387b-3bb3-4416-9d79-a2501abadd01');
INSERT INTO `sys_role_menu` VALUES ('ffa65704-de6c-461a-85c1-af55fb007dbf', '7106387b-3bb3-4416-9d79-a2501abadd01');

-- ----------------------------
-- Table structure for sys_user_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_info`;
CREATE TABLE `sys_user_info`  (
  `user_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '主键id',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `phone_number` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `true_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `sex` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '用户性别（0男 1女 ）',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `salt` varchar(255) CHARACTER SET utf16le COLLATE utf16le_general_ci NULL DEFAULT NULL COMMENT 'salt码',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '用户状态 0：正常；1：禁用',
  `image_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片路径',
  `image_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片名称',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `login_Time` timestamp(0) NULL DEFAULT NULL COMMENT '最后登录时间',
  `modify_time` timestamp(0) NULL DEFAULT NULL COMMENT '修改时间',
  `login_ip` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后登陆IP',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '后台用户信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_user_info
-- ----------------------------
INSERT INTO `sys_user_info` VALUES ('9722a28d-a85e-4216-8d51-72da46fe7f25', 'yankai', 'ff210928e31eff77dab8aae4a042cbae', '15538157826', '闫凯', '0', NULL, 'yanakai@127.com', 'a08cc4', '0', NULL, NULL, '2019-11-17 03:24:27', '2019-11-20 13:03:25', NULL, '0:0:0:0:0:0:0:1');
INSERT INTO `sys_user_info` VALUES ('admin', 'admin', '6e46bc8bfd6617fb29fd152ada99c3dc', '', '超级管理员', '0', NULL, 'yanakai@124.com', 'ba36d3', '0', '/profile/avatar/2019/11/16/14d52b633c9d852f0c8ae4e40c0bd295.png', NULL, NULL, '2019-11-20 21:48:07', '2019-11-16 10:20:16', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_user_info` VALUES ('b8837a0a-5cc9-42b7-b062-3b71ac3147f8', 'dudu', '13b60a3cfdb05c30e51a1e12b3c44d3e', '15538157822', 'dudu', '0', NULL, 'yanakai@129.com', 'a48946', '0', NULL, NULL, '2019-11-19 15:18:49', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `user_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  `role_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色id',
  PRIMARY KEY (`user_id`, `role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '后台用户和角色管理表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1f6cb2c5-a267-4a6f-b9ec-97ba14673413', '7106387b-3bb3-4416-9d79-a2501abadd01');
INSERT INTO `sys_user_role` VALUES ('512ae24c-f0a0-43fa-ac4c-7b830e152036', '7106387b-3bb3-4416-9d79-a2501abadd01');
INSERT INTO `sys_user_role` VALUES ('670886ba-dad1-4b53-8b08-a4a0d871ba19', '1');
INSERT INTO `sys_user_role` VALUES ('7f6da361-72f7-44a7-a23b-ba53342f4b1e', '1');
INSERT INTO `sys_user_role` VALUES ('9722a28d-a85e-4216-8d51-72da46fe7f25', '7106387b-3bb3-4416-9d79-a2501abadd01');
INSERT INTO `sys_user_role` VALUES ('admin', '1');
INSERT INTO `sys_user_role` VALUES ('b8837a0a-5cc9-42b7-b062-3b71ac3147f8', '1');
INSERT INTO `sys_user_role` VALUES ('b8837a0a-5cc9-42b7-b062-3b71ac3147f8', '7106387b-3bb3-4416-9d79-a2501abadd01');

SET FOREIGN_KEY_CHECKS = 1;
