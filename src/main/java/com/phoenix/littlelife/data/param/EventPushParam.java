package com.phoenix.littlelife.data.param;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author liyangyangnt
 * @date 2022/12/28 21:04
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EventPushParam implements Serializable {
    /**
     * 日程id
     */
    private Long eventId;
    /**
     * 日程推送类型
     */
    private Integer pushType;
}
