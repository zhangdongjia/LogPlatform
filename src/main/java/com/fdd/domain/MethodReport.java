package com.fdd.domain;

/**
 * Created by admin on 2016/11/7.
 */
public class MethodReport {
    private Integer reportId;

    private String suiteName;

    private String methodName;

    private Integer processPass;

    private Integer processFail;

    private String methodResult;

    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    public String getSuiteName() {
        return suiteName;
    }

    public void setSuiteName(String suiteName) {
        this.suiteName = suiteName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Integer getProcessPass() {
        return processPass;
    }

    public void setProcessPass(Integer processPass) {
        this.processPass = processPass;
    }

    public Integer getProcessFail() {
        return processFail;
    }

    public void setProcessFail(Integer processFail) {
        this.processFail = processFail;
    }

    public String getMethodResult() {
        return methodResult;
    }

    public void setMethodResult(String methodResult) {
        this.methodResult = methodResult;
    }
}
