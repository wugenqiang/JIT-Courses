
CREATE TABLE `ACCOUNT` (
  account_id 					int(12) NOT NULL AUTO_INCREMENT,
  account_name 					varchar(60) NOT NULL,
  account_real_name 			varchar(60) NOT NULL,
  account_pass 					varchar(60) NOT NULL,
  account_mail 					varchar(60) NOT NULL,
  account_province 				varchar(20) DEFAULT NULL,
  account_city 					varchar(20) NOT NULL,
  account_district 				varchar(20) NOT NULL,
  account_address 				varchar(100) NOT NULL,
  account_phone 				varchar(50) NOT NULL,
  account_telephone 			varchar(50) DEFAULT NULL,
  account_role_id				int(12) DEFAULT NULL,
  account_position_id			int(12) DEFAULT NULL,
  account_department_id 		int(12) DEFAULT NULL,
  account_company_id 			int(12) DEFAULT NULL,
  account_created_datetime 		timestamp NOT NULL,
  account_updated_datetime 		timestamp NOT NULL,
  account_isValid tinyint(1) 	NOT NULL DEFAULT '1',
  PRIMARY KEY (account_id),
  UNIQUE KEY (account_name)
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

drop table `account`

select * from account
