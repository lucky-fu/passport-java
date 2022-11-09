-- MySQL dump 10.13  Distrib 8.0.19, for osx10.15 (x86_64)
--
-- Host: 43.143.238.182    Database: passport
-- ------------------------------------------------------
-- Server version	5.7.40

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
                        `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户id',
                        `name` varchar(128) CHARACTER SET utf8 DEFAULT NULL COMMENT '用户名称',
                        `avatar` varchar(128) NOT NULL COMMENT '头像',
                        `Introduce` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT 'wait for you' COMMENT '简介',
                        `status` int(10) NOT NULL DEFAULT '0' COMMENT '状态0待激活1正常2被删除',
                        `extension` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '{}' COMMENT '扩展',
                        `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                        `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
                        PRIMARY KEY (`id`),
                        UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_bind`
--

DROP TABLE IF EXISTS `user_bind`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_bind` (
                             `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
                             `user_id` bigint(20) NOT NULL COMMENT '用户',
                             `identify_type` int(10) NOT NULL COMMENT '账号类型',
                             `identifier` varchar(128) CHARACTER SET utf8 NOT NULL COMMENT '账号',
                             `status` int(10) NOT NULL DEFAULT '0' COMMENT '状态0激活，1正常，2删除',
                             `extension` varchar(128) NOT NULL DEFAULT '{}' COMMENT '扩展字段',
                             `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                             `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
                             PRIMARY KEY (`id`),
                             UNIQUE KEY `id` (`id`),
                             KEY `user_id_index` (`user_id`) USING BTREE,
                             KEY `identifier_index` (`identifier`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_bind`
--

LOCK TABLES `user_bind` WRITE;
/*!40000 ALTER TABLE `user_bind` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_bind` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-08 21:50:54