package com.oj.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zhang run kai
 * @version 1.0
 * @date 2021/3/26 13:43
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Problem {
    //运行Id
    private Integer submitId;
    //运行类型，指语言
    private String submitType;
    private Date submitTime;
    //时间限制
    private long timeLimit;
    //内存限制
    private long memoryLimit;
    //代码文件
    private String code;
    /**
     * 数据地址
     * 输出输出应同名
     */
    private List<String> dataFilePathList = new ArrayList<String>();

    public Integer getSubmitId() {
        return submitId;
    }

    public void setSubmitId(Integer submitId) {
        this.submitId = submitId;
    }

    public String getSubmitType() {
        return submitType;
    }

    public void setSubmitType(String submitType) {
        this.submitType = submitType.toUpperCase();
    }

    public long getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(long timeLimit) {
        this.timeLimit = timeLimit;
    }

    public long getMemoryLimit() {
        return memoryLimit;
    }

    public void setMemoryLimit(long memoryLimit) {
        this.memoryLimit = memoryLimit;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<String> getDataFilePathList() {
        return dataFilePathList;
    }

    public void setDataFilePathList(List<String> dataFilePathList) {
        this.dataFilePathList = dataFilePathList;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }
}
