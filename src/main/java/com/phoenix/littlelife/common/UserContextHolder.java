package com.phoenix.littlelife.common;

/**
 * @Author Phoenix Fly
 * @create 2022/7/3 15:42
 */
public class UserContextHolder {

    private static ThreadLocal<Long> userLocal = new ThreadLocal<>();

    public static void setUserId(Long userId) {
        userLocal.set(userId);
    }

    public static Long getUserId() {
        return userLocal.get();
    }

    public static void clear() {
        userLocal.remove();
    }
}
