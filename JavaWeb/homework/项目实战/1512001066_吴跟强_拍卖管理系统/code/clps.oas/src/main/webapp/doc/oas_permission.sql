--<ScriptOptions statementTerminator=";"/>
--oas  --




DROP TABLE IF EXISTS `permission`;

CREATE TABLE `permission` (
  `permission_id` int(11) NOT NULL AUTO_INCREMENT,
  `permission_name` varchar(30) NOT NULL ,
  `permission_content` int(30) NOT NULL ,
  `permission_comment` varchar(100) NOT NULL ,
  `permission_level` int(11) NOT NULL,
  `permission_created_datetime` timestamp NULL DEFAULT '0000-00-00 00:00:00',
  `permission_created_name` int(11) DEFAULT NULL,
  `permission_updated_datetime` timestamp NULL DEFAULT '0000-00-00 00:00:00',
  `permission_updated_name` int(11) DEFAULT NULL,
  `maintenance_time` timestamp NULL DEFAULT '0000-00-00 00:00:00',
  `check_time` timestamp NULL DEFAULT '0000-00-00 00:00:00',
  `is_visible` int(11) DEFAULT 1,
  PRIMARY KEY (`permission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `permission` */

insert  into `permission`(`permission_id`,`permission_name`,`permission_content`,`permission_comment`,
`permission_level`,`permission_created_datetime`,`permission_created_name`,`permission_updated_datetime`,
`permission_updated_name`,`maintenance_time`,`check_time`,`is_visible`) 
values (1,'noah',12,'123',1,'2018-05-11 09:35:48',1,'2018-05-11 09:35:48',1,
'2018-05-11 09:35:48','2018-05-11 09:35:48',1);