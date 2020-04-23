
DROP TABLE IF EXISTS parameter;


create table PARAMETER(
	parameter_id 				int AUTO_INCREMENT,	
	parameter_name 				VARCHAR(60) NOT null,	
	parameter_conent 			varchar(100) NOT NULL,	
	parameter_spuelId 			int,	
	parameter__comment 			varchar(1000),	
	parameter_created_datetime	timestamp NOT NULL,	
	parameter_created_name 		int NOT NULL,
	parameter__updated_datetime timestamp NOT NULL,
	parameter_updated_name 		int NOT NULL,
	parameter_isvariable 		int NOT NULL,
	user_default1 				varchar(60),
	user_default2 				varchar(60),
	PRIMARY KEY (parameter_id)
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

INSERT INTO PARAMETER(parameter_name,parameter_conent,parameter_spuelId,parameter__comment,
parameter_created_datetime,parameter_created_name,parameter__updated_datetime,parameter_updated_name,
parameter_isvariable,user_default1,user_default2
) VALUES("topPrice","189",0,"zuigaojiao",'2018-5-7',1,'2018-5-7',1,1,"111","111");