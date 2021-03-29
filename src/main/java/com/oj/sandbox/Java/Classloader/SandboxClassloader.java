package com.oj.sandbox.Java.Classloader;

import com.oj.entity.Problem;
import com.oj.exception.CEException;
import com.oj.stream.ThreadOutputStream;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;
import java.util.regex.Pattern;

/**
 * @author zhang run kai
 * @version 1.0Th
 * @date 2021/3/26 15:02
 */
public class SandboxClassloader extends ClassLoader{

    private Pattern packagePattern = Pattern.compile("^[ ]*package.*;");
    private Pattern classNamePattern = Pattern.compile("public[ ]*class[ ]*Main[ ]*\\{");
    private Pattern mainMethodPattern = Pattern.compile("public[ ]*static[ ]*void[ ]*main");
    private Pattern threadPattern = Pattern.compile("Thread");

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);
    }

    private Class<?> loadCode(Problem problem) throws RuntimeException{
        JavaCompiler systemJavaCompiler = ToolProvider.getSystemJavaCompiler();
        int run = systemJavaCompiler.run(null, null, ThreadOutputStream.threadLocal.get(), problem.getCode());
        if(run==0){

        }
        else{
            new CEException();
        }

        return null;
    }

    public void submit(Problem problem){
        File file = new File(problem.getCode());
        try {
            StringBuilder codeTemp;
            int len;
            byte[] bytes = new byte[20240];
            FileInputStream fileInputStream = new FileInputStream(file);
            if((len = fileInputStream.read(bytes))!=-1){
            }

            int read = fileInputStream.read(bytes);

//            if(check())
                loadCode(problem);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void check(String code){
        if(packagePattern.matcher(code).find()){
            new RuntimeException("Java代码不能拥有package语句");
        }
        else if(classNamePattern.matcher(code).find()){
            new RuntimeException("主类名必须是Main");
        }
        else if(mainMethodPattern.matcher(code).find()){
            new RuntimeException("没有静态的main方法入口");
        }
        else if(threadPattern.matcher(code).find()){
            new RuntimeException("不允许创建线程");
        }
    }
}
