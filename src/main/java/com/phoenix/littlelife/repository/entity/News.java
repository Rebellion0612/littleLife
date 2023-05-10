package com.phoenix.littlelife.repository.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName news
 */
@TableName(value ="news")
@Data
public class News implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    private String company;

    /**
     * 
     */
    private String abbre;

    /**
     * 
     */
    private String platform;

    /**
     * 
     */
    private String type;

    /**
     * 
     */
    private String jobType;

    /**
     * 
     */
    private String website;

    /**
     * 
     */
    private String location;

    /**
     * 
     */
    private String province;

    /**
     * 
     */
    private String city;

    /**
     * 
     */
    private String county;

    /**
     * 
     */
    private String riskType;

    /**
     * 
     */
    private String url;

    /**
     * 
     */
    private String title;

    /**
     * 
     */
    private Date time;

    /**
     * 
     */
    private String author;

    /**
     * 
     */
    private String source;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}