CREATE TABLE `family_user_relation` (
                                        `id` bigint NOT NULL COMMENT '主键',
                                        `family_id` bigint NOT NULL COMMENT '家庭号',
                                        `user_id` bigint NOT NULL COMMENT '用户id',
                                        `create_time` datetime NOT NULL COMMENT '创建时间',
                                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `family` (
                          `id` bigint NOT NULL COMMENT '主键',
                          `name` varchar(60) NOT NULL COMMENT '家庭名称\r\n家庭名称',
                          `create_time` datetime NOT NULL COMMENT '创建时间',
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `event` (
                         `id` bigint NOT NULL COMMENT '主键',
                         `name` varchar(255) NOT NULL COMMENT '事件名称',
                         `cycle_duration` int DEFAULT NULL COMMENT '周期时长',
                         `start_time` datetime NOT NULL COMMENT '事件开始时间',
                         `next_time` datetime DEFAULT NULL COMMENT '事件下次开始时间',
                         `event_type` int NOT NULL COMMENT '1:周期性事件，0：一次性事件',
                         `advance_notice_days` int NOT NULL COMMENT '提前通知天数',
                         `create_time` datetime NOT NULL COMMENT '事件创建日期',
                         `notice_time` datetime NOT NULL COMMENT '提醒日期',
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `event_log` (
                             `id` bigint NOT NULL COMMENT '主键',
                             `event_id` bigint NOT NULL COMMENT '事件id',
                             `create_time` datetime NOT NULL COMMENT '事件发生时间',
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `event_user_relation` (
                                       `id` bigint NOT NULL COMMENT '主键',
                                       `event_id` bigint NOT NULL COMMENT '事件id',
                                       `user_id` bigint NOT NULL COMMENT '用户id',
                                       `create_time` datetime NOT NULL COMMENT '事件创建时间',
                                       PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;