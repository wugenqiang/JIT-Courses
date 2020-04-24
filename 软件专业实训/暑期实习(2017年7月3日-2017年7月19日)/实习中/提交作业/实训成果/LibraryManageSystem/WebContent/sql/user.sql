/*
SQLyog Ultimate v9.63 
MySQL - 5.5.5-10.1.13-MariaDB : Database - bookdb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bookdb` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `bookdb`;

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `name` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(40) NOT NULL COMMENT '密码',
  `age` int(5) DEFAULT NULL COMMENT '年龄',
  `sex` int(2) NOT NULL COMMENT '性别',
  `nickname` varchar(20) NOT NULL COMMENT '昵称',
  `usertype` int(2) NOT NULL COMMENT '0：普通用户 1:管理员',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`password`,`age`,`sex`,`nickname`,`usertype`) values (1,'admin','123456',18,1,'admin_nk',1),(2,'user1','123456',18,1,'user1_nk',0),(3,'user2','123456',18,1,'user2_nk',0),(4,'11','11',11,1,'1',1),(5,'22','22',22,1,'1',0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
