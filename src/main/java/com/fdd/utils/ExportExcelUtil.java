package com.fdd.utils;

import com.fdd.domain.LogReport;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

/**
 * Created by admin on 2016/12/30.
 */
public class ExportExcelUtil {

    //根据文件路径获取excel模板文件
    public File getExcelDemoFile(String fileDir) throws Exception {

        String classDir = Thread.currentThread().getContextClassLoader().getResource("/").getPath();
        System.out.println(classDir);
        String fileBasedir = classDir.substring(0, classDir.lastIndexOf("classes"));
        File file = new File(fileBasedir + fileDir);

        if (!file.exists()) {
            throw new Exception("模板文件不存在!");
        }
        return file;
    }

    public Workbook writeExcel(File file, String sheetName, List<LogReport> list) throws Exception {
        FileInputStream fis = new FileInputStream(file);
        Workbook workbook = new ImportExcelUtil().getWorkbook(fis, file.getName());
        Sheet sheet = workbook.getSheet(sheetName);
        Row row = null;
        Cell cell = null;

        //插入数据
        int lastRow = sheet.getLastRowNum() + 1; //插入数据的行数
        CellStyle cellStyle = setCellStyle(workbook);
        for (int i = 0; i < list.size(); i++) {
            row = sheet.createRow(lastRow + i);

            LogReport logReport = list.get(i);
            if (logReport == null) {
                break;
            }

            cell = row.createCell(0);
            cell.setCellValue(logReport.getReportId());
            cell.setCellStyle(cellStyle);

            cell = row.createCell(1);
            cell.setCellValue(logReport.getCreateTime());
            cell.setCellStyle(cellStyle);

            cell = row.createCell(2);
            cell.setCellValue(logReport.getSuiteName());
            cell.setCellStyle(cellStyle);

            cell = row.createCell(3);
            cell.setCellValue(logReport.getMethodName());
            cell.setCellStyle(cellStyle);

            cell = row.createCell(4);
            cell.setCellValue(logReport.getDescription());
            cell.setCellStyle(cellStyle);

            cell = row.createCell(5);
            cell.setCellValue(logReport.getActual());
            cell.setCellStyle(cellStyle);

            cell = row.createCell(6);
            cell.setCellValue(logReport.getExpected());
            cell.setCellStyle(cellStyle);

            cell = row.createCell(7);
            cell.setCellValue(logReport.getIsPass());
            cell.setCellStyle(cellStyle);
        }
        return workbook;
    }

    //设置Excel样式
    public CellStyle setCellStyle(Workbook workbook) {
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
        cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
        cellStyle.setBorderTop(CellStyle.BORDER_THIN);
        cellStyle.setBorderRight(CellStyle.BORDER_THIN);
        cellStyle.setAlignment(CellStyle.ALIGN_LEFT);

        return cellStyle;
    }
}
