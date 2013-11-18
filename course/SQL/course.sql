/*
Navicat MySQL Data Transfer

Source Server         : Frank
Source Server Version : 50701
Source Host           : 127.0.0.1:3306
Source Database       : course

Target Server Type    : MYSQL
Target Server Version : 50701
File Encoding         : 65001

Date: 2013-11-18 23:30:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ruser
-- ----------------------------
DROP TABLE IF EXISTS `ruser`;
CREATE TABLE `ruser` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `realname` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ruser
-- ----------------------------
INSERT INTO `ruser` VALUES ('1', '111111', '张逍凡', 'frank');
INSERT INTO `ruser` VALUES ('2', '111111', '李老师', 'lilaoshi');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `clazz` varchar(255) DEFAULT NULL,
  `stu_id` int(11) NOT NULL,
  PRIMARY KEY (`stu_id`),
  KEY `FK_joflkmk5fdmp75g2iyd808vx2` (`stu_id`),
  CONSTRAINT `FK_joflkmk5fdmp75g2iyd808vx2` FOREIGN KEY (`stu_id`) REFERENCES `ruser` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('软件112', '1');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `position` varchar(255) DEFAULT NULL,
  `t_id` int(11) NOT NULL,
  PRIMARY KEY (`t_id`),
  KEY `FK_r33udr6kkx3c8jvsxnc3fb1t3` (`t_id`),
  CONSTRAINT `FK_r33udr6kkx3c8jvsxnc3fb1t3` FOREIGN KEY (`t_id`) REFERENCES `ruser` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('教授', '2');


-- ----------------------------
-- Table structure for calendar
-- ----------------------------
DROP TABLE IF EXISTS `calendar`;
CREATE TABLE `calendar` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cname` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of calendar
-- ----------------------------

-- ----------------------------
-- Table structure for courseware
-- ----------------------------
DROP TABLE IF EXISTS `courseware`;
CREATE TABLE `courseware` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cwname` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of courseware
-- ----------------------------

-- ----------------------------
-- Table structure for guestbook
-- ----------------------------
DROP TABLE IF EXISTS `guestbook`;
CREATE TABLE `guestbook` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cont` varchar(255) DEFAULT NULL,
  `datetime` datetime DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `u_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_6rhfv76hiybr6nd8stt3j3rkj` (`parent_id`),
  KEY `FK_4w2uqdash85kji8pb8inxeub2` (`u_id`),
  CONSTRAINT `FK_4w2uqdash85kji8pb8inxeub2` FOREIGN KEY (`u_id`) REFERENCES `ruser` (`id`),
  CONSTRAINT `FK_6rhfv76hiybr6nd8stt3j3rkj` FOREIGN KEY (`parent_id`) REFERENCES `guestbook` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;



-- ----------------------------
-- Table structure for video
-- ----------------------------
DROP TABLE IF EXISTS `video`;
CREATE TABLE `video` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `path` varchar(255) DEFAULT NULL,
  `vname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of video
-- ----------------------------
