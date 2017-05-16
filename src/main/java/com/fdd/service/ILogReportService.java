package com.fdd.service;

import com.fdd.domain.LogReport;

import java.util.List;

/**
 * Created by admin on 2016/11/18.
 */
public interface ILogReportService {

    List<LogReport> getAllLogReport();

    List<LogReport> getLogReportByIds(List<String> reportIds);
 }
