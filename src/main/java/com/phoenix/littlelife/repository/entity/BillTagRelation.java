package com.phoenix.littlelife.repository.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 账单关联关系表
 *
 * @TableName bill_tag_relation
 */
@TableName(value = "bill_tag_relation")
@Data
public class BillTagRelation implements Serializable {
    /**
     * 主键
     */
    @TableId
    private Long id;

    /**
     * 账单ID
     */
    private Long billId;

    /**
     * 标签ID
     */
    private Long tagId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}