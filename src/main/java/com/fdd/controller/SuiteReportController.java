package com.fdd.controller;

import com.fdd.domain.SuiteReport;
import com.fdd.service.impl.SuiteReportServiceImpl;
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
public class SuiteReportController {
    @Resource
    SuiteReportServiceImpl suiteReportService;

    @RequestMapping("/showsuitereport")
    public String suiteReportPage(HttpServletRequest request, HttpServletResponse response, Model model) {
        return "ShowSuiteReport";
    }

    @RequestMapping("/getAllSuite")
    @ResponseBody
    public List<SuiteReport> getAllSuiteReport(HttpServletRequest request, HttpServletResponse response, Model model) {
        return suiteReportService.getAllSuiteReport();
    }

    @RequestMapping(value = "downloadExcel3")
    public String downloadExcel3(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String todayStr = sdf.format(new Date());

        String fileName = todayStr + "_suitereport";
        List<SuiteReport> suiteReports = suiteReportService.getAllSuiteReport();
        List<Map<String, Object>> list = createExcelRecord(suiteReports);

        String columns[] = {"测试ID", "用例集名", "该用例集通过用例数", "该用例集未通过用例数", "用例集通过情况"};
        String keys[] = {"reportId", "suiteName", "methodsPass", "methodsFail", "suiteResult"};

        ExcelUtil util = new ExcelUtil();
        util.writeExcel(list, columns, keys, response, fileName);
        return null;
    }

    private List<Map<String, Object>> createExcelRecord(List<SuiteReport> suiteReports) {
        List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("sheetName", "sheet1");
        mapList.add(map);
        SuiteReport suiteReport = null;

        for (int i = 0; i < suiteReports.size(); i++) {
            suiteReport = suiteReports.get(i);
            Map<String, Object> mapValue = new HashMap<String, Object>();
            mapValue.put("reportId", suiteReport.getReportId());
            mapValue.put("suiteName", suiteReport.getSuiteName());
            mapValue.put("methodsPass", suiteReport.getMethodsPass());
            mapValue.put("methodsFail", suiteReport.getMethodsFail());
            mapValue.put("suiteResult", suiteReport.getSuiteResult());
            mapList.add(mapValue);
        }
        return mapList;
    }
}
