package com.fdd.service.impl;

import com.fdd.dao.impl.MethodReportDaoImpl;
import com.fdd.domain.MethodReport;
import com.fdd.service.IMethodReportService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by admin on 2016/12/27.
 */

@Service("MethodReportServiceImpl")
public class MethodReportServiceImpl implements IMethodReportService {
    @Resource
    MethodReportDaoImpl methodReportDao;

    @Override
    public List<MethodReport> getAllMethodReport() {
        List<MethodReport> methodReportList = methodReportDao.queryAllMethodReport();
        return methodReportList;
    }
}
