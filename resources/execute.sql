CREATE DATABASE `ima_management` CHARACTER SET 'utf8' COLLATE 'utf8_general_ci';

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for DepartmentModel
-- ----------------------------
DROP TABLE IF EXISTS `DepartmentModel`;
CREATE TABLE `DepartmentModel`  (
  `no` int(11) NOT NULL AUTO_INCREMENT,
  `id` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`no`, `id`) USING BTREE,
  UNIQUE INDEX `id`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of DepartmentModel
-- ----------------------------
INSERT INTO `DepartmentModel` VALUES (1, 1, '部门1');
INSERT INTO `DepartmentModel` VALUES (2, 2, '部门2');

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log`  (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `UserModel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `action` varchar(2550) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for UserModels
-- ----------------------------
DROP TABLE IF EXISTS `UserModels`;
CREATE TABLE `UserModels`  (
  `no` int(11) NOT NULL AUTO_INCREMENT,
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `qq` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `DepartmentModel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `permission` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`no`, `id`) USING BTREE,
  UNIQUE INDEX `no`(`no`, `id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of UserModels
-- ----------------------------
INSERT INTO `UserModels` VALUES (2, '1', '测试', 'xMpCOKC5I4INzFCab3WEmw==', '1', '1', '1', '1');

SET FOREIGN_KEY_CHECKS = 1;
