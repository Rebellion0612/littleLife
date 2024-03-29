package com.phoenix.littlelife.repository.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 
 * @TableName family_user_relation
 */
@TableName(value ="family_user_relation")
@Data
@AllArgsConstructor
public class FamilyUserRelation implements Serializable {
    /**
     * 主键
     */
    @TableId
    private Long id;

    /**
     * 家庭号
     */
    private Long familyId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}