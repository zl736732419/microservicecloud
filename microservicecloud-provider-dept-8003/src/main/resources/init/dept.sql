drop database if exists clouddb03;

create database clouddb03;

use clouddb03;

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept`  (
  `deptno` bigint(20) NOT NULL AUTO_INCREMENT,
  `dname` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `db_source` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`deptno`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES (1, '开发部', 'clouddb03');
INSERT INTO `dept` VALUES (2, '人事部', 'clouddb03');
INSERT INTO `dept` VALUES (3, '财务部', 'clouddb03');
INSERT INTO `dept` VALUES (4, '市场部', 'clouddb03');
INSERT INTO `dept` VALUES (5, '运维部', 'clouddb03');
INSERT INTO `dept` VALUES (6, 'bigdata2019', 'clouddb03');

