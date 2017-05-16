package com.fdd.controller;

import com.fdd.domain.LogReport;
import com.fdd.service.impl.LogReportServiceImpl;
import com.fdd.utils.ExcelUtil;
import com.fdd.utils.ExportExcelUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * Created by admin on 2016/12/1.
 */

@Controller
@RequestMapping("/report")
public class LogReportController {
    private final static Logger logger = LoggerFactory.getLogger(LogReportController.class);

    @Resource
    LogReportServiceImpl logReportService;

    /**
     *
     * @param request
     * @param model
     * @return 返回对应视图名称
     */
    @RequestMapping("/showlogreport")
    public String logReportPage(HttpServletRequest request, HttpServletResponse response, Model model) {
        return "ShowLogReport";
    }

    @RequestMapping("/getAllLog")
    @ResponseBody
    public List<LogReport> getAllLogReport(HttpServletRequest request, Model model, HttpServletResponse response) {
        return logReportService.getAllLogReport();
    }

    /**
    @RequestMapping(value = "exportExcel", method = {RequestMethod.GET, RequestMethod.POST})
    public String  exportExcel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("---通过模板导出excel文件---");
        OutputStream os = null;
        Workbook workbook = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String todayStr = sdf.format(new Date());

        String id = request.getParameter("reportId");
        logger.info("<------"+id+"------>");
        List<String> idList = new ArrayList<>(Arrays.asList(id.split(",")));
        try {
            //从数据库取值
            //List<LogReport> logReportList = logReportService.getAllLogReport();
            List<LogReport> logReportList = logReportService.getLogReportByIds(idList);

            //导出Excel文件
            ExportExcelUtil exportExcelUtil = new ExportExcelUtil();
            File file = exportExcelUtil.getExcelDemoFile("/exceldemo/ExcelDemo.xlsx");
            String sheetName = "sheet1";
            workbook = exportExcelUtil.writeExcel(file, sheetName, logReportList);

            //导出的exce文件名
            String fileName = todayStr + "_logreport";
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-dispositon", "attachment;filename=" + URLEncoder.encode(fileName, "utf-8") + ".xls");
            os = response.getOutputStream();
            workbook.write(os);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            os.flush();
            os.close();
            workbook.close();
        }
        return null;
    }
    **/

    /**
     *以excel文件的格式导出数据
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "downloadExcel")
    public String downloadExcel(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String todayStr = sdf.format(new Date());

        String fileName = todayStr + "_logreport";
        List<LogReport> logReports = logReportService.getAllLogReport();
        List<Map<String, Object>> list = createExcelRecord(logReports);

        String columns[] = {"测试ID", "运行时间", "所属用例集名", "所属用例名", "步骤描述", "实际结果", "期望结果", "步骤通过情况"};
        String keys[] = {"reportId", "createTime", "suiteName", "methodName", "decription", "actual", "expected", "isPass"};

        ExcelUtil util = new ExcelUtil();
        util.writeExcel(list, columns, keys, response, fileName);
        return null;
    }

    private List<Map<String, Object>> createExcelRecord(List<LogReport> logReports) {
        List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("sheetName", "sheet1");
        mapList.add(map);
        LogReport logReport = null;

        for (int i = 0; i < logReports.size(); i++) {
            logReport = logReports.get(i);
            Map<String, Object> mapValue = new HashMap<String, Object>();
            mapValue.put("reportId", logReport.getReportId());
            mapValue.put("createTime", logReport.getCreateTime());
            mapValue.put("suiteName", logReport.getSuiteName());
            mapValue.put("methodName", logReport.getMethodName());
            mapValue.put("decription", logReport.getDescription());
            mapValue.put("expected", logReport.getExpected());
            mapValue.put("actual", logReport.getActual());
            mapValue.put("isPass", logReport.getIsPass());
            mapList.add(mapValue);
        }
        return mapList;
    }
}
