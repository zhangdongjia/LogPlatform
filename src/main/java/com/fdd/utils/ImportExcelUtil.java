package com.fdd.utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by admin on 2016/12/30.
 */
public class ImportExcelUtil {

    private final static String excel2003 = ".xls";
    private final static String excel2007 = ".xlsx";

    //获取IO流中的数据，组装成List<List<Object>>对象
    public List<List<Object>> getBankListByExcel(InputStream in, String fileName) throws Exception {
        List<List<Object>> lists = new ArrayList<List<Object>>();
        //创建Excel工作簿
        Workbook work = this.getWorkbook(in, fileName);
        if (work == null) {
            throw new Exception("创建Excel工作簿为空！");
        }

        Sheet sheet = null;
        Row row = null;
        Cell cell = null;

        //遍历Excel中的所有sheet
        for (int i = 0; i < work.getNumberOfSheets(); i++) {
            sheet = work.getSheetAt(i);
            if (sheet == null) {
                continue;
            }
            //遍历当前sheet中的所有行
            for (int j = sheet.getFirstRowNum(); j < sheet.getLastRowNum(); j++) {
                row =sheet.getRow(j);
                if (row == null || row.getFirstCellNum() == j) {
                    continue;
                }
                //遍历所有列
                List<Object> list = new ArrayList<Object>();
                for (int k = row.getFirstCellNum(); k < row.getLastCellNum(); k++) {
                    cell = row.getCell(k);
                    list.add(this.getCellValue(cell));
                }
                lists.add(list);
            }
        }
        work.close();
        return lists;
    }

    //根据文件后缀，自适应上传文件的格式
    public Workbook getWorkbook(InputStream inputStream, String fileName) throws Exception {
        Workbook wb = null;
        String fileType = fileName.substring(fileName.lastIndexOf("."));
        if (excel2003.equals(fileType)) {
            wb = new HSSFWorkbook(inputStream);
        } else if (excel2007.equals(fileType)){
            wb = new XSSFWorkbook(inputStream);
        } else {
            throw new Exception("解析的文件格式有误！");
        }
        return wb;
    }

    //对表格中的数据进行格式化
    public Object getCellValue(Cell cell) {
        Object value = null;
        DecimalFormat df = new DecimalFormat("0");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                value = cell.getRichStringCellValue().getString();
                break;
            case Cell.CELL_TYPE_NUMERIC:
                if ("General".equals(cell.getCellStyle().getDataFormatString())) {
                    value = df.format(cell.getNumericCellValue());
                } else if ("m/d/yy".equals(cell.getCellStyle().getDataFormatString())) {
                    value = sdf.format(cell.getDateCellValue());
                }
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                value = cell.getBooleanCellValue();
                break;
            case Cell.CELL_TYPE_BLANK:
                value = "";
                break;
            default:
                break;
        }
        return value;
    }
}
