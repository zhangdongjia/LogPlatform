package com.fdd.dao;

import com.fdd.domain.TestReport;

import java.util.List;

/**
 * Created by admin on 2016/12/27.
 */
public interface ITestReportDao {
    List<TestReport> queryAllTestReport();
}
