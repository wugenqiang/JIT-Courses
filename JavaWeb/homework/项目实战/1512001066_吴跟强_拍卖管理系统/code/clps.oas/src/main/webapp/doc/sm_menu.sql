
--------create table menu--------
Drop table sm_menu;
CREATE TABLE sm_menu (
	menu_id INT NOT NULL auto_increment,
	menu_name VARCHAR(100) NOT NULL comment '菜单名',
	menu_sort_id int not null comment '菜单排序号',
	menu_level INT not null comment '菜单等级',
	menu_parentid INT not null comment '菜单父Id',
	menu_url VARCHAR(100) comment '菜单url' ,
	menu_isvariable int not null default 1 comment '菜单状态',
	menu_comment VARCHAR(1000) comment '菜单备注',
	menu_created_datetime TIMESTAMP  NULL comment '菜单创建时间'
	comment '菜单创建时间',
	menu_created_name INT NOT NULL comment '菜单创建人',
	menu_updated_datetime TIMESTAMP  NOT NULL  
	default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP 
	comment '菜单修改时间',
	menu_updated_name INT NOT NULL comment '菜单修改人',
	menu_default1 VARCHAR(20),
	menu_default2 VARCHAR(20),
	PRIMARY KEY (menu_id)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

insert into `sm_menu` (`menu_id`, 
`menu_name`, `menu_sort_id`, `menu_level`, `menu_parentid`,
`menu_url`, `menu_isvariable`, `menu_comment`, `menu_created_datetime`,
`menu_created_name`, `menu_updated_datetime`, `menu_updated_name`, 
`menu_default1`, `menu_default2`) values(null, 'menu', 3, 1, 0,
'menu', 1, 'menu', '20180511092203', 1, '20180511092207', 1, null, null)