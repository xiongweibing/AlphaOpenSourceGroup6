/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50527
 Source Host           : localhost:3306
 Source Schema         : demo

 Target Server Type    : MySQL
 Target Server Version : 50527
 File Encoding         : 65001

 Date: 17/08/2018 10:04:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cq
-- ----------------------------
DROP TABLE IF EXISTS `cq`;
CREATE TABLE `cq`  (
  `id` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `area` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `tenement_num` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `population` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `FBI_num` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `broadband_num` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `IPTV_num` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `otherIPTV_num` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of cq
-- ----------------------------
INSERT INTO `cq` VALUES ('1', 'Yubei', '334', '767', '511', '224', '205', '229');
INSERT INTO `cq` VALUES ('2', 'Yuzhong', '145', '298', '266', '129', '87', '101');
INSERT INTO `cq` VALUES ('3', 'Nanan', '214', '523', '340', '177', '116', '152');
INSERT INTO `cq` VALUES ('4', 'Jiangbei', '223', '517', '407', '201', '134', '178');
INSERT INTO `cq` VALUES ('5', 'Jiulongpo', '217', '477', '480', '176', '157', '211');
INSERT INTO `cq` VALUES ('6', 'Shapingba', '267', '489', '501', '231', '191', '246');

-- ----------------------------
-- Table structure for local_channel
-- ----------------------------
DROP TABLE IF EXISTS `local_channel`;
CREATE TABLE `local_channel`  (
  `id` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL DEFAULT '',
  `channel_type` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `channel_num` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of local_channel
-- ----------------------------
INSERT INTO `local_channel` VALUES ('1', 'monopolized store', '2812');
INSERT INTO `local_channel` VALUES ('2', 'area contract', '1082');
INSERT INTO `local_channel` VALUES ('3', 'open store', '2467');
INSERT INTO `local_channel` VALUES ('4', 'direct agent', '1095');
INSERT INTO `local_channel` VALUES ('5', 'sum', '7456');

-- ----------------------------
-- Table structure for mobile
-- ----------------------------
DROP TABLE IF EXISTS `mobile`;
CREATE TABLE `mobile`  (
  `id` int(2) NOT NULL,
  `area` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `carrieroperator` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `M_income` float(255, 1) NULL DEFAULT NULL,
  `M_userPer` int(3) NULL DEFAULT NULL,
  `Month_1` float(255, 1) NULL DEFAULT NULL,
  `Month_2` float(255, 1) NULL DEFAULT NULL,
  `Month_3` float(255, 1) NULL DEFAULT NULL,
  `Month_4` float(255, 1) NULL DEFAULT NULL,
  `Month_5` float(255, 1) NULL DEFAULT NULL,
  `Month_6` float(255, 1) NULL DEFAULT NULL,
  `Month_7` float(255, 1) NULL DEFAULT NULL,
  `Month_8` float(255, 1) NULL DEFAULT NULL,
  `Month_9` float(255, 1) NULL DEFAULT NULL,
  `Month_10` float(255, 1) NULL DEFAULT NULL,
  `Month_11` float(255, 1) NULL DEFAULT NULL,
  `Month_12` float(255, 1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of mobile
-- ----------------------------
INSERT INTO `mobile` VALUES (1, 'jiangbei', 'CT', 76454.6, 154, 345.6, 368.4, 298.5, 281.7, 312.6, 391.6, 300.6, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `mobile` VALUES (2, 'jiangbei', 'CMCC', 160750.7, 302, 698.1, 712.5, 709.2, 645.2, 721.2, 621.1, 680.4, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `mobile` VALUES (3, 'jiangbei', 'CUCC', 49662.8, 127, 213.9, 245.8, 209.6, 178.5, 199.4, 278.4, 271.1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `mobile` VALUES (4, 'jiulongpo', 'CT', 82335.7, 156, 298.4, 301.3, 224.6, 260.1, 334.7, 247.4, 219.5, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `mobile` VALUES (5, 'jiulongpo', 'CMCC', 143107.3, 300, 708.1, 677.1, 635.5, 597.2, 691.4, 603.3, 578.1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `mobile` VALUES (6, 'jiulongpo', 'CUCC', 56850.8, 140, 187.4, 201.5, 265.2, 234.8, 276.6, 197.4, 323.6, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `mobile` VALUES (7, 'nanan', 'CT', 95078.1, 2222, 251.5, 268.9, 267.2, 271.6, 256.7, 267.5, 331.2, 111111.0, NULL, NULL, NULL, NULL);
INSERT INTO `mobile` VALUES (8, 'nanan', 'CMCC', 166631.8, 1, 1.0, 607.6, 588.8, 571.0, 610.2, 634.1, 602.2, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `mobile` VALUES (9, 'nanan', 'CUCC', 60118.1, 130, 234.7, 213.6, 246.1, 198.1, 298.3, 210.4, 200.4, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `mobile` VALUES (10, 'yuzhong', 'CT', 90177.2, 150, 201.3, 215.2, 231.3, 229.5, 251.2, 255.8, 269.1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `mobile` VALUES (11, 'yuzhong', 'CMCC', 190156.3, 300, 578.3, 587.2, 598.3, 571.9, 588.2, 601.2, 611.3, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `mobile` VALUES (12, 'yuzhong', 'CUCC', 62732.0, 160, 231.1, 224.1, 219.1, 268.5, 234.6, 246.7, 199.2, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `mobile` VALUES (13, 'yubei', 'CT', 98018.7, 3, 376.1, 360.5, 378.1, 381.4, 329.1, 376.1, 378.3, 123.0, NULL, NULL, NULL, 2.0);
INSERT INTO `mobile` VALUES (14, 'yubei', 'CMCC', 196037.4, 2342, 432.0, 689.1, 657.3, 708.1, 688.2, 697.3, 711.4, 12.0, 2.0, 2001.0, NULL, NULL);
INSERT INTO `mobile` VALUES (15, 'yubei', 'CUCC', 65345.8, 33333, 276.3, 257.1, 289.1, 219.9, 244.2, 256.5, 231.5, NULL, NULL, 22222.0, NULL, NULL);
INSERT INTO `mobile` VALUES (16, 'shapingba', 'CT', 29405.6, 200, 278.1, 265.1, 275.1, 274.6, 282.1, 262.4, 297.3, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `mobile` VALUES (17, 'shapingba', 'CMCC', 98018.7, 1, 564.1, 578.2, 598.1, 613.3, 607.1, 587.3, 598.2, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `mobile` VALUES (18, 'shapingba', 'CUCC', 26138.3, 140, 234.4, 251.2, 214.1, 210.0, 246.7, 197.6, 229.9, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for other_channel
-- ----------------------------
DROP TABLE IF EXISTS `other_channel`;
CREATE TABLE `other_channel`  (
  `id` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `carrieroperator` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `channel_num` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of other_channel
-- ----------------------------
INSERT INTO `other_channel` VALUES ('1', 'CMCC', '9233');
INSERT INTO `other_channel` VALUES ('2', 'CUCC', '5712');

-- ----------------------------
-- Table structure for store_users
-- ----------------------------
DROP TABLE IF EXISTS `store_users`;
CREATE TABLE `store_users`  (
  `id` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL DEFAULT '',
  `service_type` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `user_num` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of store_users
-- ----------------------------
INSERT INTO `store_users` VALUES ('1', 'mobile', '843');
INSERT INTO `store_users` VALUES ('2', 'broadband', '675');
INSERT INTO `store_users` VALUES ('3', 'IPTV', '369');

SET FOREIGN_KEY_CHECKS = 1;
