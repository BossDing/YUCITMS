/*
Navicat MySQL Data Transfer

Source Server         : qiangzi
Source Server Version : 50528
Source Host           : 127.0.0.1:3306
Source Database       : yucitms

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2018-01-28 15:09:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for attendance_attendancelist
-- ----------------------------
DROP TABLE IF EXISTS `attendance_attendancelist`;
CREATE TABLE `attendance_attendancelist` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `SIGNINTRUE` varchar(255) DEFAULT NULL,
  `SIGNINTIME` datetime DEFAULT NULL,
  `ATTENDANCEMAINID` int(11) DEFAULT NULL,
  `Student` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK9FF9AB1DE335F043` (`Student`),
  KEY `FK9FF9AB1DF656B7FD` (`ATTENDANCEMAINID`),
  CONSTRAINT `FK9FF9AB1DE335F043` FOREIGN KEY (`Student`) REFERENCES `school_student` (`student_id`),
  CONSTRAINT `FK9FF9AB1DF656B7FD` FOREIGN KEY (`ATTENDANCEMAINID`) REFERENCES `attendance_attendancemain` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of attendance_attendancelist
-- ----------------------------

-- ----------------------------
-- Table structure for attendance_attendancemain
-- ----------------------------
DROP TABLE IF EXISTS `attendance_attendancemain`;
CREATE TABLE `attendance_attendancemain` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DAY` date DEFAULT NULL,
  `STARTTIME` datetime DEFAULT NULL,
  `ENDTIME` datetime DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `CLASSROOM` int(11) DEFAULT NULL,
  `COMPUTERROOM` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK9FFA00383673E367` (`CLASSROOM`),
  KEY `FK9FFA0038673C4976` (`COMPUTERROOM`),
  CONSTRAINT `FK9FFA00383673E367` FOREIGN KEY (`CLASSROOM`) REFERENCES `attendance_computerroom` (`ID`),
  CONSTRAINT `FK9FFA0038673C4976` FOREIGN KEY (`COMPUTERROOM`) REFERENCES `school_classroom` (`ClassRoom_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of attendance_attendancemain
-- ----------------------------

-- ----------------------------
-- Table structure for attendance_computerroom
-- ----------------------------
DROP TABLE IF EXISTS `attendance_computerroom`;
CREATE TABLE `attendance_computerroom` (
  `ID` int(11) NOT NULL,
  `IPSECTION` varchar(255) DEFAULT NULL,
  `ROOMNO` varchar(255) DEFAULT NULL,
  `ADDRESS` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of attendance_computerroom
-- ----------------------------

-- ----------------------------
-- Table structure for bbs_post
-- ----------------------------
DROP TABLE IF EXISTS `bbs_post`;
CREATE TABLE `bbs_post` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `response_count` int(11) DEFAULT NULL,
  `newresp` tinyint(1) DEFAULT NULL,
  `type_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKCE027D2C6D86FE1C` (`type_id`),
  CONSTRAINT `FKCE027D2C6D86FE1C` FOREIGN KEY (`type_id`) REFERENCES `bbs_post_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bbs_post
-- ----------------------------
INSERT INTO `bbs_post` VALUES ('1', '13', '321', null, '2016-11-14 17:06:16', '0', '0', '1');

-- ----------------------------
-- Table structure for bbs_post_type
-- ----------------------------
DROP TABLE IF EXISTS `bbs_post_type`;
CREATE TABLE `bbs_post_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bbs_post_type
-- ----------------------------
INSERT INTO `bbs_post_type` VALUES ('1', '');

-- ----------------------------
-- Table structure for bbs_response
-- ----------------------------
DROP TABLE IF EXISTS `bbs_response`;
CREATE TABLE `bbs_response` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `response_time` datetime DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `post_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9FA7D2CD890CBC5C` (`post_id`),
  CONSTRAINT `FK9FA7D2CD890CBC5C` FOREIGN KEY (`post_id`) REFERENCES `bbs_post` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bbs_response
-- ----------------------------

-- ----------------------------
-- Table structure for exam
-- ----------------------------
DROP TABLE IF EXISTS `exam`;
CREATE TABLE `exam` (
  `exam_id` int(11) NOT NULL AUTO_INCREMENT,
  `examPaperId` int(11) DEFAULT NULL,
  `major_ID` int(11) DEFAULT NULL,
  `STARTDATE` datetime DEFAULT NULL,
  `ENDDATE` datetime DEFAULT NULL,
  `CREATEDATE` datetime DEFAULT NULL,
  `REMARK` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`exam_id`),
  KEY `FK20B01FE4DFB48D` (`examPaperId`),
  KEY `FK20B01F27A8E627` (`major_ID`),
  CONSTRAINT `FK20B01F27A8E627` FOREIGN KEY (`major_ID`) REFERENCES `school_major` (`major_ID`),
  CONSTRAINT `FK20B01FE4DFB48D` FOREIGN KEY (`examPaperId`) REFERENCES `exam_exampaper` (`examPaperId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exam
-- ----------------------------

-- ----------------------------
-- Table structure for exam_answer
-- ----------------------------
DROP TABLE IF EXISTS `exam_answer`;
CREATE TABLE `exam_answer` (
  `answer_id` int(11) NOT NULL AUTO_INCREMENT,
  `ANSWER` varchar(255) DEFAULT NULL,
  `RIGHT_` tinyint(1) DEFAULT NULL,
  `PARSE` varchar(255) DEFAULT NULL,
  `DEFEN` float DEFAULT NULL,
  `REMARK` varchar(255) DEFAULT NULL,
  `answerSheets_id` int(11) DEFAULT NULL,
  `questions_Id` int(11) DEFAULT NULL,
  PRIMARY KEY (`answer_id`),
  KEY `FKBE42E7DEFC023FD2` (`questions_Id`),
  KEY `FKBE42E7DE83AD0062` (`answerSheets_id`),
  CONSTRAINT `FKBE42E7DE83AD0062` FOREIGN KEY (`answerSheets_id`) REFERENCES `exam_answersheets` (`answerSheets_id`),
  CONSTRAINT `FKBE42E7DEFC023FD2` FOREIGN KEY (`questions_Id`) REFERENCES `exam_questions` (`questions_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exam_answer
-- ----------------------------

-- ----------------------------
-- Table structure for exam_answersheets
-- ----------------------------
DROP TABLE IF EXISTS `exam_answersheets`;
CREATE TABLE `exam_answersheets` (
  `answerSheets_id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) DEFAULT NULL,
  `examPaperId` int(11) DEFAULT NULL,
  `exam_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`answerSheets_id`),
  KEY `FKB59A4C52E4DFB48D` (`examPaperId`),
  KEY `FKB59A4C527811B922` (`exam_id`),
  KEY `FKB59A4C5215ADEFA7` (`student_id`),
  CONSTRAINT `FKB59A4C5215ADEFA7` FOREIGN KEY (`student_id`) REFERENCES `school_student` (`student_id`),
  CONSTRAINT `FKB59A4C527811B922` FOREIGN KEY (`exam_id`) REFERENCES `exam` (`exam_id`),
  CONSTRAINT `FKB59A4C52E4DFB48D` FOREIGN KEY (`examPaperId`) REFERENCES `exam_exampaper` (`examPaperId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exam_answersheets
-- ----------------------------

-- ----------------------------
-- Table structure for exam_classify
-- ----------------------------
DROP TABLE IF EXISTS `exam_classify`;
CREATE TABLE `exam_classify` (
  `classify_id` int(11) NOT NULL AUTO_INCREMENT,
  `CLASSIFY` varchar(255) DEFAULT NULL,
  `CREATEDATE` datetime DEFAULT NULL,
  `STATE` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`classify_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exam_classify
-- ----------------------------
INSERT INTO `exam_classify` VALUES ('1', 'java', '2016-10-24 12:29:52', '1');

-- ----------------------------
-- Table structure for exam_difficulty
-- ----------------------------
DROP TABLE IF EXISTS `exam_difficulty`;
CREATE TABLE `exam_difficulty` (
  `difficulty_id` int(11) NOT NULL AUTO_INCREMENT,
  `DIFFICULTY` varchar(255) DEFAULT NULL,
  `CREATEDATE` datetime DEFAULT NULL,
  `STATE` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`difficulty_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exam_difficulty
-- ----------------------------
INSERT INTO `exam_difficulty` VALUES ('1', '难', '2016-10-24 12:29:35', '1');

-- ----------------------------
-- Table structure for exam_exampaper
-- ----------------------------
DROP TABLE IF EXISTS `exam_exampaper`;
CREATE TABLE `exam_exampaper` (
  `examPaperId` int(11) NOT NULL AUTO_INCREMENT,
  `PAPERNAME` varchar(255) DEFAULT NULL,
  `ZONGSCORE` float DEFAULT NULL,
  `JIGESCORE` float DEFAULT NULL,
  `SCORE` float DEFAULT NULL,
  `STATE` tinyint(1) DEFAULT NULL,
  `CREATEDATE` datetime DEFAULT NULL,
  `paperSourceId` int(11) DEFAULT NULL,
  `paperClassifyId` int(11) DEFAULT NULL,
  `paperGroupingId` int(11) DEFAULT NULL,
  `teacher_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`examPaperId`),
  KEY `FK8315FC8D12AAC01` (`paperSourceId`),
  KEY `FK8315FC8D26493A47` (`teacher_ID`),
  KEY `FK8315FC8DA678DFD1` (`paperGroupingId`),
  KEY `FK8315FC8D53CDFE93` (`paperClassifyId`),
  CONSTRAINT `FK8315FC8D12AAC01` FOREIGN KEY (`paperSourceId`) REFERENCES `exam_papersource` (`paperSourceId`),
  CONSTRAINT `FK8315FC8D26493A47` FOREIGN KEY (`teacher_ID`) REFERENCES `school_teacher` (`teacher_ID`),
  CONSTRAINT `FK8315FC8D53CDFE93` FOREIGN KEY (`paperClassifyId`) REFERENCES `exam_paperclassify` (`paperClassifyId`),
  CONSTRAINT `FK8315FC8DA678DFD1` FOREIGN KEY (`paperGroupingId`) REFERENCES `exam_papergrouping` (`paperGroupingId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exam_exampaper
-- ----------------------------
INSERT INTO `exam_exampaper` VALUES ('1', 'test', '20', '20', '0', '1', '2016-10-24 12:38:09', '1', '1', '1', '1');

-- ----------------------------
-- Table structure for exam_grouping
-- ----------------------------
DROP TABLE IF EXISTS `exam_grouping`;
CREATE TABLE `exam_grouping` (
  `grouping_id` int(11) NOT NULL AUTO_INCREMENT,
  `GROUPING` varchar(255) DEFAULT NULL,
  `CREATEDATE` datetime DEFAULT NULL,
  `STATE` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`grouping_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exam_grouping
-- ----------------------------
INSERT INTO `exam_grouping` VALUES ('1', '测试组', '2016-10-24 12:30:01', '1');

-- ----------------------------
-- Table structure for exam_paperclassify
-- ----------------------------
DROP TABLE IF EXISTS `exam_paperclassify`;
CREATE TABLE `exam_paperclassify` (
  `paperClassifyId` int(11) NOT NULL AUTO_INCREMENT,
  `PAPERCLASSIFY` varchar(255) DEFAULT NULL,
  `CREATEDATE` datetime DEFAULT NULL,
  `STATE` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`paperClassifyId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exam_paperclassify
-- ----------------------------
INSERT INTO `exam_paperclassify` VALUES ('1', '期末', '2016-10-24 12:30:21', '1');

-- ----------------------------
-- Table structure for exam_papergrouping
-- ----------------------------
DROP TABLE IF EXISTS `exam_papergrouping`;
CREATE TABLE `exam_papergrouping` (
  `paperGroupingId` int(11) NOT NULL AUTO_INCREMENT,
  `PAPERGROUPING` varchar(255) DEFAULT NULL,
  `CREATEDATE` datetime DEFAULT NULL,
  `STATE` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`paperGroupingId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exam_papergrouping
-- ----------------------------
INSERT INTO `exam_papergrouping` VALUES ('1', '计算机', '2016-10-24 12:30:28', '1');

-- ----------------------------
-- Table structure for exam_papersource
-- ----------------------------
DROP TABLE IF EXISTS `exam_papersource`;
CREATE TABLE `exam_papersource` (
  `paperSourceId` int(11) NOT NULL AUTO_INCREMENT,
  `PAPERSOURCE` varchar(255) DEFAULT NULL,
  `CREATEDATE` datetime DEFAULT NULL,
  `STATE` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`paperSourceId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exam_papersource
-- ----------------------------
INSERT INTO `exam_papersource` VALUES ('1', '组合', '2016-10-24 12:30:34', '1');

-- ----------------------------
-- Table structure for exam_qgrouping
-- ----------------------------
DROP TABLE IF EXISTS `exam_qgrouping`;
CREATE TABLE `exam_qgrouping` (
  `qgrouping_id` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) DEFAULT NULL,
  `INDEX_` int(11) DEFAULT NULL,
  `TYPE_` varchar(255) DEFAULT NULL,
  `ZONGFEN` float DEFAULT NULL,
  `examPaperId` int(11) DEFAULT NULL,
  PRIMARY KEY (`qgrouping_id`),
  KEY `FK713FF454E4DFB48D` (`examPaperId`),
  CONSTRAINT `FK713FF454E4DFB48D` FOREIGN KEY (`examPaperId`) REFERENCES `exam_exampaper` (`examPaperId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exam_qgrouping
-- ----------------------------
INSERT INTO `exam_qgrouping` VALUES ('1', '大题', '1', null, '20', '1');

-- ----------------------------
-- Table structure for exam_questions
-- ----------------------------
DROP TABLE IF EXISTS `exam_questions`;
CREATE TABLE `exam_questions` (
  `questions_Id` int(11) NOT NULL AUTO_INCREMENT,
  `QUESTIONS` varchar(255) DEFAULT NULL,
  `A` varchar(255) DEFAULT NULL,
  `B` varchar(255) DEFAULT NULL,
  `C` varchar(255) DEFAULT NULL,
  `D` varchar(255) DEFAULT NULL,
  `ANSWER` varchar(255) DEFAULT NULL,
  `PARSE` varchar(255) DEFAULT NULL,
  `ANSWER_PD` int(11) DEFAULT NULL,
  `STUDENTANSWER` varchar(255) DEFAULT NULL,
  `ZHENGQUE` tinyint(1) DEFAULT NULL,
  `FENZHI` float DEFAULT NULL,
  `SCORE` float DEFAULT NULL,
  `CODE` int(11) DEFAULT NULL,
  `qCODE` int(11) DEFAULT NULL,
  `TYPE` varchar(255) DEFAULT NULL,
  `qgrouping_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`questions_Id`),
  KEY `FK1CB9A90DD51C6B6E` (`qgrouping_id`),
  CONSTRAINT `FK1CB9A90DD51C6B6E` FOREIGN KEY (`qgrouping_id`) REFERENCES `exam_qgrouping` (`qgrouping_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exam_questions
-- ----------------------------
INSERT INTO `exam_questions` VALUES ('4', '123456789', null, null, null, null, '曲儿返回给', '曲儿返回给', '0', null, '0', '0', '0', '0', '1', 'tiankong', '1');

-- ----------------------------
-- Table structure for exam_questions_danxuan
-- ----------------------------
DROP TABLE IF EXISTS `exam_questions_danxuan`;
CREATE TABLE `exam_questions_danxuan` (
  `danxuan_id` int(11) NOT NULL AUTO_INCREMENT,
  `QUESTIONS_DX` longtext,
  `A` longtext,
  `B` longtext,
  `C` longtext,
  `D` longtext,
  `ANSWER_DX` longtext,
  `PARSE` longtext,
  `STATE` tinyint(1) DEFAULT NULL,
  `TYPE` varchar(255) DEFAULT NULL,
  `CREATEDATE` datetime DEFAULT NULL,
  `classify_id` int(11) DEFAULT NULL,
  `difficulty_id` int(11) DEFAULT NULL,
  `grouping_id` int(11) DEFAULT NULL,
  `source_id` int(11) DEFAULT NULL,
  `teacher_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`danxuan_id`),
  KEY `FK159121A9718515A2` (`source_id`),
  KEY `FK159121A9EE7B4DA2` (`difficulty_id`),
  KEY `FK159121A9E2C73F02` (`classify_id`),
  KEY `FK159121A93231BAA2` (`grouping_id`),
  KEY `FK159121A926493A47` (`teacher_ID`),
  CONSTRAINT `FK159121A926493A47` FOREIGN KEY (`teacher_ID`) REFERENCES `school_teacher` (`teacher_ID`),
  CONSTRAINT `FK159121A93231BAA2` FOREIGN KEY (`grouping_id`) REFERENCES `exam_grouping` (`grouping_id`),
  CONSTRAINT `FK159121A9718515A2` FOREIGN KEY (`source_id`) REFERENCES `exam_source` (`source_id`),
  CONSTRAINT `FK159121A9E2C73F02` FOREIGN KEY (`classify_id`) REFERENCES `exam_classify` (`classify_id`),
  CONSTRAINT `FK159121A9EE7B4DA2` FOREIGN KEY (`difficulty_id`) REFERENCES `exam_difficulty` (`difficulty_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exam_questions_danxuan
-- ----------------------------

-- ----------------------------
-- Table structure for exam_questions_duoxuan
-- ----------------------------
DROP TABLE IF EXISTS `exam_questions_duoxuan`;
CREATE TABLE `exam_questions_duoxuan` (
  `duoxuan_id` int(11) NOT NULL AUTO_INCREMENT,
  `QUESTIONS_DXS` longtext,
  `A` longtext,
  `B` longtext,
  `C` longtext,
  `D` longtext,
  `E` longtext,
  `F` longtext,
  `ANSWER_DXS` longtext,
  `PARSE` longtext,
  `STATE` tinyint(1) DEFAULT NULL,
  `TYPE` varchar(255) DEFAULT NULL,
  `CREATEDATE` datetime DEFAULT NULL,
  `classify_id` int(11) DEFAULT NULL,
  `difficulty_id` int(11) DEFAULT NULL,
  `grouping_id` int(11) DEFAULT NULL,
  `source_id` int(11) DEFAULT NULL,
  `teacher_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`duoxuan_id`),
  KEY `FK37C02596718515A2` (`source_id`),
  KEY `FK37C02596EE7B4DA2` (`difficulty_id`),
  KEY `FK37C02596E2C73F02` (`classify_id`),
  KEY `FK37C025963231BAA2` (`grouping_id`),
  KEY `FK37C0259626493A47` (`teacher_ID`),
  CONSTRAINT `FK37C0259626493A47` FOREIGN KEY (`teacher_ID`) REFERENCES `school_teacher` (`teacher_ID`),
  CONSTRAINT `FK37C025963231BAA2` FOREIGN KEY (`grouping_id`) REFERENCES `exam_grouping` (`grouping_id`),
  CONSTRAINT `FK37C02596718515A2` FOREIGN KEY (`source_id`) REFERENCES `exam_source` (`source_id`),
  CONSTRAINT `FK37C02596E2C73F02` FOREIGN KEY (`classify_id`) REFERENCES `exam_classify` (`classify_id`),
  CONSTRAINT `FK37C02596EE7B4DA2` FOREIGN KEY (`difficulty_id`) REFERENCES `exam_difficulty` (`difficulty_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exam_questions_duoxuan
-- ----------------------------

-- ----------------------------
-- Table structure for exam_questions_jianda
-- ----------------------------
DROP TABLE IF EXISTS `exam_questions_jianda`;
CREATE TABLE `exam_questions_jianda` (
  `jianda_id` int(11) NOT NULL AUTO_INCREMENT,
  `QUESTIONS_JD` longtext,
  `ANSWER_JD` longtext,
  `PARSE` longtext,
  `STATE` tinyint(1) DEFAULT NULL,
  `TYPE` varchar(255) DEFAULT NULL,
  `CREATEDATE` datetime DEFAULT NULL,
  `classify_id` int(11) DEFAULT NULL,
  `difficulty_id` int(11) DEFAULT NULL,
  `grouping_id` int(11) DEFAULT NULL,
  `source_id` int(11) DEFAULT NULL,
  `teacher_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`jianda_id`),
  KEY `FKE20F869B718515A2` (`source_id`),
  KEY `FKE20F869BEE7B4DA2` (`difficulty_id`),
  KEY `FKE20F869BE2C73F02` (`classify_id`),
  KEY `FKE20F869B3231BAA2` (`grouping_id`),
  KEY `FKE20F869B26493A47` (`teacher_ID`),
  CONSTRAINT `FKE20F869B26493A47` FOREIGN KEY (`teacher_ID`) REFERENCES `school_teacher` (`teacher_ID`),
  CONSTRAINT `FKE20F869B3231BAA2` FOREIGN KEY (`grouping_id`) REFERENCES `exam_grouping` (`grouping_id`),
  CONSTRAINT `FKE20F869B718515A2` FOREIGN KEY (`source_id`) REFERENCES `exam_source` (`source_id`),
  CONSTRAINT `FKE20F869BE2C73F02` FOREIGN KEY (`classify_id`) REFERENCES `exam_classify` (`classify_id`),
  CONSTRAINT `FKE20F869BEE7B4DA2` FOREIGN KEY (`difficulty_id`) REFERENCES `exam_difficulty` (`difficulty_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exam_questions_jianda
-- ----------------------------

-- ----------------------------
-- Table structure for exam_questions_panduan
-- ----------------------------
DROP TABLE IF EXISTS `exam_questions_panduan`;
CREATE TABLE `exam_questions_panduan` (
  `panduan_id` int(11) NOT NULL AUTO_INCREMENT,
  `QUESTIONS_PD` varchar(255) DEFAULT NULL,
  `ANSWER_PD` int(11) DEFAULT NULL,
  `state` tinyint(1) DEFAULT NULL,
  `PARSE` varchar(255) DEFAULT NULL,
  `TYPE` varchar(255) DEFAULT NULL,
  `CREATEDATE` datetime DEFAULT NULL,
  `classify_id` int(11) DEFAULT NULL,
  `difficulty_id` int(11) DEFAULT NULL,
  `grouping_id` int(11) DEFAULT NULL,
  `source_id` int(11) DEFAULT NULL,
  `teacher_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`panduan_id`),
  KEY `FK9052D149718515A2` (`source_id`),
  KEY `FK9052D149EE7B4DA2` (`difficulty_id`),
  KEY `FK9052D149E2C73F02` (`classify_id`),
  KEY `FK9052D1493231BAA2` (`grouping_id`),
  KEY `FK9052D14926493A47` (`teacher_ID`),
  CONSTRAINT `FK9052D14926493A47` FOREIGN KEY (`teacher_ID`) REFERENCES `school_teacher` (`teacher_ID`),
  CONSTRAINT `FK9052D1493231BAA2` FOREIGN KEY (`grouping_id`) REFERENCES `exam_grouping` (`grouping_id`),
  CONSTRAINT `FK9052D149718515A2` FOREIGN KEY (`source_id`) REFERENCES `exam_source` (`source_id`),
  CONSTRAINT `FK9052D149E2C73F02` FOREIGN KEY (`classify_id`) REFERENCES `exam_classify` (`classify_id`),
  CONSTRAINT `FK9052D149EE7B4DA2` FOREIGN KEY (`difficulty_id`) REFERENCES `exam_difficulty` (`difficulty_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exam_questions_panduan
-- ----------------------------

-- ----------------------------
-- Table structure for exam_questions_tiankong
-- ----------------------------
DROP TABLE IF EXISTS `exam_questions_tiankong`;
CREATE TABLE `exam_questions_tiankong` (
  `tiankong_id` int(11) NOT NULL AUTO_INCREMENT,
  `QUESTIONS_TK` varchar(255) DEFAULT NULL,
  `ANSWER_TK` varchar(255) DEFAULT NULL,
  `STATE` tinyint(1) DEFAULT NULL,
  `PARSE` varchar(255) DEFAULT NULL,
  `TYPE` varchar(255) DEFAULT NULL,
  `CREATEDATE` datetime DEFAULT NULL,
  `classify_id` int(11) DEFAULT NULL,
  `difficulty_id` int(11) DEFAULT NULL,
  `grouping_id` int(11) DEFAULT NULL,
  `source_id` int(11) DEFAULT NULL,
  `teacher_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`tiankong_id`),
  KEY `FKAB177971718515A2` (`source_id`),
  KEY `FKAB177971EE7B4DA2` (`difficulty_id`),
  KEY `FKAB177971E2C73F02` (`classify_id`),
  KEY `FKAB1779713231BAA2` (`grouping_id`),
  KEY `FKAB17797126493A47` (`teacher_ID`),
  CONSTRAINT `FKAB17797126493A47` FOREIGN KEY (`teacher_ID`) REFERENCES `school_teacher` (`teacher_ID`),
  CONSTRAINT `FKAB1779713231BAA2` FOREIGN KEY (`grouping_id`) REFERENCES `exam_grouping` (`grouping_id`),
  CONSTRAINT `FKAB177971718515A2` FOREIGN KEY (`source_id`) REFERENCES `exam_source` (`source_id`),
  CONSTRAINT `FKAB177971E2C73F02` FOREIGN KEY (`classify_id`) REFERENCES `exam_classify` (`classify_id`),
  CONSTRAINT `FKAB177971EE7B4DA2` FOREIGN KEY (`difficulty_id`) REFERENCES `exam_difficulty` (`difficulty_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exam_questions_tiankong
-- ----------------------------
INSERT INTO `exam_questions_tiankong` VALUES ('1', '123456789', '曲儿返回给', '1', null, 'tiankong', '2016-10-24 12:31:07', '1', '1', '1', '1', '1');

-- ----------------------------
-- Table structure for exam_source
-- ----------------------------
DROP TABLE IF EXISTS `exam_source`;
CREATE TABLE `exam_source` (
  `source_id` int(11) NOT NULL AUTO_INCREMENT,
  `SOURCE` varchar(255) DEFAULT NULL,
  `CREATEDATE` datetime DEFAULT NULL,
  `STATE` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`source_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exam_source
-- ----------------------------
INSERT INTO `exam_source` VALUES ('1', '手动', '2016-10-24 12:29:45', '1');

-- ----------------------------
-- Table structure for lesson_difficultyguidance
-- ----------------------------
DROP TABLE IF EXISTS `lesson_difficultyguidance`;
CREATE TABLE `lesson_difficultyguidance` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DIFFNAME` varchar(255) DEFAULT NULL,
  `DIFFSCHEME` varchar(255) DEFAULT NULL,
  `DIFFREMARK` varchar(255) DEFAULT NULL,
  `ATTACHMENTSPATH` varchar(255) DEFAULT NULL,
  `OLDFILEPATH` varchar(255) DEFAULT NULL,
  `CREATEDATE` datetime DEFAULT NULL,
  `COURSE_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKE523327AAB71B610` (`COURSE_ID`),
  CONSTRAINT `FKE523327AAB71B610` FOREIGN KEY (`COURSE_ID`) REFERENCES `lesson_excellentcourse` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lesson_difficultyguidance
-- ----------------------------

-- ----------------------------
-- Table structure for lesson_excellentcourse
-- ----------------------------
DROP TABLE IF EXISTS `lesson_excellentcourse`;
CREATE TABLE `lesson_excellentcourse` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) DEFAULT NULL,
  `TEACHINGTHOUGHT` longtext,
  `TEACHINGCONTENT` longtext,
  `COURSEPARSING` longtext,
  `TEACHINGTEAM` longtext,
  `TEACHINGAIM` longtext,
  `TEACHINGREQUIRE` longtext,
  `PRACTICE` longtext,
  `WORK` longtext,
  `SCHEDULING` longtext,
  `THUMBNAILPATH` longtext,
  `CREATEDATE` datetime DEFAULT NULL,
  `COURSECODE` varchar(255) DEFAULT NULL,
  `ZHUXIAN` tinyint(1) DEFAULT NULL,
  `CLICKNUM` int(11) DEFAULT NULL,
  `ADDFINISH` tinyint(1) DEFAULT NULL,
  `STATE` tinyint(1) DEFAULT NULL,
  `Audit` tinyint(1) DEFAULT NULL,
  `UPDATEDATE` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lesson_excellentcourse
-- ----------------------------
INSERT INTO `lesson_excellentcourse` VALUES ('1', '测试课程', '和到大街上的几十个呵护和结构性傻笑国际化的干撒先感受见习爱神', null, null, null, null, null, null, null, null, '1477283159480.jpg', '2016-10-24 12:26:20', '001', '0', '0', '0', '1', '0', null);

-- ----------------------------
-- Table structure for lesson_excellentteacher
-- ----------------------------
DROP TABLE IF EXISTS `lesson_excellentteacher`;
CREATE TABLE `lesson_excellentteacher` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TEACHERNAME` varchar(255) DEFAULT NULL,
  `CONTENT` varchar(255) DEFAULT NULL,
  `JOBTITLE` varchar(255) DEFAULT NULL,
  `REMARK` varchar(255) DEFAULT NULL,
  `IMGPATH` varchar(255) DEFAULT NULL,
  `CREATEDATE` datetime DEFAULT NULL,
  `COURSE_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK4B942B13AB71B610` (`COURSE_ID`),
  CONSTRAINT `FK4B942B13AB71B610` FOREIGN KEY (`COURSE_ID`) REFERENCES `lesson_excellentcourse` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lesson_excellentteacher
-- ----------------------------

-- ----------------------------
-- Table structure for lesson_excellentvideo
-- ----------------------------
DROP TABLE IF EXISTS `lesson_excellentvideo`;
CREATE TABLE `lesson_excellentvideo` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `VIDEONAME` varchar(255) DEFAULT NULL,
  `VIDEOSIZE` double DEFAULT NULL,
  `VIDEOPATH` varchar(255) DEFAULT NULL,
  `VIDEOIMGPATH` varchar(255) DEFAULT NULL,
  `CREATEDATE` datetime DEFAULT NULL,
  `COURSE_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKE25393ECAB71B610` (`COURSE_ID`),
  CONSTRAINT `FKE25393ECAB71B610` FOREIGN KEY (`COURSE_ID`) REFERENCES `lesson_excellentcourse` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lesson_excellentvideo
-- ----------------------------

-- ----------------------------
-- Table structure for lesson_expandapplication
-- ----------------------------
DROP TABLE IF EXISTS `lesson_expandapplication`;
CREATE TABLE `lesson_expandapplication` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) DEFAULT NULL,
  `FILEPATH` varchar(255) DEFAULT NULL,
  `OLDFILEPATH` varchar(255) DEFAULT NULL,
  `CREATEDATE` datetime DEFAULT NULL,
  `COURSE_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKB769BB0FAB71B610` (`COURSE_ID`),
  CONSTRAINT `FKB769BB0FAB71B610` FOREIGN KEY (`COURSE_ID`) REFERENCES `lesson_excellentcourse` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lesson_expandapplication
-- ----------------------------

-- ----------------------------
-- Table structure for lesson_experimentcase
-- ----------------------------
DROP TABLE IF EXISTS `lesson_experimentcase`;
CREATE TABLE `lesson_experimentcase` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) DEFAULT NULL,
  `FILEPATH` varchar(255) DEFAULT NULL,
  `CREATEDATE` datetime DEFAULT NULL,
  `COURSE_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK9BD99E94AB71B610` (`COURSE_ID`),
  CONSTRAINT `FK9BD99E94AB71B610` FOREIGN KEY (`COURSE_ID`) REFERENCES `lesson_excellentcourse` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lesson_experimentcase
-- ----------------------------

-- ----------------------------
-- Table structure for lesson_imgcarousel
-- ----------------------------
DROP TABLE IF EXISTS `lesson_imgcarousel`;
CREATE TABLE `lesson_imgcarousel` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `IMGEXPLAIN` varchar(255) DEFAULT NULL,
  `IMGPATH` varchar(255) DEFAULT NULL,
  `REMARK` varchar(255) DEFAULT NULL,
  `CREATEDATE` datetime DEFAULT NULL,
  `COURSE_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKDD16899CAB71B610` (`COURSE_ID`),
  CONSTRAINT `FKDD16899CAB71B610` FOREIGN KEY (`COURSE_ID`) REFERENCES `lesson_excellentcourse` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lesson_imgcarousel
-- ----------------------------

-- ----------------------------
-- Table structure for lesson_lessionbook
-- ----------------------------
DROP TABLE IF EXISTS `lesson_lessionbook`;
CREATE TABLE `lesson_lessionbook` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `BOOKNAME` varchar(255) DEFAULT NULL,
  `BOOKCODE` varchar(255) DEFAULT NULL,
  `PUBLISHINGHOUSE` varchar(255) DEFAULT NULL,
  `PRICE` varchar(255) DEFAULT NULL,
  `INTRODUCE` varchar(255) DEFAULT NULL,
  `AUTHOR` varchar(255) DEFAULT NULL,
  `imgPath` varchar(255) DEFAULT NULL,
  `CREATEDATE` datetime DEFAULT NULL,
  `COURSE_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK25CD2A91AB71B610` (`COURSE_ID`),
  CONSTRAINT `FK25CD2A91AB71B610` FOREIGN KEY (`COURSE_ID`) REFERENCES `lesson_excellentcourse` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lesson_lessionbook
-- ----------------------------

-- ----------------------------
-- Table structure for lesson_referencedata
-- ----------------------------
DROP TABLE IF EXISTS `lesson_referencedata`;
CREATE TABLE `lesson_referencedata` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `REFERENCENAME` varchar(255) DEFAULT NULL,
  `PDFPATH` varchar(255) DEFAULT NULL,
  `CREATEDATE` datetime DEFAULT NULL,
  `OLDFILEPATH` datetime DEFAULT NULL,
  `COURSE_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKBB5CA68EAB71B610` (`COURSE_ID`),
  CONSTRAINT `FKBB5CA68EAB71B610` FOREIGN KEY (`COURSE_ID`) REFERENCES `lesson_excellentcourse` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lesson_referencedata
-- ----------------------------

-- ----------------------------
-- Table structure for practicaltraining_practicaltrainingtask
-- ----------------------------
DROP TABLE IF EXISTS `practicaltraining_practicaltrainingtask`;
CREATE TABLE `practicaltraining_practicaltrainingtask` (
  `practicalTrainingTask_ID` int(11) NOT NULL AUTO_INCREMENT,
  `TASKNAME` varchar(255) DEFAULT NULL,
  `TASKTYPE` varchar(255) DEFAULT NULL,
  `CREATIONTIME` datetime DEFAULT NULL,
  `TASKTIMELIMIT` date DEFAULT NULL,
  `DESCRIBE_` varchar(255) DEFAULT NULL,
  `PRACTICALTRAININGTEMPLATE` int(11) DEFAULT NULL,
  `TEACHER` int(11) DEFAULT NULL,
  `PRACTICALTRAININGTASKSTEP` int(11) DEFAULT NULL,
  PRIMARY KEY (`practicalTrainingTask_ID`),
  KEY `FKD661ED648F2000CC` (`PRACTICALTRAININGTEMPLATE`),
  KEY `FKD661ED64FBD3BF9A` (`PRACTICALTRAININGTASKSTEP`),
  KEY `FKD661ED64179C8391` (`TEACHER`),
  CONSTRAINT `FKD661ED64179C8391` FOREIGN KEY (`TEACHER`) REFERENCES `school_teacher` (`teacher_ID`),
  CONSTRAINT `FKD661ED648F2000CC` FOREIGN KEY (`PRACTICALTRAININGTEMPLATE`) REFERENCES `practicaltraining_practicaltrainingtemplate` (`ID`),
  CONSTRAINT `FKD661ED64FBD3BF9A` FOREIGN KEY (`PRACTICALTRAININGTASKSTEP`) REFERENCES `practicaltraining_practicaltrainingtaskstep` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of practicaltraining_practicaltrainingtask
-- ----------------------------

-- ----------------------------
-- Table structure for practicaltraining_practicaltrainingtaskstep
-- ----------------------------
DROP TABLE IF EXISTS `practicaltraining_practicaltrainingtaskstep`;
CREATE TABLE `practicaltraining_practicaltrainingtaskstep` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `STEPONEDETAILS` varchar(255) DEFAULT NULL,
  `STEPTHREEDETAILS` varchar(255) DEFAULT NULL,
  `STEPFOURDETAILS` varchar(255) DEFAULT NULL,
  `STEPFIVEDETAILS` varchar(255) DEFAULT NULL,
  `STEPSIXDETAILS` varchar(255) DEFAULT NULL,
  `STEPSEVENDETAILS` varchar(255) DEFAULT NULL,
  `STEPEIGHTDETAILS` varchar(255) DEFAULT NULL,
  `STEPNINEDETAILS` varchar(255) DEFAULT NULL,
  `STEPTENDETAILS` varchar(255) DEFAULT NULL,
  `STEPSUM` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of practicaltraining_practicaltrainingtaskstep
-- ----------------------------

-- ----------------------------
-- Table structure for practicaltraining_practicaltrainingtaskstudent
-- ----------------------------
DROP TABLE IF EXISTS `practicaltraining_practicaltrainingtaskstudent`;
CREATE TABLE `practicaltraining_practicaltrainingtaskstudent` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ISSUEDTIME` datetime DEFAULT NULL,
  `CLAIMTIME` datetime DEFAULT NULL,
  `DESCRIBE_` varchar(255) DEFAULT NULL,
  `PROGRESS` varchar(255) DEFAULT NULL,
  `practicalTrainingTask` int(11) DEFAULT NULL,
  `UPLOADTEMPLATENAME` varchar(255) DEFAULT NULL,
  `UPLOADTEMPLATEPATH` varchar(255) DEFAULT NULL,
  `DEGRADATIONTEMPLATENAME` varchar(255) DEFAULT NULL,
  `DEGRADATIONTEMPLATEPATH` varchar(255) DEFAULT NULL,
  `SUBMITMARK` varchar(255) DEFAULT NULL,
  `SCORE` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK2FC90837D9747EE2` (`practicalTrainingTask`),
  CONSTRAINT `FK2FC90837D9747EE2` FOREIGN KEY (`practicalTrainingTask`) REFERENCES `practicaltraining_practicaltrainingtask` (`practicalTrainingTask_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of practicaltraining_practicaltrainingtaskstudent
-- ----------------------------

-- ----------------------------
-- Table structure for practicaltraining_practicaltrainingtemplate
-- ----------------------------
DROP TABLE IF EXISTS `practicaltraining_practicaltrainingtemplate`;
CREATE TABLE `practicaltraining_practicaltrainingtemplate` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TEMPLATENAME` varchar(255) DEFAULT NULL,
  `TECHNOLOGICALTYPE` varchar(255) DEFAULT NULL,
  `UPLOADTIME` datetime DEFAULT NULL,
  `UPLOADTEMPLATENAME` varchar(255) DEFAULT NULL,
  `UPLOADTEMPLATEPATH` varchar(255) DEFAULT NULL,
  `DEGRADATIONTEMPLATENAME` varchar(255) DEFAULT NULL,
  `DEGRADATIONTEMPLATEPATH` varchar(255) DEFAULT NULL,
  `TEACHER` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK98EA74D9179C8391` (`TEACHER`),
  CONSTRAINT `FK98EA74D9179C8391` FOREIGN KEY (`TEACHER`) REFERENCES `school_teacher` (`teacher_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of practicaltraining_practicaltrainingtemplate
-- ----------------------------

-- ----------------------------
-- Table structure for practicaltrainin_task_class
-- ----------------------------
DROP TABLE IF EXISTS `practicaltrainin_task_class`;
CREATE TABLE `practicaltrainin_task_class` (
  `practicalTrainingTask_ID` int(11) NOT NULL,
  `ClassRoom_ID` int(11) NOT NULL,
  PRIMARY KEY (`practicalTrainingTask_ID`,`ClassRoom_ID`),
  KEY `FK2F6A3F454E1B9C34` (`practicalTrainingTask_ID`),
  KEY `FK2F6A3F45C93F0D87` (`ClassRoom_ID`),
  CONSTRAINT `FK2F6A3F454E1B9C34` FOREIGN KEY (`practicalTrainingTask_ID`) REFERENCES `practicaltraining_practicaltrainingtask` (`practicalTrainingTask_ID`),
  CONSTRAINT `FK2F6A3F45C93F0D87` FOREIGN KEY (`ClassRoom_ID`) REFERENCES `school_classroom` (`ClassRoom_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of practicaltrainin_task_class
-- ----------------------------

-- ----------------------------
-- Table structure for practicaltrainin_task_student
-- ----------------------------
DROP TABLE IF EXISTS `practicaltrainin_task_student`;
CREATE TABLE `practicaltrainin_task_student` (
  `practicalTrainingTask_ID` int(11) NOT NULL,
  `id` int(11) NOT NULL,
  PRIMARY KEY (`practicalTrainingTask_ID`,`id`),
  KEY `FK5AF4D4C853377B23` (`id`),
  KEY `FK5AF4D4C84E1B9C34` (`practicalTrainingTask_ID`),
  CONSTRAINT `FK5AF4D4C84E1B9C34` FOREIGN KEY (`practicalTrainingTask_ID`) REFERENCES `practicaltraining_practicaltrainingtask` (`practicalTrainingTask_ID`),
  CONSTRAINT `FK5AF4D4C853377B23` FOREIGN KEY (`id`) REFERENCES `school_student` (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of practicaltrainin_task_student
-- ----------------------------

-- ----------------------------
-- Table structure for school_classroom
-- ----------------------------
DROP TABLE IF EXISTS `school_classroom`;
CREATE TABLE `school_classroom` (
  `ClassRoom_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CLASSROOMNAME` varchar(255) DEFAULT NULL,
  `major_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ClassRoom_ID`),
  KEY `FKA811472827A8E627` (`major_ID`),
  CONSTRAINT `FKA811472827A8E627` FOREIGN KEY (`major_ID`) REFERENCES `school_major` (`major_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of school_classroom
-- ----------------------------

-- ----------------------------
-- Table structure for school_course
-- ----------------------------
DROP TABLE IF EXISTS `school_course`;
CREATE TABLE `school_course` (
  `Course_ID` int(11) NOT NULL,
  `COURSENAME` varchar(255) DEFAULT NULL,
  `COURSEADDRESS` varchar(255) DEFAULT NULL,
  `CONTENT` varchar(255) DEFAULT NULL,
  `CREATEDATE` datetime DEFAULT NULL,
  PRIMARY KEY (`Course_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of school_course
-- ----------------------------

-- ----------------------------
-- Table structure for school_course_classroom
-- ----------------------------
DROP TABLE IF EXISTS `school_course_classroom`;
CREATE TABLE `school_course_classroom` (
  `ClassRoom_ID` int(11) NOT NULL,
  `Course_ID` int(11) NOT NULL,
  PRIMARY KEY (`Course_ID`,`ClassRoom_ID`),
  KEY `FK86FBCC9AC93F0D87` (`ClassRoom_ID`),
  KEY `FK86FBCC9AEBE59E6D` (`Course_ID`),
  CONSTRAINT `FK86FBCC9AC93F0D87` FOREIGN KEY (`ClassRoom_ID`) REFERENCES `school_classroom` (`ClassRoom_ID`),
  CONSTRAINT `FK86FBCC9AEBE59E6D` FOREIGN KEY (`Course_ID`) REFERENCES `school_course` (`Course_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of school_course_classroom
-- ----------------------------

-- ----------------------------
-- Table structure for school_department
-- ----------------------------
DROP TABLE IF EXISTS `school_department`;
CREATE TABLE `school_department` (
  `department_ID` int(11) NOT NULL AUTO_INCREMENT,
  `DEPARTMENTNAME` varchar(255) DEFAULT NULL,
  `DEPARTMENTCONTENT` varchar(255) DEFAULT NULL,
  `CREATEDATE` datetime DEFAULT NULL,
  PRIMARY KEY (`department_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of school_department
-- ----------------------------

-- ----------------------------
-- Table structure for school_major
-- ----------------------------
DROP TABLE IF EXISTS `school_major`;
CREATE TABLE `school_major` (
  `major_ID` int(11) NOT NULL AUTO_INCREMENT,
  `MAJORNAME` varchar(255) DEFAULT NULL,
  `MAJORCONTENT` varchar(255) DEFAULT NULL,
  `CREATEDATE` datetime DEFAULT NULL,
  `department_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`major_ID`),
  KEY `FK5588090EA8D43D8D` (`department_ID`),
  CONSTRAINT `FK5588090EA8D43D8D` FOREIGN KEY (`department_ID`) REFERENCES `school_department` (`department_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of school_major
-- ----------------------------

-- ----------------------------
-- Table structure for school_student
-- ----------------------------
DROP TABLE IF EXISTS `school_student`;
CREATE TABLE `school_student` (
  `student_id` int(11) NOT NULL AUTO_INCREMENT,
  `STUDENTNAME` varchar(255) DEFAULT NULL,
  `STUDENTCODE` varchar(255) DEFAULT NULL,
  `SEX` varchar(255) DEFAULT NULL,
  `AGE` int(11) DEFAULT NULL,
  `LOGINNAME` varchar(255) DEFAULT NULL,
  `LOGINPAS` varchar(255) DEFAULT NULL,
  `CREATEDATE` datetime DEFAULT NULL,
  `ClassRoom_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`student_id`),
  KEY `FK72115050C93F0D87` (`ClassRoom_ID`),
  CONSTRAINT `FK72115050C93F0D87` FOREIGN KEY (`ClassRoom_ID`) REFERENCES `school_classroom` (`ClassRoom_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of school_student
-- ----------------------------

-- ----------------------------
-- Table structure for school_teacher
-- ----------------------------
DROP TABLE IF EXISTS `school_teacher`;
CREATE TABLE `school_teacher` (
  `teacher_ID` int(11) NOT NULL AUTO_INCREMENT,
  `TEACHERNAME` varchar(255) DEFAULT NULL,
  `TEACHERCODE` varchar(255) DEFAULT NULL,
  `SEX` varchar(255) DEFAULT NULL,
  `AGE` int(11) DEFAULT NULL,
  `LOGINNAME` varchar(255) DEFAULT NULL,
  `LOGINPAS` varchar(255) DEFAULT NULL,
  `CREATEDATE` datetime DEFAULT NULL,
  PRIMARY KEY (`teacher_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of school_teacher
-- ----------------------------
INSERT INTO `school_teacher` VALUES ('1', null, null, null, '19', 'admin', 'admin', null);

-- ----------------------------
-- Table structure for school_teacher_course
-- ----------------------------
DROP TABLE IF EXISTS `school_teacher_course`;
CREATE TABLE `school_teacher_course` (
  `Course_ID` int(11) NOT NULL,
  `teacher_ID` int(11) NOT NULL,
  PRIMARY KEY (`teacher_ID`,`Course_ID`),
  KEY `FKC595636326493A47` (`teacher_ID`),
  KEY `FKC5956363EBE59E6D` (`Course_ID`),
  CONSTRAINT `FKC595636326493A47` FOREIGN KEY (`teacher_ID`) REFERENCES `school_teacher` (`teacher_ID`),
  CONSTRAINT `FKC5956363EBE59E6D` FOREIGN KEY (`Course_ID`) REFERENCES `school_course` (`Course_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of school_teacher_course
-- ----------------------------
