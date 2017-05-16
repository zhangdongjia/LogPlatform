package com.fdd.domain;

/**
 * Created by admin on 2016/11/7.
 */
public class SuiteReport {
    private Integer reportId;

    private String suiteName;

    private Integer methodsPass;

    private Integer methodsFail;

    private String suiteResult;

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

    public Integer getMethodsPass() {
        return methodsPass;
    }

    public void setMethodsPass(Integer methodsPass) {
        this.methodsPass = methodsPass;
    }

    public Integer getMethodsFail() {
        return methodsFail;
    }

    public void setMethodsFail(Integer methodsFail) {
        this.methodsFail = methodsFail;
    }

    public String getSuiteResult() {
        return suiteResult;
    }

    public void setSuiteResult(String suiteResult) {
        this.suiteResult =suiteResult;
    }
}
