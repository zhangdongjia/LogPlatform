package com.fdd.dao.impl;

import com.fdd.domain.LogReport;
import com.fdd.dao.ILogReportDao;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

/**
 * Created by admin on 2016/11/11.
 */
@Repository("LogReportDaoImpl")
public class LogReportDaoImpl extends SqlSessionDaoSupport implements ILogReportDao {

    private final static String NAMESPACE = "com.fdd.dao.impl.LogReportDaoImpl.";

    @Resource(name = "sqlSessionFactory")
    private SqlSessionFactory sqlSessionFactory;

    @PostConstruct
    public void SqlSessionFactory() {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public List<LogReport> queryAllLogReport() {
        List<LogReport> logReportList = getSqlSession().selectList(NAMESPACE + "queryAllLogReport");
        return logReportList;
    }

    @Override
    public List<LogReport> queryLogReportByIds(List<String> reportIds) {
        List<LogReport> logReportList = getSqlSession().selectList(NAMESPACE + "queryLogReportByIds", reportIds);
        return logReportList;
    }
}
