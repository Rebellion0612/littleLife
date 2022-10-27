package com.phoenix.littlelife.repository.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName family_user_relation
 */
@TableName(value = "family_user_relation")
@Data
@AllArgsConstructor
public class FamilyUserRelation implements Serializable {
    /**
     * 主键
     */
    @TableId
    private Long id;

    /**
     * 团体id
     */
    private Long familyId;

    /**
     * 用户id
     */
    private Long userId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}