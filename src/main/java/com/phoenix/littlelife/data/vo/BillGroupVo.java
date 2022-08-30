package com.phoenix.littlelife.data.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Phoenix Fly
 * @create 2022/7/2 15:32
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BillGroupVo {

    private String name;

    private Long id;

}
