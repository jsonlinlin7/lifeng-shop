/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : localhost:3306
 Source Schema         : lifengshop

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 05/08/2021 23:55:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for catagory
-- ----------------------------
DROP TABLE IF EXISTS `catagory`;
CREATE TABLE `catagory`  (
  `catagory` varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
  `primarycatagory` varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
  PRIMARY KEY (`catagory`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = gbk COLLATE = gbk_chinese_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for collection
-- ----------------------------
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection`  (
  `goodsid` int(11) NOT NULL,
  `userid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`goodsid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = gbk COLLATE = gbk_chinese_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `goodsid` int(11) NOT NULL AUTO_INCREMENT,
  `goodsname` varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
  `catagory` varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
  `price` decimal(10, 2) NULL DEFAULT NULL,
  `details` varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  PRIMARY KEY (`goodsid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for history
-- ----------------------------
DROP TABLE IF EXISTS `history`;
CREATE TABLE `history`  (
  `date` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `catagory` varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  `userid` int(11) NULL DEFAULT NULL,
  `goodsid` int(11) NOT NULL
) ENGINE = InnoDB CHARACTER SET = gbk COLLATE = gbk_chinese_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `orderid` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `goodsid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `status` int(1) NULL DEFAULT NULL COMMENT '0.已下单1.已发货2.已收货3.已完成',
  PRIMARY KEY (`orderid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goodsid` int(11) NOT NULL,
  `orderid` int(11) NOT NULL,
  `num` int(11) NULL DEFAULT NULL,
  `totalprice` decimal(10, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for shoppingcart
-- ----------------------------
DROP TABLE IF EXISTS `shoppingcart`;
CREATE TABLE `shoppingcart`  (
  `cartid` int(11) NOT NULL,
  `userid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`cartid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = gbk COLLATE = gbk_chinese_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for shoppingcart_detail
-- ----------------------------
DROP TABLE IF EXISTS `shoppingcart_detail`;
CREATE TABLE `shoppingcart_detail`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shoppingcartid` int(11) NOT NULL,
  `goodsid` int(11) NOT NULL,
  `num` int(11) NULL DEFAULT NULL,
  `totalprice` decimal(10, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = gbk COLLATE = gbk_chinese_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `shopuser`;
CREATE TABLE `shopuser` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci DEFAULT NULL,
  `password` varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `address` varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  PRIMARY KEY (`userid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=gbk ROW_FORMAT=DYNAMIC;

SET FOREIGN_KEY_CHECKS = 1;
