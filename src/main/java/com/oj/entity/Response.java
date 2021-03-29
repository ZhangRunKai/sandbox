package com.oj.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * @author zhang run kai
 * @version 1.0
 * @date 2021/3/26 20:56
 */
@AllArgsConstructor
public class Response {
    private String status;
    private String message;
    private Integer submitId;
    //运行类型，指语言
    private String submitType;
    private Date submitTime;

    private Response(){}

    public static Response AC(Problem problem){
        return new Response(SandboxCommand.AC,null,problem.getSubmitId(),problem.getSubmitType(),problem.getSubmitTime());
    }

    public static Response CE(Problem problem,String message){
        return new Response(SandboxCommand.CE,message,problem.getSubmitId(),problem.getSubmitType(),problem.getSubmitTime());
    }
}
