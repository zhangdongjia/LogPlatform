package com.fdd.service.impl;

import com.fdd.domain.LogReport;
import com.fdd.dao.impl.LogReportDaoImpl;
import com.fdd.service.ILogReportService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by admin on 2016/11/18.
 */

@Service("LogReportServiceImpl")
public class LogReportServiceImpl implements ILogReportService {

    @Resource
    LogReportDaoImpl logReportDao;

    @Override
    public List<LogReport> getAllLogReport() {
        List<LogReport> logReportList = logReportDao.queryAllLogReport();
        return logReportList;
    }

    @Override
    public List<LogReport> getLogReportByIds(List<String> reportIds) {
        List<LogReport> logReportList = logReportDao.queryLogReportByIds(reportIds);
        return logReportList;
    }
}
