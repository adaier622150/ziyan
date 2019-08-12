DROP TABLE IF EXISTS user;

-- 建表
CREATE TABLE user (
  id int(20) NOT NULL AUTO_INCREMENT COMMENT '主键 自增ID',
  user_name varchar(16) NOT NULL DEFAULT '' COMMENT '用户名',
  user_code varchar(64) NOT NULL DEFAULT '' COMMENT '用户编码',
  nick_name varchar(32) NOT NULL DEFAULT '' COMMENT '昵称',
  password varchar(128) NOT NULL DEFAULT '' COMMENT '密码',
  valid int(2) NOT NULL DEFAULT 0 COMMENT '状态 0无效 1有效',
  create_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  update_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (id),
  UNIQUE KEY uniq_user_code (user_code),
  UNIQUE KEY uniq_user_name (user_name),
) COMMENT='用户表';
