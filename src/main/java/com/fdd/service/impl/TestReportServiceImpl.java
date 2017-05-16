package com.fdd.service.impl;

import com.fdd.dao.impl.TestReportDaoImpl;
import com.fdd.domain.TestReport;
import com.fdd.service.ITestReportService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by admin on 2016/12/27.
 */
@Service("TestReportServiceImpl")
public class TestReportServiceImpl implements ITestReportService {
    @Resource
    TestReportDaoImpl testReportDao;

    @Override
    public List<TestReport> getAllTestReport() {
        List<TestReport> testReportList = testReportDao.queryAllTestReport();
        return testReportList;
    }
}
