CREATE TABLE `t_order` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `member_id` int(11) DEFAULT NULL COMMENT '会员id',
  `order_num` varchar(45) COLLATE utf8_bin DEFAULT NULL COMMENT '订单编号',
  `goods_name` varchar(45) COLLATE utf8_bin DEFAULT NULL COMMENT '商品名称',
  PRIMARY KEY (`order_id`),
  UNIQUE KEY `order_num_UNIQUE` (`order_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='订单表'