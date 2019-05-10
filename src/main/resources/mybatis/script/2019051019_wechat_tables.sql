CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `open_id` varchar(64) NOT NULL COMMENT 'open_id',
  `skey` varchar(64) NOT NULL COMMENT 'skey',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_visit_time` timestamp NOT NULL COMMENT '最后登录时间',
  `session_key` varchar(64) NOT NULL COMMENT 'session_key',
  `city` varchar(8) NULL DEFAULT NULL COMMENT '市',
  `province` varchar(8) NULL DEFAULT NULL COMMENT '省',
  `country` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '国',
  `avatar_url` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `gender` int(1) NULL DEFAULT NULL COMMENT '性别',
  `nick_name` varchar(64)  NULL DEFAULT NULL COMMENT '网名',
  `is_deleted` int(1) NOT NULL DEFAULT 0 COMMENT '是否删除（0-未删除、1-删除）',
  PRIMARY KEY `id_index` (`id`) COMMENT 'id主键'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '微信用户信息'