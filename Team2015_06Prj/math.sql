/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50096
Source Host           : localhost:3306
Source Database       : math

Target Server Type    : MYSQL
Target Server Version : 50096
File Encoding         : 65001

Date: 2015-10-10 20:19:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `id` int(11) NOT NULL auto_increment,
  `que_type` int(11) default NULL COMMENT '题目的类型 1为。。2为。。3为。。',
  `que_name` varchar(100) default NULL COMMENT '题目的详细描述',
  `que_rightanswer` varchar(100) default NULL COMMENT '系统给出的题目的正确答案',
  `que_useranswer` varchar(100) default NULL COMMENT '用户给出的题目的正确答案',
  `que_isright` varchar(100) default NULL COMMENT '用户给出的答案是否正确',
  `que_belonged` int(11) default NULL COMMENT '题目是哪个用户做的',
  `que_rightanswerdescription` varchar(100) default NULL COMMENT '对系统给出的答案的描述',
  `que_useranswerdescription` varchar(100) default NULL COMMENT '对用户给出的答案的描述',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES ('59', '2', '一个为长方形，其长为 84宽为77, 请计算该正方形的面积和周长。', null, null, '本题面积答案错，本题周长答案错', '1', '矩形的面积正确答案是： 6468.0。\r\n     矩形的周长正确答案是： 322.0。', '矩形的面积答案是： 21.0。\r\n     矩形的周长答案是： 12.0。');
INSERT INTO `question` VALUES ('60', '2', '一个为长方形，其长为 43宽为3, 请计算该正方形的面积和周长。', null, null, '本题面积答案错，本题周长答案错', '1', '矩形的面积正确答案是： 129.0。\r\n     矩形的周长正确答案是： 92.0。', '矩形的面积答案是： 21.0。\r\n     矩形的周长答案是： 1.0。');
INSERT INTO `question` VALUES ('61', '4', '将下面十个数字从小到大进行排序93,84,83,66,25,23,53,55,74,84,', null, null, '您的答案错误', '1', '0,23,25,53,55,66,74,83,84,93,', '123,0,0,0,0,0,0,0,0,0,');
INSERT INTO `question` VALUES ('62', '4', '将下面十个数字从小到大进行排序74,51,77,57,68,77,83,41,35,1,', null, null, '您的答案错误', '1', '0,35,41,51,57,68,74,77,77,83,', '12,34,0,0,0,0,0,0,0,0,');
INSERT INTO `question` VALUES ('63', '1', '一个三角形，底边长为 14, 高为91，请计算该三角形的面积和周长。', null, null, '本题面积答案错，本题周长答案错', '1', '三角形的面积正确答案是： 637.0。\r\n     三角形的周长正确答案是： 196.0。', '三角形的面积答案是： 12.0。\r\n     三角形的周长答案是： 12.0。');
INSERT INTO `question` VALUES ('64', '4', '将下面十个数字从小到大进行排序9,95,65,67,92,56,73,61,72,65,', null, null, '您的答案错误', '1', '0,9,56,61,65,67,72,73,92,95,', '12,0,0,0,0,0,0,0,0,0,');
INSERT INTO `question` VALUES ('65', '1', '一个三角形，底边长为 1, 高为20，请计算该三角形的面积和周长。', null, null, '本题面积答案错，本题周长答案错', '1', '三角形的面积正确答案是： 10.0。\r\n     三角形的周长正确答案是： 41.0。', '三角形的面积答案是： 12.0。\r\n     三角形的周长答案是： 21.0。');
INSERT INTO `question` VALUES ('66', '1', '一个三角形，底边长为 99, 高为51，请计算该三角形的面积和周长。', null, null, '本题面积答案错，本题周长答案错', '1', '三角形的面积正确答案是： 2524.5。\r\n     三角形的周长正确答案是： 239.0。', '三角形的面积答案是： 21.0。\r\n     三角形的周长答案是： 2.0。');
INSERT INTO `question` VALUES ('67', '2', '一个为长方形，其长为 35宽为27, 请计算该正方形的面积和周长。', null, null, '本题面积答案错，本题周长答案错', '1', '矩形的面积正确答案是： 945.0。\r\n     矩形的周长正确答案是： 124.0。', '矩形的面积答案是： 12.234。\r\n     矩形的周长答案是： 12.567。');
INSERT INTO `question` VALUES ('68', '2', '一个为长方形，其长为 28宽为63, 请计算该正方形的面积和周长。', null, null, '本题面积答案错，本题周长答案错', '1', '矩形的面积正确答案是： 1764.0。\r\n     矩形的周长正确答案是： 182.0。', '矩形的面积答案是： 123.0。\r\n     矩形的周长答案是： 321.0。');
INSERT INTO `question` VALUES ('69', '6', '题目：三条边，边x为 82，边x为 35，边y为 24, 请判定这三条边是否能构成三角形。', null, null, '本题判断答案正确', '1', '正确答辩：三条边，边x为 82，边y为 35，边z为 24,  三条边不能构成三角形。', '你的答辩：三条边，边x为 82，边y为 35，边z为 24,  三条边不能构成三角形。');
INSERT INTO `question` VALUES ('70', '5', '找出下面十个数字中的最大值和最小值:69,14,64,21,53,94,79,89,28,75,', null, null, '学生的答案是:错误的', '1', '最大值是:69 最小的值是:0', '最大值是:94 最小值是:14');
INSERT INTO `question` VALUES ('71', '5', '找出下面十个数字中的最大值和最小值:44,11,3,27,48,11,83,11,78,76,', null, null, '学生的答案是:错误的', '1', '最大值是:44 最小的值是:0', '最大值是:83 最小值是:3');
INSERT INTO `question` VALUES ('72', '3', '一个半径为R = 15, 请计算该圆的面积和周长。', null, null, '本题面积答案错，本题周长答案错', '1', '圆形的面积正确答案是： 706.86。\r\n     圆形的周长正确答案是： 94.25。', '圆形的面积答案是:12.00。\r\n     圆形的周长答案是： 21.00。');
INSERT INTO `question` VALUES ('73', '2', '一个为长方形，其长为 4宽为67, 请计算该正方形的面积和周长。', null, null, '本题面积答案正确，本题周长答案正确', '1', '矩形的面积正确答案是： 268.00。\r\n     矩形的周长正确答案是： 142.00。', '矩形的面积答案是:268.00。\r\n     矩形的周长答案是： 142.00。');
INSERT INTO `question` VALUES ('74', '4', '将下面十个数字从小到大进行排序83,66,7,16,77,11,57,21,45,72,', null, null, '您的答案错误', '1', '7,11,16,21,45,57,66,72,77,83,', '21,34,0,0,0,0,0,0,0,0,');
INSERT INTO `question` VALUES ('75', '4', '将下面十个数字从小到大进行排序89,91,74,4,56,13,6,96,42,36,', null, null, '您的答案错误', '1', '4,6,13,36,42,56,74,89,91,96,', '4,6,13,36,42,56,74,89,91,96,');
INSERT INTO `question` VALUES ('76', '6', '题目：三条边，边x为 70，边x为 32，边y为 28, 请判定这三条边是否能构成三角形。', null, null, '本题判断答案正确', '1', '正确答辩：三条边，边x为 70，边y为 32，边z为 28,  三条边不能构成三角形。', '你的答辩：三条边，边x为 70，边y为 32，边z为 28,  三条边不能构成三角形。');
INSERT INTO `question` VALUES ('77', '1', '一个三角形，底边长为 61, 高为12，请计算该三角形的面积和周长。', null, null, '本题面积答案正确，本题周长答案错', '1', '三角形的面积正确答案是： 366.00。\r\n     三角形的周长正确答案是： 125.00。', '三角形的面积答案是:366.00。\r\n     三角形的周长答案是： 55.00。');

-- ----------------------------
-- Table structure for questiontype
-- ----------------------------
DROP TABLE IF EXISTS `questiontype`;
CREATE TABLE `questiontype` (
  `id` int(11) NOT NULL,
  `qutp_name` varchar(50) default NULL COMMENT '问题类型的名称',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of questiontype
-- ----------------------------
INSERT INTO `questiontype` VALUES ('1', '计算三角形的面积和周长');
INSERT INTO `questiontype` VALUES ('2', '计算长方形的面价和周长');
INSERT INTO `questiontype` VALUES ('3', '计算园的周长和面积');
INSERT INTO `questiontype` VALUES ('4', '排序');
INSERT INTO `questiontype` VALUES ('5', '求最值');
INSERT INTO `questiontype` VALUES ('6', '三角形判断');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL auto_increment,
  `user_loginname` varchar(25) default NULL,
  `user_passworld` varchar(25) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'swl', '123');
INSERT INTO `user` VALUES ('2', 'qeq', 'gfd');
INSERT INTO `user` VALUES ('3', 'qeq131', 'afsfasf');
INSERT INTO `user` VALUES ('4', 'qeq131', 'rweqr');
INSERT INTO `user` VALUES ('5', 'qeq131', 'hgklglj');
INSERT INTO `user` VALUES ('6', 'dhfgh', 'fdggh');
INSERT INTO `user` VALUES ('7', 'sgtsh', 'gdhgfjd');
INSERT INTO `user` VALUES ('8', 'sgtsh', 'fgjhfghgfjghf');
INSERT INTO `user` VALUES ('9', 'swq342523534', 's523523454253');
