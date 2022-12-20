package com.phoenix.littlelife.data.param;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author liyangyang
 * @date 2022/12/20 14:01
 */
@Data
public class EventParam {


    /**
     * 事件名称
     */
    @NotBlank(message = "事件名称不可为空")
    private String name;

    /**
     * 周期时长
     */
    private Integer cycleDuration;

    /**
     * 事件开始时间
     */
    @NotBlank(message = "事件开始时间不可为空")
    private String startTime;

    /**
     * 事件下次开始时间
     */
    private LocalDateTime nextTime;

    /**
     * 1:周期性事件，0：一次性事件
     */
    @NotNull(message = "事件类型不可为空")
    private Integer eventType;

    /**
     * 提前通知天数
     */
    @NotNull(message = "提前通知天数不可为空")
    private Integer advanceNoticeDays;
}
