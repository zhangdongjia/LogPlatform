package com.fdd.dao;

import com.fdd.domain.SuiteReport;

import java.util.List;

/**
 * Created by admin on 2016/12/27.
 */
public interface ISuiteReportDao {
    List<SuiteReport> queryAllSuiteReport();
}
