CREATE TABLE `user` (
  `user_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `phone` varchar(100) NOT NULL COMMENT '手机号码',
  `pwd` varchar(100) DEFAULT NULL COMMENT '密码',
  `nick_name` varchar(100) NOT NULL COMMENT '昵称',
  `idfa` varchar(100) NOT NULL COMMENT 'idfa',
  `head_pic` varchar(100) DEFAULT NULL COMMENT '头像',
  `c_time` datetime DEFAULT NULL,
  `m_time` datetime DEFAULT NULL,
  `real_name` varchar(100) DEFAULT NULL,
  `sex` int(4) DEFAULT NULL COMMENT '1 男 2女',
  `birthday` date DEFAULT NULL,
  `exp` varchar(4000) DEFAULT NULL,
  `des` varchar(4000) DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='用户表';


CREATE TABLE `user_phone` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_id` int(10) unsigned NOT NULL COMMENT '用户ID',
  `c_time` datetime DEFAULT NULL,
  `m_time` datetime DEFAULT NULL,
  `content` text DEFAULT NULL,
  `des` varchar(1000) DEFAULT NULL,
  `num` int(10) DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='用户云通讯录';

CREATE TABLE `user_stat`  (
  `stat_date` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `user_active` int(11) NOT NULL COMMENT '今日激活用户数',
  `user_register` int(11) NOT NULL COMMENT '今日注册用户数',
  `user_idfa` int(11) NOT NULL COMMENT '今日新增idfa',
  `browse_num` int(11) NOT NULL COMMENT '总浏览人数',
  `copy_num` int(11) NOT NULL COMMENT '总复制人数',
  `join_num` int(11) NOT NULL COMMENT '总参与人数',
  `c_time` datetime NULL DEFAULT NULL,
  `m_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`stat_date`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户统计表' ROW_FORMAT = Compact;