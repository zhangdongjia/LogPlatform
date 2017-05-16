package com.fdd.service.impl;

import com.fdd.dao.impl.SuiteReportDaoImpl;
import com.fdd.domain.SuiteReport;
import com.fdd.service.ISuiteReportService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by admin on 2016/12/27.
 */

@Service("SuiteReportServiceImpl")
public class SuiteReportServiceImpl implements ISuiteReportService {
    //resource注解相当于new一个对象
    @Resource
    SuiteReportDaoImpl suiteReportDao;

    @Override
    public List<SuiteReport> getAllSuiteReport() {
        List<SuiteReport> suiteReportList = suiteReportDao.queryAllSuiteReport();
        return suiteReportList;
    }
}
