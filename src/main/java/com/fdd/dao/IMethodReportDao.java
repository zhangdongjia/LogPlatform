package com.fdd.dao;

import com.fdd.domain.MethodReport;

import java.util.List;

/**
 * Created by admin on 2016/12/27.
 */
public interface IMethodReportDao {
    List<MethodReport> queryAllMethodReport();
}
