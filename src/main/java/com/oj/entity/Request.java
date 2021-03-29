package com.oj.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Locale;

/**
 * @author zhang run kai
 * @version 1.0
 * @date 2021/3/26 14:29
 */
@NoArgsConstructor
public class Request {
    //沙盒指令
    private String command;
    private Problem problem;

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command.toUpperCase();
    }

    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }
}
