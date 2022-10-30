package com.phoenix.littlelife.repository.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @TableName family
 */
@TableName(value = "family")
@Data
//@AllArgsConstructor
public class Family implements Serializable {
    /**
     * 主键
     */
    @TableId
    private Long id;

    /**
     * 团体名称
     */
    private String name;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


}