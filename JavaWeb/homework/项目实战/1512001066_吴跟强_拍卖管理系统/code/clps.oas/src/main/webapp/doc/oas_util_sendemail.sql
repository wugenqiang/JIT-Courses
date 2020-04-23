

DROP TABLE IF EXISTS `sm_sendemail`;

CREATE TABLE `sm_sendemail` (
  `email_id` int(11) NOT NULL AUTO_INCREMENT,
  `email_subject` varchar(50) DEFAULT NULL,
  `email_recipient` varchar(50) NOT NULL,
  `email_recipient_id` int(10) NOT NULL,
  `email_content` text NOT NULL,
  `email_sendtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `email_status` tinyint(1) NOT NULL,
  `email_default1` varchar(30) DEFAULT NULL,
  `email_default2` varchar(30) DEFAULT NULL,
  `email_is_visable` tinyint(1) NOT NULL,
  PRIMARY KEY (`email_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `sm_sendemail` */

insert  into `sm_sendemail`(`email_id`,`email_subject`,`email_recipient`,`email_recipient_id`,`email_content`,`email_sendtime`,`email_status`,`email_default1`,`email_default2`,`email_is_visable`) values (1,'13215','chen1',1,'asssasasaasa','2018-05-04 10:41:41',1,NULL,NULL,1),(2,'love','chen',2,' i love you','2018-05-04 11:36:41',1,'','',1),(3,'girlfriend','wjy',3,' i love ','2018-05-07 14:10:11',1,'','',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
