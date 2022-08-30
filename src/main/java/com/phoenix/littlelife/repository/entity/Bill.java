package com.phoenix.littlelife.repository.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 账单
 *
 * @TableName bill
 */
@TableName(value = "bill")
@Data
public class Bill implements Serializable {
    /**
     * 主键
     */
    @TableId
    private Long id;

    /**
     * 金额
     */
    private Long amount;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 分组ID
     */
    private Long groupId;

    /**
     * 账单类型（0，是出账 ，1-入账）
     */
    private Integer type;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}