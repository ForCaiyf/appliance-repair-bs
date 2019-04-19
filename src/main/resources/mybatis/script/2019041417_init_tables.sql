CREATE TABLE `staff` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `num` int(6) NOT NULL DEFAULT 0 COMMENT '员工id',
  `password` varchar(32) NOT NULL DEFAULT '' COMMENT '员工密码',
  `type` int(1) NOT NULL DEFAULT 0 COMMENT '员工类别（1-初级人员、2-中级人员、3-高级人员）',
  `level` int(1) NOT NULL DEFAULT 0 COMMENT '员工级别（1-维修员、2-业务员、3-管理员）',
  `info_id` int(11) NOT NULL DEFAULT 0 COMMENT '员工信息表id',
  `agent_id` int(11) NOT NULL DEFAULT 0 COMMENT '经办人id',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `is_deleted` int(1) NOT NULL DEFAULT 0 COMMENT '是否删除（0-未删除、1-删除）',
  PRIMARY KEY `id_index` (`id`) COMMENT 'id主键'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '员工表';

CREATE TABLE `staff_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `name` varchar(8) NOT NULL DEFAULT '' COMMENT '姓名',
  `age` int(3) NOT NULL DEFAULT 0 COMMENT '年龄',
  `sex` int(1) NOT NULL DEFAULT 0 COMMENT '性别index',
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

