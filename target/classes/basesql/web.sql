/*
Navicat MySQL Data Transfer

Source Server         : 本机密码netmarch
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : web

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2019-03-05 10:40:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL COMMENT '字典名称',
  `code` varchar(50) NOT NULL COMMENT '字典代码',
  `parent_code` varchar(20) NOT NULL DEFAULT '-1' COMMENT '上级code',
  `is_delete` int(1) DEFAULT '0',
  `comments` varchar(45) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `creater` int(11) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `updater` varchar(45) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`),
  KEY `code_unique` (`code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=526 DEFAULT CHARSET=utf8 COMMENT='数据字典表';

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
INSERT INTO `sys_dict` VALUES ('1', '视频平台', 'video_platform', '-1', '0', '', '2019-02-13 20:50:01', null, null, null);
INSERT INTO `sys_dict` VALUES ('2', '罗普特平台', 'platform_lpt', 'video_platform', '0', '', '2019-02-13 20:50:33', null, null, null);
INSERT INTO `sys_dict` VALUES ('3', '直连设备', 'platform_zlsb', 'video_platform', '0', null, '2019-02-13 20:57:16', null, null, null);
INSERT INTO `sys_dict` VALUES ('4', '科达视频平台', 'platform_kd', 'video_platform', '0', null, '2019-02-13 20:58:04', null, null, null);
INSERT INTO `sys_dict` VALUES ('5', '科达V2.0平台', 'platform_kd2.0', 'video_platform', '0', null, '2019-02-13 20:59:02', null, null, null);
INSERT INTO `sys_dict` VALUES ('6', '其他设备', 'platform_other', 'video_platform', '0', null, '2019-02-13 20:59:43', null, null, null);
INSERT INTO `sys_dict` VALUES ('414', '抓拍类型', 'snap_type', '-1', '0', null, '2019-02-14 20:21:54', null, null, null);
INSERT INTO `sys_dict` VALUES ('415', '人脸抓拍', 'snap_face', 'snap_type', '0', null, '2019-02-14 20:23:00', null, null, null);
INSERT INTO `sys_dict` VALUES ('416', '车辆抓拍', 'snap_car', 'snap_type', '0', null, '2019-02-14 20:23:35', null, null, null);
INSERT INTO `sys_dict` VALUES ('417', '普通抓拍', 'snap_common', 'snap_type', '0', null, '2019-02-14 20:24:13', null, null, null);
INSERT INTO `sys_dict` VALUES ('418', '推送类型', 'push_type', '-1', '0', null, '2019-02-14 20:24:50', null, null, null);
INSERT INTO `sys_dict` VALUES ('419', 'HTTP', 'push_http', 'push_type', '0', null, '2019-02-14 20:25:16', null, null, null);
INSERT INTO `sys_dict` VALUES ('420', '网关', 'push_gateway', 'push_type', '0', null, '2019-02-14 20:26:06', null, null, null);
INSERT INTO `sys_dict` VALUES ('421', '摄像机像素', 'pixel', '-1', '0', null, '2019-02-14 20:26:33', null, null, null);
INSERT INTO `sys_dict` VALUES ('422', '720P', 'pixel_720P', 'pixel', '0', null, '2019-02-14 20:27:11', null, null, null);
INSERT INTO `sys_dict` VALUES ('423', '1080P', 'pixel_1080P', 'pixel', '0', null, '2019-02-14 20:27:50', null, null, null);
INSERT INTO `sys_dict` VALUES ('424', '设备监控方向', 'direction', '-1', '0', null, '2019-02-14 20:28:37', null, null, null);
INSERT INTO `sys_dict` VALUES ('425', '东', 'direction_east', 'direction', '0', null, '2019-02-14 20:29:36', null, null, null);
INSERT INTO `sys_dict` VALUES ('426', '西', 'direction_west', 'direction', '0', null, '2019-02-14 20:29:57', null, null, null);
INSERT INTO `sys_dict` VALUES ('427', '南', 'direction_south', 'direction', '0', null, '2019-02-14 20:30:08', null, null, null);
INSERT INTO `sys_dict` VALUES ('428', '北', 'direction_north', 'direction', '0', null, '2019-02-14 20:30:19', null, null, null);
INSERT INTO `sys_dict` VALUES ('429', '东南', 'direction_southeast', 'direction', '0', null, '2019-02-14 20:31:45', null, null, null);
INSERT INTO `sys_dict` VALUES ('430', '东北', 'direction_northeast', 'direction', '0', null, '2019-02-14 20:32:11', null, null, null);
INSERT INTO `sys_dict` VALUES ('431', '西南', 'direction_southwest', 'direction', '0', null, '2019-02-14 20:32:49', null, null, null);
INSERT INTO `sys_dict` VALUES ('432', '西北', 'direction_northwest', 'direction', '0', null, '2019-02-14 20:33:40', null, null, null);
INSERT INTO `sys_dict` VALUES ('434', '数据权限', 'data_permission', '-1', '0', null, '2019-02-18 01:09:02', null, null, null);
INSERT INTO `sys_dict` VALUES ('437', '个人', 'permission_personal', 'data_permission', '0', null, '2019-02-18 01:09:54', null, null, null);
INSERT INTO `sys_dict` VALUES ('438', '分局/支队', 'permission_fjzd', 'data_permission', '0', null, '2019-02-18 01:11:30', null, null, null);
INSERT INTO `sys_dict` VALUES ('439', '全市', 'permission_sn', 'data_permission', '0', null, '2019-02-18 01:14:14', null, null, null);
INSERT INTO `sys_dict` VALUES ('440', '战果类型', 'victory_type', '-1', '0', null, '2019-02-18 01:17:06', null, null, null);
INSERT INTO `sys_dict` VALUES ('441', '设备类型', 'device_type', '-1', '0', null, '2019-02-19 04:01:41', null, null, null);
INSERT INTO `sys_dict` VALUES ('442', '由苏入昆', 'from_su_to_kun', 'device_type', '0', null, '2019-02-19 04:02:34', null, null, null);
INSERT INTO `sys_dict` VALUES ('443', '由昆入苏', 'from_kun_to_su', 'device_type', '0', null, '2019-02-19 04:02:57', null, null, null);
INSERT INTO `sys_dict` VALUES ('444', '由沪入昆', 'from_hu_to_kun', 'device_type', '0', null, '2019-02-19 04:03:35', null, null, null);
INSERT INTO `sys_dict` VALUES ('446', '由昆入沪', 'from_kun_to_hu', 'device_type', '0', null, '2019-02-19 04:04:19', null, null, null);
INSERT INTO `sys_dict` VALUES ('448', '信号类型', 'signal_type', '-1', '0', null, '2019-02-20 00:59:18', null, null, null);
INSERT INTO `sys_dict` VALUES ('449', '数字信号', 'signal_digital', 'signal_type', '0', null, '2019-02-20 01:00:39', null, null, null);
INSERT INTO `sys_dict` VALUES ('450', '模拟信号', 'signal_analog', 'signal_type', '0', null, '2019-02-20 01:01:21', null, null, null);
INSERT INTO `sys_dict` VALUES ('452', '一级', 'first', 'fault_level', '0', null, '2019-02-20 03:37:26', null, null, null);
INSERT INTO `sys_dict` VALUES ('453', '二级', 'second', 'fault_level', '0', null, '2019-02-20 03:37:46', null, null, null);
INSERT INTO `sys_dict` VALUES ('454', '三级', 'third', 'fault_level', '0', null, '2019-02-20 03:37:59', null, null, null);
INSERT INTO `sys_dict` VALUES ('455', '依图', 'shenxing', 'engine_vendor', '0', '', '2019-02-20 03:44:10', null, '2019-02-28 16:33:25', '1');
INSERT INTO `sys_dict` VALUES ('456', '故障等级', 'fault_level', '-1', '0', null, '2019-02-20 04:05:15', null, null, null);
INSERT INTO `sys_dict` VALUES ('457', '引擎厂商', 'engine_vendor', '-1', '0', null, '2019-02-20 04:05:28', null, null, null);
INSERT INTO `sys_dict` VALUES ('469', 'testType', 'test-type', '-1', '0', null, '2019-02-22 00:42:41', null, null, null);
INSERT INTO `sys_dict` VALUES ('477', '字典', '-1', '0', '0', null, '2019-02-24 20:51:15', null, null, null);
INSERT INTO `sys_dict` VALUES ('478', '个人中心类型', 'individual_type', '-1', '0', null, '2019-02-24 21:31:35', null, null, null);
INSERT INTO `sys_dict` VALUES ('479', '战果', 'victory', 'individual_type', '0', null, '2019-02-24 21:31:52', null, null, null);
INSERT INTO `sys_dict` VALUES ('480', '案例', 'case', 'individual_type', '0', null, '2019-02-24 21:32:06', null, null, null);
INSERT INTO `sys_dict` VALUES ('481', '视频', 'video', 'individual_type', '0', null, '2019-02-24 21:32:21', null, null, null);
INSERT INTO `sys_dict` VALUES ('482', '反馈', 'feedback', 'individual_type', '0', null, '2019-02-24 21:32:32', null, null, null);
INSERT INTO `sys_dict` VALUES ('496', '点赞', 'likes', 'individual_type', '0', null, '2019-02-24 22:05:59', null, null, null);
INSERT INTO `sys_dict` VALUES ('497', '评论', 'comment', 'individual_type', '0', null, '2019-02-24 22:06:23', null, null, null);
INSERT INTO `sys_dict` VALUES ('502', '嫌疑人', 'criminal_suspect_victory', 'victory_type', '0', null, '2019-02-25 00:55:44', null, null, null);
INSERT INTO `sys_dict` VALUES ('509', 'test', 'test1', 'test-type', '0', 'test', '2019-02-26 03:05:53', null, null, null);
INSERT INTO `sys_dict` VALUES ('510', 'test2', 'test2', 'test-type', '0', '111', '2019-02-26 18:44:20', '1', null, null);
INSERT INTO `sys_dict` VALUES ('511', 'test3', 'test3', 'test-type', '0', 'test3', '2019-02-26 18:44:48', '1', null, null);
INSERT INTO `sys_dict` VALUES ('512', 'test4', 'test4', 'test-type', '0', 'tes131', '2019-02-26 19:14:59', '1', null, null);
INSERT INTO `sys_dict` VALUES ('513', 'test4', 'test41', 'test-type', '0', '', '2019-02-27 17:58:46', '1', '2019-02-28 16:42:38', '1');
INSERT INTO `sys_dict` VALUES ('514', 'test42', 'test42', 'test41', '0', '', '2019-02-27 17:59:00', '1', null, null);
INSERT INTO `sys_dict` VALUES ('520', '报警类型', 'alarm_type', '-1', '0', '报警类型', '2019-03-01 14:26:53', '1', null, null);
INSERT INTO `sys_dict` VALUES ('521', '卡口', 'bayonet_alarm_type', 'alarm_type', '0', '卡口', '2019-03-01 14:28:01', '1', null, null);
INSERT INTO `sys_dict` VALUES ('522', '报警类型测试', 'test_alarm_type', 'alarm_type', '0', '报警类型测试', '2019-03-01 16:13:03', '1', null, null);
INSERT INTO `sys_dict` VALUES ('523', '1', 'accc', '-1', '0', '', '2019-03-04 15:04:48', '1', null, null);
INSERT INTO `sys_dict` VALUES ('524', '1111', 'sddsf', 'accc', '0', '22222', '2019-03-04 15:05:07', '1', null, null);
INSERT INTO `sys_dict` VALUES ('525', '222', 'dsf', '-1', '0', '', '2019-03-04 15:06:03', '1', null, null);

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) NOT NULL COMMENT '用户',
  `ip` varchar(255) NOT NULL COMMENT 'IP地址',
  `model` varchar(255) NOT NULL COMMENT '操作模块',
  `action` varchar(255) NOT NULL COMMENT '操作内容',
  `content` varchar(255) NOT NULL COMMENT '操作描述',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES ('1', '操作用户', '172.16.3.11', '操作日志', '获取操作日志信息列表', '查询列表', '2019-03-05 10:30:31');
INSERT INTO `sys_log` VALUES ('2', '操作用户', '172.16.3.11', '操作日志', '获取操作日志信息列表', '查询列表', '2019-03-05 10:30:33');
INSERT INTO `sys_log` VALUES ('3', '操作用户', '172.16.3.11', '操作日志', '获取操作日志信息列表', '查询列表', '2019-03-05 10:30:33');
INSERT INTO `sys_log` VALUES ('4', '操作用户', '172.16.3.11', '操作日志', '获取操作日志信息列表', '查询列表', '2019-03-05 10:30:33');
INSERT INTO `sys_log` VALUES ('5', '操作用户', '172.16.3.11', '操作日志', '获取操作日志信息列表', '查询列表', '2019-03-05 10:30:34');
INSERT INTO `sys_log` VALUES ('6', '操作用户', '172.16.3.11', '操作日志', '获取操作日志信息列表', '查询列表', '2019-03-05 10:30:34');

-- ----------------------------
-- Table structure for sys_login_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_login_user`;
CREATE TABLE `sys_login_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `login_name` varchar(20) NOT NULL COMMENT '登录名',
  `password` varchar(255) NOT NULL COMMENT '登录密码',
  `name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `police_num` varchar(20) DEFAULT NULL COMMENT '警号',
  `organization_id` int(11) DEFAULT NULL COMMENT '归属',
  `data_permission` varchar(20) DEFAULT NULL COMMENT '数据权限',
  `status` int(11) DEFAULT NULL COMMENT '1-启用，0-禁用',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `creater` int(11) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `updater` varchar(45) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`),
  UNIQUE KEY `loginName_UNIQUE` (`login_name`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_login_user
-- ----------------------------
INSERT INTO `sys_login_user` VALUES ('1', 'admin', '$2a$10$6PTUTj1VTngu6zV10XEIxeTCfWHNWfpYowueRRNYwVZt2i2vhTGhe', '超级管理员', '00001', '1', '1', '1', '2019-02-15 04:04:55', null, '2019-02-25 03:07:08', null);
INSERT INTO `sys_login_user` VALUES ('21', 'admin2', '$2a$10$6PTUTj1VTngu6zV10XEIxeTCfWHNWfpYowueRRNYwVZt2i2vhTGhe', 'admin', '123', '1', '1', '1', '2019-02-26 06:14:55', null, '2019-03-05 10:27:09', '1');
INSERT INTO `sys_login_user` VALUES ('22', 'ynk', '$2a$10$6PTUTj1VTngu6zV10XEIxeTCfWHNWfpYowueRRNYwVZt2i2vhTGhe', '袁宁康', '000044444', '1', '1', '1', '2019-02-26 21:44:01', '1', '2019-03-05 10:35:30', '1');

-- ----------------------------
-- Table structure for sys_login_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_login_user_role`;
CREATE TABLE `sys_login_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户角色中间表id',
  `sys_login_user_id` int(11) NOT NULL COMMENT '外链sys_login_user表id',
  `sys_role_id` int(11) NOT NULL COMMENT '外链sys_role表id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8 COMMENT='用户角色中间表';

-- ----------------------------
-- Records of sys_login_user_role
-- ----------------------------
INSERT INTO `sys_login_user_role` VALUES ('1', '1', '1');
INSERT INTO `sys_login_user_role` VALUES ('37', '21', '5');
INSERT INTO `sys_login_user_role` VALUES ('39', '22', '5');
INSERT INTO `sys_login_user_role` VALUES ('40', '22', '14');

-- ----------------------------
-- Table structure for sys_organization
-- ----------------------------
DROP TABLE IF EXISTS `sys_organization`;
CREATE TABLE `sys_organization` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '组织id',
  `linkman_id` int(11) DEFAULT NULL COMMENT '联系人id，外链sys_login_user表id',
  `name` varchar(255) NOT NULL COMMENT '组织名称',
  `rank` int(11) DEFAULT NULL COMMENT '组织级别',
  `region_code` int(11) DEFAULT NULL COMMENT '行政区域编码',
  `address` varchar(255) DEFAULT NULL COMMENT '组织地址',
  `telephone` varchar(255) DEFAULT NULL COMMENT '电话',
  `email` varchar(255) DEFAULT NULL COMMENT '电子邮件',
  `is_delete` tinyint(1) DEFAULT '0' COMMENT '是否删除',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `parent_id` int(11) DEFAULT NULL COMMENT '父组织id',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='组织表';

-- ----------------------------
-- Records of sys_organization
-- ----------------------------
INSERT INTO `sys_organization` VALUES ('1', '1', '昆山市公安局', '1', '325', '前进路', '188', '110@110.com', '0', '2019-02-22 09:51:46', '2019-02-22 09:51:50', '-1', '0');
INSERT INTO `sys_organization` VALUES ('2', '1', '花城所', '2', '325', '人民路', '177', '111@110.com', '0', null, null, '1', null);
INSERT INTO `sys_organization` VALUES ('3', '1', '千灯所', '2', '325', '人民路', '199', '111@110.com', '0', null, null, '1', null);

-- ----------------------------
-- Table structure for sys_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_resource`;
CREATE TABLE `sys_resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '资源id',
  `code` varchar(255) DEFAULT NULL COMMENT '资源编码',
  `name` varchar(255) DEFAULT NULL COMMENT '资源名称',
  `url` varchar(255) DEFAULT NULL COMMENT '资源链接,页面组件为空',
  `type` int(11) DEFAULT NULL COMMENT '资源类型 0主菜单 1功能菜单 2功能',
  `css_selector` varchar(255) DEFAULT NULL COMMENT 'css选择器,页面组件控制用',
  `status` tinyint(1) DEFAULT '0' COMMENT '资源状态,0启用 1停用',
  `sort_index` int(11) DEFAULT NULL COMMENT '排序号',
  `parent_id` int(11) DEFAULT NULL COMMENT '父资源id',
  `imgUrl1` varchar(100) DEFAULT NULL,
  `imgUrl2` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8 COMMENT='资源表';

-- ----------------------------
-- Records of sys_resource
-- ----------------------------
INSERT INTO `sys_resource` VALUES ('1', 'root', '根结点', null, '0', null, '0', '1', '0', null, null);
INSERT INTO `sys_resource` VALUES ('2', 'sysManage', '系统管理', 'sysManage', '1', null, '1', '5', '1', 'images/I206_nav5.png', 'images/I206_navCur5.png');
INSERT INTO `sys_resource` VALUES ('3', 'resourceManage', '资源管理', '/resource/list', '2', null, '1', '2', '2', null, null);
INSERT INTO `sys_resource` VALUES ('4', 'userManage', '用户管理', '/user/list', '2', null, '1', '1', '2', null, null);
INSERT INTO `sys_resource` VALUES ('11', 'roleManage', '角色管理', '/role/list', '2', null, '1', '3', '2', null, null);
INSERT INTO `sys_resource` VALUES ('12', 'resourceAdd', '资源新增', '/resource/add', '3', null, '1', '1', '3', null, null);
INSERT INTO `sys_resource` VALUES ('13', 'resourceEdit', '资源编辑', '/resource/edit', '3', null, '1', '2', '3', null, null);
INSERT INTO `sys_resource` VALUES ('14', 'resourceDel', '资源删除', '/resource/delBatch', '3', null, '1', '3', '3', null, null);
INSERT INTO `sys_resource` VALUES ('15', 'userAdd', '用户新增', '/user/add', '3', null, '1', '1', '4', null, null);
INSERT INTO `sys_resource` VALUES ('16', 'userEdit', '用户编辑', '/user/edit', '3', null, '1', '2', '4', null, null);
INSERT INTO `sys_resource` VALUES ('17', 'userDel', '用户删除', '/user/delBatch', '3', null, '1', '3', '4', null, null);
INSERT INTO `sys_resource` VALUES ('18', 'roleAdd', '角色新增', '/role/add', '3', null, '1', '1', '11', null, null);
INSERT INTO `sys_resource` VALUES ('19', 'roleEdit', '角色编辑', '/role/edit', '3', null, '1', '2', '11', null, null);
INSERT INTO `sys_resource` VALUES ('20', 'roleDel', '角色删除', '/role/delBatch', '3', null, '1', '3', '11', null, null);
INSERT INTO `sys_resource` VALUES ('29', 'individualism', '个人中心', 'individualism', '1', null, '1', '6', '1', 'images/I206_nav4.png', 'images/I206_navCur4.png');
INSERT INTO `sys_resource` VALUES ('31', 'dict', '字典管理', '/dict/list', '2', null, '1', '5', '2', null, null);
INSERT INTO `sys_resource` VALUES ('32', 'dictadd', '字典新增', '/dict/add', '3', null, '1', '1', '31', null, null);
INSERT INTO `sys_resource` VALUES ('35', 'dictedit', '字典编辑', '/dict/edit', '3', null, '1', '2', '31', null, null);
INSERT INTO `sys_resource` VALUES ('40', 'dictdel', '字典删除', '/dict/del', '3', null, '1', '3', '31', null, null);
INSERT INTO `sys_resource` VALUES ('41', 'dictview', '字典查看', '/dict/view', '3', null, '1', '4', '31', null, null);
INSERT INTO `sys_resource` VALUES ('56', 'actionLog', '操作日志', '/log/list', '2', null, '1', '8', '2', null, null);

-- ----------------------------
-- Table structure for sys_resource_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_resource_role`;
CREATE TABLE `sys_resource_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '资源角色中间表id',
  `sys_resource_id` int(11) NOT NULL COMMENT '外链sys_resource表id',
  `sys_role_id` int(11) NOT NULL COMMENT '外链sys_role表id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1413 DEFAULT CHARSET=utf8 COMMENT='资源角色中间表';

-- ----------------------------
-- Records of sys_resource_role
-- ----------------------------
INSERT INTO `sys_resource_role` VALUES ('4', '2', '3');
INSERT INTO `sys_resource_role` VALUES ('5', '3', '3');
INSERT INTO `sys_resource_role` VALUES ('6', '4', '3');
INSERT INTO `sys_resource_role` VALUES ('7', '2', '4');
INSERT INTO `sys_resource_role` VALUES ('8', '3', '4');
INSERT INTO `sys_resource_role` VALUES ('9', '4', '4');
INSERT INTO `sys_resource_role` VALUES ('39', '3', '7');
INSERT INTO `sys_resource_role` VALUES ('673', '12', '10');
INSERT INTO `sys_resource_role` VALUES ('719', '2', '11');
INSERT INTO `sys_resource_role` VALUES ('720', '3', '11');
INSERT INTO `sys_resource_role` VALUES ('721', '12', '11');
INSERT INTO `sys_resource_role` VALUES ('722', '2', '12');
INSERT INTO `sys_resource_role` VALUES ('723', '3', '12');
INSERT INTO `sys_resource_role` VALUES ('724', '4', '12');
INSERT INTO `sys_resource_role` VALUES ('725', '15', '12');
INSERT INTO `sys_resource_role` VALUES ('918', '29', '8');
INSERT INTO `sys_resource_role` VALUES ('937', '2', '9');
INSERT INTO `sys_resource_role` VALUES ('950', '29', '9');
INSERT INTO `sys_resource_role` VALUES ('1386', '2', '5');
INSERT INTO `sys_resource_role` VALUES ('1387', '31', '5');
INSERT INTO `sys_resource_role` VALUES ('1388', '32', '5');
INSERT INTO `sys_resource_role` VALUES ('1389', '35', '5');
INSERT INTO `sys_resource_role` VALUES ('1390', '40', '5');
INSERT INTO `sys_resource_role` VALUES ('1391', '41', '5');
INSERT INTO `sys_resource_role` VALUES ('1392', '2', '1');
INSERT INTO `sys_resource_role` VALUES ('1393', '3', '1');
INSERT INTO `sys_resource_role` VALUES ('1394', '12', '1');
INSERT INTO `sys_resource_role` VALUES ('1395', '13', '1');
INSERT INTO `sys_resource_role` VALUES ('1396', '14', '1');
INSERT INTO `sys_resource_role` VALUES ('1397', '4', '1');
INSERT INTO `sys_resource_role` VALUES ('1398', '15', '1');
INSERT INTO `sys_resource_role` VALUES ('1399', '16', '1');
INSERT INTO `sys_resource_role` VALUES ('1400', '17', '1');
INSERT INTO `sys_resource_role` VALUES ('1401', '11', '1');
INSERT INTO `sys_resource_role` VALUES ('1402', '18', '1');
INSERT INTO `sys_resource_role` VALUES ('1403', '19', '1');
INSERT INTO `sys_resource_role` VALUES ('1404', '20', '1');
INSERT INTO `sys_resource_role` VALUES ('1405', '31', '1');
INSERT INTO `sys_resource_role` VALUES ('1406', '32', '1');
INSERT INTO `sys_resource_role` VALUES ('1407', '35', '1');
INSERT INTO `sys_resource_role` VALUES ('1408', '40', '1');
INSERT INTO `sys_resource_role` VALUES ('1409', '41', '1');
INSERT INTO `sys_resource_role` VALUES ('1410', '56', '1');
INSERT INTO `sys_resource_role` VALUES ('1411', '29', '1');
INSERT INTO `sys_resource_role` VALUES ('1412', '29', '14');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `code` varchar(255) DEFAULT NULL COMMENT '角色编码',
  `name` varchar(255) DEFAULT NULL COMMENT '角色名',
  `create_user` int(11) DEFAULT NULL COMMENT '创建人，外链sys_login_user表id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user` int(11) DEFAULT NULL COMMENT '修改人，外链sys_login_user表id',
  `upate_time` datetime DEFAULT NULL COMMENT '修改时间',
  `is_delete` tinyint(1) DEFAULT '0' COMMENT '是否删除',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', 'admin', '系统超级管理员', null, null, '1', '2019-03-05 10:30:51', '0', 'admin');
INSERT INTO `sys_role` VALUES ('5', 'szjs', '字典管理角色', null, '2019-02-22 23:04:15', '1', '2019-03-05 10:26:44', '0', '字典管理角色');
INSERT INTO `sys_role` VALUES ('14', '000122212', '个人中心角色', '1', '2019-03-05 10:35:05', null, null, '0', '000122212');
