package com.fdd.controller;

import com.fdd.domain.MethodReport;
import com.fdd.service.impl.MethodReportServiceImpl;
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
public class MethodReportController {
    @Resource
    MethodReportServiceImpl methodReportService;

    @RequestMapping("/showmethodreport")
    public String methodReportPage(HttpServletRequest request, HttpServletResponse response, Model model) {
        return "ShowMethodReport";
    }

    @RequestMapping("/getAllMethod")
    @ResponseBody
    public List<MethodReport> getAllMethodReport(HttpServletRequest request, HttpServletResponse response, Model model) {
        return methodReportService.getAllMethodReport();
    }

    @RequestMapping(value = "downloadExcel2")
    public String downloadExcel2(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String todayStr = sdf.format(new Date());

        String fileName = todayStr + "_methodreport";
        List<MethodReport> methodReports = methodReportService.getAllMethodReport();
        List<Map<String, Object>> list = createExcelRecord(methodReports);

        String columns[] = {"测试ID", "所属用例集名", "用例名", "该用例通过步骤数", "该用例通过步骤数", "用例通过情况"};
        String keys[] = {"reportId", "suiteName", "methodName", "processPass", "processFail", "methodResult"};

        ExcelUtil util = new ExcelUtil();
        util.writeExcel(list, columns, keys, response, fileName);
        return null;
    }

    private List<Map<String, Object>> createExcelRecord(List<MethodReport> methodReports) {
        List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("sheetName", "sheet1");
        mapList.add(map);
        MethodReport methodReport = null;

        for (int i = 0; i < methodReports.size(); i++) {
            methodReport = methodReports.get(i);
            Map<String, Object> mapValue = new HashMap<String, Object>();
            mapValue.put("reportId", methodReport.getReportId());
            mapValue.put("suiteName", methodReport.getSuiteName());
            mapValue.put("methodName", methodReport.getMethodName());
            mapValue.put("processPass", methodReport.getProcessPass());
            mapValue.put("processFail", methodReport.getProcessFail());
            mapValue.put("methodResult", methodReport.getMethodResult());
            mapList.add(mapValue);
        }
        return mapList;
    }
}
