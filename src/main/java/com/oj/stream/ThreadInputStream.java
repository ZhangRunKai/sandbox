package com.oj.stream;

import java.io.ByteArrayInputStream;

/**
 * @author zhang run kai
 * @version 1.0
 * @date 2021/3/26 20:17
 */
public class ThreadInputStream {
    public static ThreadLocal<ByteArrayInputStream> threadLocal = new ThreadLocal<ByteArrayInputStream>();
}
