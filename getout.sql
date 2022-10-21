/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80029
 Source Host           : localhost:3306
 Source Schema         : getout

 Target Server Type    : MySQL
 Target Server Version : 80029
 File Encoding         : 65001

 Date: 21/10/2022 18:38:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for this_http
-- ----------------------------
DROP TABLE IF EXISTS `this_http`;
CREATE TABLE `this_http`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `request_uri` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '客户端请求行的资源名称',
  `request_url` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '客户端请求的完整的url',
  `remote_addr` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '客户端的ip地址',
  `query_string` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '客户端请求的参数部分',
  `remote_host` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '客户端的请求名',
  `remote_port` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '客户端的端口号',
  `serve_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '服务器的主机名称',
  `serve_port` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '服务器的端口号',
  `request_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '请求时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of this_http
-- ----------------------------
INSERT INTO `this_http` VALUES (1, '/Login/login', 'http://localhost:8081/Login/login', '0:0:0:0:0:0:0:1', NULL, '0:0:0:0:0:0:0:1', '57706', 'localhost', '8081', '2022-09-27 14:52:31');
INSERT INTO `this_http` VALUES (2, '/Login/login', 'http://localhost:8081/Login/login', '0:0:0:0:0:0:0:1', NULL, '0:0:0:0:0:0:0:1', '56273', 'localhost', '8081', '2022-09-27 14:52:36');
INSERT INTO `this_http` VALUES (3, '/Login/login', 'http://localhost:8081/Login/login', '0:0:0:0:0:0:0:1', NULL, '0:0:0:0:0:0:0:1', '49807', 'localhost', '8081', '2022-09-27 17:44:01');
INSERT INTO `this_http` VALUES (4, '/Login/login', 'http://localhost:8081/Login/login', '0:0:0:0:0:0:0:1', NULL, '0:0:0:0:0:0:0:1', '57482', 'localhost', '8081', '2022-09-27 17:49:01');
INSERT INTO `this_http` VALUES (5, '/Login/login', 'http://localhost:8081/Login/login', '0:0:0:0:0:0:0:1', NULL, '0:0:0:0:0:0:0:1', '58670', 'localhost', '8081', '2022-09-30 11:23:58');
INSERT INTO `this_http` VALUES (6, '/Login/login', 'http://localhost:8081/Login/login', '0:0:0:0:0:0:0:1', NULL, '0:0:0:0:0:0:0:1', '59809', 'localhost', '8081', '2022-09-30 11:25:02');
INSERT INTO `this_http` VALUES (7, '/Login/login', 'http://localhost:8081/Login/login', '0:0:0:0:0:0:0:1', NULL, '0:0:0:0:0:0:0:1', '62604', 'localhost', '8081', '2022-09-30 11:26:05');
INSERT INTO `this_http` VALUES (8, '/Login/login', 'http://localhost:8081/Login/login', '0:0:0:0:0:0:0:1', '{    \"name\":\"llt\",    \"pwd\":\"1\"}', '0:0:0:0:0:0:0:1', '60858', 'localhost', '8081', '2022-09-30 11:28:43');
INSERT INTO `this_http` VALUES (9, '/Login/login', 'http://localhost:8081/Login/login', '0:0:0:0:0:0:0:1', '{    \"name\":\"llt\",    \"pwd\":\"1\"}', '0:0:0:0:0:0:0:1', '58878', 'localhost', '8081', '2022-10-12 11:43:13');
INSERT INTO `this_http` VALUES (10, '/Login/login', 'http://localhost:8081/Login/login', '0:0:0:0:0:0:0:1', '{    \"name\":\"llt\",    \"pwd\":\"1\"}', '0:0:0:0:0:0:0:1', '60756', 'localhost', '8081', '2022-10-12 11:43:47');
INSERT INTO `this_http` VALUES (11, '/Login/login', 'http://localhost:8081/Login/login', '0:0:0:0:0:0:0:1', '{    \"name\":\"llt\",    \"pwd\":\"1\"}', '0:0:0:0:0:0:0:1', '60678', 'localhost', '8081', '2022-10-12 11:44:22');
INSERT INTO `this_http` VALUES (12, '/Login/login', 'http://localhost:8081/Login/login', '0:0:0:0:0:0:0:1', '{    \"name\":\"llt\",    \"pwd\":\"1\"}', '0:0:0:0:0:0:0:1', '59343', 'localhost', '8081', '2022-10-12 15:00:58');
INSERT INTO `this_http` VALUES (13, '/Login/login', 'http://localhost:8081/Login/login', '0:0:0:0:0:0:0:1', '{    \"name\":\"llt\",    \"pwd\":\"1\"}', '0:0:0:0:0:0:0:1', '56100', 'localhost', '8081', '2022-10-12 15:03:48');
INSERT INTO `this_http` VALUES (14, '/Login/login', 'http://localhost:8081/Login/login', '0:0:0:0:0:0:0:1', '{    \"name\":\"llt\",    \"pwd\":\"1\"}', '0:0:0:0:0:0:0:1', '54261', 'localhost', '8081', '2022-10-12 15:04:37');
INSERT INTO `this_http` VALUES (15, '/Login/login', 'http://localhost:8081/Login/login', '0:0:0:0:0:0:0:1', '{    \"name\":\"llt\",    \"pwd\":\"1\"}', '0:0:0:0:0:0:0:1', '54741', 'localhost', '8081', '2022-10-12 15:05:58');
INSERT INTO `this_http` VALUES (16, '/Login/login', 'http://localhost:8081/Login/login', '0:0:0:0:0:0:0:1', '{    \"name\":\"llt\",    \"pwd\":\"1\"}', '0:0:0:0:0:0:0:1', '63457', 'localhost', '8081', '2022-10-12 15:37:44');

-- ----------------------------
-- Table structure for this_query_product_info
-- ----------------------------
DROP TABLE IF EXISTS `this_query_product_info`;
CREATE TABLE `this_query_product_info`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '主键',
  `query_url_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT 'this_query_url主键',
  `product_type` tinyint NULL DEFAULT NULL COMMENT '产品类型（1：箱码；2：瓶码',
  `packing_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '箱码（识别二维码内容）',
  `dm_code` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '瓶盖内码',
  `product_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '蜀云产品编码',
  `product_name` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '蜀云产品名称',
  `time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '查询时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `query_url_id_index`(`query_url_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of this_query_product_info
-- ----------------------------
INSERT INTO `this_query_product_info` VALUES ('0467b987280405a2b621dd6c47b61ebb', 'd8531834b45b4794a18c42227e74a2c2', 1, NULL, NULL, 'http://aax5.cn/B/DF6S7H9BU4OXD080VO8M1', NULL, '2022-10-21 15:46:53');
INSERT INTO `this_query_product_info` VALUES ('0dbbcefa43c0dca888cc18e60a2c1372', '2fdae1c4228641038dcb141647b0ebea', 1, 'DF6S7H9BU4OXD080VO8M1', NULL, NULL, NULL, '2022-10-21 15:48:19');
INSERT INTO `this_query_product_info` VALUES ('3b86327e0585ad2d0c2bd9309a41de61', '1f282f0bfdca4946a43885adbd4d80c9', 2, NULL, 'LVVEFW5H1F', '310000000000020', '500皇冠盖四川区域8度冰山勇闯', '2022-10-21 17:57:06');
INSERT INTO `this_query_product_info` VALUES ('6b0debb66bc30d975299513cb7832987', 'a3d003204c304c828e25bcd285207934', 2, NULL, '2GML557HSY', '30000343', '500皇冠盖四川区域superX', '2022-10-21 15:44:07');
INSERT INTO `this_query_product_info` VALUES ('70e26de3a9d63e683847eae8fbd4da25', '084a8b4e15ba4a34bc048e636e55e095', 2, NULL, '2GML557HSY', '30000343', '500皇冠盖四川区域superX', '2022-10-21 16:45:18');
INSERT INTO `this_query_product_info` VALUES ('8405ce1b28390e043bd41fe448c50f47', 'c07cbd65acc64421a511536db932d06c', 2, NULL, '2GML557HSY', '30000343', '500皇冠盖四川区域superX', '2022-10-21 16:08:25');
INSERT INTO `this_query_product_info` VALUES ('8675b31bc96b2ae1e6928b72f7141f30', '7c49b673401b42f396c739aef65a274e', 2, NULL, '2GML557HSY', '30000343', '500皇冠盖四川区域superX', '2022-10-21 16:10:06');
INSERT INTO `this_query_product_info` VALUES ('885c37afb93bbbf23104d41a64908c0d', 'a358b496bdcc4e7abc925285ec8f84e7', 1, NULL, NULL, 'http://aax5.cn/B/DF6S7H9BU4OXD080VO8M1', NULL, '2022-10-21 15:42:52');
INSERT INTO `this_query_product_info` VALUES ('ba6747d28cd9cbb5a1c4b0f0314b8f7d', 'ea15f1fbc83841deb040ce08e9b68ab9', 1, 'S5*:RPN5391LM5BGL-2YT', NULL, NULL, NULL, '2022-10-21 17:56:48');
INSERT INTO `this_query_product_info` VALUES ('bd8890006782d78ccc019a2051a6b0de', '0868a35d04594f57af41dc46be316cf4', 2, NULL, '2GML557HSY', '30000343', '500皇冠盖四川区域superX', '2022-10-21 17:58:00');
INSERT INTO `this_query_product_info` VALUES ('f06d801295cf9db2676cee97891cc1e6', '88da16a975114b8e86d45a6e2d081772', 2, NULL, NULL, NULL, NULL, '2022-10-21 15:48:41');

-- ----------------------------
-- Table structure for this_query_url
-- ----------------------------
DROP TABLE IF EXISTS `this_query_url`;
CREATE TABLE `this_query_url`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '主键',
  `user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '用户id',
  `url` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '查询内容',
  `product_type` tinyint NULL DEFAULT NULL COMMENT '产品类型（1：箱码；2：瓶码）',
  `type` tinyint NULL DEFAULT NULL COMMENT '查询类型（1：网址查询；2：解析内容查询；3：二维码查询)',
  `result` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL COMMENT '查询结果',
  `success` tinyint NULL DEFAULT NULL COMMENT '查询结果是否成功（1：成功；2：失败）',
  `time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '查询时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `url_ndex`(`url` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of this_query_url
-- ----------------------------
INSERT INTO `this_query_url` VALUES ('084a8b4e15ba4a34bc048e636e55e095', NULL, 'https://ty-gateway-common-inter.aax5.cn/wechat/web/gps?account=xhpj_wx00007f560e6313be&redirect_uri=https%3A%2F%2Fty-gateway-access-router.aax5.cn%2Fmss%2Fgps%2FcallbackNext%3Fcode%3Dhttp%253A%252F%252Faax5.cn%252FB%252FDF6S7H9BU4OXD080VO8M1', 2, 1, '{data={\"productId\":435923057930182656,\"qcount\":5,\"seqNum\":\"1040675317501\",\"destFactoryCode\":\"PLANT_GACB0\",\"packLevel\":1,\"isActivated\":1,\"extendProperties\":{\"noticeOrderNo\":\"DD2022090810017_01\",\"waiterFirsterTime\":\"2022-10-19 10:36:34\",\"qcount\":\"5\",\"activeType\":\"1\",\"waiterAccount\":\"18325032328\",\"isPrimary\":\"true\",\"marketCenter\":\"重庆营销中心\",\"storeName\":\"7桌老火锅\",\"storeCode\":\"1008400421\"},\"productName\":\"500皇冠盖四川区域superX\",\"tagBatchCreateDate\":\"\",\"dmCode\":\"2GML557HSY\",\"productCode\":\"30000343\",\"qrCode\":\"-yywe7MxVoR4CoCS03Oz4VVIm2xBFoLedJmiLCsx-tY\",\"entCode\":\"hrxh0008\",\"enterpriseId\":45259876771655680,\"tagBatchId\":\"\",\"status\":70}, 该二维码解析的内容为=http://aax5.cn/B/DF6S7H9BU4OXD080VO8M1}', 0, '2022-10-21 16:45:18');
INSERT INTO `this_query_url` VALUES ('0868a35d04594f57af41dc46be316cf4', NULL, 'https://ty-gateway-common-inter.aax5.cn/wechat/web/gps?account=xhpj_wx00007f560e6313be&redirect_uri=https%3A%2F%2Fty-gateway-access-router.aax5.cn%2Fmss%2Fgps%2FcallbackNext%3Fcode%3Dhttp%253A%252F%252Faax5.cn%252FB%252FDF6S7H9BU4OXD080VO8M1', 2, 1, '{data={\"productId\":435923057930182656,\"qcount\":5,\"seqNum\":\"1040675317501\",\"destFactoryCode\":\"PLANT_GACB0\",\"packLevel\":1,\"isActivated\":1,\"extendProperties\":{\"noticeOrderNo\":\"DD2022090810017_01\",\"waiterFirsterTime\":\"2022-10-19 10:36:34\",\"qcount\":\"5\",\"activeType\":\"1\",\"waiterAccount\":\"18325032328\",\"isPrimary\":\"true\",\"marketCenter\":\"重庆营销中心\",\"storeName\":\"7桌老火锅\",\"storeCode\":\"1008400421\"},\"productName\":\"500皇冠盖四川区域superX\",\"tagBatchCreateDate\":\"\",\"dmCode\":\"2GML557HSY\",\"productCode\":\"30000343\",\"qrCode\":\"-yywe7MxVoR4CoCS03Oz4VVIm2xBFoLedJmiLCsx-tY\",\"entCode\":\"hrxh0008\",\"enterpriseId\":45259876771655680,\"tagBatchId\":\"\",\"status\":70}, 该二维码解析的内容为=http://aax5.cn/B/DF6S7H9BU4OXD080VO8M1}', 0, '2022-10-21 17:58:00');
INSERT INTO `this_query_url` VALUES ('1f282f0bfdca4946a43885adbd4d80c9', NULL, 'https://ty-gateway-common-inter.aax5.cn/wechat/web/gps?account=xhpj_wx00007f560e6313be&redirect_uri=https%3A%2F%2Fty-gateway-access-router.aax5.cn%2Fmss%2Fgps%2FcallbackNext%3Fcode%3Dhttp%253A%252F%252Faax5.cn%252FB%252FS5*%253ARPN5391LM5BGL-2YT', 2, 1, '{data={\"productId\":130421575805124608,\"qcount\":5,\"seqNum\":\"1038431594570\",\"destFactoryCode\":\"PLANT_CBSE0\",\"packLevel\":1,\"isActivated\":1,\"extendProperties\":{\"noticeOrderNo\":\"DD2022071210004_01\",\"waiterFirsterTime\":\"2022-10-19 11:25:26\",\"qcount\":\"5\",\"activeType\":\"1\",\"waiterAccount\":\"11600067601\",\"isPrimary\":\"true\",\"marketCenter\":\"重庆营销中心\",\"storeName\":\"【虚拟】万州区龙华街龙马副食批发部\",\"storeCode\":\"1160006760\"},\"productName\":\"500皇冠盖四川区域8度冰山勇闯\",\"tagBatchCreateDate\":\"\",\"dmCode\":\"LVVEFW5H1F\",\"productCode\":\"310000000000020\",\"qrCode\":\"c3dmLv9RGJ1BbkvFN6z_IvYWmX2xQUGO0n3kJdHCQeI\",\"entCode\":\"hrxh0008\",\"enterpriseId\":45259876771655680,\"tagBatchId\":\"\",\"status\":70}, 该二维码解析的内容为=http://aax5.cn/B/S5*:RPN5391LM5BGL-2YT}', 0, '2022-10-21 17:57:06');
INSERT INTO `this_query_url` VALUES ('2fdae1c4228641038dcb141647b0ebea', NULL, 'https://ty-gateway-common-inter.aax5.cn/wechat/web/gps?account=xhpj_wx00007f560e6313be&redirect_uri=https%3A%2F%2Fty-gateway-access-router.aax5.cn%2Fmss%2Fgps%2FcallbackNext%3Fcode%3Dhttp%253A%252F%252Faax5.cn%252FB%252FDF6S7H9BU4OXD080VO8M1', 1, 1, '{该二维码解析的内容为=http://aax5.cn/B/DF6S7H9BU4OXD080VO8M1, 该产品二维码为=DF6S7H9BU4OXD080VO8M1}', 0, '2022-10-21 15:48:19');
INSERT INTO `this_query_url` VALUES ('7c49b673401b42f396c739aef65a274e', NULL, 'https://ty-gateway-common-inter.aax5.cn/wechat/web/gps?account=xhpj_wx00007f560e6313be&redirect_uri=https%3A%2F%2Fty-gateway-access-router.aax5.cn%2Fmss%2Fgps%2FcallbackNext%3Fcode%3Dhttp%253A%252F%252Faax5.cn%252FB%252FDF6S7H9BU4OXD080VO8M1', 2, 1, '{data={\"productId\":435923057930182656,\"qcount\":5,\"seqNum\":\"1040675317501\",\"destFactoryCode\":\"PLANT_GACB0\",\"packLevel\":1,\"isActivated\":1,\"extendProperties\":{\"noticeOrderNo\":\"DD2022090810017_01\",\"waiterFirsterTime\":\"2022-10-19 10:36:34\",\"qcount\":\"5\",\"activeType\":\"1\",\"waiterAccount\":\"18325032328\",\"isPrimary\":\"true\",\"marketCenter\":\"重庆营销中心\",\"storeName\":\"7桌老火锅\",\"storeCode\":\"1008400421\"},\"productName\":\"500皇冠盖四川区域superX\",\"tagBatchCreateDate\":\"\",\"dmCode\":\"2GML557HSY\",\"productCode\":\"30000343\",\"qrCode\":\"-yywe7MxVoR4CoCS03Oz4VVIm2xBFoLedJmiLCsx-tY\",\"entCode\":\"hrxh0008\",\"enterpriseId\":45259876771655680,\"tagBatchId\":\"\",\"status\":70}, 该二维码解析的内容为=http://aax5.cn/B/DF6S7H9BU4OXD080VO8M1}', 0, '2022-10-21 16:10:06');
INSERT INTO `this_query_url` VALUES ('88da16a975114b8e86d45a6e2d081772', NULL, 'https://ty-gateway-common-inter.aax5.cn/wechat/web/gps?account=xhpj_wx00007f560e6313be&redirect_uri=https%3A%2F%2Fty-gateway-access-router.aax5.cn%2Fmss%2Fgps%2FcallbackNext%3Fcode%3Dhttp%253A%252F%252Faax5.cn%252FB%252FDF6S7H9BU4OXD080VO8M', 2, 1, '{data=null, 该二维码解析的内容为=http://aax5.cn/B/DF6S7H9BU4OXD080VO8M}', 0, '2022-10-21 15:48:41');
INSERT INTO `this_query_url` VALUES ('a358b496bdcc4e7abc925285ec8f84e7', NULL, 'https://ty-gateway-common-inter.aax5.cn/wechat/web/gps?account=xhpj_wx00007f560e6313be&redirect_uri=https%3A%2F%2Fty-gateway-access-router.aax5.cn%2Fmss%2Fgps%2FcallbackNext%3Fcode%3Dhttp%253A%252F%252Faax5.cn%252FB%252FDF6S7H9BU4OXD080VO8M1', 1, 1, '{该二维码解析的内容为=http://aax5.cn/B/DF6S7H9BU4OXD080VO8M1, 该产品二维码为=DF6S7H9BU4OXD080VO8M1}', 0, '2022-10-21 15:42:52');
INSERT INTO `this_query_url` VALUES ('a3d003204c304c828e25bcd285207934', NULL, 'https://ty-gateway-common-inter.aax5.cn/wechat/web/gps?account=xhpj_wx00007f560e6313be&redirect_uri=https%3A%2F%2Fty-gateway-access-router.aax5.cn%2Fmss%2Fgps%2FcallbackNext%3Fcode%3Dhttp%253A%252F%252Faax5.cn%252FB%252FDF6S7H9BU4OXD080VO8M1', 2, 1, '{data={\"productId\":435923057930182656,\"qcount\":5,\"seqNum\":\"1040675317501\",\"destFactoryCode\":\"PLANT_GACB0\",\"packLevel\":1,\"isActivated\":1,\"extendProperties\":{\"noticeOrderNo\":\"DD2022090810017_01\",\"waiterFirsterTime\":\"2022-10-19 10:36:34\",\"qcount\":\"5\",\"activeType\":\"1\",\"waiterAccount\":\"18325032328\",\"isPrimary\":\"true\",\"marketCenter\":\"重庆营销中心\",\"storeName\":\"7桌老火锅\",\"storeCode\":\"1008400421\"},\"productName\":\"500皇冠盖四川区域superX\",\"tagBatchCreateDate\":\"\",\"dmCode\":\"2GML557HSY\",\"productCode\":\"30000343\",\"qrCode\":\"-yywe7MxVoR4CoCS03Oz4VVIm2xBFoLedJmiLCsx-tY\",\"entCode\":\"hrxh0008\",\"enterpriseId\":45259876771655680,\"tagBatchId\":\"\",\"status\":70}, 该二维码解析的内容为=http://aax5.cn/B/DF6S7H9BU4OXD080VO8M1}', 0, '2022-10-21 15:44:07');
INSERT INTO `this_query_url` VALUES ('c07cbd65acc64421a511536db932d06c', NULL, 'https://ty-gateway-common-inter.aax5.cn/wechat/web/gps?account=xhpj_wx00007f560e6313be&redirect_uri=https%3A%2F%2Fty-gateway-access-router.aax5.cn%2Fmss%2Fgps%2FcallbackNext%3Fcode%3Dhttp%253A%252F%252Faax5.cn%252FB%252FDF6S7H9BU4OXD080VO8M1', 2, 1, '{data={\"productId\":435923057930182656,\"qcount\":5,\"seqNum\":\"1040675317501\",\"destFactoryCode\":\"PLANT_GACB0\",\"packLevel\":1,\"isActivated\":1,\"extendProperties\":{\"noticeOrderNo\":\"DD2022090810017_01\",\"waiterFirsterTime\":\"2022-10-19 10:36:34\",\"qcount\":\"5\",\"activeType\":\"1\",\"waiterAccount\":\"18325032328\",\"isPrimary\":\"true\",\"marketCenter\":\"重庆营销中心\",\"storeName\":\"7桌老火锅\",\"storeCode\":\"1008400421\"},\"productName\":\"500皇冠盖四川区域superX\",\"tagBatchCreateDate\":\"\",\"dmCode\":\"2GML557HSY\",\"productCode\":\"30000343\",\"qrCode\":\"-yywe7MxVoR4CoCS03Oz4VVIm2xBFoLedJmiLCsx-tY\",\"entCode\":\"hrxh0008\",\"enterpriseId\":45259876771655680,\"tagBatchId\":\"\",\"status\":70}, 该二维码解析的内容为=http://aax5.cn/B/DF6S7H9BU4OXD080VO8M1}', 0, '2022-10-21 16:08:25');
INSERT INTO `this_query_url` VALUES ('d8531834b45b4794a18c42227e74a2c2', NULL, 'https://ty-gateway-common-inter.aax5.cn/wechat/web/gps?account=xhpj_wx00007f560e6313be&redirect_uri=https%3A%2F%2Fty-gateway-access-router.aax5.cn%2Fmss%2Fgps%2FcallbackNext%3Fcode%3Dhttp%253A%252F%252Faax5.cn%252FB%252FDF6S7H9BU4OXD080VO8M1', 1, 1, '{该二维码解析的内容为=http://aax5.cn/B/DF6S7H9BU4OXD080VO8M1, 该产品二维码为=DF6S7H9BU4OXD080VO8M1}', 0, '2022-10-21 15:46:53');
INSERT INTO `this_query_url` VALUES ('ea15f1fbc83841deb040ce08e9b68ab9', NULL, 'https://ty-gateway-common-inter.aax5.cn/wechat/web/gps?account=xhpj_wx00007f560e6313be&redirect_uri=https%3A%2F%2Fty-gateway-access-router.aax5.cn%2Fmss%2Fgps%2FcallbackNext%3Fcode%3Dhttp%253A%252F%252Faax5.cn%252FB%252FS5*%253ARPN5391LM5BGL-2YT', 1, 1, '{该二维码解析的内容为=http://aax5.cn/B/S5*:RPN5391LM5BGL-2YT, 该产品二维码为=S5*:RPN5391LM5BGL-2YT}', 0, '2022-10-21 17:56:49');

-- ----------------------------
-- Table structure for this_user
-- ----------------------------
DROP TABLE IF EXISTS `this_user`;
CREATE TABLE `this_user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `pwd` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `time` datetime NULL DEFAULT NULL,
  `tel` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '电话',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `nameage`(`name` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of this_user
-- ----------------------------
INSERT INTO `this_user` VALUES (1, 'llt', '1', '2021-11-10 09:36:31', '15099999999');
INSERT INTO `this_user` VALUES (2, 'no', '2', '2021-11-10 09:36:40', '15099999999');
INSERT INTO `this_user` VALUES (3, '雪花', '3', '2022-10-20 15:35:52', '15099999999');

SET FOREIGN_KEY_CHECKS = 1;
