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
 * @TableName event_user_relation
 */
@TableName(value ="event_user_relation")
@Data
@Builder
public class EventUserRelation implements Serializable {
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
     * 用户id
     */
    private Long userId;

    /**
     * 事件创建时间
     */
    private LocalDateTime createTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}