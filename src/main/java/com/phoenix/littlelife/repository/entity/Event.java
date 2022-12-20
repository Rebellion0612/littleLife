package com.phoenix.littlelife.repository.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import lombok.Builder;
import lombok.Data;

/**
 * 
 * @TableName event
 */
@TableName(value ="event")
@Data
@Builder
public class Event implements Serializable {
    /**
     * 主键
     */
    @TableId
    private Long id;

    /**
     * 事件名称
     */
    private String name;

    /**
     * 周期时长
     */
    private Integer cycleDuration;

    /**
     * 事件开始时间
     */
    private LocalDateTime startTime;

    /**
     * 事件下次开始时间
     */
    private LocalDateTime nextTime;

    /**
     * 1:周期性事件，0：一次性事件
     */
    private Integer eventType;

    /**
     * 提前通知天数
     */
    private Integer advanceNoticeDays;

    /**
     * 事件创建日期
     */
    private LocalDateTime createTime;

    /**
     * 提醒日期
     */
    private LocalDateTime noticeTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}