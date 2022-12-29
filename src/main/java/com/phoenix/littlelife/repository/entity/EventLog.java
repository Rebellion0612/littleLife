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
 * @TableName event_log
 */
@TableName(value ="event_log")
@Data
@Builder
public class EventLog implements Serializable {
    /**
     * 主键
     */
    @TableId
    private Long id;

    /**
     * 事件id
     */
    private Long eventId;

    /**
     * 事件发生时间
     */
    private LocalDateTime createTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}