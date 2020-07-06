CREATE TABLE seckill (
`seckill_id` bigint NOT NULL AUTO_INCREMENT,
`name` varchar(20) NOT NULL,
`number` int NOT NULL,
`start_time` timestamp NOT NULL,
`end_time` timestamp NOT NULL,
`create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
PRIMARY KEY (seckill_id),
key idx_start_time(start_time),
key idx_end_time(end_time),
key idx_create_time(create_time)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT '秒杀库存';


INSERT INTO
     seckill (name, number, start_time, end_time)
 VALUES
        ('1元秒杀Iphone', 1000, '2020-07-05 00:00:00', '2020-07-05 00:01:00'),
        ('2元秒杀Surface', 500, '2020-07-05 00:00:00', '2020-07-05 00:01:00'),
        ('1元秒杀Ipad', 400, '2020-07-05 00:00:00', '2020-07-05 00:01:00'),
        ('1元秒杀RedMi', 300, '2020-07-05 00:00:00', '2020-07-05 00:01:00');

CREATE TABLE success_killed (
 `seckill_id` bigint NOT NULL,
 `user_phone` bigint NOT NULL,
 `state` tinyint NOT NULL DEFAULT -1 COMMENT '-1: 无效 0: 成功 1: 已付款 2: 已发货',
 `create_time` timestamp NOT NULL,
 PRIMARY KEY (seckill_id, user_phone),
 key idx_create_time(create_time)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='秒杀成功明细';