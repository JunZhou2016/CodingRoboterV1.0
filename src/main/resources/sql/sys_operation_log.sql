/*
Navicat MySQL Data Transfer

Source Server         : fangshuo
Source Server Version : 50718
Source Host           : 127.0.0.1:3306
Source Database       : generator-demo

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2018-10-07 15:51:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_operation_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_operation_log`;
CREATE TABLE `sys_operation_log` (
  `id` varchar(255) NOT NULL COMMENT '主键',
  `logtype` varchar(255) DEFAULT NULL COMMENT '日志类型',
  `logname` varchar(255) DEFAULT NULL COMMENT '日志名称',
  `userid` varchar(255) DEFAULT NULL COMMENT '用户id',
  `access_ip` varchar(255) DEFAULT NULL,
  `access_mac` varchar(255) DEFAULT NULL,
  `method` varchar(255) DEFAULT NULL COMMENT '方法名称',
  `createtime` datetime(6) DEFAULT NULL COMMENT '创建时间',
  `status` varchar(255) DEFAULT NULL COMMENT '是否成功',
  `message` varchar(255) DEFAULT NULL COMMENT '备注',
  `oper_params` varchar(255) DEFAULT NULL,
  `oper_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='操作日志';

-- ----------------------------
-- Records of sys_operation_log
-- ----------------------------
INSERT INTO `sys_operation_log` VALUES ('12A70QQJSI2NP002', '新增', '日志记录模块集成测试', null, '127.0.0.1', '00-00-00-00-00-00', 'com.fangshuo.lib4fangshuo.log.controller.TestController.testLog()', '2018-10-07 15:48:55.169000', '0', '操作成功', '{}', '/test');
