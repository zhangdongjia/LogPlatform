package com.fdd.dao.impl;

import com.fdd.dao.IMethodReportDao;
import com.fdd.domain.MethodReport;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

/**
 * Created by admin on 2016/12/27.
 */

@Repository("MethodReportDaoImpl")
public class MethodReportDaoImpl extends SqlSessionDaoSupport implements IMethodReportDao {
    private final static String NAMESPACE = "com.fdd.dao.MethodReportDaoImpl.";

    @Resource(name = "sqlSessionFactory")
    private SqlSessionFactory sqlSessionFactory;

    @PostConstruct
    public void SqlSessionFactory() {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public List<MethodReport> queryAllMethodReport() {
        List<MethodReport> methodReportList = getSqlSession().selectList(NAMESPACE + "queryAllMethodReport");
        return methodReportList;
    }
}
