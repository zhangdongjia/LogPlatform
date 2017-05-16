package com.fdd.dao.impl;

import com.fdd.dao.ITestReportDao;
import com.fdd.domain.TestReport;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

/**
 * Created by admin on 2016/12/27.
 */

@Repository("TestReportDaoImpl")
public class TestReportDaoImpl extends SqlSessionDaoSupport implements ITestReportDao {
    private final static String NAMESPACE = "com.fdd.dao.impl.TestReportDaoImpl.";

    @Resource(name = "sqlSessionFactory")
    private SqlSessionFactory sqlSessionFactory;

    @PostConstruct
    public void SqlSessionFactory() {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public List<TestReport> queryAllTestReport() {
        List<TestReport> testReportList = getSqlSession().selectList(NAMESPACE + "queryAllTestReport");
        return testReportList;
    }
}
