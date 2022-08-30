package com.phoenix.littlelife.data.param;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author Phoenix Fly
 * @create 2022/7/2 15:28
 */
@Data
public class BillParam {

    /**
     * 金额
     */
    private BigDecimal amount;

    /**
     * 标签集
     */
    private List<Long> tagList;

    /**
     * 分组ID
     */
    private Long groupId;

}
