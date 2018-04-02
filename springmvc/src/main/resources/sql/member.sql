CREATE TABLE `member` (
  `member_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `member_name` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '用户名',
  `member_email` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '用户邮箱',
  `member_mobile` varchar(14) COLLATE utf8_bin NOT NULL COMMENT '用户手机',
  PRIMARY KEY (`member_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户表'