/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : Wach_book

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 25/12/2019 10:04:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for department_info
-- ----------------------------
DROP TABLE IF EXISTS `department_info`;
CREATE TABLE `department_info` (
  `d_id` int(5) NOT NULL AUTO_INCREMENT COMMENT '系别id',
  `d_nanem` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '院系名称',
  `d_teacher_name` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '院长姓名',
  `d_teacher_phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '院长电话',
  `d_teacher_email` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '院长邮箱',
  `d_sup_id` int(5) NOT NULL DEFAULT '0' COMMENT '上级id，0为院其他为系',
  PRIMARY KEY (`d_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='院系班表';

-- ----------------------------
-- Records of department_info
-- ----------------------------
BEGIN;
INSERT INTO `department_info` VALUES (1, '文学院', '诺言', '13234221343', '13234221343@qq.com', 0);
INSERT INTO `department_info` VALUES (2, '计算机与应用学院', '张学艺', '18333465123', '18333465123@qq.com', 0);
INSERT INTO `department_info` VALUES (3, '理学院', '罗振江', '15634678934', '15634678934@163.com', 0);
INSERT INTO `department_info` VALUES (4, '法学院', '郑阳', '15434235678', '15434235678@163.com', 0);
INSERT INTO `department_info` VALUES (5, '新闻传媒学院', '蒋健', '18745654879', '18745654879@163.com', 0);
INSERT INTO `department_info` VALUES (6, '哲学系', '陈敏尔', '13435462635', '13435462635@163.com', 1);
INSERT INTO `department_info` VALUES (7, '中国文学系', '陈敏尔', '13435462635', '13435462635@163.com', 1);
INSERT INTO `department_info` VALUES (8, '史学系', '陈眉之', '13654673557', '13654673557@qq.com', 1);
INSERT INTO `department_info` VALUES (9, '法律系', '何宝光', '15634874567', '15634874567@163.com', 4);
INSERT INTO `department_info` VALUES (10, '计算机系', '张学艺', '18333465123', '18333465123@163.com', 2);
INSERT INTO `department_info` VALUES (11, '网络工程系', '张学艺', '18333456123', '18333456123@163.com', 2);
INSERT INTO `department_info` VALUES (12, '应用数学系', '何茫兹', '13245763456', '13245763456@163.com', 3);
INSERT INTO `department_info` VALUES (13, '化学系', '马天翔', '14365745322', '14365745322@163.com', 3);
INSERT INTO `department_info` VALUES (14, '物理系', '蒋登丽', '14556342354', '14556342354@163.com', 3);
INSERT INTO `department_info` VALUES (15, '新闻系', '李丹丹', '13423432323', '13423432323@163.com', 5);
INSERT INTO `department_info` VALUES (16, '广告系', '李丹丹', '13423432323', '13423432323@163.com', 5);
INSERT INTO `department_info` VALUES (17, 'WX201001', '吴炳光', '14345672312', '14345672312@163.com', 7);
INSERT INTO `department_info` VALUES (18, 'ZX20101', '将田凯', '13256342343', '13256342343@163.com', 6);
INSERT INTO `department_info` VALUES (19, 'SX20101', '王丹凯', '14323126789', '14323126789@163.com', 8);
INSERT INTO `department_info` VALUES (20, 'JSJ20101', '张学艺', '18333456123', '18333456123@163.com', 10);
INSERT INTO `department_info` VALUES (21, 'WL20101', '张学艺', '18333456123', '18333456123@163.com', 11);
COMMIT;

-- ----------------------------
-- Table structure for dormitory_info
-- ----------------------------
DROP TABLE IF EXISTS `dormitory_info`;
CREATE TABLE `dormitory_info` (
  `d_id` int(5) NOT NULL AUTO_INCREMENT COMMENT '寝室id',
  `f_id` int(5) NOT NULL COMMENT '楼号id',
  `max_number` int(1) NOT NULL DEFAULT '0' COMMENT '最大入住数量9人',
  `d_number` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '寝室号',
  `current_number` int(1) DEFAULT '0' COMMENT '当前人数',
  PRIMARY KEY (`d_id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='寝室表';

-- ----------------------------
-- Records of dormitory_info
-- ----------------------------
BEGIN;
INSERT INTO `dormitory_info` VALUES (1, 1, 6, '101', 6);
INSERT INTO `dormitory_info` VALUES (2, 1, 6, '102', 0);
INSERT INTO `dormitory_info` VALUES (3, 1, 6, '103', 0);
INSERT INTO `dormitory_info` VALUES (4, 1, 6, '104', 0);
INSERT INTO `dormitory_info` VALUES (5, 1, 6, '105', 0);
INSERT INTO `dormitory_info` VALUES (6, 1, 6, '106', 0);
INSERT INTO `dormitory_info` VALUES (7, 3, 4, 'Y-101', 0);
INSERT INTO `dormitory_info` VALUES (8, 3, 4, 'Y-102', 0);
INSERT INTO `dormitory_info` VALUES (9, 3, 4, 'Y-103', 0);
INSERT INTO `dormitory_info` VALUES (10, 2, 8, '101', 0);
INSERT INTO `dormitory_info` VALUES (11, 2, 8, '102', 0);
INSERT INTO `dormitory_info` VALUES (12, 2, 8, '103', 0);
INSERT INTO `dormitory_info` VALUES (13, 2, 8, '104', 0);
INSERT INTO `dormitory_info` VALUES (14, 2, 8, '105', 0);
INSERT INTO `dormitory_info` VALUES (15, 2, 6, '201', 6);
INSERT INTO `dormitory_info` VALUES (16, 2, 6, '202', 0);
INSERT INTO `dormitory_info` VALUES (17, 2, 6, '203', 0);
INSERT INTO `dormitory_info` VALUES (18, 2, 8, '204', 0);
INSERT INTO `dormitory_info` VALUES (19, 2, 6, '205', 0);
INSERT INTO `dormitory_info` VALUES (20, 2, 6, '207', 0);
INSERT INTO `dormitory_info` VALUES (21, 2, 6, '208', 0);
INSERT INTO `dormitory_info` VALUES (22, 2, 6, '209', 0);
INSERT INTO `dormitory_info` VALUES (23, 2, 6, '210', 0);
INSERT INTO `dormitory_info` VALUES (24, 1, 4, '201', 0);
INSERT INTO `dormitory_info` VALUES (25, 1, 4, '202', 0);
INSERT INTO `dormitory_info` VALUES (26, 1, 4, '203', 0);
INSERT INTO `dormitory_info` VALUES (27, 1, 4, '205', 0);
INSERT INTO `dormitory_info` VALUES (28, 1, 4, '206', 0);
INSERT INTO `dormitory_info` VALUES (29, 1, 4, '207', 0);
INSERT INTO `dormitory_info` VALUES (30, 1, 4, '208', 0);
INSERT INTO `dormitory_info` VALUES (31, 1, 4, '209', 0);
INSERT INTO `dormitory_info` VALUES (32, 1, 4, '210', 0);
COMMIT;

-- ----------------------------
-- Table structure for floor_info
-- ----------------------------
DROP TABLE IF EXISTS `floor_info`;
CREATE TABLE `floor_info` (
  `f_id` int(5) NOT NULL AUTO_INCREMENT COMMENT '楼层id',
  `u_id` int(5) NOT NULL COMMENT '管理人员id',
  `add_time` varchar(50) DEFAULT NULL COMMENT '创建时间',
  `add_by` int(5) DEFAULT NULL COMMENT '创建人id',
  `up_date` varchar(50) DEFAULT NULL COMMENT '修改时间',
  `up_by` int(5) DEFAULT NULL COMMENT '修改人id',
  `f_sex` int(1) DEFAULT '1' COMMENT '楼层类型，0女生寝室1男生',
  `f_number` int(2) DEFAULT NULL COMMENT '楼层数',
  `f_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_czech_ci NOT NULL COMMENT '楼层名称',
  PRIMARY KEY (`f_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='寝室楼号表';

-- ----------------------------
-- Records of floor_info
-- ----------------------------
BEGIN;
INSERT INTO `floor_info` VALUES (1, 2, '2019-12-24 15:02:01', 1, NULL, NULL, 0, 5, '梨冬苑');
INSERT INTO `floor_info` VALUES (2, 4, '2019-12-24 15:02:23', 1, NULL, NULL, 1, 6, '奋进苑');
INSERT INTO `floor_info` VALUES (3, 6, '2019-12-24 15:02:45', 1, NULL, NULL, 0, 4, '研究生楼');
INSERT INTO `floor_info` VALUES (4, 4, '2019-12-24 15:03:20', 1, NULL, NULL, 1, 4, '研究生楼');
COMMIT;

-- ----------------------------
-- Table structure for menu_info
-- ----------------------------
DROP TABLE IF EXISTS `menu_info`;
CREATE TABLE `menu_info` (
  `menu_id` int(3) NOT NULL AUTO_INCREMENT COMMENT '菜单id',
  `menu_code` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单编码',
  `menu_name` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单名称',
  `menu_nav` varchar(150) NOT NULL COMMENT '菜单导航表示',
  `menu_remark` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '注释',
  `menu_url` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单地址',
  `menu_level` int(1) NOT NULL COMMENT '菜单类型，1导航，2菜单',
  `menu_order` int(5) DEFAULT NULL COMMENT '排序',
  `menu_status` int(1) DEFAULT NULL COMMENT '菜单状态，1启用，2禁用',
  `menu_pid` int(2) DEFAULT '0' COMMENT '上级菜单ID',
  `menu_hidden` int(2) DEFAULT NULL COMMENT '菜单是否隐藏，0隐藏1显示',
  `menu_target` varchar(50) DEFAULT NULL COMMENT '打开类型，single(单页)，iframe，blank（新窗口）',
  `menu_sysid` int(3) NOT NULL COMMENT '所属系统',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='菜单';

-- ----------------------------
-- Records of menu_info
-- ----------------------------
BEGIN;
INSERT INTO `menu_info` VALUES (1, 'sysAdmin', '系统管理', '系统管理', NULL, '#', 2, 1, 1, 0, 1, NULL, 1);
INSERT INTO `menu_info` VALUES (2, 'menu_info', '菜单管理', '系统管理>菜单管理', NULL, 'html/menu_info', 2, 1, 1, 1, 1, NULL, 1);
INSERT INTO `menu_info` VALUES (3, 'user_info', '人员管理', '系统管理 > 人员管理', '系统管理 > 人员管理', 'html/user_info', 2, 1, 1, 1, 1, NULL, 1);
INSERT INTO `menu_info` VALUES (4, 'role_info', '权限管理', '系统管理 >', '', 'html/role_info', 2, 1, 1, 1, 1, NULL, 1);
INSERT INTO `menu_info` VALUES (5, 'org_info', '机构管理', '系统管理 > 机构管理', '', 'html/org_info', 2, 1, 1, 1, 1, NULL, 1);
INSERT INTO `menu_info` VALUES (6, 'dormitory', '宿舍管理', '系统管理 > 宿舍管理', '', '#', 2, 1, 1, 0, 1, NULL, 1);
INSERT INTO `menu_info` VALUES (7, 'department_info', '院系管理', '宿舍管理 > 院系管理', '', 'dormitory/department_info', 2, 1, 1, 6, 1, NULL, 1);
INSERT INTO `menu_info` VALUES (8, 'dormitory_info', '寝室管理', '宿舍管理 > 寝室管理', '', 'dormitory/dormitory_info', 2, 1, 1, 6, 1, NULL, 1);
INSERT INTO `menu_info` VALUES (9, 'floor_info', '楼层管理', '宿舍管理 > 楼层管理', '', 'dormitory/floor_info', 2, 1, 1, 6, 1, NULL, 1);
INSERT INTO `menu_info` VALUES (10, 'student_into', '学生入住', '宿舍管理 > 学生入住', '', 'dormitory/student_into', 2, 1, 1, 6, 1, NULL, 1);
INSERT INTO `menu_info` VALUES (11, 'student_out', '学生迁出', '宿舍管理 >', '', 'dormitory/student_out', 2, 1, 1, 6, 1, NULL, 1);
COMMIT;

-- ----------------------------
-- Table structure for org_info
-- ----------------------------
DROP TABLE IF EXISTS `org_info`;
CREATE TABLE `org_info` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `code_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '组织名称',
  `p_id` int(9) DEFAULT '0' COMMENT '上级id，无上级默认为0',
  `sys_id` int(5) NOT NULL COMMENT '系统id',
  `org_full_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '组织机构全称',
  `org_remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=111 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of org_info
-- ----------------------------
BEGIN;
INSERT INTO `org_info` VALUES (1, '中国', 0, 1, '中国', '中华人民共和国');
INSERT INTO `org_info` VALUES (2, '贵州省', 1, 1, '中国/贵州省', '中国/贵州');
INSERT INTO `org_info` VALUES (3, '六盘水市', 2, 1, '贵州/六盘水市', '');
INSERT INTO `org_info` VALUES (4, '贵阳市', 2, 1, '贵州省/贵阳市', '');
INSERT INTO `org_info` VALUES (5, '遵义市', 2, 1, '贵州省/遵义市', '');
INSERT INTO `org_info` VALUES (6, '毕节市', 2, 1, '贵州省/毕节市', '');
INSERT INTO `org_info` VALUES (7, '安顺市', 2, 1, '贵州省/安顺市', '');
INSERT INTO `org_info` VALUES (8, '黔南布衣族苗族自治州', 2, 1, '贵州省/黔南布衣族苗族自治州', '');
INSERT INTO `org_info` VALUES (9, '黔东南苗族侗族自治州', 2, 1, '贵州省/黔东南苗族侗族自治州', '');
INSERT INTO `org_info` VALUES (10, '黔西南布衣族苗族自治州', 2, 1, '贵州省/黔西南布衣族苗族自治州', '');
INSERT INTO `org_info` VALUES (11, '南明区', 4, 1, '贵阳市/南明区', '');
INSERT INTO `org_info` VALUES (12, '云岩区', 4, 1, '贵阳市/云岩区', '');
INSERT INTO `org_info` VALUES (13, '白云区', 4, 1, '贵阳市/白云区', '');
INSERT INTO `org_info` VALUES (14, '观山湖区', 4, 1, '贵阳市/观山湖区', '');
INSERT INTO `org_info` VALUES (15, '花溪区', 4, 1, '贵阳市/花溪区', '');
INSERT INTO `org_info` VALUES (16, '乌当区', 4, 1, '贵阳市/乌当区', '');
INSERT INTO `org_info` VALUES (17, '修文县', 4, 1, '贵阳市/修文县', '');
INSERT INTO `org_info` VALUES (18, '开阳县', 4, 1, '贵阳市/开阳县', '');
INSERT INTO `org_info` VALUES (19, '小河区', 4, 1, '贵阳市/小河区', '');
INSERT INTO `org_info` VALUES (20, '清镇市', 4, 1, '贵阳市/清镇市', '');
INSERT INTO `org_info` VALUES (21, '息烽县', 4, 1, '贵阳市/息烽县', '');
INSERT INTO `org_info` VALUES (22, '水城县', 3, 1, '六盘水市/水城县', '');
INSERT INTO `org_info` VALUES (23, '钟山区', 3, 1, '六盘水市/钟山区', '');
INSERT INTO `org_info` VALUES (24, '六枝经济特区', 3, 1, '六盘水市/六枝经济特区', '');
INSERT INTO `org_info` VALUES (25, '盘州市', 3, 1, '六盘水市/盘州市', '');
INSERT INTO `org_info` VALUES (26, '凤凰新区', 3, 1, '六盘水市/凤凰新区', '');
INSERT INTO `org_info` VALUES (27, '红花岗区', 5, 1, '遵义市/红花岗区', '');
INSERT INTO `org_info` VALUES (28, '汇川区', 5, 1, '遵义市/汇川区', '');
INSERT INTO `org_info` VALUES (29, '赤水市', 5, 1, '遵义市/赤水市', '');
INSERT INTO `org_info` VALUES (30, '仁怀市', 5, 1, '遵义市/仁怀市', '');
INSERT INTO `org_info` VALUES (31, '遵义县', 5, 1, '遵义市/遵义县', '');
INSERT INTO `org_info` VALUES (32, '绥阳县', 5, 1, '遵义市/绥阳县', '');
INSERT INTO `org_info` VALUES (33, '桐梓县', 5, 1, '遵义市/桐梓县', '');
INSERT INTO `org_info` VALUES (34, '习水县', 5, 1, '遵义市/习水县', '');
INSERT INTO `org_info` VALUES (35, '凤冈县', 5, 1, '遵义市/凤冈县', '');
INSERT INTO `org_info` VALUES (36, '正安县', 5, 1, '遵义市/正安县', '');
INSERT INTO `org_info` VALUES (37, '余庆县', 5, 1, '遵义市/余庆县', '');
INSERT INTO `org_info` VALUES (38, ' 湄潭县', 5, 1, '遵义市/ 湄潭县', '');
INSERT INTO `org_info` VALUES (39, '道真仡佬族苗族自治县', 5, 1, '遵义市/道真仡佬族苗族自治县', '');
INSERT INTO `org_info` VALUES (40, '务川仡佬族苗族自治县', 5, 1, '遵义市/务川仡佬族苗族自治县', '');
INSERT INTO `org_info` VALUES (41, '西秀区', 7, 1, '安顺市/西秀区', '');
INSERT INTO `org_info` VALUES (42, '普定县', 7, 1, '安顺市/普定县', '');
INSERT INTO `org_info` VALUES (43, '平坝县', 7, 1, '安顺市/平坝县', '');
INSERT INTO `org_info` VALUES (44, '镇宁布依族苗族自治县', 7, 1, '安顺市/镇宁布依族苗族自治县', '');
INSERT INTO `org_info` VALUES (45, '紫云苗族布依族自治县', 7, 1, '安顺市/紫云苗族布依族自治县', '');
INSERT INTO `org_info` VALUES (46, '关岭布依族苗族自治县', 7, 1, '安顺市/关岭布依族苗族自治县', '');
INSERT INTO `org_info` VALUES (47, '铜仁市', 2, 1, '贵州省/铜仁市', '');
INSERT INTO `org_info` VALUES (49, '黔西县', 6, 1, '毕节市/黔西县', '');
INSERT INTO `org_info` VALUES (50, '大方县', 6, 1, '毕节市/大方县', '');
INSERT INTO `org_info` VALUES (51, '织金县', 6, 1, '毕节市/织金县', '');
INSERT INTO `org_info` VALUES (52, '金沙县', 6, 1, '毕节市/金沙县', '');
INSERT INTO `org_info` VALUES (53, '赫章县', 6, 1, '毕节市/赫章县', '');
INSERT INTO `org_info` VALUES (54, '纳雍县', 6, 1, '毕节市/纳雍县', '');
INSERT INTO `org_info` VALUES (55, '威宁彝族回族苗族自治县', 6, 1, '毕节市/威宁彝族回族苗族自治县', '');
INSERT INTO `org_info` VALUES (56, '毕节市', 6, 1, '毕节市/毕节市', '');
INSERT INTO `org_info` VALUES (57, '兴义市', 10, 1, '黔西南布衣族苗族自治州/兴义市', '');
INSERT INTO `org_info` VALUES (58, '望谟县', 10, 1, '黔西南布衣族苗族自治州/望谟县', '');
INSERT INTO `org_info` VALUES (59, '兴义市', 10, 1, NULL, NULL);
INSERT INTO `org_info` VALUES (60, '兴仁县', 10, 1, NULL, NULL);
INSERT INTO `org_info` VALUES (61, '普安县', 10, 1, NULL, NULL);
INSERT INTO `org_info` VALUES (62, '册亨县', 10, 1, NULL, NULL);
INSERT INTO `org_info` VALUES (63, '晴隆县', 10, 1, NULL, NULL);
INSERT INTO `org_info` VALUES (64, '贞丰县', 10, 1, NULL, NULL);
INSERT INTO `org_info` VALUES (65, '安龙县', 10, 1, NULL, NULL);
INSERT INTO `org_info` VALUES (66, '兴义市', 10, 1, NULL, NULL);
INSERT INTO `org_info` VALUES (67, '兴仁县', 10, 1, NULL, NULL);
INSERT INTO `org_info` VALUES (68, '普安县', 10, 1, NULL, NULL);
INSERT INTO `org_info` VALUES (69, '册亨县', 10, 1, NULL, NULL);
INSERT INTO `org_info` VALUES (70, '晴隆县', 10, 1, NULL, NULL);
INSERT INTO `org_info` VALUES (71, '贞丰县', 10, 1, NULL, NULL);
INSERT INTO `org_info` VALUES (72, '安龙县', 10, 1, NULL, NULL);
INSERT INTO `org_info` VALUES (73, '凯里市', 9, 1, NULL, NULL);
INSERT INTO `org_info` VALUES (74, '施秉县', 9, 1, NULL, NULL);
INSERT INTO `org_info` VALUES (75, '从江县', 9, 1, NULL, NULL);
INSERT INTO `org_info` VALUES (76, '锦屏县', 9, 1, NULL, NULL);
INSERT INTO `org_info` VALUES (77, '镇远县', 9, 1, NULL, NULL);
INSERT INTO `org_info` VALUES (78, '麻江县', 9, 1, NULL, NULL);
INSERT INTO `org_info` VALUES (79, '台江县', 9, 1, NULL, NULL);
INSERT INTO `org_info` VALUES (80, '天柱县', 9, 1, NULL, NULL);
INSERT INTO `org_info` VALUES (81, '黄平县', 9, 1, NULL, NULL);
INSERT INTO `org_info` VALUES (82, '榕江县', 9, 1, NULL, NULL);
INSERT INTO `org_info` VALUES (83, '剑河县', 9, 1, NULL, NULL);
INSERT INTO `org_info` VALUES (84, '三穗县', 9, 1, NULL, NULL);
INSERT INTO `org_info` VALUES (85, '雷山县', 9, 1, NULL, NULL);
INSERT INTO `org_info` VALUES (86, '黎平县', 9, 1, NULL, NULL);
INSERT INTO `org_info` VALUES (87, '岑巩县', 9, 1, NULL, NULL);
INSERT INTO `org_info` VALUES (88, '丹寨县', 9, 1, NULL, NULL);
INSERT INTO `org_info` VALUES (89, '都匀市', 8, 1, NULL, NULL);
INSERT INTO `org_info` VALUES (90, '贵定县', 8, 1, NULL, NULL);
INSERT INTO `org_info` VALUES (91, '惠水县', 8, 1, NULL, NULL);
INSERT INTO `org_info` VALUES (92, '罗甸县', 8, 1, NULL, NULL);
INSERT INTO `org_info` VALUES (93, '瓮安县', 8, 1, NULL, NULL);
INSERT INTO `org_info` VALUES (95, '龙里县', 8, 1, NULL, NULL);
INSERT INTO `org_info` VALUES (96, '平塘县', 8, 1, NULL, NULL);
INSERT INTO `org_info` VALUES (97, '长顺县', 8, 1, NULL, NULL);
INSERT INTO `org_info` VALUES (98, '独山县', 8, 1, NULL, NULL);
INSERT INTO `org_info` VALUES (99, '三都水族自治县', 8, 1, NULL, NULL);
INSERT INTO `org_info` VALUES (102, '德江县', 47, 1, NULL, NULL);
INSERT INTO `org_info` VALUES (103, '江口县', 47, 1, NULL, NULL);
INSERT INTO `org_info` VALUES (104, '思南县', 47, 1, NULL, NULL);
INSERT INTO `org_info` VALUES (105, '石阡县', 47, 1, NULL, NULL);
INSERT INTO `org_info` VALUES (106, '玉屏侗族自治县', 47, 1, NULL, NULL);
INSERT INTO `org_info` VALUES (107, '松桃苗族自治县', 47, 1, NULL, NULL);
INSERT INTO `org_info` VALUES (108, '印江土家族苗族自治县', 47, 1, NULL, NULL);
INSERT INTO `org_info` VALUES (109, '沿河土家族自治县', 47, 1, NULL, NULL);
INSERT INTO `org_info` VALUES (110, '万山特区', 47, 1, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for role_info
-- ----------------------------
DROP TABLE IF EXISTS `role_info`;
CREATE TABLE `role_info` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `role_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色编码',
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `role_state` int(1) DEFAULT NULL COMMENT '角色状态 0禁用，1启用',
  `sys_id` int(5) DEFAULT NULL COMMENT '系统id',
  `role_order` int(2) DEFAULT NULL COMMENT '角色顺序',
  `role_remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色表';

-- ----------------------------
-- Records of role_info
-- ----------------------------
BEGIN;
INSERT INTO `role_info` VALUES (1, 'SuperAdmin', '超级管理员', 1, 1, 1, '超级管理员');
INSERT INTO `role_info` VALUES (2, 'dormitory_admin', '宿舍管理员', 1, 1, 2, '宿舍管理员');
COMMIT;

-- ----------------------------
-- Table structure for role_menu_info
-- ----------------------------
DROP TABLE IF EXISTS `role_menu_info`;
CREATE TABLE `role_menu_info` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `role_id` int(5) NOT NULL COMMENT '角色id',
  `menu_id` int(5) NOT NULL COMMENT '菜单id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色菜单权限';

-- ----------------------------
-- Records of role_menu_info
-- ----------------------------
BEGIN;
INSERT INTO `role_menu_info` VALUES (45, 2, 7);
INSERT INTO `role_menu_info` VALUES (46, 2, 8);
INSERT INTO `role_menu_info` VALUES (47, 2, 9);
INSERT INTO `role_menu_info` VALUES (48, 2, 10);
INSERT INTO `role_menu_info` VALUES (49, 2, 11);
INSERT INTO `role_menu_info` VALUES (50, 1, 2);
INSERT INTO `role_menu_info` VALUES (51, 1, 3);
INSERT INTO `role_menu_info` VALUES (52, 1, 4);
INSERT INTO `role_menu_info` VALUES (53, 1, 5);
INSERT INTO `role_menu_info` VALUES (54, 1, 7);
INSERT INTO `role_menu_info` VALUES (55, 1, 8);
INSERT INTO `role_menu_info` VALUES (56, 1, 9);
INSERT INTO `role_menu_info` VALUES (57, 1, 10);
INSERT INTO `role_menu_info` VALUES (58, 1, 11);
COMMIT;

-- ----------------------------
-- Table structure for Student_info
-- ----------------------------
DROP TABLE IF EXISTS `Student_info`;
CREATE TABLE `Student_info` (
  `s_id` int(9) NOT NULL AUTO_INCREMENT COMMENT '学生id',
  `s_name` varchar(50) NOT NULL COMMENT '学生姓名',
  `s_sex` int(1) NOT NULL COMMENT '学生性别0女1男',
  `c_id` int(5) NOT NULL COMMENT '所在班级id',
  `s_phone` varchar(20) NOT NULL COMMENT '学生电话',
  `s_email` varchar(50) DEFAULT NULL COMMENT '学生邮箱',
  `s_urgent_phone` varchar(20) NOT NULL COMMENT '紧急联系人电话',
  `s_urgent_name` varchar(50) NOT NULL COMMENT '紧急联系人姓名',
  `s_urgent_address` varchar(255) DEFAULT NULL COMMENT '紧急联系人地址',
  `s_id_number` varchar(50) NOT NULL COMMENT '学号',
  `s_session` varchar(50) NOT NULL COMMENT '届别',
  `d_id` int(5) NOT NULL COMMENT '寝室id',
  `s_state` int(1) NOT NULL DEFAULT '0' COMMENT '迁入0迁出1',
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='学生表';

-- ----------------------------
-- Records of Student_info
-- ----------------------------
BEGIN;
INSERT INTO `Student_info` VALUES (1, '李雪梅', 0, 17, '13245646789', '13245646789@163.com', '15678904523', '李建江', '贵州省六盘水', 'QN20102334', '2010', 1, 0);
INSERT INTO `Student_info` VALUES (2, '张梅梅', 0, 17, '13556789834', '13556789834@163.com', '18756349034', '张开', '贵州省三都', 'QN20102309', '2010', 1, 0);
INSERT INTO `Student_info` VALUES (3, '王春燕', 0, 17, '13245212321', '13245212321@163.com', '15632457809', '王明江', '贵州省贵阳市', 'QN20109834', '2010', 1, 0);
INSERT INTO `Student_info` VALUES (4, '蒋冬梅', 0, 17, '17643320424', '17643320424@qq.com', '18434236532', '蒋振东', '贵州凯里', 'QN20109432', '2010', 1, 0);
INSERT INTO `Student_info` VALUES (5, '马春花', 0, 17, '14323452345', '1243242@qq.com', '13312764434', '马关', '贵州兴义', 'QN20108342', '2010', 1, 0);
INSERT INTO `Student_info` VALUES (6, '程晨', 0, 17, '18345452344', '23423423@11.com', '13465623532', '程军', '贵州都匀', 'QN20108456', '2010', 1, 0);
INSERT INTO `Student_info` VALUES (7, '马光璇', 1, 17, '18342349345', '32423423@11.com', '18534443534', '马天钿', '安徽凤阳', 'QN20107343', '2010', 15, 0);
INSERT INTO `Student_info` VALUES (8, '吴光亚', 1, 17, '15443453433', '231321@qq.com', '17745653234', '吴明', '浙江绍兴', 'QN20108343', '2010', 15, 0);
INSERT INTO `Student_info` VALUES (9, '李晨', 1, 17, '18434234234', '234234@qq.com', '18634543523', '李明江', '河北保定', 'QN20103452', '2010', 15, 0);
INSERT INTO `Student_info` VALUES (10, '吴凯', 1, 17, '15434534654', '1231@qq.com', '18324234323', '吴建川', '贵州凯里', 'QN20108347', '2010', 15, 0);
INSERT INTO `Student_info` VALUES (11, '邓建', 1, 17, '13436742345', '3241232@qq.com', '13434545643', '邓辉', '贵州三都', 'QN2010234234', '2010', 15, 0);
INSERT INTO `Student_info` VALUES (12, '吴明辉', 1, 17, '13433453323', '2342342@qq.com', '13434323244', '吴军', '贵州毕节', 'QN20102455', '2010', 15, 0);
COMMIT;

-- ----------------------------
-- Table structure for student_out
-- ----------------------------
DROP TABLE IF EXISTS `student_out`;
CREATE TABLE `student_out` (
  `o_id` int(6) NOT NULL AUTO_INCREMENT,
  `s_id` int(9) NOT NULL COMMENT '学生id',
  `out_time` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '迁出时间',
  `out_reason` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '迁出原因',
  `u_id` int(5) NOT NULL COMMENT '办理迁出人员id',
  `add_time` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '受理时间',
  PRIMARY KEY (`o_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='学生迁出表';

-- ----------------------------
-- Table structure for system_info
-- ----------------------------
DROP TABLE IF EXISTS `system_info`;
CREATE TABLE `system_info` (
  `id` int(5) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `sys_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '系统编码',
  `sys_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '系统名称',
  `sys_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '系统访问路径',
  `sys_main_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '首页地址',
  `sys_status` int(2) DEFAULT NULL COMMENT '系统状态，0禁用，1启用',
  `sys_remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`,`sys_code`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='系统表';

-- ----------------------------
-- Records of system_info
-- ----------------------------
BEGIN;
INSERT INTO `system_info` VALUES (1, '1', '校园宿舍管理', 'default/index', 'html/index', 1, NULL);
COMMIT;

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '姓名',
  `user_login` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '登陆账号',
  `login_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '登陆密码，加密后的',
  `user_status` int(2) DEFAULT NULL COMMENT '账号状态0禁用1启用',
  `user_org` int(4) DEFAULT NULL COMMENT '组织机构地区',
  `user_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '电话号码',
  `user_remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '账号备注',
  `user_sex` int(1) DEFAULT NULL COMMENT '性别，1男2女',
  `user_email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户邮箱',
  `user_sys` int(5) DEFAULT NULL COMMENT '归属系统',
  `role_id` int(5) NOT NULL COMMENT '角色id',
  `user_on` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '用户编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户表';

-- ----------------------------
-- Records of user_info
-- ----------------------------
BEGIN;
INSERT INTO `user_info` VALUES (1, '卢鑫丽', 'lxl', 'TFhMMjAxMzE0QA==', 1, NULL, NULL, NULL, 0, NULL, 1, 1, '00001');
INSERT INTO `user_info` VALUES (2, '卢鑫美', 'lxm', 'bHhsMjAxMzE0', 1, 28, '13043239234', '', 0, '13043239234@qq.com', 1, 2, 'lxm0001');
INSERT INTO `user_info` VALUES (3, '刘崇贵', 'lcg', 'bHhsMjAxMzE0', 1, 22, '15623441234', '', 1, '15623441234@qq.com', 1, 2, 'lcg0003');
INSERT INTO `user_info` VALUES (4, '罗茜', 'lx', 'bHhsMjAxMzE0', 1, 22, '13544353454', '', 1, '13544353454@qq.com', 1, 2, 'lx123212');
INSERT INTO `user_info` VALUES (5, '王凯', 'wk', 'TFhMMjAxMzE0QA==', 1, 22, '13456567763', '', 1, '13456567763@qq.com', 1, 2, '201393242');
INSERT INTO `user_info` VALUES (6, '张娜', 'zn', 'bHhsMjAxMzE0', 1, 25, '13545678790', '', 0, '', 1, 2, '19950710');
INSERT INTO `user_info` VALUES (7, '罗圣佳', 'lsj', 'TFhMMjAxMzE0QA==', 1, 22, '15676899087', '', 0, '15676899087@qq.com', 1, 2, '20060901');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
