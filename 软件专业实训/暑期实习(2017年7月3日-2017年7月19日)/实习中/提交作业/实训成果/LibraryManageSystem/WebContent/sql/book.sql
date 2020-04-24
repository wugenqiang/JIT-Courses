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

/*Table structure for table `book` */

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '图书id',
  `name` varchar(100) NOT NULL COMMENT '图书名',
  `author` varchar(100) NOT NULL COMMENT '图书作者',
  `publish` varchar(100) NOT NULL COMMENT '出版社',
  `publishdate` date NOT NULL COMMENT '出版日期',
  `page` int(5) DEFAULT NULL COMMENT '页数',
  `price` int(5) DEFAULT NULL COMMENT '价格',
  `content` varchar(500) DEFAULT NULL COMMENT '内容摘要',
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=208 DEFAULT CHARSET=utf8;

/*Data for the table `book` */

insert  into `book`(`id`,`name`,`author`,`publish`,`publishdate`,`page`,`price`,`content`) values (201,'JavaWeb实战（上册）','吴跟强','北京师范大学出版社','2017-07-13',234,22,'不错的一本书'),(202,'JavaWeb实战（下册）','吴跟强','北京师范大学出版社','2017-07-14',234,22,'fighting'),(203,'J2EE','吴跟强','金陵科技学院','2017-10-16',123,22,'j2ee资料'),(204,'J2EE资料','吴跟强','金陵科技学院','2017-12-10',333,22,'fine'),(206,'JavaWeb2','吴跟强','金陵科技学院','2017-07-07',222,11,'ok'),(207,'测试书籍1','吴跟强','金陵科技学院','2017-07-07',222,11,'测试使用');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
