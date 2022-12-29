package com.phoenix.littlelife.schedule;


import lombok.RequiredArgsConstructor;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author liyangyang
 * @date 2022/12/26 15:51
 */

@RequiredArgsConstructor
public class Task<T> implements Delayed{

    /**
     * 到期时间，单位ms
     */
    private long activeTime;

    private T data;

    public Task(long activeTime,T data) {
        super();
        this.activeTime = TimeUnit.NANOSECONDS.convert(activeTime, TimeUnit.MILLISECONDS) + System.nanoTime();
        this.data = data;
    }

    public long getActiveTime() {
        return activeTime;
    }

    public T getData() {
        return data;
    }

    @Override
    public int compareTo(Delayed o) {
        long diff = getDelay(TimeUnit.NANOSECONDS) - getDelay(TimeUnit.NANOSECONDS);
        return diff == 0 ? 0 : (diff > 0 ? 1 : -1);
    }

    @Override
    public long getDelay(TimeUnit unit) {
        long diff = unit.convert(activeTime - System.nanoTime(), TimeUnit.NANOSECONDS);
        return diff;
    }
}
