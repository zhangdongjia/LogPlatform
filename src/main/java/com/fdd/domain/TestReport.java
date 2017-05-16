package com.fdd.domain;

/**
 * Created by admin on 2016/11/7.
 */
public class TestReport {
    private Integer reportId;

    private Integer suitesPass;

    private Integer suitesFail;

    private String testResult;

    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    public Integer getSuitesPass() {
        return suitesPass;
    }

    public void setSuitesPass(Integer suitesPass) {
        this.suitesPass = suitesPass;
    }

    public Integer getSuitesFail() {
        return suitesFail;
    }

    public void setSuitesFail(Integer suitesFail) {
        this.suitesFail = suitesFail;
    }

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }
}
