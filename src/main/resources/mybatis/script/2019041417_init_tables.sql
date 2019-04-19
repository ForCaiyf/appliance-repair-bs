CREATE TABLE `staff_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `name` varchar(8) NOT NULL DEFAULT '' COMMENT '姓名',
  `age` int(3) NOT NULL DEFAULT 0 COMMENT '年龄',
  `sex_id` int(1) NOT NULL DEFAULT 0 COMMENT '性别id',
  `id_card_encrypt` varchar(64) NOT NULL DEFAULT '' COMMENT '身份证',
  `phone_encrypr` varchar(32) NOT NULL DEFAULT '' COMMENT '手机号',
  `email` varchar(32) NOT NULL DEFAULT '' COMMENT '邮箱',
  `school` varchar(32) NOT NULL DEFAULT '' COMMENT '毕业学校',
  `education_id` int(2) NOT NULL DEFAULT 0 COMMENT '学历id',
  `nation_id` int(2) NOT NULL DEFAULT 0 COMMENT '民族id',
  `marriage_id` int(2) NOT NULL DEFAULT 0 COMMENT '婚姻状况id',
  `experience` varchar(128) NOT NULL DEFAULT '' COMMENT '简要经历',
  `image_url` varchar(64) NOT NULL DEFAULT '' COMMENT '照片url',
  `address` varchar(64) NOT NULL DEFAULT '' COMMENT '家庭住址',
  `family_contact` varchar(8) NOT NULL DEFAULT '' COMMENT '家庭联系人',
  `family_phone_encrypt` varchar(32) NOT NULL DEFAULT '' COMMENT '家庭联系人电话',
  `emergency_contact` varchar(8) NOT NULL DEFAULT '' COMMENT '紧急联系人',
  `emergency_phone_encrypt` varchar(8) NOT NULL DEFAULT '' COMMENT '紧急联系人电话',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `is_deleted` int(1) NOT NULL DEFAULT 0 COMMENT '是否删除（0-未删除、1-删除）',
  PRIMARY KEY `id_index` (`id`) COMMENT 'id主键'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '员工信息表';

INSERT INTO `staff_info` (`name`, `age`, `sex_id`, `id_card_encrypt`, `phone_encrypr`, `email`, `school`, `education_id`, `nation_id`, `marriage_id`, `experience`, `image_url`, `address`)
    VALUES ('caiyf', 23, 1, 'KI705sKPp++h4aXBpyULpyG54bryiPoh', 'K7iLGXmIxuBTCi68urNP1A==', 'caiyf_wx@163.com', '东北林业大学', '6', '1', '1', '。。。', 'D:\\Program Files\\IDEAwork\\images\\caiyf.jpg', '黑龙江|哈尔滨|香坊|东北林业大学');

CREATE TABLE `staff_type` (
  `id` int(2) NOT NULL COMMENT '类型id',
  `type` varchar(8) NOT NULL DEFAULT '' COMMENT '类型名',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `is_deleted` int(1) NOT NULL DEFAULT 0 COMMENT '是否删除（0-未删除、1-删除）',
  PRIMARY KEY `id_index` (`id`) COMMENT 'id主键'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '员工类型表';

INSERT INTO `staff_type` (`id`, `type`) VALUES (1, '维修员');
INSERT INTO `staff_type` (`id`, `type`) VALUES (2, '业务员');
INSERT INTO `staff_type` (`id`, `type`) VALUES (3, '管理员');

CREATE TABLE `staff_level` (
  `id` int(2) NOT NULL COMMENT '级别id',
  `level` varchar(8) NOT NULL DEFAULT '' COMMENT '级别名',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `is_deleted` int(1) NOT NULL DEFAULT 0 COMMENT '是否删除（0-未删除、1-删除）',
  PRIMARY KEY `id_index` (`id`) COMMENT 'id主键'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '员工级别表';

INSERT INTO `staff_level` (`id`, `level`) VALUES (1, '初级');
INSERT INTO `staff_level` (`id`, `level`) VALUES (2, '中级');
INSERT INTO `staff_level` (`id`, `level`) VALUES (3, '高级');

CREATE TABLE `staff` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `num` int(6) NOT NULL DEFAULT 0 COMMENT '员工id',
  `name` varchar(8) NOT NULL DEFAULT '' COMMENT '员工姓名',
  `password` varchar(32) NOT NULL DEFAULT '' COMMENT '员工密码',
  `type` int(1) NOT NULL DEFAULT 0 COMMENT '员工类别',
  `level` int(1) NOT NULL DEFAULT 0 COMMENT '员工级别',
  `info_id` int(11) NOT NULL DEFAULT 0 COMMENT '员工信息表id',
  `agent_id` int(11) NOT NULL DEFAULT 0 COMMENT '经办人id',
  `info_filled` int(1) NOT NULL DEFAULT 1 COMMENT '个人信息是否完善（0-完善、1-不完善）',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `is_deleted` int(1) NOT NULL DEFAULT 0 COMMENT '是否删除（0-未删除、1-删除）',
  PRIMARY KEY `id_index` (`id`) COMMENT 'id主键'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '员工表';

INSERT INTO `staff` (`num`, `name`, `password`, `type`, `level`, `info_id`) VALUE (888888, 'caiyf', 'cyf1996', 3, 3, 1);