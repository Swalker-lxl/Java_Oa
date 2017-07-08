/*
Navicat MySQL Data Transfer

Source Server         : joker
Source Server Version : 50027
Source Host           : localhost:3306
Source Database       : ssi

Target Server Type    : MYSQL
Target Server Version : 50027
File Encoding         : 65001

Date: 2017-07-07 15:35:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `taflselect`
-- ----------------------------
DROP TABLE IF EXISTS `taflselect`;
CREATE TABLE `taflselect` (
  `aflid` varchar(36) NOT NULL default '0000',
  `id` varchar(10) NOT NULL,
  `aflstime` date default NULL,
  `faletime` date default NULL,
  `manhours` int(5) default '0',
  `afltype` varchar(10) default NULL,
  `btexplan` varchar(255) default NULL,
  `btapprover` varchar(100) default NULL,
  `btappss` varchar(2) default '待批',
  `btappdate` date default NULL,
  `addname` varchar(100) default NULL,
  `addtime` date default NULL,
  `updatetime` date default NULL,
  `updatename` varchar(100) default NULL,
  PRIMARY KEY  (`aflid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of taflselect
-- ----------------------------
INSERT INTO `taflselect` VALUES ('11111', '21140401', '2017-07-05', '2017-07-10', '21', '事假', '旅游', 'admin', '同意', '2017-07-04', 'aier', '2017-07-05', '2017-07-07', 'admin/管理员');
INSERT INTO `taflselect` VALUES ('222222', '21140402', '2017-07-04', '2017-07-05', '7', '事假', '买东西', 'admin', '待批', '2017-07-04', 'xue', '2017-07-04', '2017-07-05', 'admin');
INSERT INTO `taflselect` VALUES ('256314', '21140405', '2017-07-12', '2017-07-06', '0', '事假', '吃饭', 'admin', '待批', null, 'li', '2017-07-06', null, null);
INSERT INTO `taflselect` VALUES ('333333', '21140404', '2017-07-12', '2017-07-14', '14', '睡觉', '困', 'admin', '待批', '2017-07-11', 'shui', '2017-07-10', '2017-07-11', 'admin');
INSERT INTO `taflselect` VALUES ('4868', '486486', '2017-07-06', '2017-07-07', '0', '486', '54345', 'admin', '待批', null, '48648', '2017-07-06', null, null);

-- ----------------------------
-- Table structure for `tattselect`
-- ----------------------------
DROP TABLE IF EXISTS `tattselect`;
CREATE TABLE `tattselect` (
  `id` varchar(10) NOT NULL,
  `name` varchar(100) NOT NULL,
  `attdate` date NOT NULL,
  `atworktime` date default NULL,
  `offtime` date default NULL,
  `errorstate` varchar(2) default NULL,
  `attappss` varchar(2) default NULL,
  `addname` varchar(100) default NULL,
  `addtime` date default NULL,
  `updatename` varchar(100) default NULL,
  `updatetime` date default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tattselect
-- ----------------------------
INSERT INTO `tattselect` VALUES ('21140401', 'aier', '2017-07-07', '2017-07-08', '2017-07-09', '无', '待批', 'aier', '2017-07-05', 'admin', '2017-07-07');
INSERT INTO `tattselect` VALUES ('21140402', 'xue', '2017-07-07', '2017-07-08', '2017-07-09', '木', '待批', 'xue', '2017-07-06', 'admin', '2017-07-07');

-- ----------------------------
-- Table structure for `tbtselect`
-- ----------------------------
DROP TABLE IF EXISTS `tbtselect`;
CREATE TABLE `tbtselect` (
  `btid` varchar(36) NOT NULL,
  `id` varchar(10) NOT NULL,
  `name` varchar(100) NOT NULL,
  `btsdate` date NOT NULL,
  `btedate` date NOT NULL,
  `btplace` varchar(255) NOT NULL,
  `btvehicle` varchar(20) NOT NULL,
  `btexplain` varchar(255) default NULL,
  `btapprover` varchar(100) default NULL,
  `attappss` varchar(2) NOT NULL,
  `btappdate` date default NULL,
  `addname` varchar(100) default NULL,
  `addtime` date default NULL,
  `updatename` varchar(100) default NULL,
  `updatetime` date default NULL,
  PRIMARY KEY  (`btid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbtselect
-- ----------------------------
INSERT INTO `tbtselect` VALUES ('11111', '21140401', 'aier', '2017-07-01', '2017-07-01', '沈阳', '动车', '面试', 'admin', '待批', '2017-07-03', 'aier', '2017-07-05', 'admin', '2017-07-04');
INSERT INTO `tbtselect` VALUES ('123123', '123', '23123', '2017-07-05', '2017-07-06', '123123', '123123', '123123', 'admin', '驳回', null, null, null, 'admin/管理员', '2017-07-07');
INSERT INTO `tbtselect` VALUES ('12345', '234', 'houge', '2017-07-04', '2017-07-03', 'asdf', 'adada', 'wert', 'user', '同意', null, 'admin/管理员', '2017-07-07', 'admin/管理员', '2017-07-07');
INSERT INTO `tbtselect` VALUES ('22222', '21140402', 'xue', '2017-07-02', '2017-07-05', '北京', '火车', '工作', 'admin', '待批', '2017-07-03', 'xue', '2017-07-03', 'admin', '2017-07-06');

-- ----------------------------
-- Table structure for `tdept`
-- ----------------------------
DROP TABLE IF EXISTS `tdept`;
CREATE TABLE `tdept` (
  `PID` varchar(36) NOT NULL,
  `PIDCONCLS` varchar(100) default NULL,
  `PNAME` varchar(100) NOT NULL,
  `CSEQ` decimal(22,0) default NULL,
  `CPID` varchar(36) default NULL,
  `MESSAGE` varchar(200) default NULL,
  PRIMARY KEY  (`PID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tdept
-- ----------------------------
INSERT INTO `tdept` VALUES ('123', '', '会计q', '2', 'qwer', '123');
INSERT INTO `tdept` VALUES ('1c9f45f0-de8c-4663-b935-17cc5c289f1a', '', 'rng', '3', '123', '');
INSERT INTO `tdept` VALUES ('466', 'icon-add', 'uzi', '3', 'qwer', '123');
INSERT INTO `tdept` VALUES ('649fbf83-c4f2-4cb0-9260-cf21e936f189', '', 'mata', '3', '466', '');
INSERT INTO `tdept` VALUES ('qwer', null, '部门', '0', null, '');

-- ----------------------------
-- Table structure for `tfiveandone`
-- ----------------------------
DROP TABLE IF EXISTS `tfiveandone`;
CREATE TABLE `tfiveandone` (
  `id` varchar(36) NOT NULL,
  `fname` varchar(10) default NULL,
  `scale` double(8,2) default NULL,
  `createtime` date default NULL,
  `createname` varchar(36) default NULL,
  `modifytime` date default NULL,
  `modifyname` varchar(36) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tfiveandone
-- ----------------------------
INSERT INTO `tfiveandone` VALUES ('01', '退休基金', '0.10', '2017-07-01', null, '2017-07-08', null);
INSERT INTO `tfiveandone` VALUES ('02', '医疗保障金', '0.20', '2017-07-05', null, '2017-07-07', null);

-- ----------------------------
-- Table structure for `tjob`
-- ----------------------------
DROP TABLE IF EXISTS `tjob`;
CREATE TABLE `tjob` (
  `id` varchar(2) NOT NULL,
  `name` varchar(20) default NULL,
  `addname` varchar(100) default NULL,
  `addtime` datetime default NULL,
  `updatename` varchar(100) default NULL,
  `updatetime` datetime default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tjob
-- ----------------------------
INSERT INTO `tjob` VALUES ('1', '技术部', 'admin/管理员', '2017-07-06 15:16:54', null, null);
INSERT INTO `tjob` VALUES ('2', '研发部', 'admin/管理员', '2017-07-06 13:45:29', 'admin/管理员', '2017-07-06 15:19:25');

-- ----------------------------
-- Table structure for `tkpi`
-- ----------------------------
DROP TABLE IF EXISTS `tkpi`;
CREATE TABLE `tkpi` (
  `id` varchar(36) NOT NULL,
  `pername` varchar(200) NOT NULL,
  `percontent` varchar(100) NOT NULL,
  `post` varchar(36) NOT NULL,
  `flag` int(2) NOT NULL,
  `createname` varchar(36) default NULL,
  `createtime` date default NULL,
  `modifyname` varchar(36) default NULL,
  `modifytime` date default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tkpi
-- ----------------------------
INSERT INTO `tkpi` VALUES ('aaaaaaaaaaaaaaaaaaaaaaa', 'aa', 'aa', 'aa', '1', 'aa', '2017-07-07', null, null);
INSERT INTO `tkpi` VALUES ('K001', '开启每月绩效与关闭', '开启绩效', '管理员', '0', 'admin', '2017-07-05', 'admin', '2017-07-06');
INSERT INTO `tkpi` VALUES ('K002', '完成数据库相关任务建表', '数据库建表', '数据库运维工程师', '0', 'C001', '2017-07-06', 'C002', '2017-07-14');

-- ----------------------------
-- Table structure for `tmenu`
-- ----------------------------
DROP TABLE IF EXISTS `tmenu`;
CREATE TABLE `tmenu` (
  `CID` varchar(36) NOT NULL,
  `CICONCLS` varchar(100) default NULL,
  `CNAME` varchar(100) NOT NULL,
  `CSEQ` decimal(22,0) default NULL,
  `CURL` varchar(200) default NULL,
  `CPID` varchar(36) default NULL,
  PRIMARY KEY  (`CID`),
  KEY `PID` (`CPID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tmenu
-- ----------------------------
INSERT INTO `tmenu` VALUES ('0', null, '首页', '1', null, null);
INSERT INTO `tmenu` VALUES ('02faed0a-2c69-4e62-966d-a573d5e180c2', null, '绩效审批管理', '3', '/performance/perassess/perassess.do', 'f1350e37-f2a8-4dbc-81c2-88a7611f0bc5');
INSERT INTO `tmenu` VALUES ('0507dbb0-3f2e-4436-be38-213a5c7a85c0', null, '出差管理', '3', '/base/bt/bt.do', '2d11b303-0a85-44be-8940-8c9decc4b55b');
INSERT INTO `tmenu` VALUES ('150eb768-1c89-48bb-a616-d1a926278ea8', null, '出勤管理', '3', '/base/att/att.do', '2d11b303-0a85-44be-8940-8c9decc4b55b');
INSERT INTO `tmenu` VALUES ('2219a937-9ad4-4723-915f-ce3186cea245', null, '请假管理', '3', '/base/afl/afl.do', '2d11b303-0a85-44be-8940-8c9decc4b55b');
INSERT INTO `tmenu` VALUES ('28f31f97-a125-4ed5-88eb-25f210f0b06f', null, '部门管理', '1', '/structure/dept/dept.do', '61a52ee2-351d-4e4a-9ac8-a2d05111d4fa');
INSERT INTO `tmenu` VALUES ('29bacd48-6446-4908-8caf-abfddaccdca4', null, '数据库', '1', '/druid/index.html', '84edd04a-40f9-4404-95b7-bd7114e64eeb');
INSERT INTO `tmenu` VALUES ('2d11b303-0a85-44be-8940-8c9decc4b55b', null, '考勤管理', '3', null, '0');
INSERT INTO `tmenu` VALUES ('3b23c36c-4661-47c0-aa4f-3bfac242bd61', null, '薪资管理', '3', null, '0');
INSERT INTO `tmenu` VALUES ('3d72244e-ff29-4340-bab1-e99ea9851f24', null, '工资条', '3', '/salary/wageitem/wageitem.do', '3b23c36c-4661-47c0-aa4f-3bfac242bd61');
INSERT INTO `tmenu` VALUES ('436e2414-af1c-4854-a481-a4b7002cf31b', null, '绩效起停管理', '3', '/performance/perss/perss.do', 'f1350e37-f2a8-4dbc-81c2-88a7611f0bc5');
INSERT INTO `tmenu` VALUES ('441788a4-d38d-4bc3-b35d-b118837f0400', null, '员工档案管理', '3', '/emp/empFile/empFile.do', 'ec06d350-4308-4d98-aea9-1a9213efe262');
INSERT INTO `tmenu` VALUES ('4d517480-9dd3-4338-baac-14f8927d0039', null, '薪资设置', '1', '/salary/swage/swage.do', '3b23c36c-4661-47c0-aa4f-3bfac242bd61');
INSERT INTO `tmenu` VALUES ('534697d7-9367-4824-a757-ca39c376d12b', null, '绩效等级管理', '3', '/performance/perrank/perrank.do', 'f1350e37-f2a8-4dbc-81c2-88a7611f0bc5');
INSERT INTO `tmenu` VALUES ('5e4932ce-fc5b-4fc7-bd78-42c2610330d6', null, '员工信息管理', '3', '/emp/employee/employee.do', 'ec06d350-4308-4d98-aea9-1a9213efe262');
INSERT INTO `tmenu` VALUES ('5f98c3c2-9f6e-4829-b5bc-92ab57b15948', null, '五险一金', '2', '/salary/fiveandone/fiveandone.do', '3b23c36c-4661-47c0-aa4f-3bfac242bd61');
INSERT INTO `tmenu` VALUES ('61a52ee2-351d-4e4a-9ac8-a2d05111d4fa', null, '组织架构', '2', null, '0');
INSERT INTO `tmenu` VALUES ('84edd04a-40f9-4404-95b7-bd7114e64eeb', null, '数据库', '10', '/druid/index.html', '0');
INSERT INTO `tmenu` VALUES ('b876ffe7-1a5f-4127-9a9b-74ef17d8d574', null, '工作计划管理', '3', '/performance/workplan/workplan.do', 'f1350e37-f2a8-4dbc-81c2-88a7611f0bc5');
INSERT INTO `tmenu` VALUES ('bc87d791-ab09-482c-bf74-d28408186705', null, '岗位管理', '3', '/emp/job/job.do', 'ec06d350-4308-4d98-aea9-1a9213efe262');
INSERT INTO `tmenu` VALUES ('cb6d7c8d-b805-40d8-a297-fe4beb6062cf', null, 'kpi绩效管理', '3', '/performance/kpi/kpi.do', 'f1350e37-f2a8-4dbc-81c2-88a7611f0bc5');
INSERT INTO `tmenu` VALUES ('cdgl', null, '菜单管理', '4', '/admin/menu/menu.do', 'xtgl');
INSERT INTO `tmenu` VALUES ('e13b9459-50bc-46b9-b7d1-4439930c8cd1', null, '职位管理', '2', '/structure/post/post.do', '61a52ee2-351d-4e4a-9ac8-a2d05111d4fa');
INSERT INTO `tmenu` VALUES ('ec06d350-4308-4d98-aea9-1a9213efe262', null, '人事管理', '3', null, '0');
INSERT INTO `tmenu` VALUES ('f1350e37-f2a8-4dbc-81c2-88a7611f0bc5', null, '绩效管理', '3', null, '0');
INSERT INTO `tmenu` VALUES ('fa4af11b-2626-438e-807f-be2751a8fdf2', null, '通讯录', '3', '/emp/connect/connect.do', 'ec06d350-4308-4d98-aea9-1a9213efe262');
INSERT INTO `tmenu` VALUES ('xtgl', null, '系统管理', '2', null, '0');
INSERT INTO `tmenu` VALUES ('yhgl', null, '用户管理', '1', '/admin/user/user.do', 'xtgl');

-- ----------------------------
-- Table structure for `tmessage`
-- ----------------------------
DROP TABLE IF EXISTS `tmessage`;
CREATE TABLE `tmessage` (
  `id` varchar(36) NOT NULL,
  `sendid` varchar(10) NOT NULL,
  `sentime` varchar(400) NOT NULL,
  `content` varchar(255) NOT NULL,
  `flac` varchar(2) NOT NULL,
  `acceptid` varchar(10) NOT NULL,
  `theme` varchar(100) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tmessage
-- ----------------------------
INSERT INTO `tmessage` VALUES ('0071c8ac-bae1-4e71-bf67-bc61e1caf598', 'jzh', '2017-07-07', '哈哈H', '1', '管理员', 'uzi');
INSERT INTO `tmessage` VALUES ('14859ec2-c229-42d3-99bc-354c8d528be1', '管理员', '2017-07-06', '大家都来', '1', '管理员', '都去哪');
INSERT INTO `tmessage` VALUES ('2e3c64e2-b121-4d7e-ba43-ad2d1d90cde2', '管理员', '2017-07-06', '666666666', '1', '管理员', '哈哈H');
INSERT INTO `tmessage` VALUES ('31df5515-a853-4591-9169-3977207db6e2', '管理员', '2017-07-06', '爱你爱你', '1', 'zhaoyj945', '爱你');
INSERT INTO `tmessage` VALUES ('47538ee5-a5bd-4a65-8428-9a8775af45ae', '管理员', '2017-07-06', '123', '1', '管理员', '哈HHA');
INSERT INTO `tmessage` VALUES ('5acc57a1-89de-426a-969a-e0d23239f75c', '管理员', '2017-07-07', '123', '1', '管理员', '杜泉');
INSERT INTO `tmessage` VALUES ('c08d1d15-1086-4210-a27e-ee19e7e2fe06', '管理员', '2017-07-06', '123', '0', 'duquan', '123');

-- ----------------------------
-- Table structure for `tperassess`
-- ----------------------------
DROP TABLE IF EXISTS `tperassess`;
CREATE TABLE `tperassess` (
  `id` varchar(36) character set utf8 NOT NULL,
  `uid` varchar(10) default NULL,
  `monthtime` date NOT NULL,
  `perrank` varchar(255) character set utf8 NOT NULL,
  `asspeople` varchar(255) character set utf8 NOT NULL,
  `asstime` date NOT NULL,
  `createname` varchar(255) character set utf8 default NULL,
  `createdatetime` date default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=geostd8;

-- ----------------------------
-- Records of tperassess
-- ----------------------------
INSERT INTO `tperassess` VALUES ('P001', 'U001', '2017-07-01', '85', 'C001', '2017-06-04', 'C002', '2017-07-08');
INSERT INTO `tperassess` VALUES ('P002', 'U002', '2017-07-06', '89', 'C002', '2017-07-20', 'C003', '2017-09-02');
INSERT INTO `tperassess` VALUES ('P1003', 'U1002', '2017-07-01', '66', '审批人1', '2017-07-02', null, '2017-07-06');

-- ----------------------------
-- Table structure for `tperrank`
-- ----------------------------
DROP TABLE IF EXISTS `tperrank`;
CREATE TABLE `tperrank` (
  `id` varchar(36) character set utf8 NOT NULL,
  `pname` varchar(100) default NULL,
  `coefficient` double(100,2) NOT NULL,
  `createname` varchar(255) NOT NULL,
  `createdatetime` date NOT NULL,
  `modifyname` varchar(255) default NULL,
  `modifydatetime` date default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=geostd8;

-- ----------------------------
-- Records of tperrank
-- ----------------------------
INSERT INTO `tperrank` VALUES ('T001', 'aa', '0.40', 'bb', '2017-07-01', 'cc', '2017-07-12');
INSERT INTO `tperrank` VALUES ('T002', 'dd', '0.30', 'ee', '2017-06-01', 'ff', '2017-06-22');

-- ----------------------------
-- Table structure for `tpersonaltax`
-- ----------------------------
DROP TABLE IF EXISTS `tpersonaltax`;
CREATE TABLE `tpersonaltax` (
  `id` varchar(36) NOT NULL,
  `ptax` double(8,2) default NULL,
  `pmin` double(8,2) default NULL,
  `pmax` double(8,2) default NULL,
  `prank` varchar(2) default NULL,
  `createname` varchar(15) default NULL,
  `createtime` date default NULL,
  `modifyname` varchar(15) default NULL,
  `modifytime` date default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tpersonaltax
-- ----------------------------

-- ----------------------------
-- Table structure for `tperss`
-- ----------------------------
DROP TABLE IF EXISTS `tperss`;
CREATE TABLE `tperss` (
  `id` varchar(36) character set utf8 NOT NULL,
  `monthtime` date NOT NULL,
  `state` varchar(1) NOT NULL,
  `createname` varchar(100) NOT NULL,
  `createdatetime` date NOT NULL,
  `modifyname` varchar(100) default NULL,
  `modifydatetime` date default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=geostd8;

-- ----------------------------
-- Records of tperss
-- ----------------------------
INSERT INTO `tperss` VALUES ('P001', '2017-06-01', '0', 'abc', '2017-07-01', 'ddd', '2017-07-07');
INSERT INTO `tperss` VALUES ('P002', '2017-07-08', '1', 'bb', '2017-06-01', 'cc', '2017-07-09');

-- ----------------------------
-- Table structure for `tpost`
-- ----------------------------
DROP TABLE IF EXISTS `tpost`;
CREATE TABLE `tpost` (
  `id` varchar(36) NOT NULL,
  `pname` varchar(10) default NULL,
  `addname` varchar(100) default NULL,
  `addtime` date default NULL,
  `updatename` varchar(100) default NULL,
  `updatetime` date default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tpost
-- ----------------------------
INSERT INTO `tpost` VALUES ('123', 'wawa22', 'admin/管理员', '2017-07-06', 'admin/管理员', '2017-07-06');
INSERT INTO `tpost` VALUES ('2', '青铜', 'pdd', '2017-07-13', '亡者', null);
INSERT INTO `tpost` VALUES ('345', '123', 'admin/管理员', '2017-07-06', null, null);
INSERT INTO `tpost` VALUES ('456', '123', 'admin/管理员', '2017-07-06', null, null);
INSERT INTO `tpost` VALUES ('677', '123456', 'admin/管理员', '2017-07-06', null, null);
INSERT INTO `tpost` VALUES ('rng', '55开', 'uzi', '2017-07-03', null, null);
INSERT INTO `tpost` VALUES ('ww', 'ww', 'admin/管理员', '2017-07-06', null, null);

-- ----------------------------
-- Table structure for `tpwage`
-- ----------------------------
DROP TABLE IF EXISTS `tpwage`;
CREATE TABLE `tpwage` (
  `id` varchar(36) NOT NULL,
  `wagetime` varchar(8) default NULL,
  `state` varchar(8) default NULL,
  `createtime` date default NULL,
  `createname` varchar(36) default NULL,
  `modifytime` date default NULL,
  `modifyname` varchar(36) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tpwage
-- ----------------------------

-- ----------------------------
-- Table structure for `tstafffile`
-- ----------------------------
DROP TABLE IF EXISTS `tstafffile`;
CREATE TABLE `tstafffile` (
  `filetime` datetime default NULL,
  `tid` varchar(36) NOT NULL,
  `id` varchar(10) NOT NULL,
  `idnumber` varchar(18) default NULL,
  `rigin` varchar(100) default NULL,
  `education` varchar(10) default NULL,
  `degree` varchar(10) default NULL,
  `ps` varchar(20) default NULL,
  `school` varchar(60) default NULL,
  `major` varchar(60) default NULL,
  `workexp` varchar(255) default NULL,
  `homeadd` varchar(255) default NULL,
  `addname` varchar(100) default NULL,
  `addtime` datetime default NULL,
  `updatename` varchar(100) default NULL,
  `updatetime` datetime default NULL,
  PRIMARY KEY  (`tid`),
  KEY `id` (`id`),
  CONSTRAINT `tstafffile_ibfk_1` FOREIGN KEY (`id`) REFERENCES `tstaffinf` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tstafffile
-- ----------------------------
INSERT INTO `tstafffile` VALUES (null, '1', '3', '123', '123', '132', '123', '132', '123', '123', '123', '123', 'admin/管理员', '2017-07-06 15:15:45', null, null);
INSERT INTO `tstafffile` VALUES (null, '123', '2222', '222', '222', '222', '222', '222', '222', '222', '222', '222', 'admin/管理员', '2017-07-07 11:01:36', null, null);

-- ----------------------------
-- Table structure for `tstaffinf`
-- ----------------------------
DROP TABLE IF EXISTS `tstaffinf`;
CREATE TABLE `tstaffinf` (
  `id` varchar(10) NOT NULL,
  `name` varchar(100) default NULL,
  `sex` varchar(1) default NULL,
  `photo` varchar(255) default NULL,
  `depart` varchar(8) default NULL,
  `position` varchar(362) default NULL,
  `station` varchar(255) default NULL,
  `location` varchar(255) default NULL,
  `pnumber` varchar(20) default NULL,
  `email` varchar(100) default NULL,
  `hiredate` datetime default NULL,
  `leavedate` datetime default NULL,
  `addname` varchar(100) default NULL,
  `addtime` datetime default NULL,
  `updatename` varchar(100) default NULL,
  `updatetime` datetime default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tstaffinf
-- ----------------------------
INSERT INTO `tstaffinf` VALUES ('2222', '123', '1', 'photos/1499396477270.jpg', '2222', '2222', '2222', '2222', '22222', '222@qq.com', '2017-07-30 11:01:06', '2017-07-26 11:01:11', 'admin/管理员', '2017-07-07 11:01:17', null, null);
INSERT INTO `tstaffinf` VALUES ('3', '李四', '1', 'photos/1499409840084.jpg', '1', '1', '1', '1', '1', '253285277@qq.com', '2017-07-06 15:14:18', '2017-07-26 15:14:23', 'admin/管理员', '2017-07-06 15:14:26', 'uzi/jzh', '2017-07-07 14:44:00');
INSERT INTO `tstaffinf` VALUES ('333', '1', '1', 'photos/1499411639043.jpg', '1', '1', '1', '1', '1', '253285277@qq.com', '2017-07-19 15:13:39', '2017-07-12 15:13:43', 'admin/管理员', '2017-07-07 15:13:48', 'admin/管理员', '2017-07-07 15:13:59');

-- ----------------------------
-- Table structure for `tswage`
-- ----------------------------
DROP TABLE IF EXISTS `tswage`;
CREATE TABLE `tswage` (
  `id` varchar(36) NOT NULL,
  `basewage` double(8,2) default NULL,
  `meriwag` double(8,2) default NULL,
  `waward` double(8,2) default NULL,
  `wbank` varchar(36) default NULL,
  `wrank` varchar(36) default NULL,
  `createtime` date default NULL,
  `createid` varchar(36) default NULL,
  `modifytime` date default NULL,
  `modifyid` varchar(36) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tswage
-- ----------------------------
INSERT INTO `tswage` VALUES ('001', '5000.00', '3000.00', '1000.00', '12345678', 'B', '2017-07-01', null, '2017-07-06', 'admin001');
INSERT INTO `tswage` VALUES ('002', '5000.00', '3500.00', '1200.00', '23456781', 'A+', '2017-07-01', null, '2017-07-07', 'admin002');
INSERT INTO `tswage` VALUES ('003', '5000.00', '3540.00', '600.00', '98765432', 'A', '2017-07-07', 'admin/管理员', null, null);

-- ----------------------------
-- Table structure for `tuser`
-- ----------------------------
DROP TABLE IF EXISTS `tuser`;
CREATE TABLE `tuser` (
  `CID` varchar(36) NOT NULL,
  `CREATETIME` datetime default NULL,
  `CREATEID` varchar(36) default NULL,
  `MODIFYTIME` datetime default NULL,
  `MODIFYID` varchar(36) default NULL,
  `CNAME` varchar(100) NOT NULL,
  `CPWD` varchar(100) NOT NULL,
  PRIMARY KEY  (`CID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tuser
-- ----------------------------
INSERT INTO `tuser` VALUES ('123', '2017-07-05 08:46:57', 'admin/管理员', '2017-07-05 22:41:34', 'admin/管理员', '1234', '202cb962ac59075b964b07152d234b70');
INSERT INTO `tuser` VALUES ('1234', '2017-07-06 08:36:28', 'admin/管理员', '2017-07-06 09:07:43', 'admin/管理员', '12344', '202cb962ac59075b964b07152d234b70');
INSERT INTO `tuser` VALUES ('admin', null, null, null, null, '管理员', '4a7d1ed414474e4033ac29ccb8653d9b');
INSERT INTO `tuser` VALUES ('user', '2017-07-03 18:09:25', 'admin/管理员', null, null, '普通用户', '4a7d1ed414474e4033ac29ccb8653d9b');
INSERT INTO `tuser` VALUES ('uzi', '2017-07-07 14:39:49', 'admin/管理员', null, null, 'jzh', '81dc9bdb52d04dc20036dbd8313ed055');
INSERT INTO `tuser` VALUES ('wen', '2017-07-06 21:17:39', 'admin/管理员', null, null, 'zhaoyj945', '81dc9bdb52d04dc20036dbd8313ed055');

-- ----------------------------
-- Table structure for `twageitem`
-- ----------------------------
DROP TABLE IF EXISTS `twageitem`;
CREATE TABLE `twageitem` (
  `waid` varchar(36) NOT NULL,
  `wuid` varchar(10) default NULL,
  `basewage` double(8,2) default NULL,
  `meritwage` double(8,2) default NULL,
  `bouns` double(8,2) default NULL,
  `deductions` double(8,0) default NULL,
  `dedfiveone` double(8,0) default NULL,
  `wagetime` varchar(8) default NULL,
  `shsend` double(8,2) default NULL,
  `realsend` double(8,2) default NULL,
  `createname` varchar(15) default NULL,
  `createtime` date default NULL,
  `modifyname` varchar(15) default NULL,
  `modifytime` date default NULL,
  PRIMARY KEY  (`waid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of twageitem
-- ----------------------------
INSERT INTO `twageitem` VALUES ('201601', '001', '5000.00', '200.00', '100.00', '300', '500', '20160101', '7600.00', '7600.00', null, null, '管理员01', null);
INSERT INTO `twageitem` VALUES ('201602', '001', '5000.00', '300.00', '50.00', null, null, '20160201', null, null, null, null, null, null);
INSERT INTO `twageitem` VALUES ('201603', '001', '5000.00', '200.00', '300.00', null, null, '20160301', null, null, null, null, null, null);
INSERT INTO `twageitem` VALUES ('201701', '002', '6000.00', '300.00', '50.00', null, null, '', null, null, null, null, null, null);
INSERT INTO `twageitem` VALUES ('201702', '002', '6000.00', '300.00', '50.00', null, null, '', null, null, null, null, null, null);
INSERT INTO `twageitem` VALUES ('201703', '002', '6000.00', '300.00', '50.00', null, null, '', null, null, null, null, null, null);
INSERT INTO `twageitem` VALUES ('201704', '002', '6000.00', '300.00', '300.00', null, null, null, null, null, null, null, null, null);
INSERT INTO `twageitem` VALUES ('201705', '002', '6000.00', '200.00', '300.00', null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `tworkplan`
-- ----------------------------
DROP TABLE IF EXISTS `tworkplan`;
CREATE TABLE `tworkplan` (
  `id` varchar(36) character set utf8 NOT NULL,
  `uid` varchar(10) default NULL,
  `plan` varchar(255) character set utf8 default NULL,
  `monthtime` date default NULL,
  `kid` varchar(255) character set utf8 default NULL,
  `createname` varchar(255) character set utf8 default NULL,
  `createdatetime` date default NULL,
  `modifyname` varchar(255) character set utf8 default NULL,
  `modifydatetime` date default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=geostd8;

-- ----------------------------
-- Records of tworkplan
-- ----------------------------
INSERT INTO `tworkplan` VALUES ('W001', 'U001', '我的计划1', '2017-07-01', '数据库相关任务', 'C001', '2017-07-01', 'C002', '2017-07-12');
INSERT INTO `tworkplan` VALUES ('W002', 'U002', '我的计划2', '2017-07-08', '运维相关任务', 'C003', '2017-07-01', 'C004', '2017-07-11');
INSERT INTO `tworkplan` VALUES ('W1003', 'U1003', '我的计划3', '2017-07-01', '网络相关任务', 'abc', '2017-07-06', null, null);

-- ----------------------------
-- Table structure for `tworkscore`
-- ----------------------------
DROP TABLE IF EXISTS `tworkscore`;
CREATE TABLE `tworkscore` (
  `id` varchar(36) NOT NULL,
  `wuid` varchar(10) NOT NULL,
  `monthtime` varchar(100) NOT NULL,
  `score` varchar(36) default NULL,
  `createname` varchar(100) default NULL,
  `createdatetime` date default NULL,
  `modifyname` varchar(100) default NULL,
  `modifydatetime` date default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=geostd8;

-- ----------------------------
-- Records of tworkscore
-- ----------------------------
