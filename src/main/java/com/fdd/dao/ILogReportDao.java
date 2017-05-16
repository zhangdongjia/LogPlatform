package com.fdd.dao;

import com.fdd.domain.LogReport;

import java.util.List;

/**
 * Created by admin on 2016/11/11.
 */
public interface ILogReportDao {

    List<LogReport> queryAllLogReport();

    List<LogReport> queryLogReportByIds(List<String> reportIds);
}
