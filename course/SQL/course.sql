create databases course;

use course;
-- ----------------------------
-- Table structure for ruser
-- ----------------------------
DROP TABLE IF EXISTS `ruser`;
CREATE TABLE `ruser` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `identity` int(11) NOT NULL,
  `password` varchar(40) DEFAULT NULL,
  `realname` varchar(40) DEFAULT NULL,
  `username` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sel
-- ----------------------------
drop table if exists sel;
create table sel(
  id int(11) NOT NULL AUTO_INCREMENT, #ID
  question varchar(250) NOT NULL,     #题目内容
  cho_a varchar(250),		          #选项
  cho_b varchar(250),
  cho_c varchar(250),
  cho_d varchar(250),
  answer varchar(10),                 #A B C D
  score  float NOT NULL,              #分值
  difficult int(11),                  #1:易，2:中，3:难  
  type int(11),                       #1:单选, 2：多选                   
  uid int references ruser(id),       #外键     
  primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;;


-- ----------------------------
-- Table structure for tof (true or false)判断题
-- ----------------------------
drop table if exists tof;
create table tof(
  id int(11) NOT NULL AUTO_INCREMENT, #ID
  question varchar(250) NOT NULL,     #题目内容
  answer int(11),                     #1对/0错
  score  float NOT NULL,              #分值
  difficult int(11),                  #1:易，2:中，3:难  
  type int(11),                       #1:单选, 2：多选                   
  uid int references ruser(id),       #外键     
  primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for essayque 简答题
-- ----------------------------
drop table if exists essayque;
create table essayque(
  id int(11) NOT NULL AUTO_INCREMENT, #ID
  question varchar(250) NOT NULL,     #题目内容
  answer varchar(250),                 #参考答案
  score  float NOT NULL,              #分值
  difficult int(11),                  #1:易，2:中，3:难  
  type int(11),                       #1:单选, 2：多选                   
  uid int references ruser(id),       #外键     
  primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for guestbook 留言
-- ----------------------------
DROP TABLE IF EXISTS `guestbook`;
CREATE TABLE `guestbook` (
  `id` int(11) NOT NULL AUTO_INCREMENT,				#留言板ID号
  `cont` varchar(255) DEFAULT NULL,					#留言板内容
  `datetime` datetime DEFAULT NULL,					#留言时间
  `parent_id` int(11) DEFAULT NULL,					#父留言
  `u_id` int(11) DEFAULT NULL,						#留言者
  PRIMARY KEY (`id`),
  KEY `FK_k9y9lgfcmt17loux51k7y9nb3` (`parent_id`),
  KEY `FK_pxsg8t43mmoomtwunuwhbbyrw` (`u_id`),
  CONSTRAINT `FK_pxsg8t43mmoomtwunuwhbbyrw` FOREIGN KEY (`u_id`) REFERENCES `ruser` (`id`),
  CONSTRAINT `FK_k9y9lgfcmt17loux51k7y9nb3` FOREIGN KEY (`parent_id`) REFERENCES `guestbook` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


