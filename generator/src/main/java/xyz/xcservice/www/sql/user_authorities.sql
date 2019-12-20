DROP TABLE `user_authorities`;

CREATE TABLE `user_authorities`
(
  `id`            BIGINT (20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_login_id` BIGINT (20) NOT NULL DEFAULT '0' COMMENT '用户登录主键id',
  `authority`     VARCHAR(10)  NOT NULL DEFAULT 'USER' COMMENT '用户权限',
  `remark`        VARCHAR(256) NOT NULL DEFAULT '' COMMENT '备注',
  `create_at`     TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by`     VARCHAR(20)  NOT NULL DEFAULT '' COMMENT '创建名称',
  `update_at`     TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `update_by`     VARCHAR(20)  NOT NULL DEFAULT '' COMMENT '更新名称',
  PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT = '用户权限表';