DROP TABLE `user_login`;

CREATE TABLE `user_login`
(
  `id`                      BIGINT (20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `login_code`              VARCHAR(20)  NOT NULL DEFAULT '' COMMENT '用户账号',
  `password`                VARCHAR(126) NOT NULL DEFAULT '' COMMENT '用户密码',
  `login_count`             BIGINT (20) NOT NULL DEFAULT '0' COMMENT '登录次数',
  `login_last_time`         TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '登录最后时间',
  `account_non_expired`     TINYINT (1) NOT NULL DEFAULT '1' COMMENT '账号是否过期',
  `account_non_locked`      TINYINT (1) NOT NULL DEFAULT '1' COMMENT '账号是否被锁',
  `credentials_non_expired` TINYINT (1) NOT NULL DEFAULT '1' COMMENT '密码是否过期',
  `enabled`                 TINYINT (1) NOT NULL DEFAULT '1' COMMENT '是否启用',
  `remark`                  VARCHAR(256) NOT NULL DEFAULT '' COMMENT '备注',
  `create_at`               TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by`               VARCHAR(20)  NOT NULL DEFAULT '' COMMENT '创建名称',
  `update_at`               TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `update_by`               VARCHAR(20)  NOT NULL DEFAULT '' COMMENT '更新名称',
  PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT = '用户登录表';