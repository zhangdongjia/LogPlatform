package com.fdd.dao.impl;

import com.fdd.dao.ISuiteReportDao;
import com.fdd.domain.SuiteReport;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

/**
 * Created by admin on 2016/12/27.
 */

@Repository("SuiteReportDaoImpl")
public class SuiteReportDaoImpl extends SqlSessionDaoSupport implements ISuiteReportDao {
    private final static String NAMESPACE = "com.fdd.dao.impl.SuiteReportDaoImpl.";

    @Resource(name = "sqlSessionFactory")
    private SqlSessionFactory sqlSessionFactory;

    @PostConstruct
    public void SqlSessionFactory() {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public List<SuiteReport> queryAllSuiteReport() {
        List<SuiteReport> suiteReportList = getSqlSession().selectList(NAMESPACE + "queryAllSuiteReport");
        return suiteReportList;
    }
}
