CREATE TABLE `repair_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `open_id_encrypt` varchar(64) NOT NULL COMMENT '加密微信用户id',
  `name` varchar(8) NOT NULL COMMENT '联系人',
  `phone_encrypt` int(6) NOT NULL DEFAULT 0 COMMENT '联系电话',
  `address` varchar(64) NOT NULL DEFAULT '' COMMENT '地址',
  `type` int(1) NOT NULL DEFAULT 0 COMMENT '维修类别',
  `desc` varchar(128) NOT NULL DEFAULT '' COMMENT '故障描述',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `appointment_date` timestamp NOT NULL COMMENT '预约时间',
  `is_distribution` int(1) NOT NULL DEFAULT 0 COMMENT '是否分配（0-未分配、1-分配）',
  `is_deleted` int(1) NOT NULL DEFAULT 0 COMMENT '是否删除（0-未删除、1-删除）',
  PRIMARY KEY `id_index` (`id`) COMMENT 'id主键'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '报修信息表';

CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `repair_info_id` int(11) NOT NULL DEFAULT 0 COMMENT '报修id',
  `staff_num` int(6) NOT NULL DEFAULT 0 COMMENT '维修人员工号',
  `status` int(1) NOT NULL DEFAULT 0 COMMENT '维修状态（1-新建、2-接单、3-出工、4-维修中、5-完成）',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `is_deleted` int(1) NOT NULL DEFAULT 0 COMMENT '是否删除（0-未删除、1-删除）',
  PRIMARY KEY `id_index` (`id`) COMMENT 'id主键'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '订单表';

CREATE TABLE `order_feedback` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `order_id` int(11) NOT NULL DEFAULT 0 COMMENT '订单id',
  `cost` float NOT NULL DEFAULT 0 COMMENT '维修成本',
  `pay` float NOT NULL DEFAULT 0 COMMENT '客户支付金额',
  `evaluate` varchar(128) DEFAULT '' COMMENT '客户评价',
  `is_deleted` int(1) NOT NULL DEFAULT 0 COMMENT '是否删除（0-未删除、1-删除）',
  PRIMARY KEY `id_index` (`id`) COMMENT 'id主键'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '派工表';