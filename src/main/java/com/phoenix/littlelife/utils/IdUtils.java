package com.phoenix.littlelife.utils;

import cn.hutool.core.util.RandomUtil;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author Phoenix Fly
 * @create 2022/6/23 23:36
 */
public class IdUtils {

    private static Long tmp = System.currentTimeMillis();

    private static final ReentrantLock LOCK = new ReentrantLock();

    public static Long nextId() {
        if (LOCK.tryLock()) {
            tmp += RandomUtil.randomLong(10) + 1;
            LOCK.unlock();
            return tmp;
        } else {
            return nextId();
        }
    }
}
