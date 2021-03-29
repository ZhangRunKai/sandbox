package com.oj.stream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author zhang run kai
 * @version 1.0
 * @date 2021/3/26 20:28
 */
public class ThreadOutputStream{
    public static ThreadLocal<ByteArrayOutputStream> threadLocal = new ThreadLocal<>();


}
