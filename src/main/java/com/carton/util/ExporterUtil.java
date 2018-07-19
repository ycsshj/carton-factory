package com.carton.util;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.List;

@Component
public class ExporterUtil {
    private static final Logger logger = LoggerFactory.getLogger(ExporterUtil.class);

    public HSSFWorkbook exportExcel(String[] columns, String[] fields, List list) throws Exception {

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet();

        //设置标题样式
        HSSFCellStyle headerStyle = setHeaderStyle(workbook);
        //设置内容样式
        HSSFCellStyle contentStyle = setContentStyle(workbook);

        int i = 0;
        HSSFRow columnRow = sheet.createRow(i++);
        //创建表头
        fillColumnNames(columnRow, columns, headerStyle);
        //创建表体
        for (Object obj : list) {
            HSSFRow row = sheet.createRow(i++);
            fillDataRow(row, obj, fields, contentStyle);
        }

        //按表头调整列宽度
        for (int k = 0; k < columns.length; k++) {
            sheet.autoSizeColumn((short) k);
        }

        return workbook;
    }

    private void fillColumnNames(HSSFRow row, String[] names, HSSFCellStyle style) {
        int j = 0;
        for (String name : names) {
            HSSFCell cell = row.createCell(j++);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            cell.setCellValue(name);
            cell.setCellStyle(style);
        }
    }

    private void fillDataRow(HSSFRow row, Object model, String[] fields, HSSFCellStyle style) throws Exception {

        int j = 0;
        for (String field : fields) {
            HSSFCell cell = row.createCell(j++);
            String methodName = StringHandlerUtil.generateGetMethodName(field);
            Method method = model.getClass().getMethod(methodName);

            Object obj = method.invoke(model);
            String value = obj == null ? "" : String.valueOf(obj);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            cell.setCellValue(value);
            cell.setCellStyle(style);
        }
    }

    private HSSFCellStyle setHeaderStyle(HSSFWorkbook workbook) {
        HSSFCellStyle cellStyle = workbook.createCellStyle();

        setBorderStyle(cellStyle);
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中

        HSSFFont font = workbook.createFont();
        font.setFontName("黑体");
        font.setFontHeightInPoints((short) 12);//设置字体大小
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
        cellStyle.setFont(font);

        return cellStyle;
    }

    private HSSFCellStyle setContentStyle(HSSFWorkbook workbook) {
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        setBorderStyle(cellStyle);
        return cellStyle;
    }

    private void setBorderStyle(HSSFCellStyle cellStyle) {
        cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
        cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
        cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
        cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
    }
}
