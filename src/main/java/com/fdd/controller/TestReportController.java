package com.fdd.controller;

import com.fdd.domain.TestReport;
import com.fdd.service.impl.TestReportServiceImpl;
import com.fdd.utils.ExcelUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by admin on 2016/12/27.
 */

@Controller
@RequestMapping("/report")
public class TestReportController {
    @Resource
    TestReportServiceImpl testReportService;

    @RequestMapping("/showtestreport")
    public String suiteReportPage(HttpServletRequest request, HttpServletResponse response, Model model) {
        return "ShowTestReport";
    }

    @RequestMapping("/getAllTest")
    @ResponseBody
    public List<TestReport> getAllTestReport(HttpServletRequest request, HttpServletResponse response, Model model) {
        return testReportService.getAllTestReport();
    }

    @RequestMapping(value = "downloadExcel4")
    public String downloadExcel4(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String todayStr = sdf.format(new Date());

        String fileName = todayStr + "_testreport";
        List<TestReport> testReports = testReportService.getAllTestReport();
        List<Map<String, Object>> list = createExcelRecord(testReports);

        String columns[] = {"测试ID", "本次测试通过用例集数", "本次测试未通过用例集数", "本次测试通过情况"};
        String keys[] = {"reportId", "suitesPass", "suitesFail", "testResult"};

        ExcelUtil util = new ExcelUtil();
        util.writeExcel(list, columns, keys, response, fileName);
        return null;
    }

    private List<Map<String, Object>> createExcelRecord(List<TestReport> testReports) {
        List<Map<String, Object>> mapList = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("sheetName", "sheet1");
        mapList.add(map);
        TestReport testReport = null;

        for (int i = 0; i < testReports.size(); i++) {
            testReport = testReports.get(i);
            Map<String, Object> mapValue = new HashMap<>();
            mapValue.put("reportId", testReport.getReportId());
            mapValue.put("suitesPass", testReport.getSuitesPass());
            mapValue.put("suitesFail", testReport.getSuitesFail());
            mapValue.put("testResult", testReport.getTestResult());
            mapList.add(mapValue);
        }
        return mapList;
    }
}
