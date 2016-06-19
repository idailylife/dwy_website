CREATE DATABASE  IF NOT EXISTS `dianwuyou` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `dianwuyou`;
-- MySQL dump 10.13  Distrib 5.7.9, for osx10.9 (x86_64)
--
-- Host: localhost    Database: dianwuyou
-- ------------------------------------------------------
-- Server version	5.7.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `file`
--

DROP TABLE IF EXISTS `file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `file` (
  `id` int(11) NOT NULL,
  `filename` varchar(128) NOT NULL,
  `content` blob NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fname` (`filename`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `file`
--

LOCK TABLES `file` WRITE;
/*!40000 ALTER TABLE `file` DISABLE KEYS */;
/*!40000 ALTER TABLE `file` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task`
--

DROP TABLE IF EXISTS `task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `task` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `owner_id` int(11) NOT NULL,
  `start_time` datetime DEFAULT NULL,
  `gap_duration` int(11) NOT NULL,
  `type` int(11) NOT NULL,
  `entrance_type` int(11) DEFAULT NULL,
  `keyword` varchar(256) DEFAULT NULL,
  `taokouling` varchar(256) DEFAULT NULL,
  `act_name` varchar(128) DEFAULT NULL,
  `act_type` varchar(128) DEFAULT NULL,
  `rank_by` int(11) DEFAULT NULL,
  `buyer_gender` int(11) DEFAULT NULL,
  `buyer_age` int(11) DEFAULT NULL,
  `buyer_location` varchar(45) DEFAULT NULL,
  `buyer_rank` int(11) DEFAULT NULL,
  `payment_amount` double DEFAULT NULL,
  `sku` varchar(45) DEFAULT NULL,
  `qty_to_buy` int(11) NOT NULL,
  `claimed_count` int(11) NOT NULL DEFAULT '0',
  `require_chat` bit(1) DEFAULT NULL,
  `page_range` int(11) DEFAULT NULL,
  `price` double NOT NULL,
  `shipment_covered` bit(1) NOT NULL,
  `coupon` double DEFAULT NULL,
  `coupon_link` varchar(256) DEFAULT NULL,
  `sec_msg` varchar(256) DEFAULT NULL,
  `comment_order` varchar(100) DEFAULT NULL,
  `comment_search` varchar(100) DEFAULT NULL,
  `comment_pay` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `owner_id` (`owner_id`),
  KEY `start_time` (`start_time`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task`
--

LOCK TABLES `task` WRITE;
/*!40000 ALTER TABLE `task` DISABLE KEYS */;
INSERT INTO `task` VALUES (1,1,'2016-05-20 13:14:00',10,0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,1.02,NULL,100,0,NULL,NULL,500,'',NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` int(11) NOT NULL,
  `email` varchar(64) NOT NULL,
  `password` varchar(256) NOT NULL,
  `salt` varchar(64) NOT NULL,
  `token` varchar(64) DEFAULT NULL,
  `phone_number` varchar(45) NOT NULL,
  `inviter` int(11) DEFAULT NULL,
  `balance` double NOT NULL DEFAULT '0',
  `score` int(11) NOT NULL DEFAULT '0',
  `taobao_id` varchar(64) NOT NULL,
  `invite_code` varchar(64) DEFAULT NULL,
  `real_name` varchar(32) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `taobao_rank` int(11) DEFAULT NULL,
  `personal_id` varchar(20) DEFAULT NULL,
  `alipay_id` varchar(64) DEFAULT NULL,
  `province` varchar(16) DEFAULT NULL,
  `city` varchar(16) DEFAULT NULL,
  `district` varchar(16) DEFAULT NULL,
  `street_address` varchar(64) DEFAULT NULL,
  `id_photo` int(11) DEFAULT NULL,
  `id_photo1` int(11) DEFAULT NULL,
  `living_photo` int(11) DEFAULT NULL,
  `verify_photo` int(11) DEFAULT NULL,
  `screenshot_img` int(11) DEFAULT NULL,
  `qq` varchar(45) DEFAULT NULL,
  `reputation` int(11) NOT NULL DEFAULT '0',
  `version` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `email` (`email`),
  KEY `phone` (`phone_number`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,0,'noone_knows@yeah.net','9b67c99cc8ad34568181e9dd1c102d59','dwy_1466338020995369925333',NULL,'17090830735',NULL,0,0,'noone_knows',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-06-19 20:48:42
