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

 Date: 10/11/2019 20:52:32
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
INSERT INTO `sys_menu_info` VALUES ('197e7325-9867-4d1e-8875-e18b83e0ddd8', '用户查询', 'fb1f89bf-fdcd-4994-b57b-1c228b54dfaa', 11, '#', 'menuItem', 'F', '0', 'sys:user:list', '', '', '2019-08-10 18:17:09', '', '2019-08-10 19:47:46', '');
INSERT INTO `sys_menu_info` VALUES ('1a03644c-6e98-430f-98c3-99295567e0a7', '用户添加', 'fb1f89bf-fdcd-4994-b57b-1c228b54dfaa', 12, '#', 'menuItem', 'F', '0', 'sys:user:add', '', '', '2019-08-10 19:47:34', '', NULL, '');
INSERT INTO `sys_menu_info` VALUES ('404fbeea-053d-4def-a085-1b98053b1d03', '系统监控', 'root', 2, '#', 'menuItem', 'M', '0', '', 'fa fa-bank', '', '2019-08-04 20:07:02', '', NULL, '');
INSERT INTO `sys_menu_info` VALUES ('5a951602-4815-4bb1-9e2b-07cf2091528a', '用户删除', 'fb1f89bf-fdcd-4994-b57b-1c228b54dfaa', 13, '#', 'menuItem', 'F', '0', 'sys:user:del', '', '', '2019-08-10 19:48:40', '', NULL, '');
INSERT INTO `sys_menu_info` VALUES ('646428ba-ff5e-4a81-a9d2-68c0ef31a439', '角色管理', 'eb2d09f8-5211-4591-8802-3c7231fe90ac', 2, '/sys/role', 'menuItem', 'C', '0', 'sys:role:view', '', '', '2019-08-04 17:52:04', '', '2019-08-04 18:07:15', '');
INSERT INTO `sys_menu_info` VALUES ('8314746a-0aeb-4c54-9f92-c32fce41183e', '重置密码', 'fb1f89bf-fdcd-4994-b57b-1c228b54dfaa', 15, '#', 'menuItem', 'F', '0', 'sys:user:restPwd', '', '', '2019-08-10 19:50:54', '', NULL, '');
INSERT INTO `sys_menu_info` VALUES ('ca345f90-0100-4eda-8ebd-b73f1cb7fa29', '菜单管理', 'eb2d09f8-5211-4591-8802-3c7231fe90ac', 3, '/sys/menu', 'menuItem', 'C', '0', 'sys:menu:view', '', '', '2019-08-04 17:52:53', '', '2019-08-04 18:07:29', '');
INSERT INTO `sys_menu_info` VALUES ('cfd727d1-7a4a-4812-823c-ce78b19faff3', '用户编辑', 'fb1f89bf-fdcd-4994-b57b-1c228b54dfaa', 14, '#', 'menuItem', 'F', '0', 'sys:user:edit', '', '', '2019-08-10 19:48:13', '', '2019-08-10 19:48:57', '');
INSERT INTO `sys_menu_info` VALUES ('eb2d09f8-5211-4591-8802-3c7231fe90ac', '系统管理', 'root', 1, '#', 'menuItem', 'M', '0', '', 'fa fa-cog', '', '2019-08-04 17:44:51', '', NULL, '');
INSERT INTO `sys_menu_info` VALUES ('eb7e743c-37d5-40cb-bd4c-7ad40df9c930', '部门管理', 'eb2d09f8-5211-4591-8802-3c7231fe90ac', 4, '/sys/dept', 'menuItem', 'C', '0', 'sys:dept:view', '', '', '2019-09-08 11:00:24', '', '2019-09-08 11:00:42', '');
INSERT INTO `sys_menu_info` VALUES ('fb1f89bf-fdcd-4994-b57b-1c228b54dfaa', '用户管理', 'eb2d09f8-5211-4591-8802-3c7231fe90ac', 1, '/sys/user', 'menuItem', 'C', '0', 'sys:user:view', '', '', '2019-08-04 17:51:36', '', '2019-08-04 18:07:00', '');

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
INSERT INTO `sys_role_info` VALUES ('1', '管理员', 'admin', 1, '1', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_role_info` VALUES ('2', '普通角色', 'common', 2, '2', '0', '0', 'admin', '2018-03-16 11:33:00', '暂无登录者', '2019-11-09 07:57:03', '普通角色');
INSERT INTO `sys_role_info` VALUES ('360b9881-ab27-4488-9625-269ff38f4bc9', 'java开发 （组长）', 'zuzhang', 3, '1', '0', '0', '', '2019-08-02 19:57:16', '暂无登录者', '2019-11-09 07:57:05', '测试角色');
INSERT INTO `sys_role_info` VALUES ('6a4c9bde-fc71-4477-a384-8bfcf3cfdd1b', '测试角色', 'test', 3, '1', '0', '0', '暂无登录者', '2019-11-09 08:09:20', '', NULL, '测试角色');

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
INSERT INTO `sys_role_menu` VALUES ('197e7325-9867-4d1e-8875-e18b83e0ddd8', '1');
INSERT INTO `sys_role_menu` VALUES ('1a03644c-6e98-430f-98c3-99295567e0a7', '1');
INSERT INTO `sys_role_menu` VALUES ('5a951602-4815-4bb1-9e2b-07cf2091528a', '1');
INSERT INTO `sys_role_menu` VALUES ('646428ba-ff5e-4a81-a9d2-68c0ef31a439', '1');
INSERT INTO `sys_role_menu` VALUES ('8314746a-0aeb-4c54-9f92-c32fce41183e', '1');
INSERT INTO `sys_role_menu` VALUES ('ca345f90-0100-4eda-8ebd-b73f1cb7fa29', '1');
INSERT INTO `sys_role_menu` VALUES ('cfd727d1-7a4a-4812-823c-ce78b19faff3', '1');
INSERT INTO `sys_role_menu` VALUES ('eb2d09f8-5211-4591-8802-3c7231fe90ac', '1');
INSERT INTO `sys_role_menu` VALUES ('eb2d09f8-5211-4591-8802-3c7231fe90ac', 'b5365e0d-c291-4539-9df7-25e33bd596b7');
INSERT INTO `sys_role_menu` VALUES ('fb1f89bf-fdcd-4994-b57b-1c228b54dfaa', '1');
INSERT INTO `sys_role_menu` VALUES ('fb1f89bf-fdcd-4994-b57b-1c228b54dfaa', 'b5365e0d-c291-4539-9df7-25e33bd596b7');

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
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '后台用户信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_user_info
-- ----------------------------
INSERT INTO `sys_user_info` VALUES ('1f6cb2c5-a267-4a6f-b9ec-97ba14673413', 'yankai2', 'yankai2', '15538157826', 'kai yan', '0', '15538157829', 'yanakai@127.com', '7ab329', '0', NULL, NULL, '2019-08-05 14:44:41', NULL, '2019-11-08 14:11:20');
INSERT INTO `sys_user_info` VALUES ('512ae24c-f0a0-43fa-ac4c-7b830e152036', 'yankai', 'yankai', '15538157823', 'kai yan', '1', '15538157826', 'yanakai@126.com', 'adbd59', '0', NULL, NULL, '2019-08-01 15:31:02', NULL, '2019-11-08 14:10:58');
INSERT INTO `sys_user_info` VALUES ('670886ba-dad1-4b53-8b08-a4a0d871ba19', 'yangjing', '123456', '15538157829', 'yankai', '1', NULL, 'yanakai@123.com', '06f4ff', '0', NULL, NULL, '2019-08-03 11:51:44', NULL, '2019-11-08 14:10:22');
INSERT INTO `sys_user_info` VALUES ('7f6da361-72f7-44a7-a23b-ba53342f4b1e', 'dudu', '123456', NULL, '嘟嘟', '0', '15538157827', 'yanakai@124.com', 'f0bdd9', '0', NULL, NULL, '2019-08-02 23:07:18', NULL, '2019-08-10 17:49:16');
INSERT INTO `sys_user_info` VALUES ('admin', 'admin', 'admin', NULL, '超级管理员', '0', NULL, NULL, NULL, '0', NULL, NULL, NULL, NULL, NULL);

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
INSERT INTO `sys_user_role` VALUES ('1f6cb2c5-a267-4a6f-b9ec-97ba14673413', '1');
INSERT INTO `sys_user_role` VALUES ('512ae24c-f0a0-43fa-ac4c-7b830e152036', '1');
INSERT INTO `sys_user_role` VALUES ('670886ba-dad1-4b53-8b08-a4a0d871ba19', '1');
INSERT INTO `sys_user_role` VALUES ('7f6da361-72f7-44a7-a23b-ba53342f4b1e', '1');
INSERT INTO `sys_user_role` VALUES ('admin', '1');

SET FOREIGN_KEY_CHECKS = 1;
