CREATE DATABASE Test;

CREATE TABLE User
(
    name   varchar(5) COMMENT '姓名',
    userid int(2) NOT NULL COMMENT '用户ID',
    PRIMARY KEY (userid)
);

INSERT INTO User VALUES ('张三', 01);
INSERT INTO User VALUES ('李四', 02);
INSERT INTO User VALUES ('王五', 03);
INSERT INTO User VALUES ('老六', 04);
INSERT INTO User VALUES ('陆七', 05);