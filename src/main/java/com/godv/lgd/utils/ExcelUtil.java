package com.godv.lgd.utils;

import com.godv.lgd.dao.ExportExcelVO;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 戴启仰
 * created 2018-04-09 18:03
 * @version 1.0
 */
public class ExcelUtil {

    private static final String fontStyle = "宋体";

    /**
     * 导出execl表格到前端
     *
     * @param response
     * @param sheets
     * @param excelName
     */
    public static void outExcel(HttpServletResponse response, XSSFWorkbook sheets, String excelName) {
        try {
            ServletOutputStream out = response.getOutputStream();
            ExcelUtil.writeOut(excelName, response, sheets, out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 导出execl表格到前端
     *
     * @param response
     * @param sheets
     * @param excelName
     */
    public static void outExcel(HttpServletResponse response, SXSSFWorkbook sheets, String excelName) {
        try {
            ServletOutputStream out = response.getOutputStream();
            ExcelUtil.writeOut(excelName, response, sheets, out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void writeOut(String excelName, HttpServletResponse response, XSSFWorkbook workBook, ServletOutputStream out) {
        try {
            response.setContentType("multipart/form-data");
            String fileName = excelName + ".xlsx";
            response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(fileName, "UTF-8"));
            workBook.write(out);
            workBook.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            try {
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                out.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void writeOut(String excelName, HttpServletResponse response, SXSSFWorkbook workBook, ServletOutputStream out) {
        try {
            response.setContentType("multipart/form-data");
            String fileName = excelName + ".xlsx";
            response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(fileName, "UTF-8"));
            workBook.write(out);
            workBook.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            try {
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                out.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static String getCellString(Cell cell) {
        if (cell == null) return "";
        String cellSring = null;
        switch (cell.getCellType()) {
            case STRING: // 字符串
                cellSring = cell.getStringCellValue();
                break;
            case NUMERIC: // 数字
                cellSring = new BigDecimal(cell.getNumericCellValue()) + "";
                break;
            case BOOLEAN: // Boolean
                cellSring = String.valueOf(cell.getBooleanCellValue());
                break;
            case FORMULA: // 公式
                cellSring = String.valueOf(cell.getCellFormula());
                break;
            case BLANK: // 空值
                cellSring = "";
                break;
            case ERROR: // 故障
                cellSring = "";
                break;
            default:
                cellSring = "";
                break;
        }
        return cellSring;
    }

   /** @Description:
     * @Author: GodV
     * @Date: 2021/5/8 10:55 上午
     * @param sheetObj: 
     * @return: org.apache.poi.xssf.streaming.SXSSFWorkbook
   */ 
    public static SXSSFWorkbook outExcel(ExportExcelVO sheetObj) throws Exception {
        // 声明一个工作薄
        SXSSFWorkbook workBook = new SXSSFWorkbook();
        workBook.setCompressTempFiles(true);

        CellStyle cellStyle = workBook.createCellStyle();
        Font font = workBook.createFont();
        font.setFontName(fontStyle);
        font.setFontHeightInPoints((short) 14);
        cellStyle.setFont(font);
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyle.setBorderBottom(BorderStyle.THIN); //下边框
        cellStyle.setBorderLeft(BorderStyle.THIN);//左边框
        cellStyle.setBorderTop(BorderStyle.THIN);//上边框
        cellStyle.setBorderRight(BorderStyle.THIN);//右边框
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setFillForegroundColor(IndexedColors.WHITE.getIndex());

        // 生成一个表格
        SXSSFSheet sheet = workBook.createSheet(sheetObj.getSheetName());
        // 创建表格标题行 第一行
        List<List<String>> rowList = sheetObj.getRowTitle();
        if (CollectionUtils.isNotEmpty(rowList)) {
            for (int n = 0; n < rowList.size(); n++) {
                List<String> rowTitle = rowList.get(n);
                SXSSFRow titleOneRow = sheet.createRow(n);
                for (AtomicInteger i = new AtomicInteger(0); i.intValue() < rowTitle.size(); i.incrementAndGet()) {
                    SXSSFCell cell = titleOneRow.createCell(i.intValue());
                    cell.setCellStyle(cellStyle); //设置为文本格式
                    sheet.setColumnWidth(i.intValue(), 5000);
                    titleOneRow.setHeightInPoints(16);//目的是想把行高设置成20px
                    cell.setCellValue(rowTitle.get(i.intValue()));
                }
            }
        }
        return workBook;
    }


    /**
     * 多个sheet导出excel
     *
     * @param sheetList
     * @return
     * @throws Exception
     */
    public static SXSSFWorkbook outExcelSheet(List<ExportExcelVO> sheetList) throws Exception {
        // 声明一个工作薄
        SXSSFWorkbook workBook = new SXSSFWorkbook();
        workBook.setCompressTempFiles(true);


        CellStyle cellStyle2 = workBook.createCellStyle();
        DataFormat format2 = workBook.createDataFormat();
        cellStyle2.setDataFormat(format2.getFormat("@"));
        Font font2 = workBook.createFont();
        font2.setFontName("等线");
        font2.setFontHeightInPoints((short) 12);
        cellStyle2.setFont(font2);
        cellStyle2.setAlignment(HorizontalAlignment.LEFT);

        CellStyle cellStyle = workBook.createCellStyle();
        Font font = workBook.createFont();
        font.setFontName("Microsoft YaHei");
        font.setFontHeightInPoints((short) 14);
        cellStyle.setFont(font);
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyle.setBorderBottom(BorderStyle.THIN); //下边框
        cellStyle.setBorderLeft(BorderStyle.THIN);//左边框
        cellStyle.setBorderTop(BorderStyle.THIN);//上边框
        cellStyle.setBorderRight(BorderStyle.THIN);//右边框
        cellStyle.setAlignment(HorizontalAlignment.CENTER);

        for (int m = 0; m < sheetList.size(); m++) {
            ExportExcelVO vo = sheetList.get(m);
            // 生成一个表格
            SXSSFSheet sheet = workBook.createSheet(vo.getSheetName());
            // 创建表格标题行 第一行
            List<List<String>> rowList = vo.getRowTitle();
            if (CollectionUtils.isNotEmpty(rowList)) {
                for (int n = 0; n < rowList.size(); n++) {
                    List<String> rowTitle = rowList.get(n);
                    SXSSFRow titleOneRow = sheet.createRow(n);
                    for (AtomicInteger i = new AtomicInteger(0); i.intValue() < rowTitle.size(); i.incrementAndGet()) {
//                        titleOneRow.setHeightInPoints(20);//目的是想把行高设置成20px
//                        sheet.setColumnWidth(i.intValue(), 7000);
                        SXSSFCell cell = titleOneRow.createCell(i.intValue());
                        // 第一个sheet
                        if (m == 0) {
                            // 第一行
                            if (n == 0) {
//                                cellStyle.setFillForegroundColor("D9E1F2");
                                cellStyle.setFillForegroundColor(IndexedColors.WHITE.getIndex());
                            } else if (n == 1) {
                                CellRangeAddress titleRegion = new CellRangeAddress(1, 1, 0, 3);
                                sheet.addMergedRegion(titleRegion);
//                                cellStyle.setFillForegroundColor(new XSSFColor(new java.awt.Color(255, 255, 255)));
                                cellStyle.setFillForegroundColor(IndexedColors.WHITE.getIndex());
                            } else if (n == 2) {
//                                cellStyle.setFillForegroundColor(new XSSFColor(new java.awt.Color(252, 228, 214)));
                                cellStyle.setFillForegroundColor(IndexedColors.WHITE.getIndex());
                            } else {
//                                cellStyle.setFillForegroundColor(new XSSFColor(new java.awt.Color(255, 255, 255)));
                                cellStyle.setFillForegroundColor(IndexedColors.WHITE.getIndex());
                            }
                            cell.setCellStyle(cellStyle); //设置为文本格式
                            sheet.setColumnWidth(i.intValue(), 7000);
                            titleOneRow.setHeightInPoints(20);//目的是想把行高设置成20px
                        } else {
                            cell.setCellStyle(cellStyle2); //设置为文本格式
                            sheet.setColumnWidth(i.intValue(), 5000);
                            titleOneRow.setHeightInPoints(16);//目的是想把行高设置成20px
                        }
                        cell.setCellValue(rowTitle.get(i.intValue()));
                    }
                }
            }
        }
        return workBook;
    }
}
