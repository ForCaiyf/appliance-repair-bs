CREATE TABLE `nation` (
  `id` int(2) NOT NULL COMMENT '民族-键',
  `nation` varchar(8) NOT NULL DEFAULT '' COMMENT '民族-值',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `is_deleted` int(1) NOT NULL DEFAULT 0 COMMENT '是否删除（0-未删除、1-删除）',
  PRIMARY KEY `nation_id` (`id`) COMMENT '主键'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '民族表';

INSERT INTO `nation` (`id`, `nation`) VALUES (1, '汉族');
INSERT INTO `nation` (`id`, `nation`) VALUES (2, '蒙古族');
INSERT INTO `nation` (`id`, `nation`) VALUES (3, '回族');
INSERT INTO `nation` (`id`, `nation`) VALUES (4, '藏族');
INSERT INTO `nation` (`id`, `nation`) VALUES (5, '维吾尔族');
INSERT INTO `nation` (`id`, `nation`) VALUES (6, '苗族');
INSERT INTO `nation` (`id`, `nation`) VALUES (7, '彝族');
INSERT INTO `nation` (`id`, `nation`) VALUES (8, '壮族');
INSERT INTO `nation` (`id`, `nation`) VALUES (9, '布依族');
INSERT INTO `nation` (`id`, `nation`) VALUES (10, '朝鲜族');
INSERT INTO `nation` (`id`, `nation`) VALUES (11, '满族');
INSERT INTO `nation` (`id`, `nation`) VALUES (12, '侗族');
INSERT INTO `nation` (`id`, `nation`) VALUES (13, '瑶族');
INSERT INTO `nation` (`id`, `nation`) VALUES (14, '白族');
INSERT INTO `nation` (`id`, `nation`) VALUES (15, '土家族');
INSERT INTO `nation` (`id`, `nation`) VALUES (16, '哈尼族');
INSERT INTO `nation` (`id`, `nation`) VALUES (17, '哈萨克族');
INSERT INTO `nation` (`id`, `nation`) VALUES (18, '傣族');
INSERT INTO `nation` (`id`, `nation`) VALUES (19, '黎族');
INSERT INTO `nation` (`id`, `nation`) VALUES (20, '傈僳族');
INSERT INTO `nation` (`id`, `nation`) VALUES (21, '佤族');
INSERT INTO `nation` (`id`, `nation`) VALUES (22, '畲族');
INSERT INTO `nation` (`id`, `nation`) VALUES (23, '高山族');
INSERT INTO `nation` (`id`, `nation`) VALUES (24, '拉祜族');
INSERT INTO `nation` (`id`, `nation`) VALUES (25, '水族');
INSERT INTO `nation` (`id`, `nation`) VALUES (26, '东乡族');
INSERT INTO `nation` (`id`, `nation`) VALUES (27, '纳西族');
INSERT INTO `nation` (`id`, `nation`) VALUES (28, '景颇族');
INSERT INTO `nation` (`id`, `nation`) VALUES (29, '柯尔克孜族');
INSERT INTO `nation` (`id`, `nation`) VALUES (30, '土族');
INSERT INTO `nation` (`id`, `nation`) VALUES (31, '达翰尔族');
INSERT INTO `nation` (`id`, `nation`) VALUES (32, '么佬族');
INSERT INTO `nation` (`id`, `nation`) VALUES (33, '羌族');
INSERT INTO `nation` (`id`, `nation`) VALUES (34, '布朗族');
INSERT INTO `nation` (`id`, `nation`) VALUES (35, '撒拉族');
INSERT INTO `nation` (`id`, `nation`) VALUES (36, '毛南族');
INSERT INTO `nation` (`id`, `nation`) VALUES (37, '仡佬族');
INSERT INTO `nation` (`id`, `nation`) VALUES (38, '锡伯族');
INSERT INTO `nation` (`id`, `nation`) VALUES (39, '阿昌族');
INSERT INTO `nation` (`id`, `nation`) VALUES (40, '普米族');
INSERT INTO `nation` (`id`, `nation`) VALUES (41, '塔吉克族');
INSERT INTO `nation` (`id`, `nation`) VALUES (42, '怒族');
INSERT INTO `nation` (`id`, `nation`) VALUES (43, '乌孜别克族');
INSERT INTO `nation` (`id`, `nation`) VALUES (44, '俄罗斯族');
INSERT INTO `nation` (`id`, `nation`) VALUES (45, '鄂温克族');
INSERT INTO `nation` (`id`, `nation`) VALUES (46, '德昂族');
INSERT INTO `nation` (`id`, `nation`) VALUES (47, '保安族');
INSERT INTO `nation` (`id`, `nation`) VALUES (48, '裕固族');
INSERT INTO `nation` (`id`, `nation`) VALUES (49, '京族');
INSERT INTO `nation` (`id`, `nation`) VALUES (50, '塔塔尔族');
INSERT INTO `nation` (`id`, `nation`) VALUES (51, '独龙族');
INSERT INTO `nation` (`id`, `nation`) VALUES (52, '鄂伦春族');
INSERT INTO `nation` (`id`, `nation`) VALUES (53, '赫哲族');
INSERT INTO `nation` (`id`, `nation`) VALUES (54, '门巴族');
INSERT INTO `nation` (`id`, `nation`) VALUES (55, '珞巴族');
INSERT INTO `nation` (`id`, `nation`) VALUES (56, '基诺族');

CREATE TABLE `education` (
  `id` int(2) NOT NULL COMMENT '学历-键',
  `education` varchar(8) NOT NULL DEFAULT '' COMMENT '学历-值',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `is_deleted` int(1) NOT NULL DEFAULT 0 COMMENT '是否删除（0-未删除、1-删除）',
  PRIMARY KEY `education_id` (`id`) COMMENT 'i主键'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '学历表';

INSERT INTO `education` (`id`, `education`) VALUES (1, '文盲');
INSERT INTO `education` (`id`, `education`) VALUES (2, '小学');
INSERT INTO `education` (`id`, `education`) VALUES (3, '初中');
INSERT INTO `education` (`id`, `education`) VALUES (4, '高中');
INSERT INTO `education` (`id`, `education`) VALUES (5, '大专');
INSERT INTO `education` (`id`, `education`) VALUES (6, '本科');
INSERT INTO `education` (`id`, `education`) VALUES (7, '硕士');
INSERT INTO `education` (`id`, `education`) VALUES (8, '博士');

CREATE TABLE `sex` (
  `id` int(2) NOT NULL COMMENT '性别-键',
  `sex` varchar(8) NOT NULL DEFAULT '' COMMENT '性别-值',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `is_deleted` int(1) NOT NULL DEFAULT 0 COMMENT '是否删除（0-未删除、1-删除）',
  PRIMARY KEY `sex_id` (`id`) COMMENT '主键'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '性别表';

INSERT INTO `sex` (`id`, `sex`) VALUES (1, '男');
INSERT INTO `sex` (`id`, `sex`) VALUES (2, '女');

CREATE TABLE `marriage` (
  `id` int(2) NOT NULL COMMENT '婚姻-键',
  `marriage` varchar(8) NOT NULL DEFAULT '' COMMENT '婚姻-值',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `is_deleted` int(1) NOT NULL DEFAULT 0 COMMENT '是否删除（0-未删除、1-删除）',
  PRIMARY KEY `marriage_id` (`id`) COMMENT '主键'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '婚姻表';

INSERT INTO `marriage` (`id`, `marriage`) VALUES (1, '未婚');
INSERT INTO `marriage` (`id`, `marriage`) VALUES (2, '已婚');
INSERT INTO `marriage` (`id`, `marriage`) VALUES (3, '丧偶');
INSERT INTO `marriage` (`id`, `marriage`) VALUES (4, '离婚');
INSERT INTO `marriage` (`id`, `marriage`) VALUES (5, '其他');