package com.oj.sandbox.Java;

import com.oj.entity.Problem;
import com.oj.exception.CEException;
import com.oj.sandbox.ISandbox;
import com.oj.sandbox.Java.Classloader.SandboxClassloader;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @author zhang run kai
 * @version 1.0
 * @date 2021/3/26 15:00
 */
public class JavaSandbox implements ISandbox {
    private static SandboxClassloader sandboxClassloader;
    private static ExecutorService waitThreadPool = Executors.newSingleThreadExecutor(new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            thread.setName("waitThreadPool");
            thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                @Override
                public void uncaughtException(Thread t, Throwable e) {

                }
            });
            return null;
        }
    });
    @Override
    public void read(Problem problem) {
        try{
            sandboxClassloader.submit(problem);
        }catch (CEException ce){
            new CEException();
        }
    }


}
