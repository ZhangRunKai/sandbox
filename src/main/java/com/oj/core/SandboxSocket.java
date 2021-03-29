package com.oj.core;

import com.alibaba.fastjson.JSON;
import com.oj.entity.Problem;
import com.oj.entity.Request;
import com.oj.entity.SandboxCommand;
import com.oj.sandbox.Java.JavaSandbox;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author zhang run kai
 * @version 1.0
 * @date 2021/3/26 13:45
 */
public class SandboxSocket {
    private static Socket socket;
    private static JavaSandbox javaSandbox;
    //端口号
    private static Integer pid = 8890;
    public SandboxSocket(){
        openSocket();
    }

    private boolean openSocket(){
        try {
            ServerSocket serverSocket = new ServerSocket(pid);
            System.out.println("沙盒端口："+pid+",等待连接");
            socket = serverSocket.accept();
            System.out.println("连接成功");

            //只保留一个对外连接
            serverSocket.close();
        } catch (IOException e) {
            System.out.println("连接失败");
            System.out.println(e);
            new IOException("连接失败,请检查8890端口是否被占用");
        }
        return socket==null?false:true;
    }

    private void service(){
        try {
            Scanner scanner = new Scanner(socket.getInputStream());
            String data = null;
            while(scanner.hasNext()){
                data = scanner.nextLine();
                Request request = JSON.parseObject(data, Request.class);
                if(request.getCommand().equals(SandboxCommand.RUN)){
                    runProblem(request.getProblem());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void runProblem(Problem problem){
        switch (problem.getSubmitType()){
            case SandboxCommand.JAVA:
                javaSandbox.read(problem);
                break;
        }
    }

    private void write(){
        OutputStream outputStream = null;
        try {
            outputStream = socket.getOutputStream();
//            outputStream.write();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
