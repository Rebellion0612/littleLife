package com.phoenix.littlelife.data.param;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * 前端传递的参数接收
 *
 * @Author Phoenix Fly
 * @create 2022/10/24 22:10
 */
@Data
public class FamilyParam {

    /**
     * 家庭名
     */
    @NotBlank(message = "创建家庭名称不可为空")
    private String name;

    /**
     * 用户Id
     */
    @NotEmpty(message = "要加入的家庭成员不可为空")
    private List<Long> userIds;

    /**
     * 密钥
     */
    private String key;
}
